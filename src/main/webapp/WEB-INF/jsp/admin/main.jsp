<%--
  Created by IntelliJ IDEA.
  User: Fourteen
  Date: 2021/4/8
  Time: 21:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>主界面</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/layui/2.6.4/css/layui.css">
</head>
<body style="overflow:hidden;">
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo">PetsApp管理系统</div>
        <!-- 头部区域（可配合layui 已有的水平导航） -->
        <ul class="layui-nav layui-layout-right">
            <%--个人信息--%>
            <li class="layui-nav-item">
                <a href="javascript:;">
                    <%--管理员头像--%>
                    <img src="//tva1.sinaimg.cn/crop.0.0.118.118.180/5db11ff4gw1e77d3nqrv8j203b03cweg.jpg"
                         class="layui-nav-img">
                    <%--管理员昵称--%>
                    Admin
                </a>
            </li>
            <li class="layui-nav-item"><a href="">Sign out</a></li>
        </ul>
    </div>

    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
            <ul class="layui-nav layui-nav-tree" lay-filter="test">
                <li class="layui-nav-item">
                    <a href="${pageContext.request.contextPath}/admin/appInfo" target="ifr">AppInfo</a>
                </li>
                <li class="layui-nav-item">
                    <a>User</a>
                    <dl class="layui-nav-child">
                        <dd><a href="${pageContext.request.contextPath}/admin/userList" target="ifr">UserList</a></dd>
                    </dl>
                    <dl class="layui-nav-child">
                        <dd><a href="${pageContext.request.contextPath}/admin/addUser" target="ifr">addUser</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a>Organization</a>
                    <dl class="layui-nav-child">
                        <dd><a href="${pageContext.request.contextPath}/admin/organList" target="ifr">organList</a></dd>
                        <dd><a href="${pageContext.request.contextPath}/admin/addOrgan" target="ifr">addOrgan</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a>Article</a>
                    <dl class="layui-nav-child">
                        <dd><a href="${pageContext.request.contextPath}/admin/articleList" target="ifr">articleList</a></dd>
                        <dd><a href="${pageContext.request.contextPath}/admin/addArticle" target="ifr">addArticle</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a>Comment</a>
                    <dl class="layui-nav-child">
                        <dd><a href="${pageContext.request.contextPath}/admin/commentList" target="ifr">commentList</a></dd>
                        <dd><a href="${pageContext.request.contextPath}/admin/addComment" target="ifr">addComment</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a>Helped</a>
                    <dl class="layui-nav-child">
                        <dd><a href="${pageContext.request.contextPath}/admin/helpedList" target="ifr">helpedList</a></dd>
                        <dd><a href="${pageContext.request.contextPath}/admin/addHelped" target="ifr">addHelped</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a>RescueInfor</a>
                    <dl class="layui-nav-child">
                        <dd><a href="${pageContext.request.contextPath}/admin/rescueInforList" target="ifr">rescueInforList</a></dd>
                        <dd><a href="${pageContext.request.contextPath}/admin/addRescueInfor" target="ifr">addRescueInfor</a></dd>
                    </dl>
                </li>
            </ul>
        </div>
    </div>

    <div class="layui-body">
        <!-- 内容主体区域 -->
        <div style="padding: 15px;">
            <iframe name="ifr" frameborder="0" id="demoAdmin"
                    style="width: 100%; height: 600px; border-radius: 2px;"></iframe>
        </div>
    </div>

</div>

<script src="https://cdnjs.cloudflare.com/ajax/libs/layui/2.6.4/layui.js"></script>
<script>
    //JavaScript代码区域
    layui.use('element', function () {
        var element = layui.element;

    });
</script>
</body>
</html>