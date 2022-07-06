# UseCase

1. 회원가입
   1. `POST` /member
2. 회원 정보 변경 요청
   1. `PUT` /member
3. 회원 탈퇴 요청
   1. `DELETE` /member
4. 회원 목록 조회 (관리자 페이지 접근)
   1. `GET` /member/list
5. 채팅방 생성
   1. `POST` /room
6. 채팅 메시지 생성
   1. `POST` /message
7. 채팅 메시지 신고
   1. `POST` /message/declare
8. 채팅방 리스트 조회
   1. `GET` /room/list
9. 채팅방 즐겨찾기 등록
   1. `POST` /room/bookmark
10. 채팅 메시지 조회
   1. `GET` /message/list