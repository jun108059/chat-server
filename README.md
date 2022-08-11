# 채팅 토이 프로젝트

[자소설 닷컴](https://jasoseol.com/) 채팅 구현하기

- [Front-End Repo Link](https://github.com/jun108059/chat-front)

## Architecture

<img width="1776" alt="image" src="https://user-images.githubusercontent.com/42997924/177604570-52b3291c-3e19-4d13-b405-795185dbcab3.png">

## 요구사항

1. 회원 시스템
   - 개인 / 기업 / 관리자
2. 관리자가 채팅방 생성
   - 기업 기반 채팅방 생성이 가능해야 함
3. 개인 회원(N) : 기업(1) 채팅 참여
   - 실시간 채팅 가능

### Task

1. 이벤트 스토밍
2. 도메인 정의
3. UseCase 도출
4. Test code 작성(TDD)
5. API 서버 개발
6. Socket 서버 개발
7. Kafka 파이프라인 구성

### Event Storming

<img width="980" alt="image" src="https://user-images.githubusercontent.com/42997924/177604507-0f7a5712-5160-4df4-a95a-c2dd3602c9ab.png">

<img width="2410" alt="image" src="https://user-images.githubusercontent.com/42997924/177604430-ff3e1f81-2fe2-4943-9b8d-8269a6768554.png">

### UseCase

1. 회원가입
2. 회원 목록 조회
3. 채팅방 생성
4. 채팅 메시지 생성
5. 채팅방 리스트 조회
6. 채팅 메시지 조회

### 패키지 구조

```jsx
chat
|-- api
    |-- member
       |-- adapter
       |   |-- in
       |   |   |-- web
       |   |       |--MemberController
       |   |-- out
       |   |   |-- persistence
       |   |       |-- MemberPersistenceAdapter
       |   |       |-- SpringDataAccountRepository
       |-- application
           |-- service
           |   |-- GetMemberService
           |   |-- RegisterMemberService
           |-- port
               |-- in
               |   |-- GetMemberQuery
               |   |-- RegisterMemberCommand
               |   |-- RegisterMemberUseCase
               |-- out
               |   |-- FindMemberPort
               |   |-- SaveMemberPort
       
|-- core
   |-- domain
   |   |-- Member
   |   |-- Message
   |-- exception
   |   |-- ErrorCode
```

## gitmoji

> https://gitmoji.dev/


| `emoji` |    `설명`    | `emoji` |     `설명`     |
| :-------: | :-------------: | :-------: | :---------------: |
|   🎉   | 프로젝트 시작 |  ♻️  |    리펙터링    |
|   📝   |     문서     |   🚚   | 구조, 경로 변경 |
|   👔   | 비즈니스 로직 |  👷️  |       CI       |
|  🗃️  | 데이터베이스 | 🚀️️ |       CD       |
|  🧱️  |    인프라    | ⚡️️ |    성능개선    |
|  💡️  |     주석     |  🚑️  |     핫픽스     |
|   ✅   |    테스트    |   🐛   |    버그 해결    |
|  ➕️  |  의존성 추가  |   🔀   |  브랜치 Merge  |
|  ➖️  |  의존성 제거  |   🔖   |     릴리스     |
|   🔧    |  설정 파일  | 🔊 | 로그 추가 삭제 |