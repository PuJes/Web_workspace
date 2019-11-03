<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="java.util.*,domain.*,service.imp.*,com.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" type="text/css" href="css/default.css" />
<title>社区主页</title>
</head>
<body>
	<jsp:useBean id="infoService" class="service.imp.InfoService"
		scope="session"></jsp:useBean>
	<%
		List<Info> list = infoService.getAllInfo();
	%>
	<div id="outer">
		<div id="upbg"></div>
		<div id="inner">
			<h1>
				<span>简易社区</span>
			</h1>
			<h2>by PJ</h2>
		</div>
		<div id="splash"></div>
		<div id="menu">
			<ul>
				<li class="first"><a href="main.jsp">信息浏览</a></li>
				<li><a href="#">控制面板</a></li>
				<li><a href="logout.jsp">退出</a></li>
			</ul>
			<div id="date"></div>
		</div>
		<div id="primarycontent">
			<!-- start -->
			<div class="post">
				<div class="header">
					<h3>日志</h3>
					<div class="date"></div>
				</div>
				<%
					for (Info info : list) {
						if (info.getType().equals("日志")) {
				%>
				<div class="content">
					<p>
						<a href="detail.jsp?Id=<%=info.getId()%>"><%=info.getTitle()%></a>&nbsp;&nbsp;<%=info.getPublishingTime()%></p>
				</div>
				<%
					}
					}
				%>
				<div class="header">
					<h3>社区信息</h3>
					<div class="date"></div>
				</div>
				<%
					for (Info info : list) {
						if (info.getType().equals("社区信息")) {
				%>
				<div class="content">
					<p>
						<a href="detail.jsp?Id=<%=info.getId()%>"><%=info.getTitle()%></a>&nbsp;&nbsp;<%=info.getPublishingTime()%></p>
				</div>
				<%
					}
					}
				%>
			</div>
		</div>
		<div id="sencondarycontent">
		<h3><%=((User)session.getAttribute("user")).getUsername() %></h3>
		</div>
		<div class="content">
			<p><a href="addInformation.jsp">发布信息</a>
		</div>
	</div>

</body>
</html>