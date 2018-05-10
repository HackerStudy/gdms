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
    <title>查看申请学生</title>
    <link rel="stylesheet" href="<%=basePath%>templates/style/plugins/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="<%=basePath%>templates/style/build/css/doc.css" media="all">
    <script src="<%=basePath%>templates/style/plugins/layui/layui.js"></script>
    <script src="<%=basePath%>templates/style/plugins/layui/jquery-3.3.1.min.js"></script>
    <script src="<%=basePath%>templates/admin/js/getGroup.js"></script>
</head>
<body>
<div class="kit-doc">
    <!--这里写页面的代码-->
    <blockquote class="layui-elem-quote">这是查看申请学生的页面</blockquote>
    <div class="kit-doc-title">
        <fieldset>
            <legend><a name="blockquote">学生申请信息</a></legend>
        </fieldset>
    </div>
    <div>
    </div>
    <table class="layui-hide" id="test" lay-filter="demo">
    </table>
    <script type="text/html" id="barDemo">
        <button class="layui-btn layui-btn-sm layui-btn-normal" lay-event="approval"><i class="layui-icon">&#xe642;</i>批准</button>
        <button class="layui-btn layui-btn-sm layui-btn-danger" lay-event="unapproval"><i class="layui-icon">&#xe609;</i>不批准</button>
    </script>
</div>

<script>

    layui.config({
        base: '<%=basePath%>templates/style/build/js/'
    })

    // 渲染数据
    layui.use('table', function() {
        var table = layui.table;
        table.render({
            elem: '#test'
            , url: '<%=basePath%>advise/applyStudentGetAllJson'
            , method: 'post'
            , cols: [[
                {type: 'numbers', title: '序号', fixed:'left'},
                {field: 'id', align: 'center', width:60, title: '编号'}
                ,{field:'sid', title: '学号',width:150, sort:true}
                ,{field:'name',title: '姓名',width:80}
                ,{field:'sex', title: '性别',width:80,sort:true}
                ,{field:'did', title: '院部',width:150}
                ,{field:'mid', title: '专业',width:120}
                ,{field:'grade', title: '年级',width:80}
                ,{field:'sclass', title: '班级',width:120,sort:true}
                ,{field:'phone', title: '联系电话',width:150}
                ,{field:'email', title: '邮箱',width:190}
                , {field: 'right', align: 'center', width:200, toolbar: '#barDemo', title: '操作', fixed: 'right'}
            ]]
            , page: true
        });
        //监听工具条
        table.on('tool(demo)', function (obj) {
            var data = obj.data;
            if (obj.event === 'approval') {
                $.post("<%=basePath%>advise/correctApply", {"id": data.id,"sid":data.sid,"code":"200"}, function (data) {
                    if (data.code == "200"){
                        layer.msg(data.msg, {icon: 6, offset: 'auto'});
                    } else {
                        layer.msg(data.msg, {icon: 5, offset: 'auto'});
                    }
                });
            }else if(obj.event=='unapproval'){
                $.post("<%=basePath%>advise/correctApply", {"id": data.id,"sid":data.sid,"code":"101"}, function (data) {
                    if (data.code == "200"){
                        layer.msg(data.msg, {icon: 6, offset: 'auto'});
                    } else {
                        layer.msg(data.msg, {icon: 5, offset: 'auto'});
                    }
                });
            }
        });
    });
</script>

</body>
</html>
