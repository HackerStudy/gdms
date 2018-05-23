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
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>发布公告</title>
    <link rel="stylesheet" href="<%=basePath%>templates/style/plugins/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="<%=basePath%>templates/style/build/css/doc.css" media="all">
    <script src="<%=basePath%>templates/style/plugins/layui/layui.js"></script>
    <script src="<%=basePath%>templates/style/plugins/layui/jquery-3.3.1.min.js"></script>
    <script src="<%=basePath%>templates/admin/js/getGroup.js"></script>
</head>
<body>
<div class="kit-doc">
    <blockquote class="layui-elem-quote layui-text">
        这里是管理员发布公告的地方
    </blockquote>
    <div class="kit-doc-title">
        <fieldset>
            <legend><a name="blockquote">公告表单</a></legend>
        </fieldset>
    </div>

<form class="layui-form" action="">
    <div class="layui-form-item">
        <label class="layui-form-label">公告标题</label>
        <div class="layui-input-block">
            <input type="text" name="title" required  lay-verify="required" placeholder="请输入标题" autocomplete="off" class="layui-input" style="width:500px;">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">发布时间</label>
        <div class="layui-input-block">
            <input type="text" class="layui-input" id="theTime" name="theTime" required  lay-verify="required" placeholder="yyyy-MM-dd" style="width:120px;">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">公告地址</label>
        <div class="layui-input-block">
            <input type="text" name="url" required  lay-verify="required|url" placeholder="请输入地址" autocomplete="off" class="layui-input" style="width:500px;">
        </div>
    </div>

    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
        </div>
    </div>
</form>
</div>
<script>
    //Demo
    layui.use('form', function(){
        var form = layui.form;

        //监听提交
        form.on('submit(formDemo)', function(data){
            $.post("<%=basePath%>notice/addNotice",data.field,function(data){
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

    layui.use('laydate', function(){
        var laydate = layui.laydate;

        //执行一个laydate实例
        laydate.render({
            elem: '#theTime' //指定元素
        });
    });
</script>
</body>
</html>
