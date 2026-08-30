# Alfresco Community Spring Services 1.0.0

High-level Spring Boot 4.1 / Java 21 integration layer for Alfresco Community Edition, built on top of the generated typed Alfresco REST client.

## Architecture

- `pro.abgrid.alfresco.api` — low-level typed HTTP interfaces generated from Alfresco OpenAPI.
- `pro.abgrid.alfresco.dto` — generated API DTOs.
- `pro.abgrid.alfresco.service.*` — high-level Spring services.
- `pro.abgrid.alfresco.model` — small application-friendly models.

The original low-level client is intentionally preserved. High-level services are an additional layer and do not prevent direct use of the generated APIs.

## Verified runtime stack

The integration suite for this release was executed against the exact Docker Compose stack below.
These are **verified test-environment versions**, not mandatory transitive dependencies of this library.

| Component | Verified image / version |
|---|---|
| `alfresco` | `docker.io/alfresco/alfresco-content-repository-community:26.2.0` |
| `transform-core-aio` | `alfresco/alfresco-transform-core-aio:5.4.3` |
| `share` | `docker.io/alfresco/alfresco-share:26.2.0` |
| `postgres` | `postgres:17.9` |
| `elasticsearch` | `elasticsearch:8.17.10` |
| `kibana` | `kibana:8.17.10` |
| `batch-indexing` | `docker.io/alfresco/alfresco-elasticsearch-batch-indexing:5.7.0` |
| `activemq` | `docker.io/alfresco/alfresco-activemq:6.2.6-jre17-rockylinux8` |
| `content-app` | `alfresco/alfresco-content-app:8.0.0` |
| `control-center` | `quay.io/alfresco/alfresco-control-center:11.0.0` |

**Traefik (proxy) — 3.6**
A copy of the supplied compose file is retained as `docker/community-compose-tested.yaml` as a reference for the verified test stack.

The repository and Share versions tested by the integration suite are **Alfresco Community Edition 26.2.0.0** / **Alfresco Share 26.2.0**. Features such as transformations, search and messaging still depend on the corresponding services being enabled in the target deployment.

**Support scope:** this project is developed and integration-tested against Alfresco Community Edition. Other Alfresco Content Services editions may expose compatible REST APIs, but they are not currently tested or claimed as officially supported by this project.

### Swagger/OpenAPI compatibility notes

The bundled Swagger 2.0 definitions remain based on the Alfresco public REST specifications, with a small set of corrections verified against the live ACS Community 26.2.0 instance used by this project:

- audit application `GET`/`PUT` responses are wrapped as `AuditAppEntry` (`{"entry": {...}}`);
- rating `myRating` is polymorphic (`boolean` for `likes`, `integer` for `fiveStar`) rather than always a string;
- the trashcan restore request body is optional; omitting it restores the node to its original location.

These corrections are deliberately limited to behavior actually observed by the integration suite; the project does not claim that every upstream Swagger detail has been independently revalidated.

## Services

The stable high-level API includes `AlfrescoClient` plus the individual service beans:
`AlfrescoContentService`, `AlfrescoDocumentService`, `AlfrescoSearchService`,
`AlfrescoTransformationService`, `AlfrescoRenditionService`, `AlfrescoVersionService`,
`AlfrescoMetadataService`, `AlfrescoPermissionService`, `AlfrescoUserService`,
`AlfrescoGroupService`, `AlfrescoSiteService`, `AlfrescoTagService`,
`AlfrescoCommentService`, `AlfrescoRatingService`, `AlfrescoFavoriteService`,
`AlfrescoSharedLinkService`, `AlfrescoDownloadService`, `AlfrescoTrashService`,
`AlfrescoAssociationService`, `AlfrescoCategoryService`, `AlfrescoQueryService`,
`AlfrescoAuditService`, `AlfrescoActivityService`, `AlfrescoPreferenceService`,
`AlfrescoImageService`, and `AlfrescoInfoService`.

## Configuration

```yaml
alfresco:
  url: http://localhost:8082
  username: admin
  password: admin
```

`alfresco.url` is the ACS server root. The library derives the core, authentication, search and discovery REST base URLs automatically; applications do not need to duplicate those paths in `spring.http.serviceclient.*`.

## Examples

```java
NodeEntry file = documents.upload(new UploadRequest(folderId, "contract.docx", bytes));
ContentResource content = documents.download(file.getEntry().getId());
TransformationResult pdf = documents.toPdf(file.getEntry().getId());
SearchPage result = search.afts("cm:name:'*.pdf'", 0, 50);
```

## Important

Transformations are provided by the transformers/renditions installed and enabled in the target ACS deployment. The library does not assume that every source/target format is available.

## Runnable example

A separate consumer application is available in [`examples/quickstart`](examples/quickstart). It uses the published-style `pro.abgrid:alfresco-community-spring-services:1.0.0` dependency and demonstrates upload, download, metadata, typed search and centralized ACS error handling through the high-level `AlfrescoClient`.

Until the library is published, run `mvn clean install` in the repository root and then `mvn spring-boot:run` inside `examples/quickstart`.

## Build and release artifacts

This project is a **library**, not an executable Spring Boot application. The Maven build therefore produces a regular dependency JAR and does not run Spring Boot repackaging.

Use the release-oriented verification build:

```bash
mvn clean verify
```

A successful build must produce the following artifacts in `target/`:

| Artifact | Purpose |
|---|---|
| `alfresco-community-spring-services-1.0.0.jar` | Main library JAR used as an application dependency. |
| `alfresco-community-spring-services-1.0.0-sources.jar` | Java sources for IDE navigation, debugging and source attachment. |
| `alfresco-community-spring-services-1.0.0-javadoc.jar` | Generated RU/EN API JavaDoc for IDEs and repository publication. |

`maven-javadoc-plugin` runs during the Maven `verify` phase with `failOnError=true`, `failOnWarnings=true` and full JDK doclint enabled. Invalid JavaDoc is therefore treated as a release-build failure instead of being silently published.

The source JAR is attached during `package`; the JavaDoc JAR is deliberately generated during `verify`, so `mvn clean verify` is the canonical pre-release command.

For local use, after verification install all attached artifacts into the local Maven repository:

```bash
mvn clean install
```

The project intentionally does **not** contain a hard-coded `distributionManagement` deployment URL. The previously used `https://repo.maven.apache.org/maven2` address is a repository consumption endpoint, not a valid Maven Central publishing configuration. Publication credentials and repository metadata will be configured separately for the chosen publishing target.

## Integration tests against a real Alfresco instance

The project contains live integration coverage across the high-level service layer, including content, search, metadata/versioning, permissions, identity/sites, social features, associations/categories/queries, audit/activity/preferences, shared links/trash/downloads, and transformations.
The live tests are skipped unless `ALFRESCO_TEST_URL` is set.

PowerShell:

```powershell
$env:ALFRESCO_TEST_URL="http://localhost:8082"
$env:ALFRESCO_TEST_USERNAME="admin"
$env:ALFRESCO_TEST_PASSWORD="admin"
mvn test
```

Linux/macOS:

```bash
export ALFRESCO_TEST_URL=http://localhost:8082
export ALFRESCO_TEST_USERNAME=admin
export ALFRESCO_TEST_PASSWORD=admin
mvn test
```

The tests use uniquely named data to avoid collisions. Most temporary content is cleaned up automatically; a small number of entities may intentionally remain when the public ACS REST API has no corresponding delete operation.

## Transformations and renditions

`AlfrescoTransformationService` provides high-level asynchronous rendition operations:

```java
TransformationResult pdf = transformation.toPdf(nodeId);
TransformationResult preview = transformation.preview(nodeId);
TransformationResult thumbnail = transformation.thumbnail(nodeId);
TransformationResult custom = transformation.transform(nodeId, "my-rendition");
```

The service requests the rendition, waits until Alfresco reports `CREATED`, and downloads the generated content. The default timeout is 60 seconds with a 500 ms polling interval; both can be configured per call.

For direct rendition lifecycle operations use `AlfrescoRenditionService` (`list`, `get`, `request`, `content`, `delete`).

### Integration tests

Set these environment variables before running integration tests against a live ACS instance:

```powershell
$env:ALFRESCO_TEST_URL="http://localhost:8082"
$env:ALFRESCO_TEST_USERNAME="admin"
$env:ALFRESCO_TEST_PASSWORD="your-password"
mvn clean test
```

The transformation integration tests exercise DOCX -> PDF and image thumbnail generation against the real Alfresco/Transform Service installation.

## Metadata, aspects and versioning

High-level metadata operations are available through `AlfrescoMetadataService`:

```java
metadata.updateProperties(nodeId, Map.of("cm:title", "Contract"));
metadata.addAspect(nodeId, "cm:titled");
metadata.removeAspect(nodeId, "cm:titled");
boolean titled = metadata.hasAspect(nodeId, "cm:titled");
```

Version-aware content updates are available through `AlfrescoVersionService`:

```java
versions.updateContent(nodeId, bytes, VersionRequest.major("Approved version"));
versions.updateContent(nodeId, bytes, VersionRequest.minor("Draft update"));
VersionPaging history = versions.history(nodeId, 0, 100);
```

`createVersion(...)` can also create a snapshot while preserving the current document bytes.

The `AlfrescoMetadataVersionIntegrationTest` exercises metadata, aspects and major-version creation against a real ACS instance using the same `ALFRESCO_TEST_*` environment variables as the other integration tests.

## Permissions / ACL

High-level ACL operations are available through `AlfrescoPermissionService` and `AlfrescoDocumentService`:

```java
PermissionSnapshot acl = permissionService.get(nodeId);
permissionService.grant(nodeId, "GROUP_EVERYONE", "Consumer");
permissionService.deny(nodeId, "user@example.com", "Write");
permissionService.revoke(nodeId, "GROUP_EVERYONE", "Consumer");
permissionService.revokeAll(nodeId, "user@example.com");
permissionService.disableInheritance(nodeId);
permissionService.enableInheritance(nodeId);
```

`grant`, `deny`, `revoke` and inheritance changes preserve unrelated locally-set ACL entries. Use `replaceLocal` only when intentionally replacing the complete local ACL.

The example configuration now uses `http://localhost:8082`.

## Users, groups and sites

The high-level identity/collaboration layer now includes person lookup and membership discovery,
group lifecycle and membership management, and site lifecycle, person/group roles and containers.
Group identifiers are normalized to Alfresco's `GROUP_` form by `AlfrescoGroupService`.

A live `AlfrescoIdentitySiteIntegrationTest (creates a real temporary integration user; the user is intentionally retained because ACS People REST API has no delete-person operation)` creates a temporary group and site, exercises memberships
against the configured ACS instance, and removes both in `finally`.

## Tags, comments, ratings and favorites

High-level services now cover common collaboration metadata around repository nodes:

- `AlfrescoTagService`: node tags plus global tag create/read/rename/delete operations.
- `AlfrescoCommentService`: list, create, update and delete comments.
- `AlfrescoRatingService`: explicit `like()` and validated `fiveStar()` helpers, generic rating access and removal.
- `AlfrescoFavoriteService`: file/folder/site favorites, `-me-` helpers, listing and removal.
- `AlfrescoDocumentService` exposes common tag/comment/rating/favorite shortcuts.
- `AlfrescoSocialIntegrationTest` exercises a real file through tag, comment, like and favorite lifecycles.


### Rating value types

ACS requires the JSON type of `myRating` to match the rating scheme: `boolean` for `likes` and an integer for `fiveStar`. The high-level `AlfrescoRatingService.like()` and `fiveStar()` methods send those native JSON types. This intentionally corrects the overly broad string typing present in the source Swagger model.

The live social integration test validates `likes`. Alfresco does not allow a user to apply the `fiveStar` scheme to content owned by that same user, so the single-user integration scenario intentionally does not call `fiveStar()` on its freshly uploaded document.


## Associations, categories and queries

High-level relationship and query layer:

- `AlfrescoAssociationService`: create/delete associations plus typed source/target paging and assocType filtering.
- `AlfrescoCategoryService`: category CRUD, root/subcategory listing, node assignment/unassignment.
- `AlfrescoQueryService`: typed node/site/person query helpers.
- `PageSlice<T>` + `PagingExtractor`: converts generated `Object list` paging payloads into typed high-level pages.
- `AlfrescoAssociationCategoryQueryIntegrationTest`: live ACS lifecycle test for associations, categories and repository queries.


## Shared links, trashcan and downloads

High-level lifecycle support now includes:

- shared links: create/get/list current user's links/download shared content/delete;
- trashcan: typed paging, get deleted node/content, restore to original or another parent, purge; original-location restore sends no body, matching the optional Swagger restore body;
- asynchronous ZIP downloads: create, poll until `DONE`, fetch ZIP content, cancel/delete;
- live integration coverage in `AlfrescoSharingTrashDownloadIntegrationTest`.

`AlfrescoDownloadService` validates empty/duplicate node id lists before calling ACS. Download content is read from the generated download node after ACS reports `DONE`.


## Audit, activities and preferences

High-level administration and user-state support now includes:

- audit applications: typed paging, lookup, enable/disable, application entries and node entries;
- audit entry deletion with a required non-blank `where` guard for bulk deletion;
- activity feeds: typed paging for a person, `-me-`, `who` and `siteId` filters;
- preferences: typed paging, get/update, plus convenient current-user methods;
- live integration coverage in `AlfrescoAuditActivityPreferenceIntegrationTest`.

The integration test intentionally leaves its uniquely named preference in the disposable ACS test instance because the public Preferences REST API has no delete endpoint.

Live ACS 26.2 compatibility: audit application GET/PUT responses are unwrapped from the actual `{entry:{...}}` envelope by `AlfrescoAuditService`.


## Search DSL, typed search results and convenient models

`AlfrescoSearchService` now keeps the original raw search methods and adds a preferred typed `find(SearchCriteria)` API.

```java
SearchResultPage page = search.find(new SearchCriteria()
        .text("contract")
        .folder(folderId)
        .mimeType("application/pdf")
        .propertyEquals("cm:creator", "admin")
        .sortBy("cm:modified", false)
        .include("properties", "path")
        .fields("id", "name", "content", "properties")
        .page(0)
        .size(50));

for (SearchHit hit : page.entries()) {
    System.out.println(hit.name() + " / " + hit.mimeType() + " / " + hit.score());
}
```

The fluent criteria builder combines AFTS clauses instead of silently choosing only one criterion. With `userQuery`, structural constraints are sent as filter queries so they restrict results without replacing the full-text query. Typed `SearchResultPage` exposes pagination, context, convenient `SearchHit` values and the raw generated `ResultNode` for advanced access.

The existing `search(...)`, `afts(...)`, `userQuery(...)`, `execute(...)` and `raw(...)` methods remain available for backward compatibility.


## Exceptions, safe retry and diagnostics

Production-oriented HTTP behavior is now built into the SDK layer:

- `AlfrescoApiException` exposes HTTP method, request URI, raw response and parsed ACS error details;
- convenience predicates cover common cases such as 401/403/404/409/429 and retryable server statuses;
- standard ACS `{error:{...}}` payloads are parsed into `AlfrescoErrorDetails` (`errorKey`, `briefSummary`, `descriptionURL`, `logId`);
- transient retry is enabled by default only for safe read methods (`GET`, `HEAD`, `OPTIONS`), never automatically for POST/PUT/PATCH/DELETE;
- retries cover network `IOException` plus HTTP 429/502/503/504 with bounded exponential backoff;
- optional request timing diagnostics log method, URI, status and elapsed time without credentials or bodies;
- `AlfrescoContentIntegrationTest` now verifies structured 404 diagnostics against live ACS.

Example configuration:

```yaml
alfresco:
  retry:
    enabled: true
    max-attempts: 3
    initial-delay: 200ms
    max-delay: 2s
  diagnostics:
    enabled: false
```

The retry policy is intentionally conservative: write operations are not repeated automatically because a connection failure does not prove that ACS failed to apply the write.


## Stable public API

The first public release exposes the complete live-tested service layer. Existing individual service beans remain available and
`AlfrescoClient` is added as an optional single entry point. `AlfrescoInfoService` provides
password-safe connection diagnostics.

Compatibility baseline: Java 21, Spring Boot 4.1, Alfresco Community Edition 26.2.0.

The regression suite covers content, search, metadata/versioning, permissions, users/groups/sites,
social APIs, associations/categories/queries, shared links/trash/downloads, audit/activity/preferences,
transformations/renditions, structured errors, the stable facade and SDK-only behavior.
