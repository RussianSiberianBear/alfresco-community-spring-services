# alfresco-community-spring-services quickstart

Runnable Spring Boot 4.1 / Java 21 consumer application for `alfresco-community-spring-services:1.0.0`.

The example deliberately uses only the **high-level API** (`AlfrescoClient`) in application code. It does not inject the generated `*Api` HTTP interfaces directly.

## 1. Install the library locally

Until `alfresco-community-spring-services` is published to a Maven repository, install it from the repository root:

```bash
mvn clean install
```

This installs the main JAR, sources JAR and JavaDoc JAR in the local Maven repository.

## 2. Configure Alfresco

Defaults are suitable for the project's tested local ACS environment:

- `ALFRESCO_URL=http://localhost:8082`
- `ALFRESCO_USERNAME=admin`
- `ALFRESCO_PASSWORD=admin`
- example application port: `8090`

Override them with environment variables when necessary.

PowerShell example:

```powershell
$env:ALFRESCO_URL="http://localhost:8082"
$env:ALFRESCO_USERNAME="admin"
$env:ALFRESCO_PASSWORD="admin"
```

## 3. Run

From `examples/quickstart`:

```bash
mvn spring-boot:run
```

## Smoke test

Before starting the example, you can verify its Spring wiring:

```bash
mvn test
```

The smoke test starts the application context using only `alfresco.url`, `alfresco.username` and `alfresco.password`. It does not require a live ACS request.

## Endpoints

### Upload a document

The high-level call behind this endpoint is:

```java
alfresco.content().upload(new StreamingUploadRequest(...));
```

Alfresco supports special parent IDs such as `-my-`; alternatively pass a real folder node ID.

```bash
curl.exe -X POST "http://localhost:8090/api/alfresco/documents?parentId=-my-&autoRename=true&title=Quickstart&description=Uploaded%20through%20alfresco-community-spring-services" \
  -F "file=@README.md"
```

The example uses `MultipartFile.getResource()` with `StreamingUploadRequest`, so the controller does not call `MultipartFile.getBytes()` before sending content to Alfresco. It also passes `cm:title` and `cm:description` as arbitrary multipart QName properties.

Response example:

```json
{
  "id": "8ab7...",
  "name": "README.md",
  "nodeType": "cm:content",
  "parentId": "..."
}
```

### Read node information

```bash
curl "http://localhost:8090/api/alfresco/documents/{nodeId}"
```

Uses `alfresco.content().get(nodeId)`.

### Read metadata/properties

```bash
curl "http://localhost:8090/api/alfresco/documents/{nodeId}/metadata"
```

Uses `alfresco.metadata().properties(nodeId)`.

### Download binary content

```bash
curl -OJ "http://localhost:8090/api/alfresco/documents/{nodeId}/content"
```

Uses `alfresco.content().downloadTo(nodeId, outputStream)` through Spring MVC `StreamingResponseBody`, so the complete Alfresco response is not first collected into a `byte[]`.

### Search

```bash
curl "http://localhost:8090/api/alfresco/search?q=README&page=0&size=20"
```

Uses the typed high-level search result:

```java
SearchResultPage result = alfresco.search().userQueryTyped("README", 0, 20);
```

Newly uploaded content may require a short indexing delay before it appears in Search API results.

## Error handling

`AlfrescoExceptionHandler` demonstrates centralized JSON error handling. Alfresco REST failures are mapped from `AlfrescoApiException` using HTTP status, `errorKey`, brief summary and Alfresco `logId`; malformed requests, missing multipart parts, oversized uploads and local upload I/O failures also return the same JSON error shape instead of the default HTML error page.

Example error shape:

```json
{
  "status": 404,
  "errorKey": "framework.exception.EntityNotFound",
  "message": "...",
  "alfrescoLogId": "...",
  "path": "/api/alfresco/documents/missing-id"
}
```

## Windows command prompt

For multiline commands in `cmd.exe`, replace the trailing `\` with `^`. For example:

```bat
curl.exe -X POST "http://localhost:8090/api/alfresco/documents?parentId=-my-&autoRename=true&title=Quickstart" ^
  -F "file=@README.md"
```

## Alfresco health

The quickstart includes Spring Boot Actuator to demonstrate the library's optional health integration. With the application running:

```bash
curl "http://localhost:8090/actuator/health"
```

The `alfresco` contributor performs a real Discovery request to the configured repository. Disable it with `ALFRESCO_HEALTH_ENABLED=false`.
