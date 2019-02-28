<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>拾光书城</title>
<link href="http://localhost:8080/BookShopSSM/img/pander.jpg"
	type="image/x-icon" rel="shortcut icon">
<link rel="stylesheet" href="css/index.css" />
<script type="text/javascript" src="jslib/jquery.js"></script>
<script type="text/javascript" src="jslib/json2.js"></script>
<script type="text/javascript" src="js/index.js"></script>
</head>
<body onload="newBooks()">
	<div id="body">
		<div id="header">
			<div id="headerLeft">
				<font class="shopName">拾光书城</font>
			</div>
			<div id="headerRight">
				<iframe src="header.jsp" width="100%" height="100%" frameborder="0"
					name="header"></iframe>
			</div>
		</div>
		<div id="main">
			<div id="left">
				<!--style="margin-left: -100%;-->
				<div id="leftTop">
					<strong>全部分类</strong>
				</div>
				<div id="leftBottom">
					<strong>论坛专区</strong>
				</div>
			</div>
			<div id="right">
				<div id="top">
					<form id="serach">
						<tr>
							<td><input type="text" id="serachText" name="auther"
								placeholder="书名/作者名" /> <span><input type="submit"
									value="搜索 " id="submit" /></span></td>
						</tr>

					</form>
				</div>
				<div id="middle">
					<span class="listTitle"><font><strong>最新上架</strong></font></span>

					<div id="newBooks"
						style="margin-top: 22px; font-size: 10; width: 100%; height: 100%;">

					</div>
				</div>
				<div id="bottom">
					<span class="listTitle"><font><strong>热销图书</strong></font></span>
					<div id="hotBooks"
						style="margin-top: 22px; font-size: 10; width: 100%; height: 100%;">
						<div id="mbook"
							style="width: 20%; float: left; margin-left: 45px;">
							<img src="img/girl.jpg" width="98%" height="345px" /> <font>
								<br />书名： &lt;&lt;盛夏时光&gt;&gt; <br />作者：xxxxxxx
							</font>
						</div>
						<div id="mbook"
							style="width: 20%; float: left; margin-left: 37px;">
							<img src="img/cos1.jpg" width="98%" height="345px" /> <font>
								<br />书名： &lt;&lt;盛夏时光&gt;&gt; <br />作者：xxxxxxx
							</font>
						</div>
						<div id="mbook"
							style="width: 20%; float: left; margin-left: 37px;">
							<img src="img/清新.jpg" width="98%" height="345px" /> <font>
								<br />书名： &lt;&lt;盛夏时光&gt;&gt; <br />作者：xxxxxxx
							</font>
						</div>
						<div id="mbook"
							style="width: 20%; float: left; margin-left: 38px;">
							<img src="img/清新.jpg" width="98%" height="345px" /> <font>
								<br />书名： &lt;&lt;盛夏时光&gt;&gt; <br />作者：xxxxxxx
							</font>
						</div>
						<a href="" class="mhr">查看更多</a>
					</div>
				</div>
			</div>
		</div>

		<div id="foot">
			<iframe src="foot.html" width="100%" height="100%" class="bbb"
				frameborder="0"></iframe>
		</div>

	</div>
</body>

</html>