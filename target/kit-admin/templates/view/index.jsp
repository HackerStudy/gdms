<%--
  Created by IntelliJ IDEA.
  User: benhailong
  Date: 2018/2/5
  Time: 下午6:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<jsp:include page="common/header.jsp" flush="true"> <jsp:param name="name" value="value"/> </jsp:include>--%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>首页 - 长大本科毕业设计过程管理系统</title>
    <link rel="stylesheet" href="<%=basePath%>templates/style/plugins/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="<%=basePath%>templates/style/plugins/font-awesome/css/font-awesome.min.css" media="all">
    <link rel="stylesheet" href="<%=basePath%>templates/style/build/css/app.css" media="all">
    <link rel="stylesheet" href="<%=basePath%>templates/style/build/css/themes/green.css" media="all">
    <%--<script>--%>
        <%--// session 验证--%>
        <%--var Usersession="${user.username}"--%>
        <%--if(Usersession==null ||Usersession==""){--%>
            <%--window.location.href='<%=basePath%>'+"templates/view/login.jsp";--%>
        <%--}--%>
    <%--</script>--%>
</head>

<body class="kit-theme">
<div class="layui-layout layui-layout-admin kit-layout-admin">
    <div class="layui-header">
        <div class="layui-logo">长大本科毕设过程管理系统</div>
        <div class="layui-logo kit-logo-mobile">系统</div>
        <%--<ul class="layui-nav layui-layout-left kit-nav" kit-one-level>--%>
            <%--<li class="layui-nav-item"><a href="javascript:;">控制台</a></li>--%>
            <%--<li class="layui-nav-item"><a href="javascript:;">商品管理</a></li>--%>
        <%--</ul>--%>
        <ul class="layui-nav layui-layout-right kit-nav">
            <li class="layui-nav-item">
                    <c:choose><c:when test="${user.identity==1||user.identity==5}">
                                <a href="javascript:;">
                                    <img src="<%=basePath%>${admin.kitAdminImgUrl}" class="layui-nav-img"> ${admin.kitAdminName}
                                </a>
                                <dl class="layui-nav-child">
                                    <dd><a href="javascript:;" onclick="personalInfo('个人资料','/person/goPensonalInfo')">个人资料</a></dd>
                                    <dd><a href="javascript:;" onclick="modify_password('修改密码','/person/goModifyPassword')">修改密码</a></dd>
                                </dl></c:when><c:when test="${user.identity==2}">
                                <a href="javascript:;">
                                    <img src="<%=basePath%>${student.icon}" class="layui-nav-img"> ${student.name}
                                </a>
                                <dl class="layui-nav-child">
                                    <dd><a href="javascript:;" onclick="personalInfo('个人资料','/person/goPensonalInfo')">个人资料</a></dd>
                                    <dd><a href="javascript:;" onclick="modify_password('修改密码','/person/goModifyPassword')">修改密码</a></dd>
                                </dl></c:when><c:otherwise>
                                <a href="javascript:;">
                                    <img src="<%=basePath%>${teacher.icon}" class="layui-nav-img"> ${teacher.tname}
                                </a>
                                <dl class="layui-nav-child">
                                    <dd><a href="javascript:;" onclick="personalInfo('个人资料','/person/goPensonalInfo')">个人资料</a></dd>
                                    <dd><a href="javascript:;" onclick="modify_password('修改密码','/person/goModifyPassword')">修改密码</a></dd>
                                </dl></c:otherwise></c:choose>
            </li>
            <li class="layui-nav-item"><a href="<%=basePath%>uplogin"><i class="fa fa-sign-out" aria-hidden="true"></i> 注销</a></li>
        </ul>
    </div>

    <!-- 左侧的整个导航 -->
    <div class="layui-side layui-bg-black kit-side">
        <div class="layui-side-scroll">
            <div class="kit-side-fold"><i class="fa fa-navicon" aria-hidden="true"></i></div>
            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
            <ul class="layui-nav layui-nav-tree" lay-filter="kitNavbar" kit-navbar>

                <%--默认打开栏目 在外层的 li 标签添加  layui-nav-itemed--%>
                <c:forEach items="${limitList}" var="limitList1" >
                    <c:if test="${limitList1.limitLeaderid==0}">
                        <li class="layui-nav-item">
                            <a class="" href="javascript:;"><i class="layui-icon" aria-hidden="true">${limitList1.limitIco}</i><span> ${limitList1.limitTitle}</span></a>
                            <c:forEach items="${limitList}" var="limitList2">
                                <dl class="layui-nav-child">
                                    <c:if test="${limitList1.limitId==limitList2.limitLeaderid}">
                                        <dd>
                                            <a href="javascript:;" kit-target data-options="{url:'${limitList2.limitAction}',icon:'${limitList2.limitIco}',title:'${limitList2.limitTitle}',id:'${limitList2.limitId}'}">
                                            <i class="layui-icon">${limitList2.limitIco}</i><span> ${limitList2.limitTitle}</span></a>
                                        </dd>
                                    </c:if>
                                </dl>
                            </c:forEach>
                        </li>
                    </c:if>
                </c:forEach>
            </ul>
        </div>
    </div>
    <div class="layui-body" id="container">
        <!-- 内容主体区域 -->
        <div style="padding: 15px;">主体内容加载中,请稍等...</div>
    </div>

    <div class="layui-footer">
        <!-- 底部固定区域 -->
        2018 &copy;
        <a href="http://www.ccsu.cn/" target="_blank">长沙学院官网</a>

    </div>
</div>

<script src="<%=basePath%>templates/style/plugins/layui/layui.js"></script>
<script src="<%=basePath%>admin/js/getGroup.js"></script>
<script>
    var message;
    layui.config({
        base: '<%=basePath%>templates/style/build/js/'
    }).use(['app', 'message'], function() {
        var app = layui.app,
            $ = layui.jquery,
            layer = layui.layer;
        //将message设置为全局以便子页面调用
        message = layui.message;
        //主入口
        app.set({
            type: 'iframe'
        }).init();
        $('#pay').on('click', function() {
            layer.open({
                title: false,
                type: 1,
                content: '<img src="<%=basePath%>templates/style/build/images/pay.png" />',
                area: ['500px', '250px'],
                shadeClose: true
            });
        });
    });

    layui.use('layer', function() { //独立版的layer无需执行这一句
        var $ = layui.jquery, layer = layui.layer; //独立版的layer无需执行这一句
        //触发事件
        window.active = {
            aOpen: function (title,url) {
                var index = layer.open({
                    type: 2,
                    title:title,
                    content: url,
                    area: ['600px','450px'],
                    maxmin: true
                });
                layer.auto(index);
            }
        }
    });

    function personalInfo(title,url) {
        active.aOpen(title,url);
    }

    function modify_password(title,url) {
        active.aOpen(title,url);
    }

</script>
</body>

</html>