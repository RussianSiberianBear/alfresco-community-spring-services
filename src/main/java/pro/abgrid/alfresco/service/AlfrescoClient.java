package pro.abgrid.alfresco.service;

import pro.abgrid.alfresco.service.activity.AlfrescoActivityService;
import pro.abgrid.alfresco.service.association.AlfrescoAssociationService;
import pro.abgrid.alfresco.service.audit.AlfrescoAuditService;
import pro.abgrid.alfresco.service.category.AlfrescoCategoryService;
import pro.abgrid.alfresco.service.comment.AlfrescoCommentService;
import pro.abgrid.alfresco.service.content.AlfrescoContentService;
import pro.abgrid.alfresco.service.download.AlfrescoDownloadService;
import pro.abgrid.alfresco.service.favorite.AlfrescoFavoriteService;
import pro.abgrid.alfresco.service.group.AlfrescoGroupService;
import pro.abgrid.alfresco.service.image.AlfrescoImageService;
import pro.abgrid.alfresco.service.metadata.AlfrescoMetadataService;
import pro.abgrid.alfresco.service.permission.AlfrescoPermissionService;
import pro.abgrid.alfresco.service.preference.AlfrescoPreferenceService;
import pro.abgrid.alfresco.service.query.AlfrescoQueryService;
import pro.abgrid.alfresco.service.rating.AlfrescoRatingService;
import pro.abgrid.alfresco.service.rendition.AlfrescoRenditionService;
import pro.abgrid.alfresco.service.search.AlfrescoSearchService;
import pro.abgrid.alfresco.service.shared.AlfrescoSharedLinkService;
import pro.abgrid.alfresco.service.site.AlfrescoSiteService;
import pro.abgrid.alfresco.service.tag.AlfrescoTagService;
import pro.abgrid.alfresco.service.transformation.AlfrescoTransformationService;
import pro.abgrid.alfresco.service.trash.AlfrescoTrashService;
import pro.abgrid.alfresco.service.user.AlfrescoUserService;
import pro.abgrid.alfresco.service.version.AlfrescoVersionService;
import org.springframework.stereotype.Service;

/**
 * <p><strong>RU:</strong> Высокоуровневый Spring-сервис для сценариев «client» в Alfresco. Он служит прикладной границей над generated REST API: принимает более удобные параметры, скрывает технические детали HTTP/DTO там, где для них есть high-level модель, и оставляет доступ к серверному результату, когда это необходимо. Сервис предназначен для внедрения как обычный Spring bean в бизнес-сервисы приложения.</p>
 * <p><strong>EN:</strong> High-level Spring service for Alfresco client scenarios. It acts as an application boundary over the generated REST API: it accepts application-friendly parameters, hides HTTP/DTO plumbing where a high-level model exists, and still exposes server results when required. The service is intended to be injected as a regular Spring bean into application business services.</p>
 */
@Service
public class AlfrescoClient {
    private final AlfrescoContentService content;
    private final AlfrescoSearchService search;
    private final AlfrescoTransformationService transformations;
    private final AlfrescoRenditionService renditions;
    private final AlfrescoMetadataService metadata;
    private final AlfrescoVersionService versions;
    private final AlfrescoPermissionService permissions;
    private final AlfrescoUserService users;
    private final AlfrescoGroupService groups;
    private final AlfrescoSiteService sites;
    private final AlfrescoTagService tags;
    private final AlfrescoCommentService comments;
    private final AlfrescoRatingService ratings;
    private final AlfrescoFavoriteService favorites;
    private final AlfrescoSharedLinkService sharedLinks;
    private final AlfrescoDownloadService downloads;
    private final AlfrescoTrashService trash;
    private final AlfrescoAssociationService associations;
    private final AlfrescoCategoryService categories;
    private final AlfrescoQueryService queries;
    private final AlfrescoAuditService audit;
    private final AlfrescoActivityService activities;
    private final AlfrescoPreferenceService preferences;
    private final AlfrescoImageService images;

        /**
     * <p><strong>RU:</strong> создаёт сервис и получает его зависимости через Spring DI; обычно этот конструктор не вызывается прикладным кодом напрямую.</p>
     * <p><strong>EN:</strong> creates the service with dependencies supplied by Spring DI; application code normally does not call this constructor directly.</p>
     *
     * @param content RU: зависимость `content`, используемая сервисом для выполнения операций Alfresco. EN: `content` dependency used by the service to perform Alfresco operations.
     * @param search RU: зависимость `search`, используемая сервисом для выполнения операций Alfresco. EN: `search` dependency used by the service to perform Alfresco operations.
     * @param transformations RU: зависимость `transformations`, используемая сервисом для выполнения операций Alfresco. EN: `transformations` dependency used by the service to perform Alfresco operations.
     * @param renditions RU: зависимость `renditions`, используемая сервисом для выполнения операций Alfresco. EN: `renditions` dependency used by the service to perform Alfresco operations.
     * @param metadata RU: зависимость `metadata`, используемая сервисом для выполнения операций Alfresco. EN: `metadata` dependency used by the service to perform Alfresco operations.
     * @param versions RU: зависимость `versions`, используемая сервисом для выполнения операций Alfresco. EN: `versions` dependency used by the service to perform Alfresco operations.
     * @param permissions RU: зависимость `permissions`, используемая сервисом для выполнения операций Alfresco. EN: `permissions` dependency used by the service to perform Alfresco operations.
     * @param users RU: зависимость `users`, используемая сервисом для выполнения операций Alfresco. EN: `users` dependency used by the service to perform Alfresco operations.
     * @param groups RU: зависимость `groups`, используемая сервисом для выполнения операций Alfresco. EN: `groups` dependency used by the service to perform Alfresco operations.
     * @param sites RU: зависимость `sites`, используемая сервисом для выполнения операций Alfresco. EN: `sites` dependency used by the service to perform Alfresco operations.
     * @param tags RU: зависимость `tags`, используемая сервисом для выполнения операций Alfresco. EN: `tags` dependency used by the service to perform Alfresco operations.
     * @param comments RU: зависимость `comments`, используемая сервисом для выполнения операций Alfresco. EN: `comments` dependency used by the service to perform Alfresco operations.
     * @param ratings RU: зависимость `ratings`, используемая сервисом для выполнения операций Alfresco. EN: `ratings` dependency used by the service to perform Alfresco operations.
     * @param favorites RU: зависимость `favorites`, используемая сервисом для выполнения операций Alfresco. EN: `favorites` dependency used by the service to perform Alfresco operations.
     * @param sharedLinks RU: зависимость `sharedLinks`, используемая сервисом для выполнения операций Alfresco. EN: `sharedLinks` dependency used by the service to perform Alfresco operations.
     * @param downloads RU: зависимость `downloads`, используемая сервисом для выполнения операций Alfresco. EN: `downloads` dependency used by the service to perform Alfresco operations.
     * @param trash RU: зависимость `trash`, используемая сервисом для выполнения операций Alfresco. EN: `trash` dependency used by the service to perform Alfresco operations.
     * @param associations RU: зависимость `associations`, используемая сервисом для выполнения операций Alfresco. EN: `associations` dependency used by the service to perform Alfresco operations.
     * @param categories RU: зависимость `categories`, используемая сервисом для выполнения операций Alfresco. EN: `categories` dependency used by the service to perform Alfresco operations.
     * @param queries RU: зависимость `queries`, используемая сервисом для выполнения операций Alfresco. EN: `queries` dependency used by the service to perform Alfresco operations.
     * @param audit RU: зависимость `audit`, используемая сервисом для выполнения операций Alfresco. EN: `audit` dependency used by the service to perform Alfresco operations.
     * @param activities RU: зависимость `activities`, используемая сервисом для выполнения операций Alfresco. EN: `activities` dependency used by the service to perform Alfresco operations.
     * @param preferences RU: зависимость `preferences`, используемая сервисом для выполнения операций Alfresco. EN: `preferences` dependency used by the service to perform Alfresco operations.
     * @param images RU: зависимость `images`, используемая сервисом для выполнения операций Alfresco. EN: `images` dependency used by the service to perform Alfresco operations.
     */

    public AlfrescoClient(
            AlfrescoContentService content, AlfrescoSearchService search,
            AlfrescoTransformationService transformations, AlfrescoRenditionService renditions,
            AlfrescoMetadataService metadata, AlfrescoVersionService versions,
            AlfrescoPermissionService permissions, AlfrescoUserService users,
            AlfrescoGroupService groups, AlfrescoSiteService sites, AlfrescoTagService tags,
            AlfrescoCommentService comments, AlfrescoRatingService ratings,
            AlfrescoFavoriteService favorites, AlfrescoSharedLinkService sharedLinks,
            AlfrescoDownloadService downloads, AlfrescoTrashService trash,
            AlfrescoAssociationService associations, AlfrescoCategoryService categories,
            AlfrescoQueryService queries, AlfrescoAuditService audit,
            AlfrescoActivityService activities, AlfrescoPreferenceService preferences,
            AlfrescoImageService images) {
        this.content=content; this.search=search; this.transformations=transformations; this.renditions=renditions;
        this.metadata=metadata; this.versions=versions; this.permissions=permissions; this.users=users;
        this.groups=groups; this.sites=sites; this.tags=tags; this.comments=comments; this.ratings=ratings;
        this.favorites=favorites; this.sharedLinks=sharedLinks; this.downloads=downloads; this.trash=trash;
        this.associations=associations; this.categories=categories; this.queries=queries; this.audit=audit;
        this.activities=activities; this.preferences=preferences; this.images=images;
    }

        /**
     * <p><strong>RU:</strong> выполняет high-level операцию `content` над Alfresco и скрывает детали generated REST-клиента от прикладного кода.</p>
     * <p><strong>EN:</strong> performs the high-level `content` operation against Alfresco while hiding generated REST-client details from application code.</p>
     * @return RU: результат операции в модели high-level/generated API; конкретный тип отражает ответ Alfresco. EN: operation result represented by the high-level/generated API model; the concrete type reflects the Alfresco response.
     */

    /**
     * <p><strong>RU:</strong> Возвращает high-level сервис для работы с контентом и узлами Alfresco.</p>
     * <p><strong>EN:</strong> Returns the high-level Alfresco service for content and node operations.</p>
     * @return RU: соответствующий Spring-сервис. EN: corresponding Spring service.
     */
    public AlfrescoContentService content() { return content; }

    /**
     * <p><strong>RU:</strong> Возвращает high-level сервис для работы с поиском Alfresco.</p>
     * <p><strong>EN:</strong> Returns the high-level Alfresco service for search operations.</p>
     * @return RU: соответствующий Spring-сервис. EN: corresponding Spring service.
     */
    public AlfrescoSearchService search() { return search; }

    /**
     * <p><strong>RU:</strong> Возвращает high-level сервис для работы с трансформациями Alfresco.</p>
     * <p><strong>EN:</strong> Returns the high-level Alfresco service for transformations operations.</p>
     * @return RU: соответствующий Spring-сервис. EN: corresponding Spring service.
     */
    public AlfrescoTransformationService transformations() { return transformations; }

    /**
     * <p><strong>RU:</strong> Возвращает high-level сервис для работы с renditions Alfresco.</p>
     * <p><strong>EN:</strong> Returns the high-level Alfresco service for renditions operations.</p>
     * @return RU: соответствующий Spring-сервис. EN: corresponding Spring service.
     */
    public AlfrescoRenditionService renditions() { return renditions; }

    /**
     * <p><strong>RU:</strong> Возвращает high-level сервис для работы с метаданными Alfresco.</p>
     * <p><strong>EN:</strong> Returns the high-level Alfresco service for metadata operations.</p>
     * @return RU: соответствующий Spring-сервис. EN: corresponding Spring service.
     */
    public AlfrescoMetadataService metadata() { return metadata; }

    /**
     * <p><strong>RU:</strong> Возвращает high-level сервис для работы с версиями Alfresco.</p>
     * <p><strong>EN:</strong> Returns the high-level Alfresco service for versions operations.</p>
     * @return RU: соответствующий Spring-сервис. EN: corresponding Spring service.
     */
    public AlfrescoVersionService versions() { return versions; }

    /**
     * <p><strong>RU:</strong> Возвращает high-level сервис для работы с правами доступа Alfresco.</p>
     * <p><strong>EN:</strong> Returns the high-level Alfresco service for permissions operations.</p>
     * @return RU: соответствующий Spring-сервис. EN: corresponding Spring service.
     */
    public AlfrescoPermissionService permissions() { return permissions; }

    /**
     * <p><strong>RU:</strong> Возвращает high-level сервис для работы с пользователями Alfresco.</p>
     * <p><strong>EN:</strong> Returns the high-level Alfresco service for users operations.</p>
     * @return RU: соответствующий Spring-сервис. EN: corresponding Spring service.
     */
    public AlfrescoUserService users() { return users; }

    /**
     * <p><strong>RU:</strong> Возвращает high-level сервис для работы с группами Alfresco.</p>
     * <p><strong>EN:</strong> Returns the high-level Alfresco service for groups operations.</p>
     * @return RU: соответствующий Spring-сервис. EN: corresponding Spring service.
     */
    public AlfrescoGroupService groups() { return groups; }

    /**
     * <p><strong>RU:</strong> Возвращает high-level сервис для работы с сайтами Alfresco.</p>
     * <p><strong>EN:</strong> Returns the high-level Alfresco service for sites operations.</p>
     * @return RU: соответствующий Spring-сервис. EN: corresponding Spring service.
     */
    public AlfrescoSiteService sites() { return sites; }

    /**
     * <p><strong>RU:</strong> Возвращает high-level сервис для работы с тегами Alfresco.</p>
     * <p><strong>EN:</strong> Returns the high-level Alfresco service for tags operations.</p>
     * @return RU: соответствующий Spring-сервис. EN: corresponding Spring service.
     */
    public AlfrescoTagService tags() { return tags; }

    /**
     * <p><strong>RU:</strong> Возвращает high-level сервис для работы с комментариями Alfresco.</p>
     * <p><strong>EN:</strong> Returns the high-level Alfresco service for comments operations.</p>
     * @return RU: соответствующий Spring-сервис. EN: corresponding Spring service.
     */
    public AlfrescoCommentService comments() { return comments; }

    /**
     * <p><strong>RU:</strong> Возвращает high-level сервис для работы с рейтингами Alfresco.</p>
     * <p><strong>EN:</strong> Returns the high-level Alfresco service for ratings operations.</p>
     * @return RU: соответствующий Spring-сервис. EN: corresponding Spring service.
     */
    public AlfrescoRatingService ratings() { return ratings; }

    /**
     * <p><strong>RU:</strong> Возвращает high-level сервис для работы с избранным Alfresco.</p>
     * <p><strong>EN:</strong> Returns the high-level Alfresco service for favorites operations.</p>
     * @return RU: соответствующий Spring-сервис. EN: corresponding Spring service.
     */
    public AlfrescoFavoriteService favorites() { return favorites; }

    /**
     * <p><strong>RU:</strong> Возвращает high-level сервис для работы с общими ссылками Alfresco.</p>
     * <p><strong>EN:</strong> Returns the high-level Alfresco service for shared links operations.</p>
     * @return RU: соответствующий Spring-сервис. EN: corresponding Spring service.
     */
    public AlfrescoSharedLinkService sharedLinks() { return sharedLinks; }

    /**
     * <p><strong>RU:</strong> Возвращает high-level сервис для работы с асинхронными загрузками Alfresco.</p>
     * <p><strong>EN:</strong> Returns the high-level Alfresco service for downloads operations.</p>
     * @return RU: соответствующий Spring-сервис. EN: corresponding Spring service.
     */
    public AlfrescoDownloadService downloads() { return downloads; }

    /**
     * <p><strong>RU:</strong> Возвращает high-level сервис для работы с корзиной Alfresco.</p>
     * <p><strong>EN:</strong> Returns the high-level Alfresco service for trashcan operations.</p>
     * @return RU: соответствующий Spring-сервис. EN: corresponding Spring service.
     */
    public AlfrescoTrashService trash() { return trash; }

    /**
     * <p><strong>RU:</strong> Возвращает high-level сервис для работы с ассоциациями Alfresco.</p>
     * <p><strong>EN:</strong> Returns the high-level Alfresco service for associations operations.</p>
     * @return RU: соответствующий Spring-сервис. EN: corresponding Spring service.
     */
    public AlfrescoAssociationService associations() { return associations; }

    /**
     * <p><strong>RU:</strong> Возвращает high-level сервис для работы с категориями Alfresco.</p>
     * <p><strong>EN:</strong> Returns the high-level Alfresco service for categories operations.</p>
     * @return RU: соответствующий Spring-сервис. EN: corresponding Spring service.
     */
    public AlfrescoCategoryService categories() { return categories; }

    /**
     * <p><strong>RU:</strong> Возвращает high-level сервис для работы с query endpoints Alfresco.</p>
     * <p><strong>EN:</strong> Returns the high-level Alfresco service for query endpoints operations.</p>
     * @return RU: соответствующий Spring-сервис. EN: corresponding Spring service.
     */
    public AlfrescoQueryService queries() { return queries; }

    /**
     * <p><strong>RU:</strong> Возвращает high-level сервис для работы с аудитом Alfresco.</p>
     * <p><strong>EN:</strong> Returns the high-level Alfresco service for audit operations.</p>
     * @return RU: соответствующий Spring-сервис. EN: corresponding Spring service.
     */
    public AlfrescoAuditService audit() { return audit; }

    /**
     * <p><strong>RU:</strong> Возвращает high-level сервис для работы с активностями Alfresco.</p>
     * <p><strong>EN:</strong> Returns the high-level Alfresco service for activities operations.</p>
     * @return RU: соответствующий Spring-сервис. EN: corresponding Spring service.
     */
    public AlfrescoActivityService activities() { return activities; }

    /**
     * <p><strong>RU:</strong> Возвращает high-level сервис для работы с настройками пользователя Alfresco.</p>
     * <p><strong>EN:</strong> Returns the high-level Alfresco service for preferences operations.</p>
     * @return RU: соответствующий Spring-сервис. EN: corresponding Spring service.
     */
    public AlfrescoPreferenceService preferences() { return preferences; }

    /**
     * <p><strong>RU:</strong> Возвращает high-level сервис для работы с изображениями Alfresco.</p>
     * <p><strong>EN:</strong> Returns the high-level Alfresco service for images operations.</p>
     * @return RU: соответствующий Spring-сервис. EN: corresponding Spring service.
     */
    public AlfrescoImageService images() { return images; }
}
