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
    <title>添加老师</title>
    <link rel="stylesheet" href="<%=basePath%>templates/style/plugins/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="<%=basePath%>templates/style/build/css/doc.css" media="all">
    <script src="<%=basePath%>templates/style/plugins/layui/layui.js"></script>
    <script src="<%=basePath%>templates/style/plugins/layui/jquery-3.3.1.min.js"></script>
</head>
<body>

<div class="kit-doc">
    <form class="layui-form layui-form-pane" action="">

        <div class="layui-form-item">
            <label class="layui-form-label">工号</label>
            <div class="layui-input-block">
                <input name="tid" lay-verify="required" autocomplete="off" class="layui-input" type="text">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">姓名</label>
            <div class="layui-input-block">
                <input name="tname" lay-verify="required"  autocomplete="off" class="layui-input" type="text">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">性别</label>
            <div class="layui-input-block">
                <select name="sex" lay-verify="required" lay-search="">
                    <option value="">请选择老师的性别</option>
                    <option value="1">男</option>
                    <option value="2">女</option>
                </select>
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">参加工作时间</label>
            <div class="layui-input-block">
                <input name="workTime" lay-verify="required"  autocomplete="off" class="layui-input" type="text">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">最高学历</label>
            <div class="layui-input-block">
                <input name="hdegree" lay-verify="required"  autocomplete="off" class="layui-input" type="text">
            </div>
        </div>

        <div class="layui-form-item">
        <label class="layui-form-label">教学方向</label>
        <div class="layui-input-block">
            <input name="teachingDirection" lay-verify="required"  autocomplete="off" class="layui-input" type="text">
        </div>
    </div>

        <div class="layui-form-item">
            <label class="layui-form-label">职称</label>
            <div class="layui-input-block">
                <input name="position" lay-verify="required"  autocomplete="off" class="layui-input" type="text">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">所属院部</label>
            <div class="layui-input-block">
                <select id="did" name="did" lay-verify="required" lay-filter="didData">
                    <option value="">所属院部</option>
                    <c:forEach items="${departmentList}" var="dlist">
                        <option value="${dlist.did}">${dlist.departmentName}</option>
                    </c:forEach>
                </select>
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">所属专业</label>
            <div class="layui-input-block">
                <select id="mid" name="mid" lay-filter="midData">
                    <option value="">所属专业</option>
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

        <div class="layui-form-item">
            <label class="layui-form-label">身份</label>
            <div class="layui-input-block">
                <select id="identityId" name="identityId" lay-verify="required" lay-filter="didData">
                    <option value="">身份</option>
                    <option value="3">指导老师</option>
                    <option value="4">答辩老师</option>
                    <option value="6">答辩组组长</option>
                </select>
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">联系电话</label>
            <div class="layui-input-block">
                <input name="phone" lay-verify="required"  autocomplete="off" class="layui-input" type="text">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">邮箱</label>
            <div class="layui-input-block">
                <input name="email" lay-verify="required"  autocomplete="off" class="layui-input" type="text">
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
            $.post("<%=basePath%>user/addTeacher",data.field,function(data){
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
