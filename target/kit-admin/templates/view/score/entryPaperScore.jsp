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
    <title>成绩录入（论文）</title>
    <link rel="stylesheet" href="<%=basePath%>templates/style/plugins/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="<%=basePath%>templates/style/build/css/doc.css" media="all">
    <script src="<%=basePath%>templates/style/plugins/layui/layui.js"></script>
    <script src="<%=basePath%>templates/style/plugins/layui/jquery-3.3.1.min.js"></script>
    <script src="<%=basePath%>templates/admin/js/getGroup.js"></script>
</head>
<body>
<div class="kit-doc">
    <!--这里写页面的代码-->
    <blockquote class="layui-elem-quote">这是关于论文成绩录入的页面</blockquote>
    <div class="kit-doc-title">
        <fieldset>
            <legend><a name="blockquote">论文成绩录入</a></legend>
        </fieldset>
    </div>
    <div>
    </div>
    <table class="layui-hide" id="test" lay-filter="demo">
    </table>
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
            , url: '<%=basePath%>score/entryPaperScoreGetAllJson'
            , method: 'post'
            , cols: [[
                {type: 'numbers', title: '序号', fixed:'left'},
                {field:'id',align:'center', width:80,  title: '编号'}
                ,{field:'sid', title: '学号',sort:true}
                ,{field:'name', title: '姓名',width:80}
                ,{field:'paperScore', title: '论文成绩',width:120,event: 'setScore', style:'cursor: pointer;'}
            ]]
            ,even: true
            , page: true
        });

        //监听单元格事件
        table.on('tool(demo)', function(obj){
            var data = obj.data;
            if(obj.event === 'setScore'){
                layer.prompt({
                    formType: 2
                    ,title: '录入论文成绩'
                    ,value: data.paperScore
                }, function(value, index){
                    layer.close(index);

                    //这里一般是发送修改的Ajax请求
                    $.ajax({
                    url: '<%=basePath%>score/updatePaperScore',
                    type: 'post',
                    // async: true,
                    dataType: 'json',
                    contentType: "application/json",
                    data:JSON.stringify({
                    "sign":"发送搜索数据",
                    "inmap":{
                        'paperScore':value,
                        'sid':data.sid
                    },
                    "inlist":null
                    }),
                    success: function (data) {
                    },
                    error: function () {
                    layer.alert("请求错误", {offset: 'auto',icon: 5});
                    }
                    });
                    //同步更新表格和缓存对应的值
                    obj.update({
                        paperScore: value
                    });
                });
            }
        });
    });
</script>

</body>
</html>
