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
    <title>学生信息管理</title>
    <link rel="stylesheet" href="<%=basePath%>templates/style/plugins/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="<%=basePath%>templates/style/build/css/doc.css" media="all">
    <script src="<%=basePath%>templates/style/plugins/layui/layui.js"></script>
    <script src="<%=basePath%>templates/style/plugins/layui/jquery-3.3.1.min.js"></script>
    <script src="<%=basePath%>templates/admin/js/getGroup.js"></script>
</head>
<body>
<div class="kit-doc">
    <!--这里写页面的代码-->
    <blockquote class="layui-elem-quote">这是关于学生的信息管理页面</blockquote>
    <div class="kit-doc-title">
        <fieldset>
            <legend><a name="blockquote">学生信息管理</a></legend>
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
                    <select id="department" name="department" lay-filter="didData">
                    <option value="">院部筛选</option>
                    <c:forEach items="${departmentList}" var="dlist">
                        <option value="${dlist.did}}">${dlist.departmentName}</option>
                    </c:forEach>
                </select>
                </div>
            </div>
        </div>

        <div class="layui-form layui-form-pane" style="display:inline-block">
            <div class="layui-form-item">
                <div id="midScreen" class="layui-input-block" style="margin-left: 30px">
            <select id="major" name="major" lay-filter="midData">
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
        <input id="search" name="selectbysid" autocomplete="off" class="layui-input" type="tel">
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
                content: '<%=basePath%>user/goAddStudent',
                area: ['600px', '450px'],
                offset: 'auto',
                maxmin: true,
                end: function () {
                    window.location.reload();
                }
            });
            parent.layer.iframeAuto(index);
        });
    });



    // 渲染数据
    layui.use('table', function(){
        var table = layui.table;
        var search = $('#search').val();
        var department =$('#department').val();
        var major = $('#major').val();

        table.render({
            elem: '#test'
            ,url:'<%=basePath%>user/studentGetAllJson'
            ,where: {
                search: search,
                did:department,
                mid:major
            }
            ,method: 'post'
            ,cols: [[
                {type:'checkbox',fixed: 'left'},
                 {field:'id',align:'center', width:80,  title: '序号',sort:true,fixed:true}
                ,{field:'sid', title: '学号',width:150, sort:true}
                ,{field:'name', title: '姓名',width:80,}
                ,{field:'sex', title: '性别',width:80,sort:true}
                ,{field:'department', title: '院部',width:150}
                ,{field:'major', title: '专业',width:120}
                ,{field:'grade', title: '年级',width:80}
                ,{field:'sclass', title: '班级',width:120,sort:true}
                ,{field:'phone', title: '联系电话',width:150}
                ,{field:'email', title: '邮箱',width:190}
                ,{field:'adviserTname', title: '指导老师',width:100}
                ,{field:'replygroupName', title: '所属答辩组',width:120,sort:true}
                ,{field:'right',align:'center', width:180, toolbar: '#barDemo', title: '操作',fixed: 'right'}
            ]]
            ,page:true
        });

        // table.on('checkbox(demo)', function(obj){
        //     console.log(obj)
        // });

        //监听工具条
        table.on('tool(demo)', function(obj){
            var data = obj.data;
            if(obj.event === 'edit'){
                // 编辑
                var index = layer.open({
                    type: 2,
                    content: '<%=basePath%>user/goUpdateStudent?id='+data.id,
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
                    $.post("<%=basePath%>user/delStudent", {"id": data.id}, function (data) {
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
            layer.confirm('真的要删除么？', function(index) {
                $.ajax({
                    url: '<%=basePath%>user/deleteAllStudent',
                    type: 'post',
                    // async: true,
                    dataType: 'json',
                    contentType: "application/json",
                    data: JSON.stringify(data),
                    success: function (data) {
                        if (data.code != 200) {
                            layer.alert(data.msg, {offset: 'auto', icon: 5});
                            layer.close(index);
                        } else if (data.code == 200) {
                            layer.alert(data.msg, {offset: 'auto', icon: 6});
                            layer.close(index);
                            window.location.reload();
                        }
                    },
                    // beforeSend: function () {
                    //     // 一般是禁用按钮等防止用户重复提交
                    //     $(data.elem).attr("disabled", "true").text("提交中...");
                    // },
                    error: function () {
                        layer.alert("请求错误", {offset: 'auto', icon: 5});
                    }
                });
            });
        });

        // var $ = layui.$, active = {
        //     getCheckData: function () { //获取选中数据
        //         var checkStatus = table.checkStatus('test')
        //             , data = checkStatus.data;
        //         layer.alert(JSON.stringify(data));
        //     }
        // };
        // $('.demoTable .layui-btn').on('click', function(){
        //     var type = $(this).data('type');
        //     active[type] ? active[type].call(this) : '';
        // });
    });

    layui.use('form', function(){
        var form = layui.form;
        form.on('select(didData)', function(res){
            var table = layui.table;
            var search = $('#search').val();
            var did = res.value;
            var mid = $('#mid').val();
            console.log("did:"+did);
            console.log("mid:"+mid);
            // console.log(search);
            table.render({
                elem: '#test'
                , url: '<%=basePath%>user/studentGetAllJson'
                , where: {
                    search: search,
                    did: did,
                    mid: mid
                }
                , method: 'post'
                // ,page: {layout: ['limit', 'count', 'prev', 'page', 'next', 'skip']}
                , cols: [[
                    {type: 'checkbox', fixed: 'left'},
                    {field: 'id', align: 'center', width: 80, title: '序号', sort: true, fixed: true}
                    , {field: 'sid', title: '学号', width: 150, sort: true}
                    , {field: 'name', title: '姓名', width: 80,}
                    , {field: 'sex', title: '性别', width: 80, sort: true}
                    , {field: 'did', title: '院部', width: 150}
                    , {field: 'mid', title: '专业', width: 120}
                    , {field: 'grade', title: '年级', width: 80}
                    , {field: 'sclass', title: '班级', width: 120, sort: true}
                    , {field: 'phone', title: '联系电话', width: 150}
                    , {field: 'email', title: '邮箱', width: 190}
                    , {field: 'adviserid', title: '指导老师', width: 100}
                    , {field: 'replygroupid', title: '所属答辩组', width: 120, sort: true}
                    , {field: 'right', align: 'center', width: 180, toolbar: '#barDemo', title: '操作', fixed: 'right'}
                ]]
                , page: true
            });
    });
        form.on('select(midData)', function(res){
            var table = layui.table;
            var search = $('#search').val();
            var did = res.value;
            var mid = $('#mid').val();
            table.render({
                elem: '#test'
                , url: '<%=basePath%>user/studentGetAllJson'
                , where: {
                    search: search,
                    did: did,
                    mid: mid
                }
                , method: 'post'
                // ,page: {layout: ['limit', 'count', 'prev', 'page', 'next', 'skip']}
                , cols: [[
                    {type: 'checkbox', fixed: 'left'},
                    {field: 'id', align: 'center', width: 80, title: '序号', sort: true, fixed: true}
                    , {field: 'sid', title: '学号', width: 150, sort: true}
                    , {field: 'name', title: '姓名', width: 80,}
                    , {field: 'sex', title: '性别', width: 80, sort: true}
                    , {field: 'did', title: '院部', width: 150}
                    , {field: 'mid', title: '专业', width: 120}
                    , {field: 'grade', title: '年级', width: 80}
                    , {field: 'sclass', title: '班级', width: 120, sort: true}
                    , {field: 'phone', title: '联系电话', width: 150}
                    , {field: 'email', title: '邮箱', width: 190}
                    , {field: 'adviserid', title: '指导老师', width: 100}
                    , {field: 'replygroupid', title: '所属答辩组', width: 120, sort: true}
                    , {field: 'right', align: 'center', width: 180, toolbar: '#barDemo', title: '操作', fixed: 'right'}
                ]]
                , page: true
            });
        });
    });

        function search() {
            var table = layui.table;
            var search = $('#search').val();
            var did = $('#did').val();
            var mid = $('#mid').val();
            // console.log(search);
            table.render({
                elem: '#test'
                , url: '<%=basePath%>user/studentGetAllJson'
                , where: {
                    search: search,
                    did: did,
                    mid: mid
                }
                , method: 'post'
                // ,page: {layout: ['limit', 'count', 'prev', 'page', 'next', 'skip']}
                , cols: [[
                    {type: 'checkbox', fixed: 'left'},
                    {field: 'id', align: 'center', width: 80, title: '序号', sort: true, fixed: true}
                    , {field: 'sid', title: '学号', width: 150, sort: true}
                    , {field: 'name', title: '姓名', width: 80,}
                    , {field: 'sex', title: '性别', width: 80, sort: true}
                    , {field: 'did', title: '院部', width: 150}
                    , {field: 'mid', title: '专业', width: 120}
                    , {field: 'grade', title: '年级', width: 80}
                    , {field: 'sclass', title: '班级', width: 120, sort: true}
                    , {field: 'phone', title: '联系电话', width: 150}
                    , {field: 'email', title: '邮箱', width: 190}
                    , {field: 'adviserid', title: '指导老师', width: 100}
                    , {field: 'replygroupid', title: '所属答辩组', width: 120, sort: true}
                    , {field: 'right', align: 'center', width: 180, toolbar: '#barDemo', title: '操作', fixed: 'right'}
                ]]
                , page: true
            });
        }

</script>

</body>
</html>
