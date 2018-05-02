<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-cn">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>首页</title>
    <link rel="stylesheet" href="../templates/style/plugins/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="../templates/style/plugins/font-awesome/css/font-awesome.min.css" media="all">
    <script src="<%=basePath%>templates/style/plugins/layui/layui.js"></script>
    <script src="<%=basePath%>templates/style/plugins/layui/jquery-3.3.1.min.js"></script>
    <style>
        .info-box {
            height: 85px;
            background-color: white;
            background-color: #ecf0f5;
        }

        .info-box .info-box-icon {
            border-top-left-radius: 2px;
            border-top-right-radius: 0;
            border-bottom-right-radius: 0;
            border-bottom-left-radius: 2px;
            display: block;
            float: left;
            height: 85px;
            width: 85px;
            text-align: center;
            font-size: 45px;
            line-height: 85px;
            background: rgba(0, 0, 0, 0.2);
        }

        .info-box .info-box-content {
            padding: 5px 10px;
            margin-left: 85px;
        }

        .info-box .info-box-content .info-box-text {
            display: block;
            font-size: 14px;
            white-space: nowrap;
            overflow: hidden;
            text-overflow: ellipsis;
            text-transform: uppercase;
        }

        .info-box .info-box-content .info-box-number {
            display: block;
            font-weight: bold;
            font-size: 18px;
        }

        .major {
            font-weight: 10px;
            color: #01AAED;
        }

        .main {
            margin-top: 25px;
        }

        .main .layui-row {
            margin: 10px 0;
        }
    </style>
</head>

<body>
<div class="layui-fluid main">
    <div class="layui-row">
        <div class="layui-col-md12">
            <ul class="layui-timeline">
                <li class="layui-timeline-item">
                    <i class="layui-icon layui-timeline-axis">&#xe63f;</i>
                    <div class="layui-timeline-content layui-text">
                        <h3 class="layui-timeline-title">毕设公告</h3>
                        <ul>
                            <li>
                                <a href="javascript:;" onClick="openA('毕设公告','http://www.baidu.com')">长沙学院大四毕业生毕业设计选题通知</a>
                            </li>
                            <li>
                                <a href="http://www.baidu.com" target="_blank">长沙学院大四毕业生毕业设计指导老师选择通知</a>
                            </li>
                            <li>
                                <a href="http://www.baidu.com" target="_blank">长大学院开题答辩通知</a>
                            </li>
                            <li>
                                <a href="http://www.baidu.com" target="_blank">长大学院中期答辩通知</a>
                            </li>
                            <li>
                                <a href="http://www.baidu.com" target="_blank">长大学院毕业论文通知</a>
                            </li>
                            <li>
                                <a href="http://www.baidu.com" target="_blank">长大学院终极答辩通知</a>
                            </li>
                            <li>
                                <a href="http://www.baidu.com" target="_blank">长大学院成绩查询通知</a>
                            </li>
                        </ul>
                    </div>
                </li>
                <li class="layui-timeline-item">
                    <i class="layui-icon layui-timeline-axis">&#xe63f;</i>
                    <div class="layui-timeline-content layui-text">
                        <h3 class="layui-timeline-title">毕业生优秀论文</h3>
                        <ul>
                            <li>
                                <a href="http://www.lunwen361.com/html/2015/gongyejishu_1121/2.html" target="_blank">探析一种矿用本安型人员报警探测器</a>
                            </li>
                            <li>
                                <a href="http://www.lunwen361.com/html/2015/gongyejishu_1121/2.html" target="_blank">探析一种矿用本安型人员报警探测器</a>
                            </li>
                            <li>
                                <a href="http://www.lunwen361.com/html/2015/gongyejishu_1121/2.html" target="_blank">探析一种矿用本安型人员报警探测器</a>
                            </li>
                            <li>
                                <a href="http://www.lunwen361.com/html/2015/gongyejishu_1121/2.html" target="_blank">探析一种矿用本安型人员报警探测器</a>
                            </li>
                            <li>
                                <a href="http://www.lunwen361.com/html/2015/gongyejishu_1121/2.html" target="_blank">探析一种矿用本安型人员报警探测器</a>
                            </li>
                            <li>
                                <a href="http://www.lunwen361.com/html/2015/gongyejishu_1121/2.html" target="_blank">探析一种矿用本安型人员报警探测器</a>
                            </li>
                            <li>
                                <a href="http://www.lunwen361.com/html/2015/gongyejishu_1121/2.html" target="_blank">探析一种矿用本安型人员报警探测器</a>
                            </li>
                        </ul>
                    </div>
                </li>
                <%--<li class="layui-timeline-item">--%>
                    <%--<i class="layui-icon layui-timeline-axis">&#xe63f;</i>--%>
                    <%--<div class="layui-timeline-content layui-text">--%>
                        <%--<div class="layui-timeline-title">更新日志</div>--%>
                    <%--</div>--%>
                <%--</li>--%>
            </ul>
        </div>
    </div>
</div>
<script>
    layui.use('layer', function(){
        var layer = layui.layer;
        layer.message('Hello');
    });

    layui.use('jquery', function() {
        var $ = layui.jquery;
        $('#test').on('click', function() {
            parent.message.show({
                skin: 'cyan'
            });
        });
    });

    layui.use('layer', function() { //独立版的layer无需执行这一句
        var $ = layui.jquery, layer = layui.layer; //独立版的layer无需执行这一句
        //触发事件
        window.active = {
            aOpen: function (title,url) {
                console.log('url:' + url);
                var index = layer.open({
                    type: 2,
                    title:title,
                    content: url,
                    area: ['600px','450px'],
                    maxmin: true
                });
                layer.full(index);
            }
        }
    });

    function openA(title,url) {
        //弹出即全屏
       active.aOpen(title,url);
    }

</script>
</body>

</html>