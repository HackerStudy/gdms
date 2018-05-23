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
    <meta charset="utf-8">
    <title>个人资料</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="format-detection" content="telephone=no">
    <link rel="stylesheet" href="<%=basePath%>templates/style/plugins/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="<%=basePath%>templates/style/build/css/doc.css" media="all">
    <link rel="stylesheet" href="../../css/user.css" media="all" />
    <script src="<%=basePath%>templates/style/plugins/layui/layui.js"></script>
    <script src="<%=basePath%>templates/style/plugins/layui/jquery-3.3.1.min.js"></script>
    <script src="<%=basePath%>templates/admin/js/getGroup.js"></script>
</head>
<body class="childrenBody">
    <div class="layui-col-md12">
        <div class="layui-card">
            <div class="layui-card-header">管理员资料</div>
            <div class="layui-card-body">
                <form class="layui-form" action="">
                    <input id="kitAdminId" name="kitAdminId" value=${admin.kitAdminId} type="hidden" />
                    <div class="layui-form-item">
                        <label class="layui-form-label">账号</label>
                        <div class="layui-input-inline">
                            <input id="kitAdminUsername" type="text" name="kitAdminUsername" lay-verify="required" lay-vertype="tips" placeholder="请输入账号" value="${admin.kitAdminUsername}" autocomplete="off" class="layui-input">
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">姓名</label>
                        <div class="layui-input-inline">
                            <input type="text" name="kitAdminName" placeholder="请输入姓名" value="${admin.kitAdminName}" autocomplete="off" class="layui-input">
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">头像</label>
                        <input name="imgurl" id="imgurl" lay-verify="required" value="${admin.kitAdminImgUrl}" autocomplete="off" class="layui-input" type="hidden">
                        <div class="layui-upload">
                            <div class="layui-upload-list" style="float:left;">
                                <img id="demo1" class="layui-upload-img" style="max-width: 120px;max-height: 120px" src="<%=basePath%>${admin.kitAdminImgUrl}">
                                <p id="demoText"></p>
                            </div>
                            <button type="button" class="layui-btn" id="avatar"  style="margin-top: 30px;margin-left: 20px;"><i class="layui-icon">&#xe681;</i>上传图片</button>
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">身份</label>
                        <div class="layui-input-block">
                            <c:choose>
                                <c:when test="${admin.groupId==1}">
                                    <c:set var="groupTitle" value="超级管理员"/>
                                </c:when>
                                <c:otherwise>
                                    <c:set var="groupTitle" value="管理员"/>
                                </c:otherwise>
                            </c:choose>
                            <input type="checkbox" name="roleIds[4]" title="${groupTitle}" value="${admin.groupId}" checked="checked" disabled>
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <div class="layui-input-block">
                            <button class="layui-btn" lay-submit lay-filter="add">修改</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
    <script src="/webjars/layui/layui.js"></script>
    <script type="text/javascript">
        layui.use(['element','form','upload'], function(){
            $ = layui.jquery;
            var form = layui.form,
                upload = layui.upload;

            //普通图片上传
            var uploadInst = upload.render({
                elem: '#avatar' //绑定元素
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
                $.post("<%=basePath%>person/updateAdmin",data.field,function(data){
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