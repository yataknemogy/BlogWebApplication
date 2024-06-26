# Web Application for Blog

[RU](docs/README_RU.MD) | [FR](docs/README_FR.MD) |  [JP](docs/README_JP.MD) | [DE](docs/README_DE.MD) | [CH](docs/README_CH.MD) | [KR](docs/README_KR.MD)

This web application is designed for creating and managing a blog, where users can create posts, comment on them, subscribe to other users' blogs, and manage their own profiles.

## Project Setup

- Created a new Spring Boot project.
- Configured dependencies for web applications, databases, and authentication.
- Created a database to store information about users, posts, and comments.

## Data Model

- Defined the data structure for users, posts, and comments.
- Created Java classes corresponding to this data structure, using JPA annotations to map to tables in the database.

## Controllers

- Created controllers to handle HTTP requests, such as creating posts, comments, user authentication, etc.
- Defined controller methods to perform operations on data, such as creating a new post, adding a comment, etc.

## Services

- Implemented services to perform business logic of the application, such as saving posts, comments, user authentication, etc.
- Included logic for subscribing to other users' blogs and managing user profiles.

## Views

- Created HTML templates to display the user interface, such as pages for viewing posts, adding comments, registration, and login.
- Used Thymeleaf for integrating Java code with HTML.

## Security

- Ensured the security of the application through user authentication and authorization.
- Implemented protection against Cross-Site Request Forgery (CSRF) and other types of attacks.

This is a brief overview of the steps taken in developing the web application for the blog.
