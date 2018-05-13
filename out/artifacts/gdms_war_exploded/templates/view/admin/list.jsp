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
    <title>管理员信息管理</title>
    <link rel="stylesheet" href="../../../templates/style/plugins/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="../../../templates/style/build/css/doc.css" media="all">
    <script src="../../../templates/style/plugins/layui/layui.js"></script>
    <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
    <script src="../../../templates/view/js/getGroup.js"></script>
</head>
<body>
<div class="kit-doc">
    <!--这里写页面的代码-->
    <blockquote class="layui-elem-quote">这是关于管理员的信息管理页面</blockquote>
    <div class="kit-doc-title">
        <fieldset>
            <legend><a name="blockquote">管理员信息管理</a></legend>
        </fieldset>
    </div>
    <div>
        <button class="layui-btn" id="add">添加</button>
        <div class="layui-inline" style="float: right">
        <div class="layui-input-inline">
        <input id="selectbyid" name="selectbyid" lay-verify="required|phone" autocomplete="off" class="layui-input" type="tel">
        </div>
        <button class="layui-btn layui-btn-primary" onClick="search()">搜索</button>
        </div>
    </div>

    <table id="table" class="layui-table" lay-filter="kittable">
        <colgroup>
            <col width="40">
            <col width="100">
            <col width="120">
            <col width="70">
            <col>
            <col width="70">
        </colgroup>
        <thead>
        <tr>
            <th>编号</th>
            <th>管理员账号</th>
            <th>密码</th>
            <th>姓名</th>
            <th>头像</th>
            <th>权限</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody id="tbody">
            <% int number=1;%>
            <c:forEach items="${adminlist}" var="adminlist">
                <tr>
                    <td><%=number%></td>
                    <td>${adminlist.kitAdminUsername}</td>
                    <td>${adminlist.kitAdminPassword}</td>
                    <td>${adminlist.kitAdminName}</td>
                    <td>${adminlist.kitAdminImgUrl}</td>
                    <c:forEach items="${groupList}" var="gList">
                        <c:choose><c:when test="${gList.groupId==adminlist.groupId}">
                            <td>${gList.groupName}</td>
                        </c:when><c:otherwise>
                        </c:otherwise>
                        </c:choose>
                    </c:forEach>
                    <c:choose><c:when test="${adminlist.kitAdminUsername.equals(user.username)}">
                    <td>
                       此处不可对自身进行操作
                    </td></c:when>
                        <c:when test="${adminlist.groupId==1}">
                            <td>
                                权限不足
                            </td>
                        </c:when>
                        <c:otherwise>
                        <td>
                            <button class="layui-btn layui-btn-sm layui-btn-normal" onClick="update('${adminlist.kitAdminId}')"><i class="layui-icon">&#xe642;</i> 编辑</button>
                            <button class="layui-btn layui-btn-sm layui-btn-danger" onClick="del('${adminlist.kitAdminId}')"><i class="layui-icon">&#xe640;</i> 删除</button>
                        </td></c:otherwise></c:choose>
                </tr>
                <% number++;%>
            </c:forEach>
        </tbody>
    </table>
    <!--这里写页面的代码-->
</div>

<script>

    layui.config({
        base: '<%=basePath%>templates/style/build/js/'
    })

    // $(function() {
    //
    // });

    layui.use(['jquery', 'layer', 'table'], function () {

        var table = layui.table;

        //让层自适应iframe
        $('#add').on('click', function(){
            var index = layer.open({
                type: 2,
                title:'添加管理员',
                content: '<%=basePath%>admin/toAdd',
                area: ['600px', '450px'],
                maxmin: true,
                end: function () {
                    location.reload();
                }
            });
            parent.layer.iframeAuto(index);
        });
    });

    // 搜索
    function search(){
        var searchContent=document.getElementById("selectbyid").value;
        $.ajax({
            url: '<%=basePath%>admin/search',
            type: 'post',
            // async: true,
            dataType: 'json',
            contentType: "application/json",
            data:JSON.stringify({
                "sign":"发送搜索数据",
                "inmap":{
                    'searchContent':searchContent
                 },
                "inlist":null
            }),
            success: function (data) {
                if(data.code!=200){
                    // layer.alert(data.msg, {offset: 'auto',icon: 5});
                }else if(data.code==200){
                    layer.alert(data.msg, {offset: 'auto',icon: 6});
                    // console.log(data.data.adminList[0].kitAdminImgUrl);
                    // var array = data.data.adminList;
                    // for (var k = 0, length = array.length; k < length; k++) {
                    //     console.log(data.data.adminList[k]);
                    // }
                    var alist=data.data.adminList;
                    var glist=data.data.groupList;
                    var user=data.data.user;
                    var number=1;
                    var tdgroupName;
                    var operation;
                    $("#tbody").empty();
                    $.each(alist,function (index,domEle){
                        // console.log(domEle);
                        $.each(glist,function(index1,domEle1) {
                            if(domEle.groupId==domEle1.groupId){
                               tdgroupName= "<td>" + domEle1.groupName + "</td>";
                            }
                        });
                        if(domEle.kitAdminUsername==user.username){
                            operation="<td>此处不可对自身进行操作</td>";
                        }else if(domEle.groupId==1) {
                            operation="<td>权限不足</td>";
                        }else{
                            operation='<td><button class="layui-btn layui-btn-sm layui-btn-normal" onClick="update('+domEle.kitAdminId+')"><i class="layui-icon">&#xe642;</i>编辑</button>'+
                                    '<button class="layui-btn layui-btn-sm layui-btn-danger" onClick="del('+domEle.kitAdminId+')"><i class="layui-icon">&#xe640;</i>删除</button></td>';
                        }
                        $("#tbody").append(
                            "<tr><td>"+number+"</td>"+
                                "<td>"+domEle.kitAdminUsername+"</td>"+
                                "<td>"+domEle.kitAdminPassword+"</td>"+
                                "<td>"+domEle.kitAdminName+"</td>"+
                                "<td>"+domEle.kitAdminImgUrl+"</td>"+
                                    tdgroupName+operation
                        );
                        number++;
                    });
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
    };

    // 修改
    function update(kitAdminId){
        var index = layer.open({
            type: 2,
            title:'修改管理员信息',
            content: '<%=basePath%>admin/goUpdate?kitAdminId='+kitAdminId,
            area: ['600px','450px'],
            maxmin: true,
            end: function () {
                location.reload();
            }
        });
        parent.layer.iframeAuto(index);
    };

    // 删除
    function del(id){
        //询问框
        layer.confirm('真的要删除么？', {
            btn: ['确定','取消'], //按钮
            end: function () {
                location.reload();
            }
        }, function(){
            $.post("<%=basePath%>admin/del",{'id':id},function(data){
                // 获取 session
                if(data.code!=200){
                    layer.msg(data.msg, {icon: 5});
                }
                if(data.code==200){
                    layer.msg(data.msg, {icon: 6});
                }
                parent.layer.iframeAuto(index);
            });
        }, function(){
        });
    };

</script>

</body>
</html>
