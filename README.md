# 📝 JSPStudy - JSP 기반 게시판 프로젝트

> **JSP와 Servlet 기반**으로 개발된 간단한 웹 게시판 프로젝트입니다.  
> 외장 Tomcat을 활용해 `.war` 파일로 빌드 후 **Cafe24** 서버에 배포하여 도메인 연결까지 완료했습니다.

---

## 📌 주요 기능

### ✅ 회원 기능
- 회원가입
- 로그인 / 로그아웃

### ✅ 게시판 기능
- 게시글 작성 (회원 전용)
- 게시글 목록 조회
- 게시글 상세 보기
- 게시글 수정
- 게시글 삭제

---

## 🛠 기술 스택

| 분류     | 내용                           |
|----------|--------------------------------|
| Language | Java, JSP, CSS                 |
| DB       | MySQL (또는 MariaDB)           |
| Server   | Apache Tomcat (외장형)         |
| ORM      | JPA (Hibernate)                |
| Tool     | IntelliJ IDEA                  |
| Build    | Maven *(선택사항)*             |

---

## 📂 프로젝트 구조 
<pre>
```
jspstudy/
├── src/
│   └── main/
│       └── java/
│           └── … (Controller, DAO, Entity,security등)
├── webapp/
│   ├── jsp/
│   │   ├── main.jsp
│   │   ├── write.jsp
│   │   └── …
│   └── WEB-INF/
│       ├── web.xml
│       └── lib/
├── pom.xml
```
</pre>



---

## 🌐 배포 환경

- **도메인:** [https://moving0909.cafe24.com](https://moving0909.cafe24.com)
- **배포 방식:** `.war` 파일을 FileZilla를 이용해 Cafe24 서버의 Tomcat에 업로드 및 배포
