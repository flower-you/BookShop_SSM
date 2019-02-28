<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>最新上架</title>
<link href="http://localhost:8080/BookShopSSM/img/pander.jpg"
	type="image/x-icon" rel="shortcut icon">
<script type="text/javascript" src="jslib/jquery.js"></script>
<script type="text/javascript" src="js/newBookMore.js"></script>
<style>
.listTitle {
	font: "微软雅黑";
	font-style: oblique;
	font-size: 29px;
	color: coral;
	margin: 0px 620px;
}

#page {
	width: auto;
	height: 20px;
	margin-top: 20px;
	margin-left: 1380px;
	margin-bottom: 20px;
	float: right;
}

#newBooks {
	margin-top: 22px;
	font-size: 10;
	width: 100%;
	height: 100%;
}

#mbook {
	width: 20%;
	float: left;
	margin-left: 45px;
}
</style>
<style>
a {
	TEXT-DECORATION: none
}

a.xh {
	TEXT-DECORATION: none
}

a:hover.xh {
	TEXT-DECORATION: underline
}
</style>
</head>
<body>
	<iframe src="header2.jsp" width="100%" height="100%" frameborder="0"
			name="header"></iframe>
	<div id="middle">
		<span class="listTitle"><font><strong>最新上架</strong></font></span>
		<div id="newBooks">
			<c:if test="${bookMap.size()>0}">
				<c:forEach items="${bookMap}" var="bookmap">
					<div id="mbook">
						<a href="bookDetail?bookId=${bookmap.key.id}"><img
							src="img/girl.jpg" width="85%" height="340px" /></a> <font> <br />书名：<a
							href="bookDetail?bookId=${bookmap.key.id}">
								&lt;&lt;${bookmap.key.name}&gt;&gt;</a> <br />作者：<a href="">${bookmap.key.auth}</a>
							<br />分类： <c:if test="${bookmap.value.size()>0}">
								<c:forEach items="${bookmap.value}" var="type" varStatus="xh">
									<a href="">${type}</a>
									<!--xh.count从1开始，xh.index从0开始  -->
									<c:if test="${xh.count!=bookmap.value.size()}">
										<!-- 如果不是 最后一个元素，就加上逗号进行分隔-->
										,
									</c:if>
								</c:forEach>
							</c:if> <br />更新时间：<fmt:formatDate type="date"
								value="${bookmap.key.onlinetime}" /> <br />简介：${bookmap.key.brief}
						</font>
					</div>
				</c:forEach>
			</c:if>
		</div>

		<div id="page">

			<c:if test="${total>0}">
				<a href="newBookMore?currentPage=1">首页</a>
			</c:if>
			<c:if test="${currentPage>1}">
				<a href="newBookMore?currentPage=${currentPage-1}">上一页</a>
				${pageBar}
				<c:if test="${currentPage<total}">
					<a href="newBookMore?currentPage=${currentPage+1}">下一页</a>
				</c:if>
			</c:if>
			<c:if test="${currentPage<=1}">
				${pageBar}
				<c:if test="${currentPage<total}">
					<a href="newBookMore?currentPage=${currentPage+1}">下一页</a>
				</c:if>
			</c:if>
			<c:if test="${total>0}">
				<a href="newBookMore?currentPage=${total}">末页</a>
			</c:if>
		</div>
	</div>
</body>
</html>