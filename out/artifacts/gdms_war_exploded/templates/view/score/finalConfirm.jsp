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
    <title>最终成绩确认</title>
    <link rel="stylesheet" href="<%=basePath%>templates/style/plugins/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="<%=basePath%>templates/style/build/css/doc.css" media="all">
    <script src="<%=basePath%>templates/style/plugins/layui/layui.js"></script>
    <script src="<%=basePath%>templates/style/plugins/layui/jquery-3.3.1.min.js"></script>
    <script src="<%=basePath%>templates/admin/js/getGroup.js"></script>
</head>
<body>
<div class="kit-doc">
    <!--这里写页面的代码-->
    <blockquote class="layui-elem-quote">这是关于最终成绩确认的页面</blockquote>
    <div class="kit-doc-title">
        <fieldset>
            <legend><a name="blockquote">最终成绩确认</a></legend>
        </fieldset>
    </div>
    <table class="layui-hide" id="test" lay-filter="demo">
    </table>
    <script type="text/html" id="barDemo">
        <button class="layui-btn layui-btn-sm layui-btn-normal" lay-event="entry"><i class="layui-icon">&#xe608;</i>录入</button>
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
            , url: '<%=basePath%>score/finalScoreGetAllJson'
            , method: 'post'
            , cols: [[
                {type: 'numbers', title: '序号', fixed:'left'},
                {field:'id',align:'center', width:80,  title: '编号'}
                ,{field:'sid', title: '学号',sort:true}
                ,{field:'name', title: '姓名',width:80}
                ,{field:'adviserScore', title: '导师成绩',width:120}
                ,{field:'replyScore', title: '答辩成绩',width:120}
                ,{field:'paperScore', title: '论文成绩',width:120}
                ,{field:'right',align:'center', width:100, toolbar: '#barDemo', title: '操作',fixed: 'right'}
            ]]
            ,even: true
            , page: true
        });
        //监听工具条
        table.on('tool(demo)', function(obj){
            var data = obj.data;
            if(obj.event === 'entry'){
                $.post("<%=basePath%>score/addStudentScore", {"id": data.id,"sid":data.sid,"adviserScore":data.adviserScore,"replyScore":data.replyScore,"paperScore":data.paperScore}, function (data) {
                    if (data.code == "200") {
                        layer.msg(data.msg, {offset: 'auto'});
                        location.reload();
                    } else {
                        layer.msg(data.msg, {offset: 'auto'});
                    }
                });
            }
        });
    });
</script>

</body>
</html>
