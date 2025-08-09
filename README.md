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


## 📸 스크린샷

| 메인화면 | 회원가입 | 로그인 |
|---|---|---|
| ![메인화면](<img width="964" height="1002" alt="image" src="https://github.com/user-attachments/assets/da3e4d01-07ae-4340-b50a-2a39fa8b6527" />
) | ![회원가입](<img width="932" height="651" alt="스크린샷 2025-08-09 194551" src="https://github.com/user-attachments/assets/ae3330f9-ae38-4f51-93b0-6b1bb926553e" />
) | ![로그인](<img width="936" height="463" alt="스크린샷 2025-08-09 194545" src="https://github.com/user-attachments/assets/bb061fb5-74e0-49ac-a7b6-bb036a337680" />
) |

| 게시판 목록 | 게시글 상세보기 | 게시글 작성 |
|---|---|---|
| ![게시판 목록](<img width="926" height="456" alt="스크린샷 2025-08-09 194636" src="https://github.com/user-attachments/assets/e665f80d-bf34-42b0-a649-6db87e599ec1" />
) | ![게시글 상세보기](<img width="1919" height="682" alt="스크린샷 2025-08-09 012914" src="https://github.com/user-attachments/assets/cf41b6d2-997b-47b5-acb5-b1387135bef1" />
) | ![게시글 작성](<img width="932" height="651" alt="스크린샷 2025-08-09 194551" src="https://github.com/user-attachments/assets/8496edf3-7f56-477a-8390-b7c66150bbba" />
) |
