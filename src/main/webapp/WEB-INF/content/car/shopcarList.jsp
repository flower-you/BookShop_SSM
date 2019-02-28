<%--
  Created by IntelliJ IDEA.
  User: 17976
  Date: 2019/2/12
  Time: 20:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>购物车</title>
    <link href="css/car.css" type="text/css" rel="stylesheet" />
    <script type="text/javascript" src="js/jquery.js"></script>
    <script type="text/javascript" src="js/addLabel.js"></script>
    <script type="text/javascript" src="js/car.js"></script>
</head>
<body>
<div id="content">
    <table width="100%" border="0" cellspacing="0" cellpadding="0" id="shopping">
        <form action="" method="post" name="myform">
            <tr>
                <td class="title_1"><input id="allCheckBox" type="checkbox" value="" onclick="selectAll()" />全选</td>
                <td class="title_2" colspan="2">店铺宝贝</td>
                <td class="title_4">单价（元）</td>
                <td class="title_5">数量</td>
                <td class="title_6">金额（元）</td>
                <td class="title_7">操作</td>
            </tr>
            <tr>
                <td colspan="8" class="line"></td>
            </tr>
            <c:if test="${shopCarList.size()>0}">
                <c:forEach items="${shopCarList}" var="bookCar">
                    <div id="carBook">
                        <font>
                            <tr>
                                <td colspan="8" class="shopInfo">作者：${bookCar.key.auth}</td>
                            </tr>
                           <tr id="product">
                               <td class="cart_td_1"><input name="cartCheckBox" type="checkbox" value="product1" onclick="selectSingle()" /></td>
                               <td class="cart_td_2"> <a href="bookDetail?bookId=${bookCar.key.id}"><img src="img/girl.jpg" width="20%" height="320px" /></a></td>
                               <td class="cart_td_3"> <a
                                       href="bookDetail?bookId=${bookCar.key.id}">
                                       ${bookCar.key.name}</a><br />
                                   保障：<img src="images/taobao_icon_01.jpg" alt="icon" /></td>
                               <td class="cart_td_4"><font color="#dcdcdc">￥${bookCar.key.price}</font>&nbsp;&nbsp;
                                   <label id="price">
                                <c:if test="${book.rebate>0&&book.rebate<1}">
                                    <strong>￥${book.price*book.rebate} </strong>
                                   </c:if></label></td>
                               <td class="cart_td_5"><input type="button" value="-" onclick="subShop()"/>
                                   <input type="text" id="shopCount" size="2" value="${bookCar.value}"/>
                                   <input type="button" value="+" onclick="addShop()"/>
                               <td class="cart_td_7" id="money"><font color="red">￥${bookCar.value*bookCar.key.price}</font> </td>
                               <td class="cart_td_8"><a href="javascript:deleteRow('product1');">删除</a></td>
                           </tr>
                        </font>
                    </div>
                </c:forEach>
            </c:if>
            <tr>
                <div id="btn" align="right">
                    <br />
                    合计(不含运费): <font color="red" size=""><label></label></font>
                    <a href=""> <button>结算</button></a>
                </div>
            </tr>
        </form>
    </table>
</div>
</body>
</html>
