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
    <title>老师信息管理</title>
    <link rel="stylesheet" href="<%=basePath%>templates/style/plugins/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="<%=basePath%>templates/style/build/css/doc.css" media="all">
    <script src="<%=basePath%>templates/style/plugins/layui/layui.js"></script>
    <script src="<%=basePath%>templates/style/plugins/layui/jquery-3.3.1.min.js"></script>
    <script src="<%=basePath%>templates/admin/js/getGroup.js"></script>
</head>
<body>
<div class="kit-doc">
    <!--这里写页面的代码-->
    <blockquote class="layui-elem-quote">这是关于老师的信息管理页面</blockquote>
    <div class="kit-doc-title">
        <fieldset>
            <legend><a name="blockquote">老师信息管理</a></legend>
        </fieldset>
    </div>
    <div>
        <div class="layui-btn-group demoTable">
            <button class="layui-btn" id="add">添加</button>
            <button class="layui-btn layui-btn-danger" id="deleteAll" data-type="getCheckData">批量删除</button>
        </div>

        <form class="layui-form" action="" style="display:inline-block">
            <div class="layui-form layui-form-pane" style="display:inline-block">
                <div class="layui-form-item">
                    <div id="didScreen" class="layui-input-block" style="margin-left: 30px">
                        <select id="did" name="did" lay-verify="required" lay-filter="didData">
                            <option value="">院部筛选</option>
                            <c:forEach items="${departmentList}" var="dlist">
                                <option value="${dlist.did}">${dlist.departmentName}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
            </div>

            <div class="layui-form layui-form-pane" style="display:inline-block">
                <div class="layui-form-item">
                    <div id="midScreen" class="layui-input-block" style="margin-left: 30px">
                        <select id="mid" name="mid" lay-filter="midData">
                            <option value="">专业筛选</option>
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
            </div>
        </form>
        <div class="layui-inline" style="float: right">
            <div class="layui-input-inline">
                <input id="search" name="selectbysid" lay-verify="required|phone" autocomplete="off" class="layui-input" type="tel">
            </div>
            <button class="layui-btn layui-btn-primary" onclick="search()">搜索</button>
        </div>
    </div>
    <table class="layui-hide" id="test" lay-filter="demo">
    </table>
    <script type="text/html" id="barDemo">
        <button class="layui-btn layui-btn-sm layui-btn-normal" lay-event="edit"><i class="layui-icon">&#xe642;</i> 编辑</button>
        <button class="layui-btn layui-btn-sm layui-btn-danger" lay-event="del"><i class="layui-icon">&#xe640;</i> 删除</button>
    </script>
</div>

<script>

    layui.config({
        base: '<%=basePath%>templates/style/build/js/'
    })

    // 添加
    layui.use(['jquery', 'layer', 'table'], function () {
        var table = layui.table;
        //让层自适应iframe
        $('#add').on('click', function(){
            var index = layer.open({
                type: 2,
                content: '<%=basePath%>user/goAddTeacher',
                area: ['600px', '450px'],
                maxmin: true,
                end: function () {
                    location.reload();
                }
            });
            parent.layer.iframeAuto(index);
        });
    });



    // 渲染数据
    layui.use('table', function(){
        var table = layui.table;
        var search = $('#search').val();
        var did =$('#did').val();
        var mid = $('#mid').val();

        table.render({
            // id:'id',
            elem: '#test'
            ,url:'<%=basePath%>user/teacherGetAllJson'
            ,where: {
                search: search,
                did:did,
                mid:mid
            }
            ,method: 'post'
            ,cols: [[
                {type:'checkbox',fixed: 'left'},
                {type:'numbers',title:'序号',fixed:true},
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
                ,{field:'identityId', title: '身份',width:120}
                ,{field:'right',align:'center', width:180, toolbar: '#barDemo', title: '操作',fixed: 'right'}
            ]]
            ,done: function(){
                $("[data-field='id']").css('display','none');
            }
            ,page: true
        });

        table.on('checkbox(demo)', function(obj){
            console.log(obj)
        });

        //监听工具条
        table.on('tool(demo)', function(obj){
            var data = obj.data;
            if(obj.event === 'edit'){
                // 编辑
                var index = layer.open({
                    type: 2,
                    content: '<%=basePath%>user/goUpdateTeacher?id='+data.id,
                    area: ['600px', '450px'],
                    maxmin: true,
                    end: function () {
                        location.reload();
                    }
                });
                parent.layer.iframeAuto(index);
            } else if(obj.event === 'del'){
                layer.confirm('真的要删除么？', function(index){
                    // 写删除方法
                    $.post("<%=basePath%>user/delTeacher", {"id": data.id}, function (data) {
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

        //批量删除
        $('#deleteAll').on('click', function(){
            var checkStatus = table.checkStatus('test')
                ,data = checkStatus.data;
            $.ajax({
                url: '<%=basePath%>user/deleteAllTeacher',
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

    layui.use('form', function(){
        var form = layui.form;
        form.on('select(didData)', function(){
            var table = layui.table;
            var search = $('#search').val();
            var did = $('#did').val();
            var mid = $('#mid').val();
            console.log("did:"+did);
            console.log("mid:"+mid);
            // console.log(search);
            table.render({
                elem: '#test'
                , url: '<%=basePath%>user/teacherGetAllJson'
                , where: {
                    search: search,
                    did: did,
                    mid: mid
                }
                , method: 'post'
                // ,page: {layout: ['limit', 'count', 'prev', 'page', 'next', 'skip']}
                , cols: [[
                    {type:'checkbox',fixed: 'left'},
                    {type:'numbers',title:'序号',fixed:true},
                    {field:'id',align:'center', width:80, title: '编号',display:'none'}
                    ,{field:'tid', title: '工号',width:150, sort:true}
                    ,{field:'tname', title: '姓名',width:80}
                    ,{field:'sex', title: '性别',width:80,sort:true}
                    ,{field:'workTime', title: '参加工作时间',width:120,sort:true}
                    ,{field:'hdegree', title: '最高学历',width:100}
                    ,{field:'teachingDirection', title: '教学方向',width:120,sort:true}
                    ,{field:'position', title: '职称',width:120}
                    ,{field:'did', title: '所属院部',width:150}
                    ,{field:'mid', title: '所属专业',width:120}
                    ,{field:'identityId', title: '身份',width:120}
                    ,{field:'right',align:'center', width:180, toolbar: '#barDemo', title: '操作',fixed: 'right'}
                ]]
                , page: true
            });
        });
        form.on('select(midData)', function(){
            var table = layui.table;
            var search = $('#search').val();
            var did = $('#did').val();
            var mid = $('#mid').val();
            table.render({
                elem: '#test'
                , url: '<%=basePath%>user/teacherGetAllJson'
                , where: {
                    search: search,
                    did: did,
                    mid: mid
                }
                , method: 'post'
                // ,page: {layout: ['limit', 'count', 'prev', 'page', 'next', 'skip']}
                , cols: [[
                    {type:'checkbox',fixed: 'left'},
                    {type:'numbers',title:'序号',fixed:true},
                    {field:'id',align:'center', width:80, title: '编号',display:'none'}
                    ,{field:'tid', title: '工号',width:150, sort:true}
                    ,{field:'tname', title: '姓名',width:80}
                    ,{field:'sex', title: '性别',width:80,sort:true}
                    ,{field:'workTime', title: '参加工作时间',width:120,sort:true}
                    ,{field:'hdegree', title: '最高学历',width:100}
                    ,{field:'teachingDirection', title: '教学方向',width:120,sort:true}
                    ,{field:'position', title: '职称',width:120}
                    ,{field:'did', title: '所属院部',width:150}
                    ,{field:'mid', title: '所属专业',width:120}
                    ,{field:'identityId', title: '身份',width:120}
                    ,{field:'right',align:'center', width:180, toolbar: '#barDemo', title: '操作',fixed: 'right'}
                ]]
                , page: true
            });
        });
    });

    function search(){
        var table = layui.table;
        var search = $('#search').val();
        var did =$('#did').val();
        var mid = $('#mid').val();

        table.render({
            elem: '#test'
            ,url:'<%=basePath%>user/teacherGetAllJson'
            ,where: {
                search: search,
                did:did,
                mid:mid
            }
            ,method: 'post'
            ,cols: [[
                {type:'checkbox',fixed: 'left'},
                {type:'numbers',title:'序号',fixed:true},
                {field:'id',align:'center', width:80, title: '编号',display:'none'}
                ,{field:'tid', title: '工号',width:150, sort:true}
                ,{field:'tname', title: '姓名',width:80}
                ,{field:'sex', title: '性别',width:80,sort:true}
                ,{field:'workTime', title: '参加工作时间',width:120,sort:true}
                ,{field:'hdegree', title: '最高学历',width:100}
                ,{field:'teachingDirection', title: '教学方向',width:120,sort:true}
                ,{field:'position', title: '职称',width:120}
                ,{field:'did', title: '所属院部',width:150}
                ,{field:'mid', title: '所属专业',width:120}
                ,{field:'identityId', title: '身份',width:120}
                ,{field:'right',align:'center', width:180, toolbar: '#barDemo', title: '操作',fixed: 'right'}
            ]]
            ,page: true
        });
    }
</script>

</body>
</html>
