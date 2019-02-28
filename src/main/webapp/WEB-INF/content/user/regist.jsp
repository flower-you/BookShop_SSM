<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="http://localhost:8080/BookShopSSM/img/pander.jpg"
	type="image/x-icon" rel="shortcut icon">
<link rel="stylesheet" type="text/css" href="css/regist.css">
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/regist.js"></script>
<script type="text/javascript">
	function defaultRadio() {
		document.getElementsByName("roleid")[0].checked = true;
	}
</script>
</head>
<body class="templatemo-bg-gray" onload="defaultRadio()">
	<div align="center">
		<h1>注册</h1>
		<form id="form1" action="regist" method="post">
			<table class="templatemo-container" style="width: 650px;">
				<tr>
					<td>用户名:<input id="name" onblur="nameBlur()" type="text"
						class="form-control" name="username"
						placeholder="please input your name" />
					</td>
					<td><span id="namespan"></span></td>
				</tr>
				<tr>
					<div>
						<td>密&nbsp;&nbsp;码:<input  id="pass1" onblur="pass1Blur()"
							type="password" class="form-control" name="password" /></td>
						<td><span id="pass1span"></span></td>
					</div>

				</tr>
				<tr>
					<td>确认密码:<input id="pass2" onblur="pass2Blur()"
						type="password" class="form-control"  /></td>
				</tr>
				<tr>
					<td>年龄:<br /> <input id="age" type="text"
						class="form-control" name="age" onblur="ageBlur()"
						style="text-align: center; display: inline; width: 15%; margin-right: 8%;" />
						<span id="ageSpan"></span>
						 <input type="radio" name="sex" value="false" />女&nbsp;&nbsp;
						<input type="radio" name="sex" value="true" checked="checked" />男
					</td>
				</tr>
				<tr>
					<td>电&nbsp;&nbsp;话:<input id="tel" type="text"
						class="form-control" onblur="telBlur()" name="phone" />
						<span id="telSpan"></span></td>
				</tr>
				<tr>
					<td><c:forEach var="role" items="${roleList}">
						<input type="radio" id="role" name="roleid" value="${role.id}"
							checked="true">${role.rolename}
				</c:forEach></td>
				</tr>

				<tr>
					<td align="center"><input type="submit" value="立即注册 "
						class="btn" onclick="return registSubmit()" /></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>
