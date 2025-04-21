<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ page import="user.UserDAO" %>
<%@ page import="java.io.PrintWriter" %>

<% request.setCharacterEncoding("UTF-8"); %>
<jsp:useBean id="user" class="user.User" scope="page"/>
<jsp:setProperty name="user" property="userID"/>
<jsp:setProperty name="user" property="userPassword"/>
<jsp:setProperty name="user" property="userName"/>
<jsp:setProperty name="user" property="GENDER"/>
<jsp:setProperty name="user" property="userEmail"/>
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
        System.out.println(userID);
         PrintWriter script = response.getWriter();
         script.println("<script>");
        script.println("alert('이미 로그인이 되어있쇼');");
        script.println("location.href = '../main.jsp'");
        script.println("</script>");
    }

    else if (user.getUserID() == null || user.getUserPassword() == null || user.getUserName() == null
            || user.getGENDER() == null || user.getUserEmail() == null) {
        PrintWriter script = response.getWriter();
        script.println("<script>");
        script.println("alert('입력이 안 된 상황이 있습니다.');");
        script.println("history.back();");
        script.println("</script>");
    } else {
        UserDAO userDAO = new UserDAO();
        int result = userDAO.join(user);


        if (result == 1) {
            session.setAttribute("userID",user.getUserID());
            PrintWriter script = response.getWriter();
            script.println("<script>");
            script.println("location.href = '../main.jsp';");
            script.println("</script>");
        }
        else if (result == -1) {
            PrintWriter script = response.getWriter();
            script.println("<script>");
            script.println("alert('이미 존재 하는 아이디입니다.');");
            script.println("history.back();");
            script.println("</script>");
        }
    }


%>
</body>
</html>
