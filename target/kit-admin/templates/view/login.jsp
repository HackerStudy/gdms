<%--
  Created by IntelliJ IDEA.
  User: benhailong
  Date: 2018/2/5
  Time: 下午4:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh">
<head>
    <%--<base href="<%=basePath%>" rel="external nofollow" >--%>
    <meta charset="utf-8">
    <title>登录 - 长大本科毕业设计过程管理系统</title>
    <link rel="stylesheet" type="text/css" href="../../templates/style/bootstrap/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="../../templates/style/plugins/layui/css/register-login.css">
</head>
<body>
<div id="box"></div>
<div class="cent-box">
    <div class="cent-box-header">
        <h1 class="main-title" style="width: 300px">长大本科毕业设计过程</h1>
        <h2 class="sub-title"> 管理系统</h2>
    </div>
    <div class="cont-main clearfix">
        <form class="login form" action="<%=basePath%>login" method="post">
            <div class="group">
                <div class="group-ipt email">
                    <input type="text" name="username" id="email" class="ipt" placeholder="请输入您的账号" required>
                </div>
                <div class="group-ipt password">
                    <input type="password" name="password" id="password" class="ipt" placeholder="输入您的密码" required>
                </div>
            </div>
            <div class="firstselect" style="text-align: center;">
                <select name="identityid" class="selectpicker" style="width:130px; height: 34px; margin:12px auto;border-radius: 6px; outline:none; font-size:14px">
                    <option value='2' selected="selected">学生</option>
                    <option value='3'>指导老师</option>
                    <option value='4'>答辩老师</option>
                    <option value='6'>答辩组长</option>
                    <option value='5'>管理员</option>
                    <option value='1'>超级管理员</option>
                </select>
            </div>
            <div class="button">
                <button type="submit" class="login-btn register-btn button" id="embed-submit">登录</button>
            </div>
        </form>
    </div>
</div>

<div class="footer">
    <p>© 2018 <a href="http://www.ccsu.cn">www.ccsu.cn </a></p>
</div>
<script type="text/javascript" src="../../bootstrap/js/boostrap.js"></script>
<script type="text/javascript" src="../../bootstrap/js/jquery.min.js"></script>
<script type="text/javascript" src="../../templates/style/plugins/layui/layui.js" charset="utf-8"></script>
<script type="text/javascript" src="../../templates/style/plugins/layui/particles.js"></script>
<script type="text/javascript" src="../../templates/style/plugins/layui/background.js"></script>
<script type="text/javascript" src="../../templates/style/plugins/layui/gt.js"></script>
</body>
</html>