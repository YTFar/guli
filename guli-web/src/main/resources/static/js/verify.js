//定时器
var timer;
//验证后台表单
function verify(test){
    //获取表单的值
    var testName = test.val();
    //填写正则表达式
    var varreg;
    //提示信息
    var verifyText = "";
    //提示信息显示在此元素上
    var errorShow = $(".errorShow");
    //判断表单
    if(testName == ""){
        verifyText = "必填项不能为空!";
    }else{
        //表单不为空分别验证
        if(test.attr("name") == "username"){
            varreg = /^[a-zA-Z0-9_-]{6,20}$/;
            if(!varreg.test(testName)){
                verifyText = "此项必须由6-20位的字母数字组成";
            }else{
                verifyText = "";
            }
        }else if(test.attr("name") == "password"){
            varreg = /^[0-9a-zA-Z_]{6,15}$/;
            if(!varreg.test(testName)){
                verifyText = "密码必须由6-15位的字母数字组成";
            }else{
                verifyText = "";
            }
        }else if(test.attr("name")=="phone"){
            varreg = /^1(3|4|5|6|7|8|9)\d{9}$/;
            if(!varreg.test(testName)){
                verifyText = "请输入正确的电话号码";
            }else{
                verifyText = "";
            }
        }
    }
    //判断文字信息为空为正确此元素不显示,否则为显示
    if(verifyText == ""){
        errorShow.attr("style","display: none;")
        return true;
    }else{
        // errorShow.text(verifyText);
        // errorShow.show();
        // timer = setTimeout(function(){
        //     errorShow.hide()
        //     clearTimeout(timer);
        // },2000);
        // if(judge == 0){
        //     test.focus();
        // }
        test.focus();
        errorShow.attr("style","display: block;")
        errorShow.text(verifyText);
    }
    return false;
}

var radioNum = 0;
$("#layui-form-checkbox").click(function(){
    if(radioNum%2==0){
        $(this).attr("class","layui-unselect layui-form-checkbox layui-form-checked");
    }else{
        $(this).attr("class","layui-unselect layui-form-checkbox");
    }
    radioNum++;
});

// function hide(errorShow){
//     alert(1);
//     // errorShow.hide();
//     // clearTimeout(timer);
// }