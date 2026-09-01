# Changelog

## 1.0.0 — First public release

### Project identity and compatibility

- First public release of **Alfresco Community Spring Services**.
- Maven coordinates: `pro.abgrid:alfresco-community-spring-services:1.0.0`.
- Public Java packages use the `pro.abgrid.alfresco` namespace.
- Compatibility baseline: Java 21, Spring Boot 4.1 and Alfresco Community Edition 26.2.0.
- Other Alfresco Content Services editions may expose compatible REST APIs, but are not currently integration-tested or officially supported by this project.

### High-level API

- Provides `AlfrescoClient` as an optional single entry point while preserving individually injectable high-level service beans.
- Covers content, search, transformations, renditions, metadata, versions, permissions, users, groups, sites, tags, comments, ratings, favorites, shared links, downloads, trash, associations, categories, queries, audit, activities, preferences and images.
- Keeps the generated low-level REST interfaces available for advanced direct use.
- Adds password-safe `AlfrescoInfoService` / `AlfrescoConnectionInfo` diagnostics.

### HTTP behavior and compatibility

- Structured `AlfrescoApiException` / `AlfrescoErrorDetails` handling for ACS REST errors.
- Conservative retries for safe read methods only (`GET`, `HEAD`, `OPTIONS`) on transient network errors and HTTP 429/502/503/504.
- Optional request diagnostics without logging credentials or request/response bodies.
- A single `alfresco.url` configures the core, authentication, search and discovery HTTP Service base URLs automatically.
- Bundled Swagger definitions contain only live-verified compatibility corrections for ACS Community 26.2 behavior.
- `UploadRequest.properties` is forwarded as multipart QName fields; live integration coverage verifies `cm:title` and `cm:description`.
- Uses one shared Java 21 JDK `HttpClient` across all Alfresco HTTP Service groups for connection reuse.
- Adds configurable `alfresco.http.connect-timeout` (default `5s`) and `alfresco.http.read-timeout` (default `30s`).
- Adds constant-memory streaming content APIs: `StreamingUploadRequest` plus `AlfrescoContentService.downloadTo(OutputStream/Path)`.
- Adds an optional Actuator `alfrescoHealthIndicator`, automatically available only when Actuator is present in the consuming application.

### Search and convenience models

- Fluent `SearchCriteria`, typed `SearchResultPage` and `SearchHit`, while retaining raw search methods.
- Paging/search extractors and application-friendly models over generated DTOs.

### Quality, documentation and build

- Live integration suite against Alfresco Community Edition 26.2 plus unit/regression coverage.
- Bilingual RU/EN JavaDoc across public services, APIs, DTOs, models, configuration, exceptions and support code.
- Strict JavaDoc/doclint validation during `mvn verify`.
- Builds a regular library JAR plus attached `sources.jar` and `javadoc.jar`.
- Includes an opt-in Maven Central publishing scaffold; normal builds never publish.
- Includes the tested Docker stack definition used for live verification.

### Runnable quickstart

- `examples/quickstart` is a Spring Boot 4.1 / Java 21 consumer application that uses the high-level `AlfrescoClient`.
- Demonstrates upload with metadata, download, metadata retrieval, typed search and centralized JSON error handling.
- Includes a Spring context smoke test using only `alfresco.url`, `alfresco.username` and `alfresco.password`.
- Includes Windows `cmd.exe` / `curl.exe` usage examples.
