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
    <title>老师身份信息管理</title>
    <link rel="stylesheet" href="<%=basePath%>templates/style/plugins/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="<%=basePath%>templates/style/build/css/doc.css" media="all">
    <script src="<%=basePath%>templates/style/plugins/layui/layui.js"></script>
    <script src="<%=basePath%>templates/style/plugins/layui/jquery-3.3.1.min.js"></script>
    <script src="<%=basePath%>templates/admin/js/getGroup.js"></script>
</head>
<body>
<div class="kit-doc">
    <!--这里写页面的代码-->
    <blockquote class="layui-elem-quote">这是关于老师身份的管理页面</blockquote>
    <div class="kit-doc-title">
        <fieldset>
            <legend><a name="blockquote">老师身份管理</a></legend>
        </fieldset>
    </div>
    <div>
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
    <script type="text/html" id="identityTpl">
        <div class="layui-input-block">
            <input type="radio" name="identityId" value="{{data.identityId}}" title="指导老师" lay-filter="sexDemo" {{ data.identityId == 3 ? 'checked' : '' }}>
            <input type="radio" name="identityId" value="{{data.identityId}}" title="答辩老师" {{ data.identityId == 4 ? 'checked' : '' }}>
        </div>
    </script>
</div>

<script>

    layui.config({
        base: '<%=basePath%>templates/style/build/js/'
    })

    // 渲染数据
    layui.use('table', function(){
        var table = layui.table
            ,form = layui.form;
        var search = $('#search').val();
        var did =$('#did').val();
        var mid = $('#mid').val();

        table.render({
            elem: '#test'
            ,url:'<%=basePath%>user/teacherIdentityGetAllJson'
            ,where: {
                search: search,
                did:did,
                mid:mid
            }
            ,method: 'post'
            ,page: {layout: ['limit', 'count', 'prev', 'page', 'next', 'skip']}
            ,cols: [[
                {field:'id',align:'center', width:80, title: '序号',sort:true,fixed:true}
                ,{field:'tid', title: '工号',width:150, sort:true}
                ,{field:'tname', title: '姓名',width:80}
                ,{field:'did', title: '所属院部',width:150}
                ,{field:'mid', title: '所属专业',width:120}
                ,{field:'identityId', title: '身份',width:120 ,templet: '#identityTpl', unresize: true}
            ]]
        });

        table.on('checkbox(demo)', function(obj){
            console.log(obj)
        });

        form.on('switch(sexDemo)', function(obj){
            layer.tips(this.value + ' ' + this.name + '：'+ obj.elem.checked, obj.othis);
        });
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
                    {field:'id',align:'center', width:80, title: '序号',sort:true,fixed:true}
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
        form.on('select(midData)', function(res){
            var table = layui.table;
            var search = $('#search').val();
            var did = res.value;
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
                    {field:'id',align:'center', width:80, title: '序号',sort:true,fixed:true}
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
            ,url:'<%=basePath%>user/teacherIdentityGetAllJson'
            ,where: {
                search: search,
                did:did,
                mid:mid
            }
            ,method: 'post'
            ,page: {layout: ['limit', 'count', 'prev', 'page', 'next', 'skip']}
            ,cols: [[
                {type:'checkbox',fixed: 'left'},
                {field:'id',align:'center', width:80, title: '序号',sort:true,fixed:true}
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
        });
    }
</script>

</body>
</html>
