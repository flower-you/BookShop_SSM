<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta name="description" content="${book.name}"/>
    <meta name="keywords" content="${book.name}"/>
    <title>${book.name}</title>
    <link href="http://localhost:8080/BookShopSSM/img/pander.jpg"
          type="image/x-icon" rel="shortcut icon">
    <script type="text/javascript" src="js/jquery.js"></script>
    <script type="text/javascript" src="js/addLabel.js"></script>
    <style>
        #body {
            width: 98%;
            height: auto;
        }

        #header {
            height: 10%;
            border: solid 1px black;
        }

        #main {
            height: 402px;
        }

        #top {
            position: relative;
            height: 400px;
            margin-left: 300px;
            border: solid 1px black;
        }

        #left {
            position: relative;
            width: 17%;
            height: 395px;
            float: left;
            border: solid 1px black;
        }

        #right {
            position: relative;
            width: 80%;
            height: 395px%;
            float: right;
            margin-top: 20px;
        }

        #bottom {
            position: relative;
            margin-left: 300px;
            border: solid 1px black;
        }

        #serach {
            margin-left: 750px;
            margin-bottom: 50px;
        }

        #serachText {
            width: 250px;
            height: 25px;
            border: 1px solid rosybrown;
            /*margin: 10px 30px;*/
            font-size: 18px;
        }
    </style>
</head>

<body id="body">
<div>
    <iframe src="header2.jsp" width="100%" height="100%" frameborder="0" name="header"></iframe>
</div>

<form id="serach">
    <tr>
        <td>
            <input type="text" id="serachText" name="auther" placeholder="书名/作者名"/>
            <span><input type="submit" value="搜索 " id="submit" style="background-color: pink;"/></span>
        </td>
    </tr>

</form>
<div id="main">
    <div id="top">
        <div id="left">
            <img src="img/cos1.jpg" width="99%" height="99%"/>
        </div>
        <div id="right">
            <font size="14px"><strong>${book.name}</strong></font>
            <br/><br/>价格：￥<span id="price">${book.price}</span>
            <c:if test="${book.rebate>0&&book.rebate<1}">
                <br/>促销价：<font color="red" size="6">￥${book.price*book.rebate}</font>
            </c:if>
            <br/><br/>数量：<input type="button" value="-" onclick="subShop()"/>
            <input type="text" id="shopCount" size="2" value="1"/>
            <input type="button" value="+" onclick="addShop()"/>
            &nbsp;&nbsp;&nbsp;库存：${book.stock}件
            <br/>
            <br/><input type="button" onclick="DetailAlipay()" value="立即购买"
                                   style="background-color: peachpuff; width: 90px;height: 30px;">
            &nbsp;&nbsp;&nbsp;
            <!--  <a href="addToCar?uid=${user.id}&&bid=${book.id}&&num=1">
                <input type="button" name="num" onclick="addToCar()" value="加入购物车"
                        style="background-color:red;width: 90px;height: 30px;"></a>
            -->
            <input type="hidden" value="${book.id}" id="bid"/>
            <input type="hidden" value="${user.id}" id="uid">

            <input type="button" onclick="addToCar()" value="加入购物车"
                   style="background-color:red;width: 90px;height: 30px;">
        </div>
    </div>
    <div id="bottom">
        <strong>商品详情</strong> 出版社：${book.publisher} &nbsp;&nbsp;&nbsp;
        出版日期：<fmt:formatDate type="date" value="${book.publishdate}"/>
        <br/>页数：${book.pages}&nbsp;&nbsp;&nbsp;纸张大小：${book.size}
        <br/>版次：${book.printtimes}
        <br/>上线时间：<fmt:formatDate type="date" value="${book.onlinetime}"/>
        <br/>简介：${book.brief}
    </div>
</div>
<!-- 当前页面实际路径：${pageContext.request.contextPath} -->
</body>

</html>
