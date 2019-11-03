<%@page import="com.MyException"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="service.imp.UserService"%>
<%@ page import="domain.User"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="userService" class="service.imp.UserService"
		scope="session"></jsp:useBean>
	<%
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		User user = new User(userName);

		boolean state = false;
		try {
			state = userService.validUser(userName, password);
			if (!state) {
	%>
	<jsp:forward page="login.jsp"></jsp:forward>
	<%
		} else {
			session.setAttribute("user", user);
	%>
	<jsp:forward page="main.jsp"></jsp:forward>
	<%
		}
		} catch (MyException e) {
			e.printStackTrace();
	%>
	<jsp:forward page="login.jsp"></jsp:forward>
	<%
		}
	%>

</body>
</html>