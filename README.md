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
