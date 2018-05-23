<%--
  Created by IntelliJ IDEA.
  User: benhailong
  Date: 2018/2/7
  Time: 下午3:48
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
    <title>添加学生</title>
    <link rel="stylesheet" href="<%=basePath%>templates/style/plugins/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="<%=basePath%>templates/style/build/css/doc.css" media="all">
    <script src="<%=basePath%>templates/style/plugins/layui/layui.js"></script>
    <script src="<%=basePath%>templates/style/plugins/layui/jquery-3.3.1.min.js"></script>
</head>
<body>

<div class="kit-doc">
    <form class="layui-form layui-form-pane" action="">

        <div class="layui-form-item">
            <label class="layui-form-label">学号</label>
            <div class="layui-input-block">
                <input name="sid" lay-verify="required" placeholder="请输入学生的学号" autocomplete="off" class="layui-input" type="text">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">姓名</label>
            <div class="layui-input-block">
                <input name="name" lay-verify="required" placeholder="请输入学生的姓名" autocomplete="off" class="layui-input" type="text">
            </div>
        </div>

        <%--<div class="layui-form-item">--%>
            <%--<label class="layui-form-label">密码</label>--%>
            <%--<div class="layui-input-block">--%>
                <%--<input name="kitAdminPassword" lay-verify="required" placeholder="请输入密码" autocomplete="off" class="layui-input" type="password">--%>
            <%--</div>--%>
        <%--</div>--%>

        <div class="layui-form-item">
            <label class="layui-form-label">性别</label>
            <div class="layui-input-block">
                <select name="sex" lay-verify="required" lay-search="">
                    <option value="">请选择学生的性别</option>
                    <option value="1">男</option>
                    <option value="2">女</option>
                </select>
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">院部</label>
            <div class="layui-input-block">
                <select id="did" name="did" lay-verify="required">
                    <option value="">院部</option>
                    <c:forEach items="${departmentList}" var="dlist">
                        <option value="${dlist.did}">${dlist.departmentName}</option>
                    </c:forEach>
                </select>
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">专业</label>
            <div class="layui-input-block">
                <select id="mid" name="mid" lay-verify="required">
                    <option value="">专业</option>
                    <c:forEach items="${departmentList}" var="dlist">
                        <optgroup label="${dlist.departmentName}">
                            <c:forEach items="${majorList}" var="mlist">
                                <c:if test="${mlist.did==dlist.did}">
                                    <option value="${mlist.mid}">${mlist.majorName}</option>
                                </c:if>
                            </c:forEach>
                        </optgroup>
                    </c:forEach>
                </select>
            </div>
        </div>

        <%--<div class="layui-form-item">--%>
            <%--<label class="layui-form-label">院部</label>--%>
            <%--<div class="layui-input-block">--%>
                <%--<input name="did" lay-verify="required" placeholder="请输入学生的院部" autocomplete="off" class="layui-input" type="text">--%>
            <%--</div>--%>
        <%--</div>--%>

        <%--<div class="layui-form-item">--%>
            <%--<label class="layui-form-label">专业</label>--%>
            <%--<div class="layui-input-block">--%>
                <%--<input name="mid" lay-verify="required" placeholder="请输入学生的专业" autocomplete="off" class="layui-input" type="text">--%>
            <%--</div>--%>
        <%--</div>--%>

        <div class="layui-form-item">
            <label class="layui-form-label">年级</label>
            <div class="layui-input-block">
                <input name="grade" lay-verify="required" placeholder="请输入学生的年级" autocomplete="off" class="layui-input" type="text">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">班级</label>
            <div class="layui-input-block">
                <input name="sclass" lay-verify="required" placeholder="请输入学生的班级" autocomplete="off" class="layui-input" type="text">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">联系电话</label>
            <div class="layui-input-block">
                <input name="phone" lay-verify="required|phone|number" placeholder="请输入学生的联系电话" autocomplete="off" class="layui-input" type="text">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">邮箱</label>
            <div class="layui-input-block">
                <input name="email" lay-verify="required|email" placeholder="请输入学生的邮箱" autocomplete="off" class="layui-input" type="text">
            </div>
        </div>

        <div class="layui-form-item">
            <button class="layui-btn" lay-submit="" lay-filter="add">提交</button>
        </div>
    </form>

    <!--这里写页面的代码-->
</div>

<script>
    layui.use(['form', 'layer'], function(){
        var form = layui.form,
            layer = layui.layer

        //监听提交，发送请求
        form.on('submit(add)', function(data){
            // if(data.field.kitAdminPassword!=data.field.kitAdminPasswordAgen){
            //     layer.alert('两次密码输入不一致');
            //     return false;
            // }
            $.post("<%=basePath%>user/addStudent",data.field,function(data){
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
