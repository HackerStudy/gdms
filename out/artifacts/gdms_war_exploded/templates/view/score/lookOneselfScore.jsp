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
    <title>查看毕设成绩</title>
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
        <div class="layui-card-header">毕设成绩</div>
        <div class="layui-card-body">
            <%--<input id="id" name="id" value=${studentInfoVo.id} type="hidden" />--%>
            <div class="layui-form-item">
                <label class="layui-form-label" style="width: 100px;">导师成绩:</label>
                <div class="layui-input-inline" style="padding: 7px 0px;">
                    <label>${studentScore.adviserScore}</label>
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label" style="width: 100px;">答辩成绩:</label>
                <div class="layui-input-inline" style="padding: 7px 0px;">
                    <label>${studentScore.replyScore}</label>
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label" style="width: 100px;">论文成绩:</label>
                <div class="layui-input-inline" style="padding: 7px 0px;">
                    <label>${studentScore.paperScore}</label>
                </div>
            </div>
                <div class="layui-form-item">
                    <label class="layui-form-label" style="width: 100px;">总成绩:</label>
                    <div class="layui-input-inline" style="padding: 7px 0px;">
                        <label>${studentScore.totalScore}</label>
                    </div>
                </div>
        </div>
    </div>
</div>
<script src="/webjars/layui/layui.js"></script>
</body>
</html>