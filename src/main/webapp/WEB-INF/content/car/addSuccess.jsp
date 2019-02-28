<%--
  Created by IntelliJ IDEA.
  User: 17976
  Date: 2019/2/12
  Time: 18:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="css/header.css" />
    <link rel="stylesheet" href="css/index.css" />
    <script type="text/javascript" src="js/jquery.js"></script>
    <script type="text/javascript" src="js/addLabel.js"></script>
</head>
<body>
<div id="header">
    <div id="headerLeft">
        <font class="shopName">拾光书城</font>
    </div>
    <div id="headerRight">
        <iframe src="header.jsp" width="100%" height="100%" frameborder="0"
                name="header"></iframe>
    </div>
</div>
<div id="top">
    <form id="serach">
        <tr>
            <td><input type="text" id="serachText" name="auther"
                       placeholder="书名/作者名" /> <span><input type="submit"
                                                            value="搜索 " id="submit" /></span></td>
        </tr>

    </form>
</div>


<div id="J_ResultMain" class="result-main clearfix" data-spm="1998302264">
    <div class="item-info J_ItemInfo">
        <div class="sku-info J_SkuInfo">
            已添加商品：
        </div>
        <div class="item-op">
            <a href="addToCar?uid=${user.id}&&bid=${book.id}&&num=1" class="op-add J_CartPluginTrigger">继续添加其它属性：</a>
        </div>
        <div class="item-pic cart-pic s200"><a href="//item.taobao.com/item.htm?id=578732920581" target="_blank"><img class="J_CurItemPic" src="//gd4.alicdn.com/imgextra/i2/1726200025/O1CN01HsOi9w1C3UOhEzrKP_!!1726200025.jpg_200x200.jpg" alt=""/></a></div>
    </div>
    <div id="J_ResultSummary" class="result-summary">
        <div class="result-hint"><i class="cart-icon icon-success"></i>已成功加入购物车</div>
        <div class="price-summary">小计：<span class="price">&yen;<em>${book.price*book.rebate}</em></span></div>
        <div class="cart-summary">购物车共有<em>${shopCount}件</em>商品</div>
        <div class="result-op">
            <a href="bookDetail?bookId=${bookId}"target="_blank" class="op-return"><i class="cart-icon icon-left"></i>返回商品详情</a>
            <a href="queryCar?uid=${user.id}" class="op-cart">去购物车结算</a>
        </div>
    </div>
</div>
<div id="foot">
    <iframe src="foot.html" width="100%" height="100%" class="bbb"
            frameborder="0"></iframe>
</div>
</body>
</html>
