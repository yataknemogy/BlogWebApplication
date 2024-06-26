# 블로그 웹 애플리케이션

[RU](../README.md) | [EN](README_EN.MD) | [FR](README_FR.MD) | [JP](README_JP.MD) | [DE](README_DE.MD) | [CH](README_CH.MD) | [KR](README_KR.MD)

이 웹 애플리케이션은 사용자가 게시물을 작성하고 관리할 수 있는 블로그를 생성하는 데 사용됩니다. 사용자는 게시물을 작성하고 댓글을 남기며 다른 사용자의 블로그를 구독하고 자신의 프로필을 관리할 수 있습니다.

## 프로젝트 설정

- 새로운 Spring Boot 프로젝트를 생성했습니다.
- 웹 애플리케이션, 데이터베이스 및 인증 처리를 위한 종속성이 구성되었습니다.
- 사용자, 게시물 및 댓글 정보를 저장하기 위한 데이터베이스가 생성되었습니다.

## 데이터 모델

- 사용자, 게시물 및 댓글의 데이터 구조를 정의했습니다.
- JPA 어노테이션을 사용하여 이러한 데이터 구조에 해당하는 Java 클래스를 생성하여 데이터베이스의 테이블에 매핑했습니다.

## 컨트롤러

- 게시물 생성, 댓글 생성, 사용자 인증 등과 같은 HTTP 요청을 처리하기 위한 컨트롤러가 생성되었습니다.
- 데이터 작업을 수행하기 위한 컨트롤러 메서드가 정의되었습니다. 이에는 새 게시물 생성, 댓글 추가 등이 포함됩니다.

## 서비스

- 게시물 저장, 댓글 저장, 사용자 인증 등과 같은 애플리케이션 비즈니스 로직을 실행하기 위한 서비스가 구현되었습니다.
- 다른 사용자 블로그를 구독하고 사용자 프로필을 관리하는 논리가 포함되어 있습니다.

## 뷰

- 게시물 보기, 댓글 추가, 등록 및 로그인 페이지와 같은 사용자 인터페이스를 표시하기 위한 HTML 템플릿이 생성되었습니다.
- Java 코드를 HTML과 통합하기 위해 Thymeleaf를 사용했습니다.

## 보안

- 사용자 인증 및 권한 부여를 통해 애플리케이션의 보안을 보장했습니다.
- CSRF 및 기타 유형의 공격으로부터 보호를 제공했습니다.

이것은 블로그 웹 애플리케이션을 개발하는 데 수행된 단계의 간략한 개요입니다.
