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
    <title>上传选题</title>
    <link rel="stylesheet" href="<%=basePath%>templates/style/plugins/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="<%=basePath%>templates/style/build/css/doc.css" media="all">
    <script src="<%=basePath%>templates/style/plugins/layui/layui.js"></script>
    <script src="<%=basePath%>templates/style/plugins/layui/jquery-3.3.1.min.js"></script>
    <script src="<%=basePath%>templates/admin/js/getGroup.js"></script>
</head>
<body>
<div class="kit-doc">
    <!--这里写页面的代码-->
    <blockquote class="layui-elem-quote">这是关于指导老师上传选题的页面</blockquote>
    <div class="kit-doc-title">
        <fieldset>
            <legend><a name="blockquote">上传选题</a></legend>
        </fieldset>
    </div>
    <div>
    </div>

    <form class="layui-form" action="">
        <div class="layui-form-item">
            <label class="layui-form-label" style="width:120px">课题名称:</label>
            <div class="layui-input-inline">
                <input name="topicName" lay-verify="required" placeholder="请输入课题名称" autocomplete="off" class="layui-input" type="text"  style="width: 300px">
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
        var form = layui.form,upload = layui.upload;

        //监听提交，发送请求
        form.on('submit(add)', function(data){
            $.post("<%=basePath%>topic/addUploadTopic",data.field,function(data){
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
