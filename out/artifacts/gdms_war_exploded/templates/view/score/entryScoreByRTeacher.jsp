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
    <title>成绩录入（答辩成绩）</title>
    <link rel="stylesheet" href="<%=basePath%>templates/style/plugins/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="<%=basePath%>templates/style/build/css/doc.css" media="all">
    <script src="<%=basePath%>templates/style/plugins/layui/layui.js"></script>
    <script src="<%=basePath%>templates/style/plugins/layui/jquery-3.3.1.min.js"></script>
    <script src="<%=basePath%>templates/admin/js/getGroup.js"></script>
</head>
<body>
<div class="kit-doc">
    <!--这里写页面的代码-->
    <blockquote class="layui-elem-quote">这是关于答辩成绩最终录入的页面</blockquote>
    <div class="kit-doc-title">
        <fieldset>
            <legend><a name="blockquote">答辩成绩录入页面</a></legend>
        </fieldset>
    </div>
    <div>
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
            , url: '<%=basePath%>score/groupStudentScoreGetAllJson'
            , method: 'post'
            , cols: [[
                {type: 'numbers', title: '序号', fixed:'left'},
                {field:'id',align:'center', width:80,  title: '编号'}
                ,{field:'sid', title: '学号',sort:true}
                ,{field:'name', title: '姓名',width:80}
                , {field: 'openTopicScore', title: '开题答辩成绩', width: 150}
                , {field: 'midScore', title: '中期答辩成绩', width: 150}
                , {field: 'graduateScore', title: '毕业答辩成绩', width: 150}
                ,{field:'right',align:'center', width:100, toolbar: '#barDemo', title: '操作',fixed: 'right'}
            ]]
            ,even: true
            , page: true
        });
        //监听工具条
        table.on('tool(demo)', function(obj){
            var data = obj.data;
            if(obj.event === 'entry'){
                $.post("<%=basePath%>score/addReplyScore", {"id": data.id,"sid":data.sid,"openTopicScore":data.openTopicScore,"midScore":data.midScore,"graduateScore":data.graduateScore}, function (data) {
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
