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
    <title>查看课题通过情况</title>
    <link rel="stylesheet" href="<%=basePath%>templates/style/plugins/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="<%=basePath%>templates/style/build/css/doc.css" media="all">
    <script src="<%=basePath%>templates/style/plugins/layui/layui.js"></script>
    <script src="<%=basePath%>templates/style/plugins/layui/jquery-3.3.1.min.js"></script>
    <script src="<%=basePath%>templates/admin/js/getGroup.js"></script>
</head>
<body>
<div class="kit-doc">
    <!--这里写页面的代码-->
    <blockquote class="layui-elem-quote">这是关于学生查看课题通过情况的页面</blockquote>
    <div class="kit-doc-title">
        <fieldset>
            <legend><a name="blockquote">查看课题通过情况</a></legend>
        </fieldset>
    </div>
    <div>
    </div>

    <form class="layui-form" action="">
        <div class="layui-form-item">
            <label class="layui-form-label" style="width:120px">课题名称:</label>
            <div class="layui-input-inline">
                <input name="topicName" value="${topicApply.topicName}" lay-verify="required" autocomplete="off" class="layui-input layui-disabled" type="text"  style="width: 300px" disabled>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label"style="width:120px">附件:</label>
            <%--<a href="/apiCommon/download/?fileUrl=/uplodefiles/file/4090a9a26f2743dab05c32fa8f48fffb.xlsx">课题申请书</a>--%>
            <div style="padding-top: 8px;"><a href="<%=basePath%>apiCommon/download?fileName=${topicApply.attachmentName}&fileUrl=${topicApply.attachmentUrl}">${topicApply.attachmentName}</a></div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label"style="width:120px">课题通过情况:</label>
            <c:choose><c:when test="${topicApply.passSituation==0}">
                <div style="padding-top: 8px;"><span>正在审核中</span></div>
            </c:when><c:when test="${topicApply.passSituation==1}">
                <div style="padding-top: 8px;"><span>通过</span></div>
            </c:when><c:when test="${topicApply.passSituation==2}">
                <div style="padding-top: 8px;"><span>未通过</span></div>
            </c:when><c:otherwise>
                <div style="padding-top: 8px;"><span>你还未选课题，请尽快选择</span></div>
            </c:otherwise></c:choose>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-block">
                <c:choose><c:when test="${topicApply.passSituation==0||topicApply.passSituation==2}">
                    <button class="layui-btn layui-btn-sm layui-btn-danger" lay-submit lay-filter="add"><i class="layui-icon">&#xe640;取消申请</i></button>
                </c:when><c:when test="${topicApply.passSituation==1}">
                    <button class="layui-btn layui-disabled" disabled lay-submit lay-filter="add"><i class="layui-icon">&#xe640;取消申请</i></button>
                </c:when><c:otherwise>
                    <button class="layui-btn layui-disabled" disabled lay-submit lay-filter="add"><i class="layui-icon">&#xe640;取消申请</i></button>
                </c:otherwise></c:choose>
            </div>
        </div>
    </form>
</div>
<script>
    layui.use(['element','upload','form'], function(){
        var $ = layui.jquery;
        var form = layui.form
        //监听提交，发送请求
        form.on('submit(add)', function(data){
            $.post("<%=basePath%>topic/cancelApply",data.field,function(data){
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
