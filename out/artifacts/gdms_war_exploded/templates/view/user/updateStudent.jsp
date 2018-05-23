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
        <input name="id" value=${student.id} type="hidden" />
        <div class="layui-form-item">
            <label class="layui-form-label">学号</label>
            <div class="layui-input-block">
                <input name="sid" value=${student.sid} lay-verify="required" placeholder="请输入学生的学号" autocomplete="off" class="layui-input" type="text">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">姓名</label>
            <div class="layui-input-block">
                <input name="name" value=${student.name} lay-verify="required" placeholder="请输入学生的姓名" autocomplete="off" class="layui-input" type="text">
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
                    <option value="">请输入学生的性别</option>
                    <c:choose>
                        <c:when test="${student.sex==1}">
                            <option value="1" selected >男</option>
                            <option value="2">女</option>
                        </c:when>
                        <c:otherwise>
                            <option value="1">男</option>
                            <option value="2" selected>女</option>
                        </c:otherwise>
                    </c:choose>
                </select>
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">院部</label>
            <div class="layui-input-block">
                <select id="did" name="did" lay-verify="required" lay-filter="didData">
                    <option value="">所属院部</option>
                    <c:forEach items="${departmentList}" var="dlist">
                        <c:choose>
                            <c:when test="${dlist.did==student.did}">
                                <option value="${dlist.did}" selected>${dlist.departmentName}</option>
                            </c:when>
                            <c:otherwise>
                                <option value="${dlist.did}">${dlist.departmentName}</option>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </select>
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">专业</label>
            <div class="layui-input-block">
                <select id="mid" name="mid" lay-filter="midData">
                    <option value="">所属专业</option>
                    <c:forEach items="${departmentList}" var="dlist">
                        <optgroup label="${dlist.departmentName}">
                            <c:forEach items="${majorList}" var="mlist">
                                <c:if test="${mlist.did==dlist.did}">
                                    <c:choose>
                                        <c:when test="${mlist.mid==student.mid}">
                                            <option value="${mlist.mid}" selected>${mlist.majorName}</option>
                                        </c:when>
                                        <c:otherwise>
                                            <option value="${mlist.mid}">${mlist.majorName}</option>
                                        </c:otherwise>
                                    </c:choose>
                                </c:if>
                            </c:forEach>
                        </optgroup>
                    </c:forEach>
                </select>
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">年级</label>
            <div class="layui-input-block">
                <input name="grade" value=${student.grade} lay-verify="required" placeholder="请输入学生的年级" autocomplete="off" class="layui-input" type="text">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">班级</label>
            <div class="layui-input-block">
                <input name="sclass" value=${student.sclass} lay-verify="required" placeholder="请输入学生的班级" autocomplete="off" class="layui-input" type="text">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">联系电话</label>
            <div class="layui-input-block">
                <input name="phone" value=${student.phone} lay-verify="required" placeholder="请输入学生的联系电话" autocomplete="off" class="layui-input" type="text">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">邮箱</label>
            <div class="layui-input-block">
                <input name="email" value=${student.email} lay-verify="required" placeholder="请输入学生的邮箱" autocomplete="off" class="layui-input" type="text">
            </div>
        </div>

        <div class="layui-form-item">
            <button class="layui-btn" lay-submit="" lay-filter="add">提交</button>
        </div>
    </form>

    <!--这里写页面的代码-->
</div>

<script>
    layui.use(['form', 'layedit', 'laydate', 'element', 'layer', 'upload'], function(){
        var form = layui.form,
            layer = layui.layer,
            element = layui.element,
            upload = layui.upload;

        //监听提交，发送请求
        form.on('submit(add)', function(data){
            $.post("<%=basePath%>user/updateStudent",data.field,function(data){
                // 获取 session
                if(data.code!=200){
                    layer.alert(data.msg, {offset: 't',icon: 5});
                }
                if(data.code==200){
                    layer.alert(data.msg, {offset: 't',icon: 6});
                }
            });
            return false;
        });

    });
</script>
</body>
</html>
