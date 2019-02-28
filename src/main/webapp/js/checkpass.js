 $("input#pwd").keyup(function(){

        var txt=$("#pwd").val(); //获取密码框内容
        var len=txt.length; //获取内容长度

        if(txt=='' || len<6){
            $("label").show();
            $("label").addClass("tips");
        }else {
            $("label").hide();
        }

        checkpwd($(this));
    });

    //全部都是灰色的
    function primary(){
        $("p.pwdColor span").removeClass("co1,co2,co3");
    }

    //密码强度为弱的时候
    function weak(){
        $("span.c1").addClass("co1");
        $("span.c2").removeClass("co2");
        $("span.c3").removeClass("co3");
    }
    //密码强度为中等的时候
    function middle(){
        $("span.c1").addClass("co1");
        $("span.c2").addClass("co2");
        $("span.c3").removeClass("co3");
    }

    //密码强度为强的时候
    function strong(){
        $("span.c1").addClass("co1");
        $("span.c2").addClass("co2");  
        $("span.c3").addClass("co3");
    }

    /**判断密码的强弱规则
    1、如果是单一的字符（全是数字 或 字母 ）长度小于 6  弱
    2、如果是两两混合 (数字+字母（大小） 或 数字+特殊字符  或 特殊字符+字母  长度大于 8  中)
    3、如果是三者组合 (数字 +大写字母+小写字母 或 数字+字母+特殊字符 长度>8  强）)
**/

    //密码强弱判断函数

    function checkpwd(obj){
        var txt = $.trim(obj.val());//输入框内容 trim处理两端空格
        var len = txt.length;
        var num = /\d/.test(txt);//匹配数字
        var small = /[a-z]/.test(txt);//匹配小写字母
        var big = /[A-Z]/.test(txt);//匹配大写字母
        var corps = /\W/.test(txt);//特殊符号
        var val = num + small+big+corps; //四个组合


        if(len<1){
            primary();
        }else if(len<6){
            weak();
        }else if(len>6 && len<=8){
            if(val==1){
                weak();
            }else if(val==2){
                middle();
            }
        }else if(len>8){
            if(val==1){
                weak();
            }else if(val==2){
                middle();
            }else if(val==3){
                strong();
            }
            return false;
        }

    }


