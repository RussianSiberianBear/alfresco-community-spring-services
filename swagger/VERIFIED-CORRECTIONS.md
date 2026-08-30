# Verified Swagger corrections / Проверенные исправления Swagger

RU: Эти изменения подтверждены интеграционными тестами против Alfresco Community Edition 26.2.0.
Они не означают, что вся исходная спецификация Alfresco была независимо перепроверена.

EN: These changes were verified by integration tests against Alfresco Community Edition 26.2.0.
They do not imply that every part of the upstream Alfresco specification was independently revalidated.

## alfresco-core.yaml

1. `GET /audit-applications/{auditApplicationId}` returns an `AuditAppEntry` wrapper.
2. `PUT /audit-applications/{auditApplicationId}` returns an `AuditAppEntry` wrapper.
3. Rating `myRating` is polymorphic: boolean for `likes`, integer for `fiveStar`.
4. `POST /deleted-nodes/{nodeId}/restore` accepts no request body when restoring to the original parent.

The generated Java layer in this repository already reflects these live-API behaviors.
