<%--
  Created by IntelliJ IDEA.
  User: Fourteen
  Date: 2021/4/8
  Time: 20:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Layui</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/layui/2.6.4/css/layui.css"  media="all">
</head>
<body>

<table class="layui-hide" id="test"></table>


<script src="https://cdnjs.cloudflare.com/ajax/libs/layui/2.6.4/layui.js" charset="utf-8"></script>

<script>
    layui.use('table', function(){
        var table = layui.table;

        table.render({
            elem: '#test'
            ,url:'${pageContext.request.contextPath}/user/queryByLimit'
            ,cellMinWidth: 80 //全局定义常规单元格的最小宽度，layui 2.2.1 新增
            ,cols: [[
                {field:'id', width:80, title: 'ID', sort: true}
                ,{field:'name', width:80, title: '用户名'}
                ,{field:'age', width:80, title: '年龄', sort: true}
                ,{field:'sex', width:80, title: '性别'}
                ,{field:'location', title: '所在地', width: '30%', minWidth: 100} //minWidth：局部定义当前单元格的最小宽度，layui 2.2.1 新增
                ,{field:'imgUrl', title: '照片'}
            ]]
        });
    });
</script>

</body>
</html>