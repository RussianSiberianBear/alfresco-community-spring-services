package pro.abgrid.alfresco.integration;

import pro.abgrid.alfresco.dto.core.CommentEntry;
import pro.abgrid.alfresco.dto.core.FavoriteEntry;
import pro.abgrid.alfresco.dto.core.NodeEntry;
import pro.abgrid.alfresco.dto.core.RatingEntry;
import pro.abgrid.alfresco.dto.core.TagEntry;
import pro.abgrid.alfresco.model.UploadRequest;
import pro.abgrid.alfresco.service.comment.AlfrescoCommentService;
import pro.abgrid.alfresco.service.content.AlfrescoContentService;
import pro.abgrid.alfresco.service.favorite.AlfrescoFavoriteService;
import pro.abgrid.alfresco.service.rating.AlfrescoRatingService;
import pro.abgrid.alfresco.service.tag.AlfrescoTagService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;

import java.nio.charset.StandardCharsets;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = AlfrescoSocialIntegrationTest.TestApp.class)
class AlfrescoSocialIntegrationTest extends AlfrescoIntegrationTestBase {
    private static final String COMPANY_HOME = "-root-";

    @Autowired AlfrescoContentService content;
    @Autowired AlfrescoTagService tags;
    @Autowired AlfrescoCommentService comments;
    @Autowired AlfrescoRatingService ratings;
    @Autowired AlfrescoFavoriteService favorites;

    @Test
    void tagsCommentsRatingsAndFavoritesLifecycle() {
        String suffix = UUID.randomUUID().toString().replace("-", "").substring(0, 12);
        NodeEntry folder = content.createFolder(COMPANY_HOME, "alfresco-social-it-" + suffix);
        String folderId = folder.getEntry().getId();
        String nodeId = null;
        String tagId = null;
        String commentId = null;
        String favoriteId = null;
        boolean liked = false;

        try {
            NodeEntry uploaded = content.upload(new UploadRequest(
                    folderId,
                    "social-test-" + suffix + ".txt",
                    "Tags, comments, ratings and favorites".getBytes(StandardCharsets.UTF_8)
            ));
            nodeId = uploaded.getEntry().getId();

            TagEntry tag = tags.add(nodeId, "spring-sdk-" + suffix);
            assertThat(tag.getEntry()).isNotNull();
            assertThat(tag.getEntry().getTag()).isEqualTo("spring-sdk-" + suffix);
            tagId = tag.getEntry().getId();
            assertThat(tags.list(nodeId, 0, 100).getList()).isNotNull();

            CommentEntry comment = comments.add(nodeId, "Initial integration comment " + suffix);
            assertThat(comment.getEntry()).isNotNull();
            commentId = comment.getEntry().getId();
            assertThat(comment.getEntry().getContent()).contains("Initial integration comment");

            CommentEntry updatedComment = comments.update(nodeId, commentId, "Updated integration comment " + suffix);
            assertThat(updatedComment.getEntry().getContent()).isEqualTo("Updated integration comment " + suffix);
            assertThat(comments.list(nodeId, 0, 100).getList()).isNotNull();

            RatingEntry rating = ratings.like(nodeId);
            liked = true;
            assertThat(rating.getEntry()).isNotNull();
            assertThat(rating.getEntry().getId()).isEqualTo(AlfrescoRatingService.LIKES);
            assertThat(ratings.get(nodeId, AlfrescoRatingService.LIKES).getEntry()).isNotNull();
            assertThat(ratings.list(nodeId, 0, 100).getList()).isNotNull();

            FavoriteEntry favorite = favorites.addFile(nodeId);
            assertThat(favorite.getEntry()).isNotNull();
            favoriteId = favorite.getEntry().getTargetGuid();
            assertThat(favoriteId).isEqualTo(nodeId);
            assertThat(favorites.get(AlfrescoFavoriteService.CURRENT_USER, favoriteId).getEntry()).isNotNull();
            assertThat(favorites.mine(0, 100).getList()).isNotNull();

            favorites.remove(favoriteId);
            favoriteId = null;

            ratings.remove(nodeId, AlfrescoRatingService.LIKES);
            liked = false;

            comments.delete(nodeId, commentId);
            commentId = null;

            tags.remove(nodeId, tagId);
            tagId = null;
        } finally {
            if (nodeId != null) {
                if (favoriteId != null) {
                    try { favorites.remove(favoriteId); } catch (RuntimeException ignored) { }
                }
                if (liked) {
                    try { ratings.remove(nodeId, AlfrescoRatingService.LIKES); } catch (RuntimeException ignored) { }
                }
                if (commentId != null) {
                    try { comments.delete(nodeId, commentId); } catch (RuntimeException ignored) { }
                }
                if (tagId != null) {
                    try { tags.remove(nodeId, tagId); } catch (RuntimeException ignored) { }
                }
            }
            content.deletePermanently(folderId);
        }
    }

    @SpringBootApplication
    @ComponentScan(basePackages = "pro.abgrid.alfresco")
    static class TestApp {}
}
