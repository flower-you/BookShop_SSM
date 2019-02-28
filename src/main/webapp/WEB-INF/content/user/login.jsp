<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
<link href="http://localhost:8080/BookShopSSM/img/pander.jpg"
	type="image/x-icon" rel="shortcut icon">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/login.css " />
<style>
.loginForm {
	position: relative;
	width: 480px;
	height: 520px;
	background-color: cornsilk;
	border: 1px solid blueviolet;
	margin: 10px 780px 70px;
}

#role {
	width: 50px;
}

#body {
	width: 100%;
	height: 1000px;
	border: 2px solid red;
	background: url(img/拾光相册.jpg) no-repeat;
	background-size: 100% 100%;
	/*设置图片铺面整个容器的大小*/
	overflow: hidden;
}

#shopFont {
	font-family: fusanghua;
	font-size: 85px;
	margin: 45px 250px;
	width: 30%;
	height: 200px;
}

@font-face {
	/* font-properties */
	font-family: fusanghua;
	src: url('font/扶桑花期.ttf');
}
</style>
<script type="text/javascript">
	function defaultRadio() {
		document.getElementsByName("roleid")[0].checked = true;
	}
</script>
<script type="text/javascript">
	function check() {
		if (loginForm.username.value == "") {
			alert("请输入用户名！");
			loginForm.username.focus();
			return;
		} else if (loginForm.password.value == "") {
			alert("请输入密码！");
			loginForm.password.focus();
			return;
		} else {
			loginForm.submit();
		}
	}
</script>
</head>

<body id="body" onload="defaultRadio();">
	<div id="shopFont">
		<font>拾光--书城</font>
	</div>
	<form action="login" method="post" class="loginForm" id="loginForm">
		<table>
			<tr>
				<td>用户名：<input type="text" name="username"
					placeholder="please input your name" class="UserInput" /></td>
			</tr>
			<tr>
				<td>密&nbsp;&nbsp;码：<input type="password" id="password"
					name="password" class="UserInput" /></td>
			</tr>
			<tr>
				<td><c:forEach var="role" items="${roleList}">
						<input type="radio" id="role" name="roleid" value="${role.id}"
							checked="true">${role.rolename}
				</c:forEach></td>
			</tr>
			<tr>
				<td><input type="submit" value="登录" class="btn" onclick="check()"/></td>
			</tr>
			<font color="red">${msg}</font>
			<tr>
					<td><a href="toRegist"><font color="gray">没有账号？前去注册</font></a></td>
				</tr>
		</table>
	</form>
</body>

</html>