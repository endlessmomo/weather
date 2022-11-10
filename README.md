# 🌅 날씨 일기 프로그램
  그 날의 날씨 데이터를 API로 매일 자정 12:00 스케쥴링을 통해 정보를 가져와 해당 날씨와 일기를 저장할 수 있는 프로그램입니다.

## 💻 개발환경 및 라이브러ㅣ
 - IDE : IntelliJ
 - Language : java ( jdk 8)

## 주요 기능
1. 스케쥴링을 통한 날씨 데이터를 가져와 자동 등록하는것
2. 

## 설계 
1. MVVM + Coordinator with CleanArichitecture

|MVVM

View는 자기 UIEvent의 발행과 UI요소의 디자인 정보를 담당합니다.
ViewModel은 Presentation Logic을 갖고 있으며, UseCase를 사용해 받아온 Model을 View가 표현할 수 있는 형태로 전달하는 역할을 담당합니다.

|Clean Architecture

UseCase는 Buisness Logic을 담당하며 Repository를 사용하여 Model을 받아오는 역할을 담당합니다.
Repository는 Service 객체를 사용하여 iOS 외부의 데이터(통신, 영구저장소)를 가져옵니다. DataSource(캐시/통신)에 대한 판단도 이곳에서 이루어집니다.
Domain Layer는 Prentation Layer와 Data Layer에 의존하지 않아야 합니다. Repository 프로토콜을 사용하여 의존성을 역전을 도모합니다.
