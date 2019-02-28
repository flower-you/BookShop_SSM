<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>导航条</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/header.css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery.js">
	/*src="${pageContext.request.contextPath}/jslib/jquery.validate.js"*/
</script>
</head>
<body>
	<div id="header">
		<div id="headerLeft">
			<font class="shopName">拾光书城</font>
		</div>
		<div id="headerRight">


			<ul>
				<li><a href="index.jsp" target="_top">首页</a></li>&nbsp;|
				<c:if test="${user==null}">
					<!-- onclick="javascript:window.location.href='toLogin'" -->
					<li><a href="toLogin" target="_blank">登录</a></li>&nbsp;
				<li><a href="toRegist" target="_blank">注册</a></li>&nbsp;|
		</c:if>

				<c:if test="${user!=null}">
					<li><select id="userCenter"
						style="background-color: lightpink; font-size: 17px">
							<option>
						<a href="#">个人中心</a>
					</option>
							<option>
						<a href="#">账户设置</a>
					</option>
							<option>
						<a href="#">我的购物车</a>
					</option>
							<option>
						<a href="#">我的收藏</a>
					</option>
							<option>
						<a href="#">最近浏览</a>
					</option>
					</select></li>&nbsp;|
			<li><a href="logout" target="_blank">退出登录</a>&nbsp;|</li>
				</c:if>

				<li><a href="#about">帮助</a></li>
			</ul>
		</div>
	</div>

</body>

</html>