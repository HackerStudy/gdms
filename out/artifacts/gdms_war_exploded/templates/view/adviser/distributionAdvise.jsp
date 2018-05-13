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
    <title>为学生分配指导老师</title>
    <link rel="stylesheet" href="<%=basePath%>templates/style/plugins/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="<%=basePath%>templates/style/build/css/doc.css" media="all">
    <script src="<%=basePath%>templates/style/plugins/layui/layui.js"></script>
    <script src="<%=basePath%>templates/style/plugins/layui/jquery-3.3.1.min.js"></script>
    <script src="<%=basePath%>templates/admin/js/getGroup.js"></script>
</head>
<body>
<div class="kit-doc">
    <!--这里写页面的代码-->
    <blockquote class="layui-elem-quote">这是关于指导老师的页面</blockquote>
    <div class="kit-doc-title">
        <fieldset>
            <legend><a name="blockquote">指导老师信息</a></legend>
        </fieldset>
    </div>
    <div>
    </div>
    <table class="layui-hide" id="test" lay-filter="demo">
    </table>
    <script type="text/html" id="barDemo">
        <button class="layui-btn layui-btn-sm layui-btn-normal" lay-event="add"><i class="layui-icon">&#xe608;</i> 分配</button>
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
            <%--, url: '<%=basePath%>advise/CarryStudentGetAllJson'--%>
            // , method: 'post'
            , cols: [[
                {type: 'numbers', title: '序号', fixed:'left'},
                {field:'id',align:'center', width:80, title: '编号'}
                ,{field:'tid', title: '工号',width:150, sort:true}
                ,{field:'tname', title: '姓名',width:80}
                ,{field:'sex', title: '性别',width:80,sort:true}
                ,{field:'workTime', title: '参加工作时间',width:120,sort:true}
                ,{field:'hdegree', title: '最高学历',width:100}
                ,{field:'teachingDirection', title: '教学方向',width:120,sort:true}
                ,{field:'position', title: '职称',width:120}
                ,{field:'did', title: '所属院部',width:150}
                ,{field:'mid', title: '所属专业',width:120}
                ,{field:'phone', title: '联系电话',width:120}
                ,{field:'email', title: '邮箱',width:180}
                ,{field:'haveNumber', title: '已带人数',width:100}
                ,{field:'limitNumber', title: '限制人数',width:100}
                ,{field:'right',align:'center', width:100, toolbar: '#barDemo', title: '操作',fixed: 'right'}
            ]]
            ,data: [{
                "id": "1"
                ,"tid":"20140304625"
                ,"tname": "白展堂"
                ,"workTime": "1年"
                ,"hdegree": "硕士"
                ,"teachingDirection": "java"
                ,"position": "中级程序员"
                ,"did": "计算机工程与应用数学学院"
                ,"mid": "软件工程"
                ,"phone": "15673331257"
                ,"email": "1791133899@qq.com"
                ,"haveNumber": "2"
                ,"limitNumber": "10"
            },
                {
                    "id": "2"
                    ,"tid":"20140304626"
                    ,"tname": "王晓燕"
                    ,"workTime": "3年"
                    ,"hdegree": "博士"
                    ,"teachingDirection": "C语言"
                    ,"position": "高级程序员"
                    ,"did": "计算机工程与应用数学学院"
                    ,"mid": "软件工程"
                    ,"phone": "15673331257"
                    ,"email": "1791133899@qq.com"
                    ,"haveNumber": "3"
                    ,"limitNumber": "10"
                }
            ]
            ,even: true
            , page: true
        });

        //监听工具条
        table.on('tool(demo)', function(obj){
            var data = obj.data;
            if(obj.event === 'add'){
                // 编辑
                var index = layer.open({
                    type: 2,
                    content: '<%=basePath%>advise/goDistribution?id='+data.id,
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
