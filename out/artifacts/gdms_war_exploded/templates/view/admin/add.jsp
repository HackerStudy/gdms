<%--
  Created by IntelliJ IDEA.
  User: benhailong
  Date: 2018/2/7
  Time: 下午3:48
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
    <title>添加学生</title>
    <link rel="stylesheet" href="<%=basePath%>templates/style/plugins/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="<%=basePath%>templates/style/build/css/doc.css" media="all">
    <script src="<%=basePath%>templates/style/plugins/layui/layui.js"></script>
    <script src="<%=basePath%>templates/style/plugins/layui/jquery-3.3.1.min.js"></script>
</head>
<body>

<div class="kit-doc">
    <form class="layui-form layui-form-pane" action="">
        <div class="layui-form-item">
            <label class="layui-form-label">管理员账号</label>
            <div class="layui-input-block">
                <input name="kitAdminUsername" lay-verify="required" placeholder="请输入管理员账号" autocomplete="off" class="layui-input" type="text">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">密码</label>
            <div class="layui-input-block">
                <input name="kitAdminPassword" lay-verify="required" placeholder="请输入你的密码" autocomplete="off" class="layui-input" type="password">
            </div>
        </div>

        <div class="layui-form-item">
        <label class="layui-form-label">确认密码</label>
        <div class="layui-input-block">
        <input name="kitAdminPasswordAgain" lay-verify="required" placeholder="请确认你的密码" autocomplete="off" class="layui-input" type="password">
        </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">姓名</label>
            <div class="layui-input-block">
                <input name="kitAdminName" lay-verify="required" placeholder="请输入管理员的姓名" autocomplete="off" class="layui-input" type="text">
            </div>
        </div>

        <div class="layui-form-item" >
            <label class="layui-form-label" style="height: 137px; line-height: 117px">上传头像</label>
            <input name="imgurl" id="imgurl" lay-verify="required" value="" autocomplete="off" class="layui-input" type="hidden">
            <div class=" layui-upload-drag" id="img" style="border-left: 0px;">
                <i class="layui-icon">&#xe654;</i>
                <p>点击上传头像</p>
                <img id="demo1" style="position: absolute;height: 137px;width: 137px;margin: -106px auto auto -30px;display: none" />
            </div>
        </div>

        <%--<div class="layui-form-item">--%>
            <%--<label class="layui-form-label">权限</label>--%>
            <%--<div class="layui-input-block">--%>
                <%--<select name="权限" lay-verify="">--%>
                    <%--<option value="">请选择要添加的权限</option>--%>
                    <%--<c:forEach items="${groupList}" var="gList">--%>
                        <%--<option value="${gList.groupId}">${gList.groupName}</option>--%>
                    <%--</c:forEach>--%>
                <%--</select>--%>
            <%--</div>--%>
        <%--</div>--%>

        <div class="layui-form-item">
            <button class="layui-btn" lay-submit="" lay-filter="add">提交</button>
        </div>
    </form>

    <!--这里写页面的代码-->
</div>

<script>
    layui.use(['form', 'layedit', 'laydate', 'element', 'layer', 'upload'], function(){
            var form = layui.form,
                layer = layui.layer,
                element = layui.element,
                upload = layui.upload;

            //普通图片上传
            var uploadInst = upload.render({
                elem: '#img' //绑定元素
                , url: '/apiCommon/setImage' //上传接口
                , field: 'layuiFile' //设定文件域的字段名
                , before: function (obj) { //文件提交上传前的回调
                    //预读本地文件示例，不支持ie8
                    obj.preview(function (index, file, result, data) {
                        //index:文件的索引，file:文件的对象，result:文件base64编码，比如图片
                        $('#demo1').css('display','block').attr('src', result); //链接（base64）
                    });
                }
                , done: function (res) { //执行上传请求后的回调。
                    //如果上传失败
                    if (res.code > 0) {
                        return layer.msg('上传失败');
                    }
                    //上传成功
                    if(res.code == 0){
                        $('#imgurl').val(res.data.src);
                    }
                }
                , error: function () {
                    //演示失败状态，并实现重传
                    var demoText = $('#demoText');
                    demoText.html('<span style="color: #FF5722;">上传失败</span> <a class="layui-btn layui-btn-mini demo-reload">重试</a>');
                    demoText.find('.demo-reload').on('click', function () {
                        uploadInst.upload();
                    });
                }
            });

        //监听提交，发送请求
        form.on('submit(add)', function(data){
            console.log(data.field)
            if(data.field.kitAdminPassword!=data.field.kitAdminPasswordAgain){
                layer.alert('两次密码输入不一致');
                return false;
            }
            $.post("<%=basePath%>admin/add",data.field,function(data){
                // 获取 session
                if(data.code!=200){
                    layer.alert(data.msg, {offset: 'auto',icon: 5});
                }
                if(data.code==200){
                    layer.alert(data.msg, {offset: 'auto',icon: 6});
                }
            });
            return false;
        });
    });
</script>
</body>
</html>
