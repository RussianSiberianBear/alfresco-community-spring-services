package pro.abgrid.alfresco.config;

import pro.abgrid.alfresco.api.*;
import pro.abgrid.alfresco.exception.AlfrescoApiException;
import pro.abgrid.alfresco.exception.AlfrescoErrorParser;
import pro.abgrid.alfresco.support.AlfrescoDiagnosticsInterceptor;
import pro.abgrid.alfresco.support.AlfrescoRetryInterceptor;
import tools.jackson.databind.ObjectMapper;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.client.support.RestClientHttpServiceGroupConfigurer;
import org.springframework.web.service.registry.ImportHttpServices;

import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.Set;

/**
 * RU: Автоконфигурация Spring Boot для HTTP Service-клиентов и высокоуровневых сервисов Alfresco.
 * EN: Spring Boot auto-configuration for Alfresco HTTP Service clients and high-level services.
 *
 * Spring Boot auto-configuration for Alfresco HTTP Service clients.
 *
 * <p>Each Alfresco API family is registered in its own HTTP Service group.
 * The actual server URL is configured once through {@code alfresco.url};
 * Spring Boot HTTP Service Client properties build the corresponding API
 * base URLs from that value.</p>
 */
@AutoConfiguration
@Import({
        pro.abgrid.alfresco.service.content.AlfrescoContentService.class,
        pro.abgrid.alfresco.service.search.AlfrescoSearchService.class,
        pro.abgrid.alfresco.service.transformation.AlfrescoTransformationService.class,
        pro.abgrid.alfresco.service.version.AlfrescoVersionService.class,
        pro.abgrid.alfresco.service.metadata.AlfrescoMetadataService.class,
        pro.abgrid.alfresco.service.permission.AlfrescoPermissionService.class,
        pro.abgrid.alfresco.service.user.AlfrescoUserService.class,
        pro.abgrid.alfresco.service.group.AlfrescoGroupService.class,
        pro.abgrid.alfresco.service.tag.AlfrescoTagService.class,
        pro.abgrid.alfresco.service.comment.AlfrescoCommentService.class,
        pro.abgrid.alfresco.service.site.AlfrescoSiteService.class,
        pro.abgrid.alfresco.service.shared.AlfrescoSharedLinkService.class,
        pro.abgrid.alfresco.service.download.AlfrescoDownloadService.class,
        pro.abgrid.alfresco.service.image.AlfrescoImageService.class,
        pro.abgrid.alfresco.service.trash.AlfrescoTrashService.class,
        pro.abgrid.alfresco.service.association.AlfrescoAssociationService.class,
        pro.abgrid.alfresco.service.category.AlfrescoCategoryService.class,
        pro.abgrid.alfresco.service.query.AlfrescoQueryService.class,
        pro.abgrid.alfresco.support.PagingExtractor.class,
        pro.abgrid.alfresco.support.SearchResultExtractor.class,
        pro.abgrid.alfresco.service.rendition.AlfrescoRenditionService.class,
        pro.abgrid.alfresco.service.rating.AlfrescoRatingService.class,
        pro.abgrid.alfresco.service.audit.AlfrescoAuditService.class,
        pro.abgrid.alfresco.service.activity.AlfrescoActivityService.class,
        pro.abgrid.alfresco.service.preference.AlfrescoPreferenceService.class,
        pro.abgrid.alfresco.service.favorite.AlfrescoFavoriteService.class,
        pro.abgrid.alfresco.service.AlfrescoDocumentService.class,
        pro.abgrid.alfresco.service.AlfrescoClient.class,
        pro.abgrid.alfresco.service.AlfrescoInfoService.class
})
@EnableConfigurationProperties(AlfrescoProperties.class)
@ImportHttpServices(
        group = "alfresco",
        types = {
                ActionsApi.class,
                ActivitiesApi.class,
                AuditApi.class,
                CascadingDictionariesApi.class,
                CategoriesApi.class,
                CommentsApi.class,
                DownloadsApi.class,
                NodeUploadApi.class,
                FavoritesApi.class,
                GroupsApi.class,
                NetworksApi.class,
                NodesApi.class,
                PeopleApi.class,
                PreferencesApi.class,
                ProbesApi.class,
                QueriesApi.class,
                RatingsApi.class,
                RenditionsApi.class,
                SharedLinksApi.class,
                SitesApi.class,
                StorageInfoApi.class,
                TagsApi.class,
                TrashcanApi.class,
                VersionsApi.class
        })
/**
 * <p><strong>RU:</strong> Spring Boot auto-configuration библиотеки. Создаёт low-level HTTP Service clients для core/auth/search/discovery API, настраивает Basic Auth, единый разбор ошибок, безопасный retry и diagnostics, а также импортирует high-level сервисы. В прикладном проекте достаточно dependency и настроек {@code alfresco.*}; вручную создавать эти beans обычно не требуется.</p>
 * <p><strong>EN:</strong> Spring Boot auto-configuration for the library. Creates low-level HTTP Service clients for core/auth/search/discovery APIs, configures Basic Auth, shared error parsing, safe retry and diagnostics, and imports the high-level services. Applications normally only need the dependency and {@code alfresco.*} settings; these beans do not need to be created manually.</p>
 */
@ImportHttpServices(group = "alfresco-auth", types = AuthenticationApi.class)
@ImportHttpServices(group = "alfresco-search", types = SearchApi.class)
@ImportHttpServices(group = "alfresco-discovery", types = DiscoveryApi.class)
public class AlfrescoAutoConfiguration {

    /**
     * <p><strong>RU:</strong> Создаётся Spring Boot как контейнер auto-configuration beans; прикладному коду экземпляр напрямую не требуется.</p>
     * <p><strong>EN:</strong> Created by Spring Boot as the auto-configuration bean container; application code does not instantiate it directly.</p>
     */
    public AlfrescoAutoConfiguration() {
    }

    private static final Set<String> ALFRESCO_GROUPS = Set.of(
            "alfresco",
            "alfresco-auth",
            "alfresco-search",
            "alfresco-discovery"
    );

    private static final Map<String, String> API_PATHS = Map.of(
            "alfresco", "/alfresco/api/-default-/public/alfresco/versions/1",
            "alfresco-auth", "/alfresco/api/-default-/public/authentication/versions/1",
            "alfresco-search", "/alfresco/api/-default-/public/search/versions/1",
            "alfresco-discovery", "/alfresco/api"
    );

    @Bean
    RestClientHttpServiceGroupConfigurer alfrescoHttpServiceGroupConfigurer(
            AlfrescoProperties properties, ObjectMapper objectMapper) {

        AlfrescoErrorParser errorParser = new AlfrescoErrorParser(objectMapper);
        AlfrescoRetryInterceptor retryInterceptor = new AlfrescoRetryInterceptor(properties);
        AlfrescoDiagnosticsInterceptor diagnosticsInterceptor = new AlfrescoDiagnosticsInterceptor(properties);

        return groups -> groups.forEachClient((group, builder) -> {
            if (!ALFRESCO_GROUPS.contains(group.name())) {
                return;
            }

            if (properties.getUrl() != null && !properties.getUrl().isBlank()) {
                builder.baseUrl(resolveBaseUrl(properties.getUrl(), group.name()));
            }
            builder.requestInterceptor(retryInterceptor);
            builder.requestInterceptor(diagnosticsInterceptor);

            builder.defaultHeaders(headers -> headers.setBasicAuth(
                    properties.getUsername(),
                    properties.getPassword(),
                    StandardCharsets.UTF_8
            ));

            builder.defaultStatusHandler(
                    HttpStatusCode::isError,
                    (request, response) -> {
                        String body = new String(
                                response.getBody().readAllBytes(),
                                StandardCharsets.UTF_8
                        );
                        throw new AlfrescoApiException(
                                response.getStatusCode(),
                                body,
                                request.getMethod(),
                                request.getURI(),
                                errorParser.parse(body)
                        );
                    }
            );
        });
    }
    static String resolveBaseUrl(String configuredUrl, String groupName) {
        if (configuredUrl == null || configuredUrl.isBlank()) {
            throw new IllegalStateException("alfresco.url must be configured with an absolute HTTP(S) URL");
        }

        String base = configuredUrl.trim();
        while (base.endsWith("/")) {
            base = base.substring(0, base.length() - 1);
        }

        URI uri;
        try {
            uri = URI.create(base);
        } catch (IllegalArgumentException ex) {
            throw new IllegalStateException("alfresco.url is not a valid URI: " + configuredUrl, ex);
        }

        String scheme = uri.getScheme();
        if (scheme == null || !(scheme.equalsIgnoreCase("http") || scheme.equalsIgnoreCase("https"))) {
            throw new IllegalStateException("alfresco.url must use http or https: " + configuredUrl);
        }

        String apiPath = API_PATHS.get(groupName);
        if (apiPath == null) {
            throw new IllegalArgumentException("Unknown Alfresco HTTP service group: " + groupName);
        }
        return base + apiPath;
    }

}
