# 🌅 날씨 일기 프로그램
  당일 날씨 데이터를 Open API를 매일 자정 12:00 스케쥴 통해서 해당 날씨에 대한 정보를 가져와 저장하고 일기를 기록할 수 있도록 제작한 프로젝트입니다.

## 💻 사용기술 및 개발환경
개발 환경
운영체제 : mac M1
IDE : Intelli J
JDK : Open JDK 1.8
Spring Boot : 2.7.3
Database : Mysql, H2(testDB)

BE
- Spring Boot, Spring Data Jpa
- Mysql
- Logger, Swagger

## 주요 기능
- OpenAPI를 활용해 오늘의 날씨를 DB에 저장하도록 한다.
- 스케줄링을 통해서 일정한 주기에 따라 서비스를 업데이트 할 수 있다. (매일 자정 12시)
- 조회하고 싶은 일정 기간 날짜의 일기 리스트를 조회 할 수 있습니다.
- 조회하고 싶은 날짜에 작성된 일기 조회 할 수 있다.
- 기존에 작성한 일기를 수정하거나 삭제할 수 있다.
- LogBack과 Swagger 학습
