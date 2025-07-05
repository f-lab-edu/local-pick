# member-api-plan

## API Endpoint

1. 특별히 명시되지 않은 모든 엔드포인트는 인증 필요
2. "비고"에 "인증 불필요" 또는 "관리자 인증" 등만 예외적으로 명시

| 기능 | 메소드 | 엔드포인트 | 설명 | 비고 |
| ---- | ----- | -------- | ---- | ---- |
| 회원가입 | POST | /auth/signup | 신규 회원 등록 | 인증 불필요, 데이터 유효성 검사(이메일 중복/비밀번호 유효성) |
| 로그인 | POST | /auth/login | 사용자 로그인 | 인증 불필요 |
| 로그아웃 | POST | /auth/logout | 사용자 로그아웃 |  |
| 비밀번호 분실 | POST | /auth/forgot-password | 비밀번호 초기화(메일) |  |
| 토큰 재발급 | POST | /auth/refresh-token | 토큰 재발행 요청 |  |
| 내 정보 조회 | GET | /member/me | 내 정보(프로필) |  |
| 내 정보 수정 | PATCH | /member/me | 내 정보 수정 |  |
| 비밀번호 변경 | PATCH | /member/me/password | 내 비밀번호 변경 |                                                              |
| 회원 탈퇴 | DELETE | /member/me | 내 계정 삭제 |  |
| 회원 정보 조회 | GET | /member/{id} | 특정 회원정보 조회 | 관리자 인증 |
