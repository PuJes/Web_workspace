<%@page import="com.MyException"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="service.imp.UserService" %>
<%@ page import="domain.User" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="userService" class="service.imp.UserService" scope="session"></jsp:useBean>
<%
	String userName = request.getParameter("userName");
	String password = request.getParameter("password");
	String realName = request.getParameter("realName");
	String gender = request.getParameter("gender");
	String age =request.getParameter("age");
	String personalSignature = request.getParameter("personalSignature");
	
	User user = new User("userName");
	
	user.setPassword(password);
	user.setRealname(realName);
	user.setGender(gender);
	if(age.equals("")){
		age = "0";
	}
	user.setAge(Integer.parseInt(age));
	user.setPersonalSignature(personalSignature);
	
	try{
		userService.newUser(user);
%>
	<jsp:forward page="main.jsp"></jsp:forward>
<% 		
	}catch(MyException e){
		e.printStackTrace();
%>
	<jsp:forward page="register.jsp"></jsp:forward>
<% 
	}

%>
</body>
</html>