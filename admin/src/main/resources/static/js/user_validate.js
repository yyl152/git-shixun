//判断年龄格式是否符合规范
function testAge() {
    //正则
    var regex = /^[0-9]+$/;
    //使用正则判断是否符合
    var flag = regex.test($("#age").val());
    //不符合则显示提示
    if (!flag) {
        $("#errorformat").css("display","inline");
    }
    return flag;
}

//判断QQ是否符合规范以及是否重复
function testQq() {
    //正则
    var regex = /^[0-9]+$/;
    //获取qq输入的值
    var qq = $("#qq").val();
    //使用正则判断是否符合
    var flag = regex.test(qq);
    //不符合则显示提示
    if (!flag) {
        $("#errorqqformat").html("QQ格式有误");
    }else{
        //格式正确的话则再判断是否重复
        $.get("user/testQq",{qq:qq},function (resultInfo) {
            if (resultInfo.code==0){
                $("#errorqqformat").html("QQ已存在");
            }
        })
    }
    return flag;
}