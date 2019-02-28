function findBookTypeById(id){
	$.ajax({
		type : "post",
		url : "selectNameById",
		data : {
			bookid: id
		},
		dataType : "text",
		success : function(data){
			$("#typeName").empty().html(data);
			alert(id);
			}
		});
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
	  $("#updateTime").empty().html(time);
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











