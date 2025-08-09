# 📜 **JSPStudy - JSP 기반 게시판 프로젝트**

> **Java JSP & Servlet** 기반의 간단한 웹 게시판 프로젝트입니다.  
> 외장 **Tomcat** 환경에서 `.war` 파일로 빌드 후 **Cafe24** 서버에 배포하여 도메인 연결까지 완료했습니다.
> > ⚠️ 현재 Cafe24 서버는 도메인 만료로 접속 불가합니다.  
> 대신 로컬 환경에서 동일하게 실행 가능합니다.


---

## 🚀 **프로젝트 개요**
- **목적:** JSP와 Servlet, JPA를 활용한 CRUD 게시판 기능 구현  
- **특징:** 회원 인증(로그인/로그아웃)과 게시판 CRUD 기능 포함  
- **배포 경험:** Cafe24 서버에 배포 및 도메인 연결 완료  

---

## ✨ **주요 기능**

### 👤 회원 기능
- 회원가입 (BCrypt 단방향 암호화 적용)
- 로그인 / 로그아웃
- 세션 기반 사용자 인증

### 📝 게시판 기능
- **글 작성** (회원 전용)
- **글 목록 조회** (페이징 처리 가능)
- **글 상세 보기**
- **글 수정 / 삭제** (작성자 본인만 가능)

---

## 🛠 **기술 스택**

| 분류         | 기술 / 도구                          |
|--------------|--------------------------------------|
| **Language** | Java (JDK 17), JSP, CSS              |
| **DB**       | MySQL / MariaDB                      |
| **Server**   | Apache Tomcat (외장형)               |
| **ORM**      | JPA (Hibernate)                      |
| **Security** | BCrypt (비밀번호 암호화)              |
| **IDE**      | IntelliJ IDEA                        |
| **Build**    | Maven *(선택사항)*                   |

---

## 📂 **프로젝트 구조**

```plaintext
jspstudy/
├── src/
│   └── main/
│       └── java/
│           ├── user/        # 회원 관련 Entity, DAO
│           ├── bbs/         # 게시판 관련 Entity, DAO
│           └── security/    # 비밀번호 암호화 유틸 (BCrypt)
├── webapp/
│   ├── jsp/
│   │   ├── main.jsp
│   │   ├── write.jsp
│   │   ├── login.jsp
│   │   └── ...
│   └── WEB-INF/
│       ├── web.xml
│       └── lib/
├── pom.xml


```
## 고민했던 부분
- **회원 데이터 비밀번호 암호화**
  문제 :  해싱 알고리즘을 단방향인 SHA-256 과 BCrypt 중 고민을 했는데  찾아본 결과 SHA-256은 입력한 값이 같으면 해싱 값도 같다는 문제가 발생하여 레인보우 테이블 공격이 일어날 수도 있음. 즉 결정적 특성이 있다.
  해결방안 : salt를 자동으로 적용해주는 BCrypt 해싱 알고리즘을 사용.


## 📸 스크린샷


| 메인화면 | 회원가입 | 로그인 |
|---|---|---|
| <img src="https://github.com/user-attachments/assets/2752edee-a0bb-447f-b573-10c38228af81" width="300"/> | <img src="https://github.com/user-attachments/assets/e5f7ee59-8322-4102-b756-8aeb86c4c36a" width="300"/> | <img src="https://github.com/user-attachments/assets/b4f4310c-3e28-4a30-83c0-4dca10f78396" width="300"/> |

| 게시판 목록 | 게시글 상세보기 | 게시글 작성 |
|---|---|---|
| <img src="https://github.com/user-attachments/assets/7e550dea-45b3-4226-9e90-22b09dc38468" width="300"/> | <img src="https://github.com/user-attachments/assets/5b07c0ad-d9ba-4dc6-a3e7-46f494e2ac2a" width="300"/> | <img src="https://github.com/user-attachments/assets/ebf85906-e94d-43a5-8914-c29b346ff21d" width="300"/> |



