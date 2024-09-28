# TestFirstExample
## Описание проекта

Данный проект представляет собой автоматизированные UI-тесты разработанные в рамках практикума SDET, на языке Java с использованием Selenium WebDriver и фреймворка JUnit 4.

### Описание тест-кейсов 

test-cases.md

### Стек технологий

- Язык программирования: Java
- Версия Java: 17
- Автоматизация UI: Selenium WebDriver
- Тестовый фреймворк: JUnit 5
- Сборщик проекта: Maven
- Шаблон проектирования: page Object Model
- Документация Allure

### Настройка окружения

1. Убедитесь, что на вашем компьютере установлены следующие программные обеспечения:
   - Java Development Kit  17.
   - Apache Maven.
   - Google Chrome (последняя стабильная версия).
2. Для запуска параллельного тестирования используется механизм конфигурации Create Run со следущими аргументами:
   - Djunit.jupiter.execution.parallel.enabled=true
   - Djunit.jupiter.execution.parallel.mode.default=concurrent

   

