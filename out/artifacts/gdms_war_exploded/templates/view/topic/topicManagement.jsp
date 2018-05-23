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
    <title>学生申请课题管理</title>
    <link rel="stylesheet" href="<%=basePath%>templates/style/plugins/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="<%=basePath%>templates/style/build/css/doc.css" media="all">
    <link rel="stylesheet" href="<%=basePath%>templates/style/src/css/iconfont.css" type="text/css">
    <script src="<%=basePath%>templates/style/plugins/layui/layui.js"></script>
    <script src="<%=basePath%>templates/style/plugins/layui/jquery-3.3.1.min.js"></script>
    <script src="<%=basePath%>templates/admin/js/getGroup.js"></script>
</head>
<body>
<div class="kit-doc">
    <!--这里写页面的代码-->
    <blockquote class="layui-elem-quote">这是关于学生申请课题管理的页面</blockquote>
    <div class="kit-doc-title">
        <fieldset>
            <legend><a name="blockquote">申请的课题信息</a></legend>
        </fieldset>
    </div>
    <div>
    </div>
    <table class="layui-hide" id="test" lay-filter="demo">
    </table>
    <script type="text/html" id="barDemo">
        <button class="layui-btn layui-btn-sm layui-btn-normal" lay-event="download"><i class="iconfont">&#xe604;</i>下载</button>
        <button class="layui-btn layui-btn-sm" lay-event="approval">批准</button>
        <button class="layui-btn layui-btn-sm layui-btn-danger" lay-event="unapproval">不批准</button>
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
            , url: '<%=basePath%>topic/TopicManagementGetAllJson'
            , method: 'post'
            , cols: [[
                {type: 'numbers', title: '序号', fixed:'left'},
                {field: 'id', align: 'center', width:60, title: '编号'}
                ,{field:'sid', title: '学号',width:150, sort:true}
                ,{field:'name',title: '姓名',width:80}
                ,{field:'topicName', title: '课题名称',width:250}
                ,{field:'type', title: '类型',width:80,sort:true}
                ,{field:'passSituation', title: '课题通过情况',width:150,sort:true}
                // ,{field:'attachmentName', title: '附件',width:350,align: 'center',templet: '#link',fixed: 'right'}
                ,{field:'attachmentName', title: '附件',width:200}
                ,{field: 'right', align: 'center', width:230, toolbar: '#barDemo', title: '操作', fixed: 'right'}
            ]]
            ,even: true
            , page: true
        });

        //监听工具条
        table.on('tool(demo)', function (obj) {
            var data = obj.data;
            if (obj.event === 'download') {
                $.ajax({
                    url: '<%=basePath%>topic/selectFileUrl',
                    type: 'post',
                    // async: true,
                    dataType: 'json',
                    contentType: "application/json",
                    data:JSON.stringify({
                        "sign":"发送要下载的文件数据",
                        "inmap":{
                            'id':data.id
                        },
                        "inlist":null
                    }),
                    success: function (res) {
                        console.log("fileUrl:"+res.data.fileUrl);
                        <%--$.post("<%=basePath%>apiCommon/download", {"fileName":data.attachmentName,"fileUrl":res.data.fileUrl});--%>
                        window.location.href = "<%=basePath%>apiCommon/download?fileName="+data.attachmentName+"&fileUrl="+res.data.fileUrl;
                    },
                    // beforeSend: function () {
                    //     // 一般是禁用按钮等防止用户重复提交
                    //     $(data.elem).attr("disabled", "true").text("提交中...");
                    // },
                    error: function () {
                        layer.alert("请求错误", {offset: 'auto',icon: 5});
                    }
                });

            }else if(obj.event === 'approval'){
                $.post("<%=basePath%>topic/approval", {"id": data.id}, function (data) {
                    if (data.code == "200") {
                        layer.msg(data.msg, {icon: 1, time: 1000});
                        // 前端修改
                        // layer.close(index);
                        location.reload();
                    } else {
                        layer.msg(data.msg, {icon: 0, time: 1000});
                        // layer.close(index);
                        location.reload();
                    }
                });
            }else if(obj.event === 'unapproval'){
                $.post("<%=basePath%>topic/unapproval", {"id": data.id}, function (data) {
                    if (data.code == "200") {
                        layer.msg(data.msg, {icon: 1, time: 1000});
                        // layer.close(index);
                        location.reload();
                    } else {
                        layer.msg(data.msg, {icon: 0, time: 1000});
                        // layer.close(index);
                        location.reload();
                    }
                });
            }
        });
    });
</script>

</body>
</html>
