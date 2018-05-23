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
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>评审</title>
    <link rel="stylesheet" href="<%=basePath%>templates/style/plugins/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="<%=basePath%>templates/style/build/css/doc.css" media="all">
    <script src="<%=basePath%>templates/style/plugins/layui/layui.js"></script>
    <script src="<%=basePath%>templates/style/plugins/layui/jquery-3.3.1.min.js"></script>
    <script src="<%=basePath%>templates/admin/js/getGroup.js"></script>
</head>
<body>
<div class="kit-doc">
    <!--这里写页面的代码-->
    <blockquote class="layui-elem-quote">这是关于评审页面</blockquote>
    <div class="kit-doc-title">
        <fieldset>
            <legend><a name="blockquote">评审</a></legend>
        </fieldset>
    </div>
    <form class="layui-form" action="">
        <input name="sid" value="${sid}" type="hidden">
        <div class="layui-form-item">
            <label class="layui-form-label" style="width:120px">开题答辩成绩:</label>
            <div class="layui-input-inline">
                <input name="openTopicScore" lay-verify="required" autocomplete="off" class="layui-input" type="text"  style="width:120px">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label" style="width:120px">中期答辩成绩:</label>
            <div class="layui-input-inline">
                <input name="midScore" lay-verify="required" autocomplete="off" class="layui-input" type="text"  style="width:120px">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label" style="width:120px">毕业答辩成绩:</label>
            <div class="layui-input-inline">
                <input name="graduateScore" lay-verify="required" autocomplete="off" class="layui-input" type="text"  style="width:120px">
            </div>
        </div>
        <div class="layui-form-item">
            <button style="margin-left: 150px;" class="layui-btn" lay-submit="" lay-filter="add">提交</button>
        </div>
    </form>
</div>
<script>
    layui.use(['element','form'], function(){
        var $ = layui.jquery;
        var form = layui.form

        //监听提交，发送请求
        form.on('submit(add)', function(data){
            $.post("<%=basePath%>reply/addReview",data.field,function(data){
                // 获取 session
                if(data.code!=200){
                    layer.msg(data.msg,{offset: 'auto',icon: 5});
                }
                if(data.code==200){
                    layer.msg(data.msg,{offset: 'auto',icon: 6});
                }
            });
            return false;
        });
    });
</script>

</body>
</html>
