# Alfresco Community Spring Services 1.0.0

Высокоуровневый интеграционный слой для Alfresco Community Edition на
Spring Boot 4.1 / Java 21, построенный поверх сгенерированного
типизированного REST-клиента Alfresco.

> **Русская версия** · [English version below](#english-version)

## Архитектура

-   `pro.abgrid.alfresco.api` --- низкоуровневые типизированные
    HTTP-интерфейсы, сгенерированные из Alfresco OpenAPI.
-   `pro.abgrid.alfresco.dto` --- сгенерированные DTO API.
-   `pro.abgrid.alfresco.service.*` --- высокоуровневые Spring-сервисы.
-   `pro.abgrid.alfresco.model` --- небольшие модели, удобные для
    использования в приложениях.

Исходный низкоуровневый клиент намеренно сохранён. Высокоуровневые
сервисы являются дополнительным слоем и не препятствуют прямому
использованию сгенерированных API.

## Проверенный стек выполнения

Интеграционный набор тестов этого релиза выполнялся на приведённом ниже
стеке Docker Compose. Это **проверенные версии тестового окружения**, а
не обязательные транзитивные зависимости библиотеки.

  -------------------------------------------------------------------------------------------------------
  Компонент                           Проверенный образ / версия
  ----------------------------------- -------------------------------------------------------------------
  `alfresco`                          `docker.io/alfresco/alfresco-content-repository-community:26.2.0`

  `transform-core-aio`                `alfresco/alfresco-transform-core-aio:5.4.3`

  `share`                             `docker.io/alfresco/alfresco-share:26.2.0`

  `postgres`                          `postgres:17.9`

  `elasticsearch`                     `elasticsearch:8.17.10`

  `kibana`                            `kibana:8.17.10`

  `batch-indexing`                    `docker.io/alfresco/alfresco-elasticsearch-batch-indexing:5.7.0`

  `activemq`                          `docker.io/alfresco/alfresco-activemq:6.2.6-jre17-rockylinux8`

  `content-app`                       `alfresco/alfresco-content-app:8.0.0`

  `control-center`                    `quay.io/alfresco/alfresco-control-center:11.0.0`
  -------------------------------------------------------------------------------------------------------

**Traefik (прокси) --- 3.6**

Копия использованного compose-файла сохранена как
`docker/community-compose-tested.yaml` в качестве эталона проверенного
тестового стека.

Версии репозитория и Share, на которых выполнялся интеграционный набор
тестов: **Alfresco Community Edition 26.2.0.0** / **Alfresco Share
26.2.0**. Такие возможности, как преобразования, поиск и обмен
сообщениями, по-прежнему зависят от того, включены ли соответствующие
сервисы в целевом развёртывании.

**Область поддержки:** проект разрабатывается и интеграционно
тестируется с Alfresco Community Edition. Другие редакции Alfresco
Content Services могут предоставлять совместимые REST API, однако в
настоящее время они не тестируются и не заявляются проектом как
официально поддерживаемые.

### Примечания по совместимости Swagger/OpenAPI

Включённые в проект определения Swagger 2.0 по-прежнему основаны на
публичных спецификациях Alfresco REST, но содержат небольшой набор
исправлений, проверенных на реальном экземпляре ACS Community 26.2.0,
используемом этим проектом:

-   ответы `GET`/`PUT` для audit application обёрнуты в `AuditAppEntry`
    (`{"entry": {...}}`);
-   `myRating` для рейтинга является полиморфным (`boolean` для `likes`,
    `integer` для `fiveStar`), а не всегда строкой;
-   тело запроса при восстановлении из корзины необязательно; если его
    не передавать, узел восстанавливается в исходное расположение.

Эти исправления намеренно ограничены поведением, фактически
наблюдавшимся интеграционным набором тестов; проект не утверждает, что
каждая деталь исходного Swagger была независимо перепроверена.

## Сервисы

Стабильный высокоуровневый API включает `AlfrescoClient`, а также
отдельные Spring-бины сервисов: `AlfrescoContentService`,
`AlfrescoDocumentService`, `AlfrescoSearchService`,
`AlfrescoTransformationService`, `AlfrescoRenditionService`,
`AlfrescoVersionService`, `AlfrescoMetadataService`,
`AlfrescoPermissionService`, `AlfrescoUserService`,
`AlfrescoGroupService`, `AlfrescoSiteService`, `AlfrescoTagService`,
`AlfrescoCommentService`, `AlfrescoRatingService`,
`AlfrescoFavoriteService`, `AlfrescoSharedLinkService`,
`AlfrescoDownloadService`, `AlfrescoTrashService`,
`AlfrescoAssociationService`, `AlfrescoCategoryService`,
`AlfrescoQueryService`, `AlfrescoAuditService`,
`AlfrescoActivityService`, `AlfrescoPreferenceService`,
`AlfrescoImageService` и `AlfrescoInfoService`.

## Конфигурация

``` yaml
alfresco:
  url: http://localhost:8082
  username: admin
  password: admin
  http:
    connect-timeout: 5s
    read-timeout: 30s
  health:
    enabled: true
```

`alfresco.url` --- корневой адрес сервера ACS. Библиотека автоматически
формирует базовые REST URL для core, authentication, search и discovery;
приложениям не требуется дублировать эти пути в
`spring.http.serviceclient.*`.

Все группы Alfresco HTTP Service используют один общий JDK `HttpClient`
из Java 21, поэтому постоянные соединения повторно используются между
запросами без дополнительной зависимости от Apache HTTP Client. Тайм-аут
подключения по умолчанию составляет 5 секунд, а тайм-аут чтения --- 30
секунд; оба параметра настраиваются через `alfresco.http.*`.

Если в приложении-потребителе присутствует Spring Boot Actuator,
автоматически регистрируется `alfrescoHealthIndicator`, проверяющий
репозиторий через Discovery API. Чтобы отключить его, установите
`alfresco.health.enabled=false`. Actuator остаётся необязательной
зависимостью библиотеки.

## Примеры

``` java
NodeEntry file = documents.upload(new UploadRequest(folderId, "contract.docx", bytes));
ContentResource content = documents.download(file.getEntry().getId()); // удобно для небольших файлов

NodeEntry large = contentService.upload(new StreamingUploadRequest(folderId, "archive.zip", fileResource));
contentService.downloadTo(large.getEntry().getId(), outputStream); // потоковая обработка с постоянным потреблением памяти

TransformationResult pdf = documents.toPdf(file.getEntry().getId());
SearchPage result = search.afts("cm:name:'*.pdf'", 0, 50);
```

## Важно

Преобразования обеспечиваются трансформерами/renditions, установленными
и включёнными в целевом развёртывании ACS. Библиотека не предполагает,
что доступны все возможные исходные и целевые форматы.

## Запускаемый пример

Отдельное приложение-потребитель находится в
[`examples/quickstart`](examples/quickstart). Оно использует зависимость
`pro.abgrid:alfresco-community-spring-services:1.0.0` в том виде, в
котором она будет публиковаться, и демонстрирует загрузку, скачивание,
работу с метаданными, типизированный поиск и централизованную обработку
ошибок ACS через высокоуровневый `AlfrescoClient`.

Пока библиотека не опубликована, выполните `mvn clean install` в корне
репозитория, а затем `mvn spring-boot:run` внутри `examples/quickstart`.

## Сборка и артефакты релиза

Этот проект является **библиотекой**, а не исполняемым приложением
Spring Boot. Поэтому Maven создаёт обычный JAR для использования в
качестве зависимости и не выполняет Spring Boot repackaging.

Для проверки перед релизом используйте:

``` bash
mvn clean verify
```

Успешная сборка должна создать в `target/` следующие артефакты:

  --------------------------------------------------------------------------------------------
  Артефакт                                                 Назначение
  -------------------------------------------------------- -----------------------------------
  `alfresco-community-spring-services-1.0.0.jar`           Основной JAR библиотеки,
                                                           используемый как зависимость
                                                           приложения.

  `alfresco-community-spring-services-1.0.0-sources.jar`   Исходный код Java для навигации в
                                                           IDE, отладки и подключения
                                                           исходников.

  `alfresco-community-spring-services-1.0.0-javadoc.jar`   Сгенерированный RU/EN API JavaDoc
                                                           для IDE и публикации в репозитории.
  --------------------------------------------------------------------------------------------

`maven-javadoc-plugin` выполняется на фазе Maven `verify` с
`failOnError=true`, `failOnWarnings=true` и полностью включённым JDK
doclint. Поэтому некорректный JavaDoc приводит к ошибке релизной сборки,
а не публикуется молча.

JAR с исходниками подключается на фазе `package`; JAR с JavaDoc
намеренно генерируется на фазе `verify`, поэтому `mvn clean verify`
является основной командой проверки перед релизом.

Для локального использования после проверки установите все подключённые
артефакты в локальный Maven-репозиторий:

``` bash
mvn clean install
```

Проект намеренно **не** содержит жёстко заданный URL развёртывания
`distributionManagement`. Использовавшийся ранее адрес
`https://repo.maven.apache.org/maven2` является endpoint для получения
зависимостей, а не корректной конфигурацией публикации в Maven Central.
Учётные данные и метаданные репозитория будут настроены отдельно для
выбранной цели публикации.

## Интеграционные тесты с реальным экземпляром Alfresco

Проект содержит интеграционные тесты высокоуровневого сервисного слоя,
охватывающие контент, поиск, метаданные/версионирование, разрешения,
пользователей/сайты, социальные функции, ассоциации/категории/запросы,
аудит/активность/настройки, общие ссылки/корзину/скачивания и
преобразования. Реальные интеграционные тесты пропускаются, если
переменная `ALFRESCO_TEST_URL` не задана.

PowerShell:

``` powershell
$env:ALFRESCO_TEST_URL="http://localhost:8082"
$env:ALFRESCO_TEST_USERNAME="admin"
$env:ALFRESCO_TEST_PASSWORD="admin"
mvn test
```

Linux/macOS:

``` bash
export ALFRESCO_TEST_URL=http://localhost:8082
export ALFRESCO_TEST_USERNAME=admin
export ALFRESCO_TEST_PASSWORD=admin
mvn test
```

Тесты используют уникальные имена данных, чтобы избежать конфликтов.
Большая часть временного содержимого удаляется автоматически; небольшое
количество сущностей может намеренно оставаться, если публичный REST API
ACS не предоставляет соответствующей операции удаления.

## Преобразования и представления (renditions)

`AlfrescoTransformationService` предоставляет высокоуровневые
асинхронные операции с renditions:

``` java
TransformationResult pdf = transformation.toPdf(nodeId);
TransformationResult preview = transformation.preview(nodeId);
TransformationResult thumbnail = transformation.thumbnail(nodeId);
TransformationResult custom = transformation.transform(nodeId, "my-rendition");
```

Сервис запрашивает rendition, ожидает, пока Alfresco сообщит состояние
`CREATED`, а затем скачивает сгенерированное содержимое. Тайм-аут по
умолчанию --- 60 секунд, интервал опроса --- 500 мс; оба значения можно
настроить для каждого вызова.

Для прямого управления жизненным циклом rendition используйте
`AlfrescoRenditionService` (`list`, `get`, `request`, `content`,
`delete`).

### Интеграционные тесты

Перед запуском интеграционных тестов с реальным экземпляром ACS задайте
следующие переменные окружения:

``` powershell
$env:ALFRESCO_TEST_URL="http://localhost:8082"
$env:ALFRESCO_TEST_USERNAME="admin"
$env:ALFRESCO_TEST_PASSWORD="your-password"
mvn clean test
```

Интеграционные тесты преобразований проверяют DOCX -\> PDF и создание
миниатюр изображений на реальной установке Alfresco/Transform Service.

## Метаданные, аспекты и версионирование

Высокоуровневые операции с метаданными доступны через
`AlfrescoMetadataService`:

``` java
metadata.updateProperties(nodeId, Map.of("cm:title", "Contract"));
metadata.addAspect(nodeId, "cm:titled");
metadata.removeAspect(nodeId, "cm:titled");
boolean titled = metadata.hasAspect(nodeId, "cm:titled");
```

Обновления содержимого с учётом версий доступны через
`AlfrescoVersionService`:

``` java
versions.updateContent(nodeId, bytes, VersionRequest.major("Approved version"));
versions.updateContent(nodeId, bytes, VersionRequest.minor("Draft update"));
VersionPaging history = versions.history(nodeId, 0, 100);
```

`createVersion(...)` также может создать снимок версии, сохранив текущие
байты документа.

`AlfrescoMetadataVersionIntegrationTest` проверяет метаданные, аспекты и
создание major-версии на реальном экземпляре ACS, используя те же
переменные окружения `ALFRESCO_TEST_*`, что и остальные интеграционные
тесты.

## Разрешения / ACL

Высокоуровневые операции ACL доступны через `AlfrescoPermissionService`
и `AlfrescoDocumentService`:

``` java
PermissionSnapshot acl = permissionService.get(nodeId);
permissionService.grant(nodeId, "GROUP_EVERYONE", "Consumer");
permissionService.deny(nodeId, "user@example.com", "Write");
permissionService.revoke(nodeId, "GROUP_EVERYONE", "Consumer");
permissionService.revokeAll(nodeId, "user@example.com");
permissionService.disableInheritance(nodeId);
permissionService.enableInheritance(nodeId);
```

`grant`, `deny`, `revoke` и изменения наследования сохраняют посторонние
локально заданные записи ACL. Используйте `replaceLocal` только тогда,
когда действительно требуется полностью заменить локальный ACL.

В конфигурации примера теперь используется `http://localhost:8082`.

## Пользователи, группы и сайты

Высокоуровневый слой идентификации и совместной работы теперь включает
поиск пользователей и получение информации о членстве, управление
жизненным циклом групп и их участниками, а также жизненным циклом
сайтов, ролями пользователей/групп и контейнерами. Идентификаторы групп
нормализуются `AlfrescoGroupService` к форме Alfresco `GROUP_`.

Реальный `AlfrescoIdentitySiteIntegrationTest` (создаёт временного
интеграционного пользователя; пользователь намеренно сохраняется,
поскольку ACS People REST API не предоставляет операции удаления
пользователя) создаёт временную группу и сайт, проверяет членство на
настроенном экземпляре ACS и удаляет группу и сайт в блоке `finally`.

## Теги, комментарии, рейтинги и избранное

Высокоуровневые сервисы теперь охватывают распространённые метаданные
совместной работы вокруг узлов репозитория:

-   `AlfrescoTagService`: теги узлов, а также глобальные операции
    создания/чтения/переименования/удаления тегов.
-   `AlfrescoCommentService`: получение списка, создание, обновление и
    удаление комментариев.
-   `AlfrescoRatingService`: явные помощники `like()` и проверяемый
    `fiveStar()`, универсальная работа с рейтингами и их удаление.
-   `AlfrescoFavoriteService`: избранные файлы/папки/сайты, помощники
    `-me-`, получение списка и удаление.
-   `AlfrescoDocumentService` предоставляет сокращённые методы для
    типовых операций с тегами/комментариями/рейтингами/избранным.
-   `AlfrescoSocialIntegrationTest` проверяет на реальном файле полный
    жизненный цикл тега, комментария, like и избранного.

### Типы значений рейтинга

ACS требует, чтобы JSON-тип `myRating` соответствовал схеме рейтинга:
`boolean` для `likes` и целое число для `fiveStar`. Высокоуровневые
методы `AlfrescoRatingService.like()` и `fiveStar()` отправляют именно
эти нативные JSON-типы. Тем самым намеренно исправляется слишком
обобщённая строковая типизация исходной Swagger-модели.

Реальный социальный интеграционный тест проверяет `likes`. Alfresco не
позволяет пользователю применить схему `fiveStar` к содержимому,
владельцем которого является этот же пользователь, поэтому
однопользовательский интеграционный сценарий намеренно не вызывает
`fiveStar()` для только что загруженного документа.

## Ассоциации, категории и запросы

Высокоуровневый слой связей и запросов:

-   `AlfrescoAssociationService`: создание/удаление ассоциаций,
    типизированная пагинация источников/целей и фильтрация по
    `assocType`.
-   `AlfrescoCategoryService`: CRUD категорий, получение
    корневых/дочерних категорий, назначение категории узлу и снятие
    назначения.
-   `AlfrescoQueryService`: типизированные вспомогательные методы
    запросов для узлов/сайтов/пользователей.
-   `PageSlice<T>` + `PagingExtractor`: преобразует сгенерированные
    paging payload с `Object list` в типизированные высокоуровневые
    страницы.
-   `AlfrescoAssociationCategoryQueryIntegrationTest`: реальный тест
    жизненного цикла ACS для ассоциаций, категорий и запросов к
    репозиторию.

## Общие ссылки, корзина и скачивания

Высокоуровневая поддержка жизненного цикла теперь включает:

-   общие ссылки: создание/получение/список ссылок текущего
    пользователя/скачивание общего содержимого/удаление;
-   корзину: типизированную пагинацию, получение удалённого
    узла/содержимого, восстановление в исходного или другого родителя,
    окончательное удаление; при восстановлении в исходное расположение
    тело запроса не отправляется, что соответствует необязательному телу
    restore-запроса в Swagger;
-   асинхронные ZIP-скачивания: создание, опрос до состояния `DONE`,
    получение ZIP-содержимого, отмена/удаление;
-   реальное интеграционное покрытие в
    `AlfrescoSharingTrashDownloadIntegrationTest`.

`AlfrescoDownloadService` проверяет списки идентификаторов узлов на
пустые и повторяющиеся значения до обращения к ACS. После того как ACS
сообщает `DONE`, содержимое скачивания читается из сгенерированного
download node.

## Аудит, активность и настройки

Высокоуровневая поддержка администрирования и пользовательского
состояния теперь включает:

-   audit applications: типизированную пагинацию, поиск,
    включение/отключение, записи приложения и записи узлов;
-   удаление записей аудита с обязательной непустой проверкой `where`
    для массового удаления;
-   ленты активности: типизированную пагинацию для пользователя, фильтры
    `-me-`, `who` и `siteId`;
-   настройки: типизированную пагинацию, получение/обновление, а также
    удобные методы для текущего пользователя;
-   реальное интеграционное покрытие в
    `AlfrescoAuditActivityPreferenceIntegrationTest`.

Интеграционный тест намеренно оставляет свою настройку с уникальным
именем в одноразовом тестовом экземпляре ACS, поскольку публичный
Preferences REST API не предоставляет endpoint удаления.

Совместимость с реальным ACS 26.2: `AlfrescoAuditService` разворачивает
ответы GET/PUT audit application из фактической оболочки
`{entry:{...}}`.

## Search DSL, типизированные результаты поиска и удобные модели

`AlfrescoSearchService` сохраняет исходные методы необработанного поиска
и добавляет предпочтительный типизированный API `find(SearchCriteria)`.

``` java
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

Fluent-конструктор критериев объединяет условия AFTS, а не молча
выбирает только один критерий. При использовании `userQuery` структурные
ограничения отправляются как filter queries, поэтому они ограничивают
результаты, не заменяя полнотекстовый запрос. Типизированный
`SearchResultPage` предоставляет пагинацию, контекст, удобные значения
`SearchHit` и исходный сгенерированный `ResultNode` для расширенного
доступа.

Существующие методы `search(...)`, `afts(...)`, `userQuery(...)`,
`execute(...)` и `raw(...)` остаются доступными для обратной
совместимости.

## Исключения, безопасные повторные попытки и диагностика

Поведение HTTP, ориентированное на production-использование, теперь
встроено в слой SDK:

-   `AlfrescoApiException` предоставляет HTTP-метод, URI запроса,
    необработанный ответ и разобранные сведения об ошибке ACS;
-   вспомогательные предикаты охватывают типовые случаи
    401/403/404/409/429 и повторяемые серверные статусы;
-   стандартные payload ACS вида `{error:{...}}` разбираются в
    `AlfrescoErrorDetails` (`errorKey`, `briefSummary`,
    `descriptionURL`, `logId`);
-   повторные попытки при временных ошибках по умолчанию включены только
    для безопасных методов чтения (`GET`, `HEAD`, `OPTIONS`) и никогда
    автоматически не применяются к POST/PUT/PATCH/DELETE;
-   повторные попытки выполняются при сетевом `IOException`, а также
    HTTP 429/502/503/504, с ограниченной экспоненциальной задержкой;
-   необязательная диагностика времени запросов журналирует метод, URI,
    статус и длительность без учётных данных и тел запросов;
-   `AlfrescoContentIntegrationTest` теперь проверяет структурированную
    диагностику 404 на реальном ACS.

Пример конфигурации:

``` yaml
alfresco:
  retry:
    enabled: true
    max-attempts: 3
    initial-delay: 200ms
    max-delay: 2s
  diagnostics:
    enabled: false
```

Политика повторных попыток намеренно консервативна: операции записи
автоматически не повторяются, поскольку ошибка соединения не доказывает,
что ACS не успел применить изменение.

## HTTP-транспорт, потоковая передача и health check

Транспортный слой версии 1.0.0 использует один общий JDK `HttpClient`
для всех групп Alfresco HTTP Service. Это обеспечивает повторное
использование соединений/keep-alive без добавления зависимости Apache
HttpClient. Значение `alfresco.http.connect-timeout` по умолчанию ---
`5s`, `alfresco.http.read-timeout` --- `30s`.

Для больших объёмов содержимого предпочтительно использовать
`StreamingUploadRequest` и `AlfrescoContentService.downloadTo(...)`.
Потоковая загрузка принимает Spring `Resource`; потоковое скачивание
копирует данные непосредственно в `OutputStream` или `Path` приложения.
Существующие методы `UploadRequest` и `ContentResource`, работающие с
массивами байтов, остаются удобными для небольших файлов.

Когда Actuator присутствует в classpath приложения, необязательный
`alfrescoHealthIndicator` выполняет лёгкий Discovery-запрос. Он сообщает
только о доступности и типе исключения, не раскрывая учётные данные,
тела запросов или сообщения исключений. Отключить его можно через
`alfresco.health.enabled=false`.

## Стабильный публичный API

Первый публичный релиз предоставляет полный сервисный слой, проверенный
реальными интеграционными тестами. Существующие отдельные Spring-бины
сервисов остаются доступными, а `AlfrescoClient` добавлен как
необязательная единая точка входа. `AlfrescoInfoService` предоставляет
безопасную диагностику соединения без раскрытия пароля.

Базовая совместимость: Java 21, Spring Boot 4.1, Alfresco Community
Edition 26.2.0.

Регрессионный набор тестов охватывает контент, поиск,
метаданные/версионирование, разрешения, пользователей/группы/сайты,
социальные API, ассоциации/категории/запросы, общие
ссылки/корзину/скачивания, аудит/активность/настройки,
преобразования/renditions, структурированные ошибки, стабильный фасад и
поведение уровня SDK.

------------------------------------------------------------------------

`<a id="english-version">`{=html}`</a>`{=html}

# English version

# Alfresco Community Spring Services 1.0.0

High-level Spring Boot 4.1 / Java 21 integration layer for Alfresco
Community Edition, built on top of the generated typed Alfresco REST
client.

## Architecture

-   `pro.abgrid.alfresco.api` --- low-level typed HTTP interfaces
    generated from Alfresco OpenAPI.
-   `pro.abgrid.alfresco.dto` --- generated API DTOs.
-   `pro.abgrid.alfresco.service.*` --- high-level Spring services.
-   `pro.abgrid.alfresco.model` --- small application-friendly models.

The original low-level client is intentionally preserved. High-level
services are an additional layer and do not prevent direct use of the
generated APIs.

## Verified runtime stack

The integration suite for this release was executed against the exact
Docker Compose stack below. These are **verified test-environment
versions**, not mandatory transitive dependencies of this library.

  -------------------------------------------------------------------------------------------------------
  Component                           Verified image / version
  ----------------------------------- -------------------------------------------------------------------
  `alfresco`                          `docker.io/alfresco/alfresco-content-repository-community:26.2.0`

  `transform-core-aio`                `alfresco/alfresco-transform-core-aio:5.4.3`

  `share`                             `docker.io/alfresco/alfresco-share:26.2.0`

  `postgres`                          `postgres:17.9`

  `elasticsearch`                     `elasticsearch:8.17.10`

  `kibana`                            `kibana:8.17.10`

  `batch-indexing`                    `docker.io/alfresco/alfresco-elasticsearch-batch-indexing:5.7.0`

  `activemq`                          `docker.io/alfresco/alfresco-activemq:6.2.6-jre17-rockylinux8`

  `content-app`                       `alfresco/alfresco-content-app:8.0.0`

  `control-center`                    `quay.io/alfresco/alfresco-control-center:11.0.0`
  -------------------------------------------------------------------------------------------------------

**Traefik (proxy) --- 3.6** A copy of the supplied compose file is
retained as `docker/community-compose-tested.yaml` as a reference for
the verified test stack.

The repository and Share versions tested by the integration suite are
**Alfresco Community Edition 26.2.0.0** / **Alfresco Share 26.2.0**.
Features such as transformations, search and messaging still depend on
the corresponding services being enabled in the target deployment.

**Support scope:** this project is developed and integration-tested
against Alfresco Community Edition. Other Alfresco Content Services
editions may expose compatible REST APIs, but they are not currently
tested or claimed as officially supported by this project.

### Swagger/OpenAPI compatibility notes

The bundled Swagger 2.0 definitions remain based on the Alfresco public
REST specifications, with a small set of corrections verified against
the live ACS Community 26.2.0 instance used by this project:

-   audit application `GET`/`PUT` responses are wrapped as
    `AuditAppEntry` (`{"entry": {...}}`);
-   rating `myRating` is polymorphic (`boolean` for `likes`, `integer`
    for `fiveStar`) rather than always a string;
-   the trashcan restore request body is optional; omitting it restores
    the node to its original location.

These corrections are deliberately limited to behavior actually observed
by the integration suite; the project does not claim that every upstream
Swagger detail has been independently revalidated.

## Services

The stable high-level API includes `AlfrescoClient` plus the individual
service beans: `AlfrescoContentService`, `AlfrescoDocumentService`,
`AlfrescoSearchService`, `AlfrescoTransformationService`,
`AlfrescoRenditionService`, `AlfrescoVersionService`,
`AlfrescoMetadataService`, `AlfrescoPermissionService`,
`AlfrescoUserService`, `AlfrescoGroupService`, `AlfrescoSiteService`,
`AlfrescoTagService`, `AlfrescoCommentService`, `AlfrescoRatingService`,
`AlfrescoFavoriteService`, `AlfrescoSharedLinkService`,
`AlfrescoDownloadService`, `AlfrescoTrashService`,
`AlfrescoAssociationService`, `AlfrescoCategoryService`,
`AlfrescoQueryService`, `AlfrescoAuditService`,
`AlfrescoActivityService`, `AlfrescoPreferenceService`,
`AlfrescoImageService`, and `AlfrescoInfoService`.

## Configuration

``` yaml
alfresco:
  url: http://localhost:8082
  username: admin
  password: admin
  http:
    connect-timeout: 5s
    read-timeout: 30s
  health:
    enabled: true
```

`alfresco.url` is the ACS server root. The library derives the core,
authentication, search and discovery REST base URLs automatically;
applications do not need to duplicate those paths in
`spring.http.serviceclient.*`.

All Alfresco HTTP Service groups share one Java 21 JDK `HttpClient`, so
persistent connections are reused across requests without an additional
Apache HTTP client dependency. The default connect timeout is 5 seconds
and the default read timeout is 30 seconds; both are configurable under
`alfresco.http.*`.

If Spring Boot Actuator is present in the consuming application, an
`alfrescoHealthIndicator` is registered automatically and checks the
repository through the Discovery API. Set
`alfresco.health.enabled=false` to disable it. Actuator remains an
optional dependency of the library.

## Examples

``` java
NodeEntry file = documents.upload(new UploadRequest(folderId, "contract.docx", bytes));
ContentResource content = documents.download(file.getEntry().getId()); // convenient for small files

NodeEntry large = contentService.upload(new StreamingUploadRequest(folderId, "archive.zip", fileResource));
contentService.downloadTo(large.getEntry().getId(), outputStream); // constant-memory streaming path

TransformationResult pdf = documents.toPdf(file.getEntry().getId());
SearchPage result = search.afts("cm:name:'*.pdf'", 0, 50);
```

## Important

Transformations are provided by the transformers/renditions installed
and enabled in the target ACS deployment. The library does not assume
that every source/target format is available.

## Runnable example

A separate consumer application is available in
[`examples/quickstart`](examples/quickstart). It uses the
published-style `pro.abgrid:alfresco-community-spring-services:1.0.0`
dependency and demonstrates upload, download, metadata, typed search and
centralized ACS error handling through the high-level `AlfrescoClient`.

Until the library is published, run `mvn clean install` in the
repository root and then `mvn spring-boot:run` inside
`examples/quickstart`.

## Build and release artifacts

This project is a **library**, not an executable Spring Boot
application. The Maven build therefore produces a regular dependency JAR
and does not run Spring Boot repackaging.

Use the release-oriented verification build:

``` bash
mvn clean verify
```

A successful build must produce the following artifacts in `target/`:

  --------------------------------------------------------------------------------------------
  Artifact                                                 Purpose
  -------------------------------------------------------- -----------------------------------
  `alfresco-community-spring-services-1.0.0.jar`           Main library JAR used as an
                                                           application dependency.

  `alfresco-community-spring-services-1.0.0-sources.jar`   Java sources for IDE navigation,
                                                           debugging and source attachment.

  `alfresco-community-spring-services-1.0.0-javadoc.jar`   Generated RU/EN API JavaDoc for
                                                           IDEs and repository publication.
  --------------------------------------------------------------------------------------------

`maven-javadoc-plugin` runs during the Maven `verify` phase with
`failOnError=true`, `failOnWarnings=true` and full JDK doclint enabled.
Invalid JavaDoc is therefore treated as a release-build failure instead
of being silently published.

The source JAR is attached during `package`; the JavaDoc JAR is
deliberately generated during `verify`, so `mvn clean verify` is the
canonical pre-release command.

For local use, after verification install all attached artifacts into
the local Maven repository:

``` bash
mvn clean install
```

The project intentionally does **not** contain a hard-coded
`distributionManagement` deployment URL. The previously used
`https://repo.maven.apache.org/maven2` address is a repository
consumption endpoint, not a valid Maven Central publishing
configuration. Publication credentials and repository metadata will be
configured separately for the chosen publishing target.

## Integration tests against a real Alfresco instance

The project contains live integration coverage across the high-level
service layer, including content, search, metadata/versioning,
permissions, identity/sites, social features,
associations/categories/queries, audit/activity/preferences, shared
links/trash/downloads, and transformations. The live tests are skipped
unless `ALFRESCO_TEST_URL` is set.

PowerShell:

``` powershell
$env:ALFRESCO_TEST_URL="http://localhost:8082"
$env:ALFRESCO_TEST_USERNAME="admin"
$env:ALFRESCO_TEST_PASSWORD="admin"
mvn test
```

Linux/macOS:

``` bash
export ALFRESCO_TEST_URL=http://localhost:8082
export ALFRESCO_TEST_USERNAME=admin
export ALFRESCO_TEST_PASSWORD=admin
mvn test
```

The tests use uniquely named data to avoid collisions. Most temporary
content is cleaned up automatically; a small number of entities may
intentionally remain when the public ACS REST API has no corresponding
delete operation.

## Transformations and renditions

`AlfrescoTransformationService` provides high-level asynchronous
rendition operations:

``` java
TransformationResult pdf = transformation.toPdf(nodeId);
TransformationResult preview = transformation.preview(nodeId);
TransformationResult thumbnail = transformation.thumbnail(nodeId);
TransformationResult custom = transformation.transform(nodeId, "my-rendition");
```

The service requests the rendition, waits until Alfresco reports
`CREATED`, and downloads the generated content. The default timeout is
60 seconds with a 500 ms polling interval; both can be configured per
call.

For direct rendition lifecycle operations use `AlfrescoRenditionService`
(`list`, `get`, `request`, `content`, `delete`).

### Integration tests

Set these environment variables before running integration tests against
a live ACS instance:

``` powershell
$env:ALFRESCO_TEST_URL="http://localhost:8082"
$env:ALFRESCO_TEST_USERNAME="admin"
$env:ALFRESCO_TEST_PASSWORD="your-password"
mvn clean test
```

The transformation integration tests exercise DOCX -\> PDF and image
thumbnail generation against the real Alfresco/Transform Service
installation.

## Metadata, aspects and versioning

High-level metadata operations are available through
`AlfrescoMetadataService`:

``` java
metadata.updateProperties(nodeId, Map.of("cm:title", "Contract"));
metadata.addAspect(nodeId, "cm:titled");
metadata.removeAspect(nodeId, "cm:titled");
boolean titled = metadata.hasAspect(nodeId, "cm:titled");
```

Version-aware content updates are available through
`AlfrescoVersionService`:

``` java
versions.updateContent(nodeId, bytes, VersionRequest.major("Approved version"));
versions.updateContent(nodeId, bytes, VersionRequest.minor("Draft update"));
VersionPaging history = versions.history(nodeId, 0, 100);
```

`createVersion(...)` can also create a snapshot while preserving the
current document bytes.

The `AlfrescoMetadataVersionIntegrationTest` exercises metadata, aspects
and major-version creation against a real ACS instance using the same
`ALFRESCO_TEST_*` environment variables as the other integration tests.

## Permissions / ACL

High-level ACL operations are available through
`AlfrescoPermissionService` and `AlfrescoDocumentService`:

``` java
PermissionSnapshot acl = permissionService.get(nodeId);
permissionService.grant(nodeId, "GROUP_EVERYONE", "Consumer");
permissionService.deny(nodeId, "user@example.com", "Write");
permissionService.revoke(nodeId, "GROUP_EVERYONE", "Consumer");
permissionService.revokeAll(nodeId, "user@example.com");
permissionService.disableInheritance(nodeId);
permissionService.enableInheritance(nodeId);
```

`grant`, `deny`, `revoke` and inheritance changes preserve unrelated
locally-set ACL entries. Use `replaceLocal` only when intentionally
replacing the complete local ACL.

The example configuration now uses `http://localhost:8082`.

## Users, groups and sites

The high-level identity/collaboration layer now includes person lookup
and membership discovery, group lifecycle and membership management, and
site lifecycle, person/group roles and containers. Group identifiers are
normalized to Alfresco's `GROUP_` form by `AlfrescoGroupService`.

A live
`AlfrescoIdentitySiteIntegrationTest (creates a real temporary integration user; the user is intentionally retained because ACS People REST API has no delete-person operation)`
creates a temporary group and site, exercises memberships against the
configured ACS instance, and removes both in `finally`.

## Tags, comments, ratings and favorites

High-level services now cover common collaboration metadata around
repository nodes:

-   `AlfrescoTagService`: node tags plus global tag
    create/read/rename/delete operations.
-   `AlfrescoCommentService`: list, create, update and delete comments.
-   `AlfrescoRatingService`: explicit `like()` and validated
    `fiveStar()` helpers, generic rating access and removal.
-   `AlfrescoFavoriteService`: file/folder/site favorites, `-me-`
    helpers, listing and removal.
-   `AlfrescoDocumentService` exposes common tag/comment/rating/favorite
    shortcuts.
-   `AlfrescoSocialIntegrationTest` exercises a real file through tag,
    comment, like and favorite lifecycles.

### Rating value types

ACS requires the JSON type of `myRating` to match the rating scheme:
`boolean` for `likes` and an integer for `fiveStar`. The high-level
`AlfrescoRatingService.like()` and `fiveStar()` methods send those
native JSON types. This intentionally corrects the overly broad string
typing present in the source Swagger model.

The live social integration test validates `likes`. Alfresco does not
allow a user to apply the `fiveStar` scheme to content owned by that
same user, so the single-user integration scenario intentionally does
not call `fiveStar()` on its freshly uploaded document.

## Associations, categories and queries

High-level relationship and query layer:

-   `AlfrescoAssociationService`: create/delete associations plus typed
    source/target paging and assocType filtering.
-   `AlfrescoCategoryService`: category CRUD, root/subcategory listing,
    node assignment/unassignment.
-   `AlfrescoQueryService`: typed node/site/person query helpers.
-   `PageSlice<T>` + `PagingExtractor`: converts generated `Object list`
    paging payloads into typed high-level pages.
-   `AlfrescoAssociationCategoryQueryIntegrationTest`: live ACS
    lifecycle test for associations, categories and repository queries.

## Shared links, trashcan and downloads

High-level lifecycle support now includes:

-   shared links: create/get/list current user's links/download shared
    content/delete;
-   trashcan: typed paging, get deleted node/content, restore to
    original or another parent, purge; original-location restore sends
    no body, matching the optional Swagger restore body;
-   asynchronous ZIP downloads: create, poll until `DONE`, fetch ZIP
    content, cancel/delete;
-   live integration coverage in
    `AlfrescoSharingTrashDownloadIntegrationTest`.

`AlfrescoDownloadService` validates empty/duplicate node id lists before
calling ACS. Download content is read from the generated download node
after ACS reports `DONE`.

## Audit, activities and preferences

High-level administration and user-state support now includes:

-   audit applications: typed paging, lookup, enable/disable,
    application entries and node entries;
-   audit entry deletion with a required non-blank `where` guard for
    bulk deletion;
-   activity feeds: typed paging for a person, `-me-`, `who` and
    `siteId` filters;
-   preferences: typed paging, get/update, plus convenient current-user
    methods;
-   live integration coverage in
    `AlfrescoAuditActivityPreferenceIntegrationTest`.

The integration test intentionally leaves its uniquely named preference
in the disposable ACS test instance because the public Preferences REST
API has no delete endpoint.

Live ACS 26.2 compatibility: audit application GET/PUT responses are
unwrapped from the actual `{entry:{...}}` envelope by
`AlfrescoAuditService`.

## Search DSL, typed search results and convenient models

`AlfrescoSearchService` now keeps the original raw search methods and
adds a preferred typed `find(SearchCriteria)` API.

``` java
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

The fluent criteria builder combines AFTS clauses instead of silently
choosing only one criterion. With `userQuery`, structural constraints
are sent as filter queries so they restrict results without replacing
the full-text query. Typed `SearchResultPage` exposes pagination,
context, convenient `SearchHit` values and the raw generated
`ResultNode` for advanced access.

The existing `search(...)`, `afts(...)`, `userQuery(...)`,
`execute(...)` and `raw(...)` methods remain available for backward
compatibility.

## Exceptions, safe retry and diagnostics

Production-oriented HTTP behavior is now built into the SDK layer:

-   `AlfrescoApiException` exposes HTTP method, request URI, raw
    response and parsed ACS error details;
-   convenience predicates cover common cases such as
    401/403/404/409/429 and retryable server statuses;
-   standard ACS `{error:{...}}` payloads are parsed into
    `AlfrescoErrorDetails` (`errorKey`, `briefSummary`,
    `descriptionURL`, `logId`);
-   transient retry is enabled by default only for safe read methods
    (`GET`, `HEAD`, `OPTIONS`), never automatically for
    POST/PUT/PATCH/DELETE;
-   retries cover network `IOException` plus HTTP 429/502/503/504 with
    bounded exponential backoff;
-   optional request timing diagnostics log method, URI, status and
    elapsed time without credentials or bodies;
-   `AlfrescoContentIntegrationTest` now verifies structured 404
    diagnostics against live ACS.

Example configuration:

``` yaml
alfresco:
  retry:
    enabled: true
    max-attempts: 3
    initial-delay: 200ms
    max-delay: 2s
  diagnostics:
    enabled: false
```

The retry policy is intentionally conservative: write operations are not
repeated automatically because a connection failure does not prove that
ACS failed to apply the write.

## HTTP transport, streaming and health

The 1.0.0 transport layer uses one shared JDK `HttpClient` for all
Alfresco HTTP Service groups. This gives connection reuse/keep-alive
without introducing an Apache HttpClient dependency.
`alfresco.http.connect-timeout` defaults to `5s`;
`alfresco.http.read-timeout` defaults to `30s`.

For large content, prefer `StreamingUploadRequest` and
`AlfrescoContentService.downloadTo(...)`. Streaming upload accepts a
Spring `Resource`; streaming download copies directly to an application
`OutputStream` or `Path`. The existing `UploadRequest` and
`ContentResource` byte-array methods remain convenient for small files.

When Actuator is on the application classpath, the optional
`alfrescoHealthIndicator` performs a lightweight Discovery request. It
reports only reachability and exception type, not credentials, request
bodies or exception messages. Disable it with
`alfresco.health.enabled=false`.

## Stable public API

The first public release exposes the complete live-tested service layer.
Existing individual service beans remain available and `AlfrescoClient`
is added as an optional single entry point. `AlfrescoInfoService`
provides password-safe connection diagnostics.

Compatibility baseline: Java 21, Spring Boot 4.1, Alfresco Community
Edition 26.2.0.

The regression suite covers content, search, metadata/versioning,
permissions, users/groups/sites, social APIs,
associations/categories/queries, shared links/trash/downloads,
audit/activity/preferences, transformations/renditions, structured
errors, the stable facade and SDK-only behavior.
