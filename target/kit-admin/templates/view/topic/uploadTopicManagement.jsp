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
    <title>上传课题管理</title>
    <link rel="stylesheet" href="<%=basePath%>templates/style/plugins/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="<%=basePath%>templates/style/build/css/doc.css" media="all">
    <script src="<%=basePath%>templates/style/plugins/layui/layui.js"></script>
    <script src="<%=basePath%>templates/style/plugins/layui/jquery-3.3.1.min.js"></script>
    <script src="<%=basePath%>templates/admin/js/getGroup.js"></script>
</head>
<body>
<div class="kit-doc">
    <!--这里写页面的代码-->
    <blockquote class="layui-elem-quote">这是指导老师上传课题管理的页面</blockquote>
    <div class="kit-doc-title">
        <fieldset>
            <legend><a name="blockquote">上传课题管理</a></legend>
        </fieldset>
    </div>
    <table class="layui-hide" id="test" lay-filter="demo">
    </table>
    <script type="text/html" id="barDemo">
        <button class="layui-btn layui-btn-sm layui-btn-danger" lay-event="del"><i class="layui-icon">&#xe640;</i> 删除</button>
    </script>
</div>

<script>

    layui.config({
        base: '<%=basePath%>templates/style/build/js/'
    })

    // 渲染数据
    layui.use('table', function(){
        var table = layui.table;

        table.render({
            elem: '#test'
            ,url:'<%=basePath%>topic/UploadTopicGetAllJson'
            ,method: 'post'
            ,cols: [[
                {type: 'numbers', title: '序号', fixed:'left'},
                {field: 'id', align: 'center', width:60, title: '编号'}
                ,{field:'topicName', title: '课题名'}
                ,{field:'right',align:'center', width:100, toolbar: '#barDemo', title: '操作',fixed: 'right'}
            ]]
            ,even: true
            ,page:true
        });

        //监听工具条
        table.on('tool(demo)', function(obj){
            var data = obj.data;
            if(obj.event === 'del'){
                layer.confirm('真的要删除么？', function(index){
                    // 写删除方法
                    $.post("<%=basePath%>topic/delUploadTopic", {"id": data.id}, function (data) {
                        if (data.code == "200") {
                            layer.msg(data.msg, {icon: 1, time: 1000});
                            // 前端修改
                            layer.close(index);
                            window.location.reload();
                        } else {
                            layer.msg(data.msg, {icon: 0, time: 1000});
                            layer.close(index);
                        }
                    });
                });
            }
        });
    });

</script>

</body>
</html>
