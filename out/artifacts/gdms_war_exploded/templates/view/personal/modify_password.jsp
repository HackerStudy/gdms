<%--
  Created by IntelliJ IDEA.
  User: 鹏
  Date: 2018/4/26
  Time: 16:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <title>修改密码</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="format-detection" content="telephone=no">
    <link rel="stylesheet" href="<%=basePath%>templates/style/plugins/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="<%=basePath%>templates/style/build/css/doc.css" media="all">
    <link rel="stylesheet" href="../../css/user.css" media="all" />
    <script src="<%=basePath%>templates/style/plugins/layui/layui.js"></script>
    <script src="<%=basePath%>templates/style/plugins/layui/jquery-3.3.1.min.js"></script>
    <script src="<%=basePath%>templates/admin/js/getGroup.js"></script>
</head>
<body class="childrenBody">
<div class="layui-col-md12">
    <div class="layui-card">
        <div class="layui-card-header">修改密码</div>
        <div class="layui-card-body">
            <form class="layui-form" action="">
                <input id="oldpassword1" name="oldpassword1" value=${user.password} type="hidden" />
                <div class="layui-form-item">
                    <label class="layui-form-label">旧密码</label>
                    <div class="layui-input-inline" style="height: 40px;">
                        <input id="oldpassword" type="password" name="oldpassword" lay-verify="required" lay-vertype="tips" placeholder="请输入老密码" autocomplete="off" class="layui-input" onblur="verifyOldPassword()"><div style="position: relative;left: 200px;top: -32px;"><span id="old"></span></div>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">密码</label>
                    <div class="layui-input-inline">
                        <input id="password" type="password" name="password" lay-verify="required" placeholder="请输入密码" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">新密码</label>
                    <div class="layui-input-inline" style="height: 40px;">
                        <input id="passwordAgain" type="password" name="passwordAgain" lay-verify="required" placeholder="请确认密码" autocomplete="off" class="layui-input" onblur="verifyPasswordAgain()"><div style="position: relative;left: 200px;top: -32px;"><span id="new"></span></div>
                    </div>
                </div>
                <div class="layui-form-item">
                    <div class="layui-input-block">
                        <button id="button" class="layui-btn" lay-submit lay-filter="add">修改</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
<script type="text/javascript">

    function verifyOldPassword(){
        var oldpwd=document.getElementById("oldpassword").value;
        var oldpwd1=document.getElementById("oldpassword1").value;
        if(oldpwd==oldpwd1){
            document.getElementById("old").innerHTML="<font color='green'>旧密码输入正确</font>";
        }else{
            document.getElementById("old").innerHTML="<font color='red'>旧密码输入错误</font>";
            document.getElementById("button").disabled = true;
        }
    }

    function verifyPasswordAgain() {
        var pwd1 = document.getElementById("password").value;
        var pwd2 = document.getElementById("passwordAgain").value;
        <!-- 对比两次输入的密码 -->
        if(pwd1 == pwd2)
        {
            document.getElementById("new").innerHTML="<font color='green'>两次密码相同</font>";
            document.getElementById("button").disabled = false;
        }
        else {
            document.getElementById("new").innerHTML="<font color='red'>两次密码不相同</font>";
            document.getElementById("button").disabled = true;
        }
    };

    layui.use(['element','form'], function(){
        var form = layui.form;
        //监听提交，发送请求

        // //自定义验证规则
        // form.verify({
        //     phone: function(value,item){
        //         if(/^1[3|4|5|7|8]\d{9}$/.test(value)){
        //             return '手机必须11位，只能是数字！';
        //         }
        //     },
        //     email: function(value,item){
        //         if(/^[a-z0-9._%-]+@([a-z0-9-]+\.)+[a-z]{2,4}$|^1[3|4|5|7|8]\d{9}$/.test(value)){
        //             return '邮箱格式不对';
        //         }
        //     }
        // });
        form.on('submit(add)', function(data){
            $.post("<%=basePath%>person/updatePassword",data.field,function(data){
                // 获取 session
                if(data.code!=200){
                    layer.alert(data.msg, {offset: 'auto',icon: 5});
                }
                if(data.code==200){
                    layer.alert(data.msg, {offset: 'auto',icon: 6});
                }
            });
            return false;
        });
    });
</script>
</body>
</html>