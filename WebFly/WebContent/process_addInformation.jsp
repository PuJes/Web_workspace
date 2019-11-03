<%@page import="java.sql.Timestamp"%>
<%@page import="java.util.Date"%>
<%@page import="com.MyException"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="service.imp.InfoService"%>
<%@ page import="domain.Info"%>
<%@ page import="domain.User"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="infoService" class="service.imp.InfoService"
		scope="session"></jsp:useBean>
	<%
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String type = request.getParameter("type");
		String userName = ((User)session.getAttribute("user")).getUsername();
		System.out.print(title+content+type+userName);
		Info info = new Info();
		info.setTitle(title);
		info.setContent(content);
		info.setType(type);
		/*info.setPublishingTime(new Timestamp(new Date()));*/
		info.setPublishingUser(userName);

		boolean state = false;
		try {
			state = infoService.newInfo(info);
			if (!state) {
	%>
	<jsp:forward page="addInformation.jsp"></jsp:forward>
	<%
		} else {
	%>
	<jsp:forward page="main.jsp"></jsp:forward>
	<%
		}
		} catch (MyException e) {
			e.printStackTrace();
	%>
	<jsp:forward page="addInformation.jsp"></jsp:forward>
	<%
		}
	%>

</body>
</html>