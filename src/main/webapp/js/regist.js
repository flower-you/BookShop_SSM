nameFlag=false;//定义一个全局变量，判断用户名是否合法，默认不合法
function success_function(data) {//定义回调函数
	$("#namespan").html("");
	if (data == "true") {
		$("#namespan").html("<font color='red' size='3'>用户名已被使用</font>");
		$("#name").focus();
		nameFlag=false;
		return false;
	} else {
		$("#namespan").html("<font color='green' size='3'>用户名可用</font>");
		nameFlag=true;
		return true;
	}
};
/**
 * JQuery和Ajax验证用户名是否存在
 * 
 * @returns
 */
function nameBlur() {
	$("#namespan").html("");
	var name = document.getElementById("name").value;
	if (name != "") {
		if (name.length < 6 || name.length > 16) {// 用户名的长度应该在6到16个字符之间
			$("#namespan").html(
					"<font color='red' size='3'>用户名的长度应该在6到16个字符之间</font>");
			nameFlag=false;
			return false;
		} else {// 长度合法之后再检验用户名是否存在
			// 第一种
			$.ajax({
				type : "post",
				url : "check",// 后台的action
				data : {
					username : name
				},// username为要向后传台入的参数名称
				dataType : "text",
				success : success_function
			// 服务器响应成功后将data即username的值传入到success_function中作为参数
			});
			// 第二种
			// $.post("check.action",{name:name},function(data){
			// if(data=="true"){
			// $("#name_exit").hide();
			// }else{
			// $("#name_exit").show();
			// }
			// },"text");

		}

	} else {
		$("#namespan").html("<font color='red' size='3'>用户名不能为空</font>");
		nameFlag=false;
		return false;
	}
}
/**
 * 密码格式验证 要求： 非空 密码可以为任意的字母，数字，下划线，@，.组成，长度9~16位
 * 
 * @returns
 */
function pass1Blur() {
	$("#pass1span").html("");
	var pass1 = document.getElementById("pass1").value;
	if (pass1 == "") {
		$("#pass1span").html("<font color='red' size='3'>密码不能为空</font>");
		return false;
	} else {
		var regex1 = /^(([A-Za-z_]{9,16})|([\d]{9,16}))$/;// 纯数字或字母
		var regex2 = /^[\w*@*.*]{9,16}$/;// 密码可以为任意的字母，数字，下划线，@，.组成，长度9~16位
		if (pass1.length < 9 || pass1.length > 16) {
			$("#pass1span").html(
					"<font color='red' size='3'>密码长度要求为9到16位</font>");
			return false;
		} else if (regex1.test(pass1) == true) {
			$("#pass1span").html(
					"<font color='red' size='3'>密码必须由数字和字符组成</font>");
			return false;
		} else if (regex2.test(pass1) == false) {
			$("#pass1span").html("<font color='red' size='3'>密码中含有非法字符</font>");
			return false;
		} else {
			return true;
		}
	}
}
/**
 * 确认密码验证
 * 
 * @returns
 */
function pass2Blur() {
	$("#pass2sapn").remove();
	var pass1 = document.getElementById("pass1").value;
	var pass2 = document.getElementById("pass2").value;
	if (pass1 == pass2) {
		return true;
	} else {
		$("#pass2").after(
				"<span id='pass2sapn' style='color:red'>两次密码不一致</span>")
		return false;
	}
}
/**
 * 效验年龄 年龄在10~199之间 当不合法时弹出提示信息
 * 
 * @returns
 */
function ageBlur() {
	$("#ageSpan").html("");
	var age = $("#age").val();// 发现它会自动去掉空格诶
	// var regex1 = /^[1-9][0-9]{1}$/;// 年龄在10~99
	// var regex2 = /^1[0-9]{2}$/;// 年龄在100~199之间
	var regex = /^([1-9][0-9]{1})|(1[0-9]{2})$/;
	// if((regex1.test(age) == true)||(regex2.test(age) == true)){
	if (regex.test(age) == true) {
		return true;
	} else {
		$("#ageSpan").html("<font color='red' size='3'>输入的年龄不合法</font>");
		return false;
	}
}
/**
 * 效验电话号码 规则： 必须是满足下列格式的11位数字电话号码
 * 13（0-9）或者14（0-9）或者170或者15（0-3）或者15（5-9）或者18（0-9）+8位数字
 * 注：正整数（首位不能为0，如025不合法）的正则表达式：/^[1-9][0-9]*$/
 * 
 * 移动号码归属地支持号段:134 135 136 137 138 139 147 150 151 152 157 158 159 178 182 183
 * 184 187 188 联通号码归属地支持号段:130 131 132 145 155 156 176 186 电信号码归属地支持号段:133 153
 * 177 180 181 189 移动运营商:170
 * 
 * @returns
 */
function telBlur() {
	$("#telSpan").html("");
	var tel = $("#tel").val();
	var regex = /^(((13[0-9]{1})|(14[0-9]{1})|(17[0]{1})|(15[0-3]{1})|(15[5-9]{1})|(18[0-9]{1}))+\d{8})$/;
	if (regex.test(tel) == true) {
		return true;
	} else {
		$("#telSpan").html("<font color='red' size='3'>电话号码格式不正确</font>");
		return false;
	}
}

function registSubmit() {
	if ((ageBlur() && nameFlag&&pass1Blur() && pass2Blur() && telBlur())) {
		return true;
	} else {
		alert("请完善你的信息再提交！");
		return false;
	}
}
