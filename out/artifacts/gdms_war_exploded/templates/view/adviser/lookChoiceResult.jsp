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
    <title>查看选择结果</title>
    <link rel="stylesheet" href="<%=basePath%>templates/style/plugins/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="<%=basePath%>templates/style/build/css/doc.css" media="all">
    <script src="<%=basePath%>templates/style/plugins/layui/layui.js"></script>
    <script src="<%=basePath%>templates/style/plugins/layui/jquery-3.3.1.min.js"></script>
    <script src="<%=basePath%>templates/admin/js/getGroup.js"></script>
</head>
<body>
<div class="kit-doc">
    <!--这里写页面的代码-->
    <blockquote class="layui-elem-quote">这是关于查看指导老师选择结果页面</blockquote>
    <div class="kit-doc-title">
        <fieldset>
            <legend><a name="blockquote">选择结果</a></legend>
        </fieldset>
    </div>
    <div>
    </div>

    <form class="layui-form" action="">
        <div class="layui-form-item">
            <label class="layui-form-label" style="width:120px">指导老师工号:</label>
            <div class="layui-input-inline">
                <input name="tid" value="${teacher1.tid}" lay-verify="required" autocomplete="off" class="layui-input layui-disabled" type="text" disabled style="width: 200px">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label"style="width:120px">姓名:</label>
            <div class="layui-input-inline">
                <input name="tname" value="${teacher1.tname}" lay-verify="required" autocomplete="off" class="layui-input layui-disabled" type="text" disabled style="width: 200px">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label"style="width:120px">联系方式:</label>
            <div class="layui-input-inline">
                <input name="phone" value="${teacherContact.phone}" lay-verify="required" autocomplete="off" class="layui-input layui-disabled" type="text" disabled style="width: 200px">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label"style="width:120px">邮箱:</label>
            <div class="layui-input-inline">
                <input name="email" value="${teacherContact.email}" lay-verify="required" autocomplete="off" class="layui-input layui-disabled" type="text" disabled style="width: 200px">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label"style="width:120px">结果:</label>
            <div class="layui-input-inline">
                <c:choose>
                    <c:when test="${advise.pass==0}">
                        <input name="pass" value="你的申请还在再处理，请尽快联系导师" lay-verify="required" autocomplete="off" class="layui-input layui-disabled" type="text" disabled style="width: 250px">
                    </c:when>
                    <c:when test="${advise.pass==1}">
                        <input name="pass" value="你的申请已通过" lay-verify="required" autocomplete="off" class="layui-input layui-disabled" type="text" disabled style="width: 250px;color: #009688;">
                    </c:when>
                    <c:when test="${advise.pass==2}">
                        <input name="pass" value="你的申请已被拒绝,请重新选择导师" lay-verify="required" autocomplete="off" class="layui-input layui-disabled" type="text" disabled style="width: 250px;color: #ff5722;">
                    </c:when>
                    <c:otherwise>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-block">
            <c:choose>
                <c:when test="${advise.pass==0}">
                    <button class="layui-btn layui-btn-sm layui-btn-danger" lay-submit lay-filter="add"><i class="layui-icon">&#xe640;退选</i></button>
                </c:when>
            <c:otherwise>
                <button class="layui-btn layui-btn-sm layui-btn-disabled"><i class="layui-icon">&#xe640;退选</i></button>
            </c:otherwise>
            </c:choose>
            </div>
        </div>
    </form>
</div>
<script>
    layui.use(['element','form'], function(){
        $ = layui.jquery;
        var form = layui.form
        //监听提交，发送请求
        form.on('submit(add)', function(data){
            $.post("<%=basePath%>advise/retreat",data.field,function(data){
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
