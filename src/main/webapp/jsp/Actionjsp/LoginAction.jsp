<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ page import="user.UserDAO" %>
<%@ page import="java.io.PrintWriter" %>
<% request.setCharacterEncoding("UTF-8"); %>
<jsp:useBean id="user" class="user.User" scope="page"/>
<jsp:setProperty name="user" property="userID"/>
<jsp:setProperty name="user" property="userPassword"/>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>JSP 게시판 웹 사이트</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<body>
<%
    String userID = null;
    if(session.getAttribute("userID") != null){
        userID = (String) session.getAttribute("userID");
    }
    if(userID != null){
         PrintWriter script = response.getWriter();
          script.println("<script>");
        script.println("alert('이미 로그인이 되어있습니다.');");
        script.println("location.href = 'main.jsp'");
        script.println("</script>");
    }
    UserDAO userDAO = new UserDAO();
    int result = userDAO.login(user.getUserID(), user.getUserPassword());
    PrintWriter script = response.getWriter();

    if (result == 1) {
        session.setAttribute("userID",user.getUserID());
        script.println("<script>");
        script.println("location.href = '../main.jsp';");
        script.println("</script>");
    } else if (result == 0) {
        script.println("<script>");
        script.println("alert('아이디 존재 하지 않거나  비밀번호가 틀립니다.');");
        script.println("history.back();");
        script.println("</script>");
    } else if (result == -1) {
        script.println("<script>");
        script.println("alert('데이터베이스 오류 발생');");
        script.println("history.back();");
        script.println("</script>");
    }

%>
</body>
</html>
