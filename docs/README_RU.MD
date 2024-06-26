# Веб-приложение для блога

[EN](../README.md) | [RU](README_RU.MD) | [FR](README_FR.MD) | [JP](README_JP.MD) | [DE](README_DE.MD) | [CH](README_CH.MD) | [KR](README_KR.MD)

Это веб-приложение предназначено для создания и управления блогом, где пользователи могут создавать посты, комментировать их, подписываться на блоги других пользователей и управлять своим профилем.

## Настройка проекта

- Создан новый проект Spring Boot.
- Настроены зависимости для работы с веб-приложениями, базой данных и авторизацией.
- Создана база данных для хранения информации о пользователях, постах и комментариях.

## Модель данных

- Определена структура данных для пользователей, постов и комментариев.
- Созданы Java-классы, соответствующие этой структуре данных, используя аннотации JPA для отображения на таблицы в базе данных.

## Контроллеры

- Созданы контроллеры для обработки HTTP-запросов, таких как создание постов, комментариев, аутентификация пользователей и т.д.
- Определены методы контроллеров для выполнения операций с данными, таких как создание нового поста, добавление комментария и т.д.

## Сервисы

- Реализованы сервисы для выполнения бизнес-логики приложения, такие как сохранение постов, комментариев, аутентификация пользователей и т.д.
- Включена логика для подписки на блоги других пользователей и управления профилем пользователя.

## Представления

- Созданы HTML-шаблоны для отображения пользовательского интерфейса, такие как страницы для просмотра постов, добавления комментариев, регистрации и входа в систему.
- Использован Thymeleaf для интеграции Java-кода с HTML.

## Безопасность

- Обеспечена безопасность приложения с помощью аутентификации и авторизации пользователей.
- Реализована защита от межсайтовых запросов (CSRF) и других типов атак.

Это краткий обзор выполненных шагов при разработке веб-приложения для блога.

