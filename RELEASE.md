# Release preparation / Подготовка релиза

## RU

Обычная проверка релиза остается безопасной и ничего не публикует:

```bash
mvn clean verify
```

Она должна собрать основной JAR, `sources.jar` и `javadoc.jar`, а также прогнать тесты и строгий Javadoc/doclint.

Для Maven Central в `pom.xml` добавлен **opt-in** профиль `central-release` с официальным `org.sonatype.central:central-publishing-maven-plugin:0.11.0`. Профиль не активируется при обычной сборке и настроен на ручное подтверждение публикации (`autoPublish=false`).

Перед первой реальной публикацией необходимо осознанно заполнить четыре вида публичных метаданных, которых сейчас нет в исходном проекте и которые нельзя придумывать автоматически:

1. URL проекта;
2. лицензия распространения;
3. публичные данные разработчика/организации;
4. SCM URL/connection для окончательного репозитория.

Кроме того, Maven Central требует GPG/PGP-подписи. Настройку ключа и signing-плагина следует делать после выбора публичной идентичности релиза, не помещая секреты или passphrase в репозиторий.

Учетные данные Central Portal должны храниться только в Maven `settings.xml` под server id `central`:

```xml
<settings>
    <servers>
        <server>
            <id>central</id>
            <username>YOUR_CENTRAL_TOKEN_USERNAME</username>
            <password>YOUR_CENTRAL_TOKEN_PASSWORD</password>
        </server>
    </servers>
</settings>
```

После заполнения метаданных и настройки GPG публикация будет запускаться явно, а не случайно из `verify`:

```bash
mvn clean deploy -DcentralRelease
```

## EN

The normal release verification remains safe and never publishes artifacts:

```bash
mvn clean verify
```

It builds the main JAR, sources JAR and Javadoc JAR and runs the tests plus strict Javadoc/doclint validation.

The POM now contains an **opt-in** `central-release` profile using the official `org.sonatype.central:central-publishing-maven-plugin:0.11.0`. Normal builds do not activate it, and Central publication requires manual approval (`autoPublish=false`).

Before the first real Maven Central publication, the project still needs deliberate values for the public project URL, distribution license, developer/organization identity and final SCM coordinates. Those values are intentionally not guessed. Maven Central also requires GPG/PGP signatures; signing should be configured only after the public release identity is settled, with no private key or passphrase committed to the project.
