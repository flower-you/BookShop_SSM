function DetailAlipay(){
    var orderItems=[];
    var bid=$("#bid").val();
    var num=$("#shopCount").val();
    var bprice=$("#price").val();
    orderItems.push(bid);
    orderItems.push(num);
    orderItems.push(bprice);
    var orderItem=JSON.stringify(orderItems);

    windows.location.href="toOrder?bookid="+bid+"amt="+num+"price="+num*bprice;
}
function addShop(){
	var count=$("#shopCount").val();
	$("#shopCount").html($("#shopCount").val(++count));
}

function subShop(){
	var count=$("#shopCount").val();
	if (count>1){
        $("#shopCount").html($("#shopCount").val(--count));
	}
}

function addToCar(){
    var count=$("#shopCount").val();
    var bid=$("#bid").val();
    var uid=$("#uid").val();

    if (uid==null||uid==""){
        //在原有窗口打开
        window.location.href = "toLogin";
        // window.open("toLogin");在新窗口中打开
	}
	else {
        $.ajax({
            type : "post",
            url : "addToCar",// 后台的action
            data : {
                num : count,
                bid : bid,
                uid : uid
            },
            dataType : "json",
            success : success_function
        });
	}

}

function success_function(data){

    window.location.href=data.res+data.bid;

	//这里的data是服务器从后端返回的结果
    // alert(typeof(data.res));
	// alert("data"+data.res);
	// var sta=data.res.substring(0,data.res.lastIndexOf("="));
	// var end=data.res.substring(data.res.indexOf("="),data.res.length);
	// alert("sta"+sta.toString()+"end"+end.toString());

	// alert(${pageContext.request.contextPath}+"/WEB-INF/content/"+data.toString()+".jsp");
    // var localObj = window.location; //这个的意思是获取当前页面的地址
    // var protocol = location.protocol ;//获取http或https
    // var host = localObj.host;// 获取JSP地址栏IP和端口号 //localhost:8080
    // var contextPath = localObj.pathname.split("/")[1]; //获取项目名
    // var basePath = protocol +"//"+host+"/"+contextPath;
    //http://localhost:8081/bookDetail/WEB-INF/content/car/addSuccess.jsp
    // window.location.href=basePath.toString()+"/WEB-INF/content/"+data.toString()+".jsp";
    return true;
}




