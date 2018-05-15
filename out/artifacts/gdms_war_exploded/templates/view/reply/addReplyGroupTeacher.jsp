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
    <title>添加答辩组内的老师信息</title>
    <link rel="stylesheet" href="<%=basePath%>templates/style/plugins/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="<%=basePath%>templates/style/build/css/doc.css" media="all">
    <script src="<%=basePath%>templates/style/plugins/layui/layui.js"></script>
    <script src="<%=basePath%>templates/style/plugins/layui/jquery-3.3.1.min.js"></script>
    <script src="<%=basePath%>templates/admin/js/getGroup.js"></script>
</head>
<body>
<div class="kit-doc">
    <!--这里写页面的代码-->
    <blockquote class="layui-elem-quote">这是关于添加答辩组内老师的页面</blockquote>
    <div class="kit-doc-title">
        <fieldset>
            <legend><a name="blockquote">添加答辩组内的老师</a></legend>
        </fieldset>
    </div>
    <div>
        <div class="layui-btn-group demoTable">
            <button class="layui-btn layui-btn-danger" id="addAll" data-type="getCheckData">批量添加</button>
        </div>
    </div>
    <table class="layui-hide" id="test" lay-filter="demo">
    </table>
    <script type="text/html" id="barDemo">
        <button class="layui-btn layui-btn-sm layui-btn-normal" lay-event="add"><i class="layui-icon">&#xe608;</i>添加</button>
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
            , url: '<%=basePath%>reply/replyGroupTeacherGetAllJson'
            , method: 'post'
            , cols: [[
                {type:'checkbox',fixed: 'left'},
                {type: 'numbers', title: '序号', fixed:'left'},
                {field:'id',align:'center', width:80, title: '编号'}
                ,{field:'tid', title: '工号',width:150, sort:true}
                ,{field:'tname', title: '姓名',width:120}
                ,{field:'sex', title: '性别',width:80,sort:true}
                ,{field:'workTime', title: '参加工作时间',width:120,sort:true}
                ,{field:'hdegree', title: '最高学历',width:100}
                ,{field:'teachingDirection', title: '教学方向',width:120}
                ,{field:'position', title: '职称',width:120}
                ,{field:'department', title: '所属院部',width:250}
                ,{field:'major', title: '所属专业',width:120}
                ,{field:'phone', title: '联系电话',width:120}
                ,{field:'email', title: '邮箱',width:180}
                ,{field:'right',align:'center', width:100, toolbar: '#barDemo', title: '操作',fixed: 'right'}
            ]]
            ,even: true
            // , page: true
        });

        //监听工具条
        table.on('tool(demo)', function(obj){
            var data = obj.data;
            if(obj.event === 'add'){
                $.post("<%=basePath%>reply/addReplyGroupTeacher", {"id": data.id,"tid":data.tid}, function (data) {
                    if (data.code == "200") {
                        layer.msg(data.msg, {offset: 'auto'});
                        location.reload();
                    } else {
                        layer.msg(data.msg, {offset: 'auto'});
                    }
                });
            }
        });

        //批量分配
        $('#addAll').on('click', function(){
            var checkStatus = table.checkStatus('test')
                ,data = checkStatus.data;
            $.ajax({
                url: '<%=basePath%>reply/addAllReplyGroupTeacher',
                type: 'post',
                // async: true,
                dataType: 'json',
                contentType: "application/json",
                data:JSON.stringify(data),
                success: function (data) {
                    if(data.code!=200){
                        layer.alert(data.msg, {offset: 'auto',icon: 5});
                        location.reload();
                    }else if(data.code==200){
                        layer.alert(data.msg, {offset: 'auto',icon: 6});
                        location.reload();
                    }
                },
                // beforeSend: function () {
                //     // 一般是禁用按钮等防止用户重复提交
                //     $(data.elem).attr("disabled", "true").text("提交中...");
                // },
                error: function () {
                    layer.alert("请求错误", {offset: 'auto',icon: 5});
                }
            });
        });
    });
</script>

</body>
</html>
