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
    <title>设置申请人数限制</title>
    <link rel="stylesheet" href="<%=basePath%>templates/style/plugins/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="<%=basePath%>templates/style/build/css/doc.css" media="all">
    <script src="<%=basePath%>templates/style/plugins/layui/layui.js"></script>
    <script src="<%=basePath%>templates/style/plugins/layui/jquery-3.3.1.min.js"></script>
    <script src="<%=basePath%>templates/admin/js/getGroup.js"></script>
</head>
<body>
<div class="kit-doc">
    <!--这里写页面的代码-->
    <blockquote class="layui-elem-quote">这是关于申请人数限制的页面</blockquote>
    <div class="kit-doc-title">
        <fieldset>
            <legend><a name="blockquote">申请人数限制</a></legend>
        </fieldset>
    </div>
    <div>
    </div>

    <form class="layui-form" action="">
        <div class="layui-form-item">
            <label class="layui-form-label" style="width:120px">指导老师工号:</label>
            <div class="layui-input-inline">
                <input name="tid" value="${teacher.tid}" lay-verify="required" autocomplete="off" class="layui-input layui-disabled" type="text" disabled style="width: 200px">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label"style="width:120px">姓名:</label>
            <div class="layui-input-inline">
                <input name="tname" value="${teacher.tname}" lay-verify="required" autocomplete="off" class="layui-input layui-disabled" type="text" disabled style="width: 200px">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label"style="width:120px">已带人数:</label>
            <div class="layui-input-inline">
                <input id="haveNumber" name="haveNumber" value="${adviseTeacher.haveNumber}" lay-verify="required" autocomplete="off" class="layui-input layui-disabled" type="text" disabled style="width: 200px">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label"style="width:120px">限制人数:</label>
            <div class="layui-input-inline" style="height: 40px;">
                <input id="limitNumber" name="limitNumber" value="${adviseTeacher.limitNumber}" lay-verify="required" autocomplete="off" class="layui-input" type="text"style="width: 200px" onblur="verifylimitNumber()"><div style="position: relative;left: 230px;top: -32px;"><span id="new"></span></div>
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-block">
                <button id="button" class="layui-btn layui-btn-sm layui-btn-danger" lay-submit lay-filter="add"><i class="layui-icon">&#xe609;提交</i></button>
            </div>
        </div>
    </form>
</div>
<script>

    function verifylimitNumber(){
        var lnumber=document.getElementById("limitNumber").value;
        var hnumber=document.getElementById("haveNumber").value;
        if(lnumber>=hnumber){
            document.getElementById("new").innerHTML="";
            document.getElementById("button").disabled = false;
        }else{
            document.getElementById("new").innerHTML="<font color='red'>限制人数必须大于已带人数</font>";
            document.getElementById("button").disabled = true;
        }
    }

    layui.use(['element','form'], function(){
        $ = layui.jquery;
        var form = layui.form
        //监听提交，发送请求
        form.on('submit(add)', function(data){
            $.post("<%=basePath%>advise/updateLimitNumber",data.field,function(data){
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
