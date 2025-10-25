# 🚀 Дипломный проект по API Automation Framework для [reqres.in](https://reqres.in/)

![](https://github.com/kenzinaAA/qa_guru_diploma_api/blob/main/images/logo/ReqResLogo.png)

> Проект автоматизированного тестирования REST API Reqres.in.

## 📋 О проекте

Проект представляет собой комплексный фреймворк для автоматизированного тестирования [Reqres.in API](https://reqres.in) - публичного REST API для тестирования, включающий:

- **REST API тестирование** всех доступных эндпоинтов
- **Положительные и отрицательные сценарии** тестирования
- **Параметризованные тесты** с различными наборами данных
- **Интеграционное тестирование** бизнес-сценариев
- **Продвинутую отчетность** с Allure Framework
---

## 📚 Содержание

- [Технологии и инструменты, используемые в данном проекте](#технологии-и-инструменты)
- [Архитектура тестов](#архитектура-тестов)
- [Тест-кейсы](#тест-кейсы)
- [Сборка в Jenkins](#-сборка-в-jenkins)
- [Информация о тестах в Allure report](#-allure-отчет)
- [Интеграция с TestOps](#-интеграция-с-testops)
- [Интеграция с Jira](#-интеграция-с-jira)
- [Телеграмм-бот с уведомлениями о результатах тестов](#-телеграмм-бот-с-уведомлениями-о-результатах-тестов)

---
<a id="технологии-и-инструменты"></a>
## 🛠 Технологии и инструменты, используемые в данном проекте

[<img alt="Java" height="70" src="https://github.com/kenzinaAA/qa_guru_diploma_api/blob/main/images/logo/Java.svg" width="70"/>](https://www.java.com/)
[<img alt="IDEA" height="70" src="https://github.com/kenzinaAA/qa_guru_diploma_api/blob/main/images/logo/Idea.svg" width="70"/>](https://www.jetbrains.com/idea/)
[<img alt="Github" height="70" src="https://github.com/kenzinaAA/qa_guru_diploma_api/blob/main/images/logo/GitHub.svg" width="70"/>](https://github.com/)
[<img alt="JUnit 5" height="70" src="https://github.com/kenzinaAA/qa_guru_diploma_api/blob/main/images/logo/Junit5.svg" width="70"/>](https://junit.org/junit5/)
[<img alt="Gradle" height="70" src="https://github.com/kenzinaAA/qa_guru_diploma_api/blob/main/images/logo/Gradle.svg" width="70"/>](https://gradle.org/)
[<img alt="Rest-assured" height="70" src="https://github.com/kenzinaAA/qa_guru_diploma_api/blob/main/images/logo/RestAssured.svg" width="70"/>](https://rest-assured.io/)
[<img alt="Allure" height="70" src="https://github.com/kenzinaAA/qa_guru_diploma_api/blob/main/images/logo/Allure.svg" width="70"/>](https://github.com/allure-framework/allure2)
[<img alt="Jenkins" height="70" src="https://github.com/kenzinaAA/qa_guru_diploma_api/blob/main/images/logo/Jenkins.svg" width="70"/>](https://www.jenkins.io/)
[<img alt="Allure_EE" height="70" src="https://github.com/kenzinaAA/qa_guru_diploma_api/blob/main/images/logo/Allure_EE.svg" width="70"/>](https://qameta.io/)
[<img alt="Telegram" height="70" src="https://github.com/kenzinaAA/qa_guru_diploma_api/blob/main/images/logo/Telegram.svg" width="70"/>](https://telegram.org/)
---

<a id="архитектура-тестов"></a>
## 🏗 Архитектура тестов

```bash
src/test/java/
├── 📁 helpers/                       # 🛠 Вспомогательные классы
│   └── CustomAllureListener.java      # Кастомные Allure листенеры
├── 📁 models/lombok                  # 📊 Модели данных (DTO)
├── 📁 specs/                         # 📋 Спецификации API
│   ├── RequestSpec.java               # Response спецификация
│   └── ResponseSpec.java              # Request спецификация
├── 📁 tests/                         # 🧪 Тестовые классы
│   ├── CreateUserTests.java           # Тесты регистрации пользователя
│   ├── DeleteUserTests.java           # Тест удаления пользователя
│   ├── FetchesUserTests.java          # Тест чтения данных
│   ├── GetListUsersTests.java         # Тест получения списка пользователей
│   ├── TestBase.java                  # Базовый тестовый класс с конфигурацией запусков тестов
│   └── UpdateUserTests.java           # Тест обновления записи данных
└── 📁 resources/tpl                  # Данные для запусков тестов
````

---
<a id="Покрытие функциональности"></a>
## 🏗 Тест кейсы

✅ Успешная регистрация с минимальным набором данных

✅ Негативный сценарий с неполными набором данными для регистрации

✅ Получение данных конкретного пользователя

✅ Удаление пользователя

✅ Обновление данных пользователя

✅ Получение списка пользователей

✅ Валидация обязательных полей

✅ Валидация структуры ответов

---
## [Сборка в Jenkins](https://jenkins.autotests.cloud/job/kenzinaAA-%20qa_guru_diploma_api/)

![](https://github.com/kenzinaAA/qa_guru_diploma_api/blob/main/images/Jenkins.png)

## Информация о тестах в [Allure report](https://jenkins.autotests.cloud/job/kenzinaAA-%20qa_guru_diploma_api/allure/)

### Окно с тестовыми кейсами

![](https://github.com/kenzinaAA/qa_guru_diploma_api/blob/main/images/AllureTestCases.png)

### Окно с графиками

![](https://github.com/kenzinaAA/qa_guru_diploma_api/blob/main/images/AllureGraphs.png)

## Интеграция с [AllureTestOps](https://allure.autotests.cloud/project/4976/)

### Тест-кейсы

![](https://github.com/kenzinaAA/qa_guru_diploma_api/blob/main/images/TestOppsTestCases.png)

### Тест-кейсы с историей запусков

![](https://github.com/kenzinaAA/qa_guru_diploma_api/blob/main/images/TestOppsLaunches.png)

### Дашборд

![](https://github.com/kenzinaAA/qa_guru_diploma_api/blob/main/images/TestOppsDashboard.png)

## Интеграция с [Jira](https://jira.autotests.cloud/browse/HOMEWORK-1520)

![](https://github.com/kenzinaAA/qa_guru_diploma_api/blob/main/images/Jira.png)

## Телеграмм-бот с уведомлениями о результатах тестов

После завершения тестов отчет о прохождении приходит в Telegram с помощью заранее созданного бота

![](https://github.com/kenzinaAA/qa_guru_diploma_api/blob/main/images/Telegram.jpg)
