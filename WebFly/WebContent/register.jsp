<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8">
<title>社区主页</title>
</head>
<body>
	<div id="outer">
		<div id="upbg">
			<div id="inner">
				<div id="header">
					<h1>
						<span>简易社区</span>
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
							<form action="process_register.jsp" method="post">
								<table id="userInfo_table">
									<tr>
										<td><label>用户名</label></td>
										<td><input type="text" name="usrename" /></td>
									</tr>
									<tr>
										<td><label>性 别</label></td>
										<td><select name="gender">
												<option value="男" selected="selected">男</option>
												<option value="女">女</option>
										</select></td>
									</tr>
									<tr>
										<td><label>真實姓名</label></td>
										<td><input type="text" name="realName" /></td>
									</tr>
									<tr>
										<td><label>密碼</label></td>
										<td><input type="text" name="password" /></td>
									</tr>
									<tr>
										<td><label>年齡</label></td>
										<td><input type="text" name="age" /></td>
									</tr>
									<tr>
										<td><label>個性簽名</label></td>
										<td><textarea rows="3" cols="18" name="personalSignature" /></textarea>
									</tr>
									<tr>
										<td colspan="2"><input type="submit" value="注冊" /></td>
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