# Examples

## `quickstart/`

A runnable Spring Boot 4.1 / Java 21 application that consumes `alfresco-community-spring-services` as an ordinary Maven dependency.

It demonstrates:

- `AlfrescoClient` as the single high-level facade;
- multipart document upload through `AlfrescoContentService.upload(UploadRequest)`;
- node retrieval;
- metadata/property retrieval;
- binary download through `ContentResource`;
- typed search through `SearchResultPage`;
- centralized JSON error handling for Alfresco and upload/request failures;
- a Spring context smoke test proving the example needs only the public `alfresco.*` configuration.

See [`quickstart/README.md`](quickstart/README.md) for build, configuration and curl examples.

Before running it, install the library from the repository root with:

```bash
mvn clean install
```
