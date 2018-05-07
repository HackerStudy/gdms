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
    <script src="../../templates/style/build/js/navbar.js"></script>
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
            font-weight:10px;
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
                            <c:forEach items="${noticeVoList}" var="list">
                            <li>
                                <div>
                                <a href="http://www.ccsu.cn/info/1046/21323.htm") target="_blank">关于组织申报2019年度湖南省自然科学基金项目的通知</a>
                                    <span>     ${list.time}</span>
                                </div>
                            </li>
                            </c:forEach>
                        </ul>
                    </div>
                </li>
                <li class="layui-timeline-item">
                    <i class="layui-icon layui-timeline-axis">&#xe63f;</i>
                    <div class="layui-timeline-content layui-text">
                        <h3 class="layui-timeline-title">毕业生优秀论文</h3>
                        <ul>
                            <li>
                                <a href="javascript:;" onclick=openA("优秀毕业论文","http://www.diyilunwen.com/lwfw/jsj/10447.html")>【计算机网络安全论文】计算机病毒的危害与防范研究</a>
                            </li>
                            <li>
                                <a href="javascript:;" onclick=openA("优秀毕业论文","http://www.diyilunwen.com/lwfw/jsj/10211.html")>【计算机网络技术论文】试述计算机网络故障管理智能化</a>
                            </li>
                            <li>
                                <a href="javascript:;" onclick=openA("优秀毕业论文","http://www.diyilunwen.com/lwfw/jjxlw/10533.html")>【经济学论文】浅谈中国对外投资的现状以及应对措施</a>
                            </li>
                            <li>
                                <a href="javascript:;" onclick=openA("优秀毕业论文","http://www.diyilunwen.com/lwfw/jjxlw/10395.html")>【经济学论文】浅谈优化电力调度实现电网经济运行的策略研究</a>
                            </li>
                            <li>
                                <a href="javascript:;" onclick=openA("优秀毕业论文","http://www.diyilunwen.com/lwfw/keji/8600.html")>【科技论文】浅谈电能表校验相关问题</a>
                            </li>
                            <li>
                                <a href="javascript:;" onclick=openA("优秀毕业论文","http://www.diyilunwen.com/lwfw/keji/8498.html")>【科技论文】汽车维修行业的现状及对策研究</a>
                            </li>
                            <li>
                                <a href="javascript:;" onclick=openA("优秀毕业论文","http://www.diyilunwen.com/lwfw/gsgl/5966.html")>【工商管理毕业论文范文】浅谈民营企业的金融体系</a>
                            </li>
                        </ul>
                    </div>
                </li>
            </ul>
        </div>
    </div>
</div>
<script>
    // layui.use('layer', function(){
    //     var layer = layui.layer;
    //     layer.message('Hello');
    // });

    // layui.use('jquery', function() {
    //     var $ = layui.jquery;
    //     $('#test').on('click', function() {
    //         parent.message.show({
    //             skin: 'cyan'
    //         });
    //     });
    // });

    // layui.use('jquery', function() {
    //     var $ = layui.jquery;
    //     $(".layui-col-md12 a").on("click",function(){
    //         parent.layer;
    //     });
    // });



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