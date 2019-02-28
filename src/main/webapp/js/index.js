function newBooks() {
	$.ajax({
		type : "post",
		url : "newBookIndex",//后台的action
		dataType : "json",//data : {},
		success : function(data) {
			 if(data){
	       		 var res = []; 
	       		 //push() 方法可向数组的末尾添加一个或多个元素，并返回新的长度。
		     	 jQuery.each(data.newBookList, function(i,book){
		     		 res.push('<div id="mbook" style="width: 20%;float: left; margin-left: 45px;">');
		       		 res.push('<img  src="img/girl.jpg" width="97.5%" height="335px" />');
		       		 res.push('<font>');
		       		 res.push('<br />');
		       		 res.push('<strong>&lt;&lt;'+book.name+'&gt;&gt;</strong>');
		       		 res.push('<br />作者：'+book.auth);
		       		 res.push('<br />分类：');
		       		 
		       		 var typeList=findBookTypeById(book.id);
		       		 jQuery.each(typeList,function(j,typename){
		       			 res.push(typename);
		       			 if(j!=typeList.length-1){
		       				res.push(','); 
		       			 }
		       		 });
		       		 res.push('<br />更新时间：'+fmtDate(book.onlinetime)); 
		       		 res.push('<br />简介：'+book.brief);
		       		 res.push('</font>');
		     		 res.push('</div>');
				  });
		     	 res.push('<a href="newBookMore?currentPage=1" target="_parent" class="mhr">查看更多</a>');
		     	//arrayObject.join(separator)将数组中的所有元素放入一个字符串，spearator为分隔符，可选
				  $("#newBooks").empty().html(res.join(""));
				
			
	       }
		},
		error : function() {
			alert("系统错误！");
		}
	});
}

function findBookTypeById(id){
	var typename="";
	$.ajax({
		async:false,
		type : "post",
		url : "selectNameById.ajax",
		data : {
			bookid: id
		},
		dataType : "json",
		success : function(data){
			typename=data;
			}
		});
	return typename;
}

/**
 * 格式化时间
 * @param obj
 * @returns 形如 2018-08-09 08:00:00
 */
function fmtDateTime(obj){
	var d=new Date(obj);
	  var year=d.getFullYear();
	  var month="0"+(d.getMonth()+1);
	  var day="0"+d.getDate();
	  var hour="0"+d.getHours();
	  var minute="0"+d.getMinutes();
	  var second="0"+d.getSeconds();
	  var time=year+'-'+month.substring(month.length-2,month.length)+'-'+day.substring(day.length-2,day.length)+
	  ' '+hour.substring(hour.length-2,hour.length)+':'+minute.substring(minute.length-2,minute.length)+':'+
	  second.substring(second.length-2,second.length);
	  return time;
}

/**
 * 格式化日期
 * @param obj
 * @returns 形如2018-08-09
 */
function fmtDate(obj){
    var date =  new Date(obj);
    var y = 1900+date.getYear();
    var m = "0"+(date.getMonth()+1);
    var d = "0"+date.getDate();
    return y+"-"+m.substring(m.length-2,m.length)+"-"+d.substring(d.length-2,d.length);
}











