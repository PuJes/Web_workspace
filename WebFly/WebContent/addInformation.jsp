<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8">
<title>个人日记</title>
</head>
<body>
	<div id="outer">
		<div id="upbg">
			<div id="inner">
				<div id="header">
					<h1>
						<span>快写你的日记！</span>
					</h1>
					<h2>by PJ</h2>
				</div>
				<div id="splash"></div>
				<div id="menu"></div>
				<div id="primarycontent">
					<!-- primary content start -->
					<div class="post">
						<div class="header">
							<h3>个人信息</h3>
							<div class="date"></div>
						</div>
						<div class="content">
							<form action="process_addInformation.jsp" method="post">
								<table>
									<tr>
										<td><label>标题</label></td>
										<td><input type="text" name="title" /></td>
									</tr>
									<tr>
										<td><label>内容</label></td>
										<td><textarea rows="3" cols="18" name="content" /></textarea>
									</tr>
									<tr>
										<td><label>类型</label></td>
										<td><select name="type">
												<option value="日志">日志</option>
												<option value="社区信息">社区信息</option>
										</select></td>
									</tr>
									
									<tr>
										<td colspan="2"><input type="submit" value="发布" /></td>
									</tr>
								</table>
							</form>
						</div>
						<div class="footer">
							<ul>
								<li class="readmore"><a href = "login.jsp">返回</a></li>
							</ul>
						</div>
					</div>
					<!-- primary content end -->
				</div>
				<div id="secondarycontent">
					<h3></h3>
				</div>
				<div id="footer">
					&copy; PJ. All rights reserved. Design by PJ.
				</div>
			</div>
		</div>
	</div>
</body>
</html>