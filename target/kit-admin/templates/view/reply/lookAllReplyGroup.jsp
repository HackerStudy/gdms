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
    <title>查看全部的答辩组</title>
    <link rel="stylesheet" href="<%=basePath%>templates/style/plugins/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="<%=basePath%>templates/style/build/css/doc.css" media="all">
    <script src="<%=basePath%>templates/style/plugins/layui/layui.js"></script>
    <script src="<%=basePath%>templates/style/plugins/layui/jquery-3.3.1.min.js"></script>
    <script src="<%=basePath%>templates/admin/js/getGroup.js"></script>
</head>
<body>
<div class="kit-doc">
    <!--这里写页面的代码-->
    <blockquote class="layui-elem-quote">这是全部答辩组的信息</blockquote>
    <div class="kit-doc-title">
        <fieldset>
            <legend><a name="blockquote">答辩组信息</a></legend>
        </fieldset>
    </div>
    <div>
    </div>
    <table class="layui-hide" id="test" lay-filter="demo">
    </table>
    <script type="text/html" id="barDemo">
        <button class="layui-btn layui-btn-sm layui-btn-normal" lay-event="teacher">查看组内老师信息</button>
        <button class="layui-btn layui-btn-sm layui-btn-danger" lay-event="student">查看组内学生信息</button>
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
            , url: '<%=basePath%>reply/allReplyGroupGetAllJson'
            , method: 'post'
            , cols: [[
                {type: 'numbers', title: '序号', fixed:'left'},
                {field: 'id', align: 'center', width:60, title: '编号'}
                ,{field:'groupName', title: '组名',width:100, sort:true}
                ,{field:'groupLeaderTid',title: '组长工号',width:150}
                ,{field:'groupLeaderName', title: '组长姓名',width:120}
                ,{field:'groupTeacherNumber', title: '组内老师数量',width:150,sort:true}
                ,{field:'groupStudentNumber', title: '组内学生数量',width:150,sort:true}
                ,{field: 'right', align: 'center', width:300, toolbar: '#barDemo', title: '操作', fixed: 'right'}
            ]]
            ,even: true
            , page: true
        });

        //监听工具条
        table.on('tool(demo)', function(obj){
            var data = obj.data;
            if(obj.event === 'teacher'){
                var index = layer.open({
                    type: 2,
                    content: '<%=basePath%>reply/goAReplyGroupTeacher?id='+data.id,
                    area: ['800px', '450px'],
                    maxmin: true,
                    end: function () {
                        location.reload();
                    }
                });
                layer.full(index);
            } else if(obj.event === 'student'){
                var index = layer.open({
                    type: 2,
                    content: '<%=basePath%>reply/goAReplyGroupStudent?id='+data.id,
                    area: ['800px', '450px'],
                    maxmin: true,
                    end: function () {
                        location.reload();
                    }
                });
                layer.full(index);
            }
        });
    });
</script>

</body>
</html>
