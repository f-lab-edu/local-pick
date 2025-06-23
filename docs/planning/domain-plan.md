# Domain-Plan

## 엔티티 목록

| 도메인           | 엔티티명  | 설명               |
| ---------------- | --------- | ------------------ |
| 사용자           | User      | 회원정보           |
| 물품 판매 게시물 | Item      | 중고 거래 게시물   |
| 물품 카테고리    | category  | 중고 물품 카테고리 |
| 물품 이미지      | ItemImage | 물품 사진(S3 링크) |
| 댓글             | comment   | 게시물 댓글        |
| 리뷰             | Review    | 거래 후 평가       |



## 테이블 정보

### user

| 필드명     | 타입         | 옵션                               | 설명                       |
| ---------- | ------------ | ---------------------------------- | -------------------------- |
| id         | INT          | PRIMARY KEY                        | 고유 사용자 키             |
| email      | VARCHAR(50)  | UNIQUE, NOT NULL                   | 로그인 ID                  |
| password   | VARCHAR(100) | NOT NULL                           | 비밀번호 해시값            |
| nickname   | VARCHAR(20)  | NOT NULL                           | 사용자 표시 이름           |
| phone      | VARCHAR(15)  | NOT NULL                           | 사용자 전화번호            |
| region     | VARCHAR(30)  | NOT NULL                           | 광역시/도 기준 등록지 설정 |
| created_at | DATETIME     | NOT NULL DEFAULT CURRENT_TIMESTAMP | 가입일시 정보              |

---

### item

| 필드명     | 타입        | 옵션                        | 설명           |
| ---------- | ----------- | --------------------------- | -------------- |
| id         | BIGINT      | PRIMARY KEY                 | Item의 고유 키 |
| user_id    | INT         | FOREIGN KEY(user.id)        | 판매자 FK      |
| title      | VARCHAR(50) | NOT NULL                    | 제목           |
| content    | TEXT        | NOT NULL                    | 게시물 내용    |
| status     | ENUM        | NOT NULL                    | 판매 상태      |
| region     | VARCHAR(30) | NOT NULL                    | 판매 지역      |
| category   | INT         | FOREIGN KEY(category.id)    | 상품 카테고리  |
| price      | INT         | NOT NULL                    | 판매 가격      |
| view_count | INT         | NOT NULL DEFAULT 0          | 조회수         |
| buyer_id   | INT         | FOREIGN KEY(user.id)        | 구매자 ID      |
| created_at | DATETIME    | DEFAULT CURRENT_TIMESTAMP   | 등록 일시      |
| updated_at | DATETIME    | ON UPDATE CURRENT_TIMESTAMP | 수정 일시      |

---

### item_image

| 필드명       | 타입         | 옵션                               | 설명               |
| ------------ | ------------ | ---------------------------------- | ------------------ |
| id           | BIGINT       | PRIMARY KEY                        | Image 고유 ID      |
| item_id      | BIGINT       | FOREIGN KEY(item.id)               | 게시물 FK          |
| image_url    | VARCHAR(255) | NOT NULL                           | S3 경로            |
| is_thumbnail | BOOLEAN      | NOT NULL DEFAULT FALSE             | 대표 이미지 여부   |
| order_num    | INT          | NOT NULL DEFAULT 0                 | 이미지 정렬 순서   |
| uploaded_at  | DATETIME     | NOT NULL DEFAULT CURRENT_TIMESTAMP | 이미지 업로드 시간 |

---

### comment

| 필드명     | 타입     | 옵션                               | 설명         |
| ---------- | -------- | ---------------------------------- | ------------ |
| id         | BIGINT   | PRIMARY KEY                        | 댓글 고유 ID |
| item_id    | BIGINT   | FOREIGN KEY(item.id)               | 게시물 FK    |
| user_id    | INT      | FOREIGN KEY(user.id)               | 작성자 FK    |
| content    | TEXT     | NOT NULL                           | 댓글 정보    |
| created_at | DATETIME | NOT NULL DEFAULT CURRENT_TIMESTAMP | 작성 시각    |
| updated_at | DATETIME | ON UPDATE CURRENT_TIMESTAMP        | 수정 일시    |

---

### review

| 필드명      | 타입     | 옵션                               | 설명         |
| ----------- | -------- | ---------------------------------- | ------------ |
| id          | BIGINT   | PRIMARY KEY                        | 리뷰 고유 ID |
| item_id     | BIGINT   | FOREIGN KEY(item.id)               | 게시물 FK    |
| reviewer_id | INT      | FOREIGN KEY(user.id)               | 평가자 ID    |
| reviewee_id | INT      | FOREIGN KEY(user.id)               | 피평가자 ID  |
| rating      | ENUM     | NOT NULL                           | 별점 (1~5점) |
| content     | TEXT     | NOT NULL                           | 리뷰 내용    |
| created_at  | DATETIME | NOT NULL DEFAULT CURRENT_TIMESTAMP | 작성 시각    |
| updated_at  | DATETIME | ON UPDATE CURRENT_TIMESTAMP        | 수정 일시    |

---

### category

| 필드명 | 타입        | 옵션        | 설명             |
| ------ | ----------- | ----------- | ---------------- |
| id     | INT         | PRIMARY KEY | 카테고리 고유 ID |
| name   | VARCHAR(30) | NOT NULL    | 카테고리명       |

