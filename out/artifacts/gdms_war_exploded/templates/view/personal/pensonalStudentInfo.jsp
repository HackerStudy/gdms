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
        <div class="layui-card-header">学生资料</div>
        <div class="layui-card-body">
            <form class="layui-form" action="">
                <input id="id" name="id" value=${studentInfoVo.id} type="hidden" />
                <div class="layui-form-item">
                    <label class="layui-form-label">头像:</label>
                    <input name="icon" id="imgurl" lay-verify="required" value="${studentInfoVo.icon}" autocomplete="off" class="layui-input" type="hidden">
                    <div class="layui-upload">
                        <div class="layui-upload-list" style="float:left;">
                            <img id="demo1" class="layui-upload-img" style="max-width: 120px;max-height: 120px" src="<%=basePath%>${studentInfoVo.icon}">
                            <p id="demoText"></p>
                        </div>
                        <button type="button" class="layui-btn" id="avatar"  style="margin-top: 30px;margin-left: 20px;"><i class="layui-icon">&#xe681;</i>上传图片</button>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">账号:</label>
                    <div class="layui-input-inline" style="padding: 7px 0px;">
                        <label>${studentInfoVo.sid}</label>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">姓名:</label>
                    <div class="layui-input-inline" style="padding: 7px 0px;">
                        <label>${studentInfoVo.name}</label>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">性别:</label>
                    <div class="layui-input-inline" style="padding: 7px 0px;">
                        <label>${studentInfoVo.sex}</label>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">所属院部:</label>
                    <div class="layui-input-inline" style="padding: 7px 0px;">
                        <label>${studentInfoVo.department}</label >
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">所属专业:</label>
                    <div class="layui-input-inline" style="padding: 7px 0px;">
                        <label>${studentInfoVo.major}</label>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">年级:</label>
                    <div class="layui-input-inline" style="padding: 7px 0px;">
                        <label>${studentInfoVo.grade}</label>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">班级:</label>
                    <div class="layui-input-inline" style="padding: 7px 0px;">
                        <label>${studentInfoVo.sclass}</label>
                    </div>
                </div>
                <div class="layui-form-item">
                <label class="layui-form-label">联系电话:</label>
                <div class="layui-input-inline">
                    <input name="phone" value="${studentInfoVo.phone}" lay-verify="required|phone|number" autocomplete="off" class="layui-input" type="text" style="width: 200px">
                </div>
            </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">邮箱:</label>
                    <div class="layui-input-inline">
                        <input name="email" value="${studentInfoVo.email}" lay-verify="email" autocomplete="off" class="layui-input" type="text" style="width: 200px">
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

        // //自定义验证规则
        // form.verify({
        //     // phone: function(value,item){
        //     //     if(/^1[3|4|5|7|8]\d{9}$/.test(value)){
        //     //         return '手机必须11位，只能是数字！';
        //     //     }
        //     // },
        //     // email: function(value,item){
        //     //     if(/^[a-z0-9._%-]+@([a-z0-9-]+\.)+[a-z]{2,4}$|^1[3|4|5|7|8]\d{9}$/.test(value)){
        //     //         return '邮箱格式不对';
        //     //     }
        //     // }
        //     phone: [/^1[3|4|5|7|8]\d{9}$/, '手机必须11位，只能是数字！']
        //     ,email: [/^[a-z0-9._%-]+@([a-z0-9-]+\.)+[a-z]{2,4}$|^1[3|4|5|7|8]\d{9}$/, '邮箱格式不对']
        // });

        //监听提交，发送请求
        form.on('submit(add)', function(data){
            $.post("<%=basePath%>person/updateStudent",data.field,function(data){
                // 获取 session
                if(data.code!=200){
                    layer.alert(data.msg, {offset: 't',icon: 5});
                }
                if(data.code==200){
                    layer.alert(data.msg, {offset: 't',icon: 6});
                }
            });
            return false;
        });
    });
</script>
</body>
</html>