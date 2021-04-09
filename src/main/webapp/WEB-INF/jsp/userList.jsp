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

<table class="layui-hide" id="test3" lay-filter="test3"></table>


<script src="https://cdnjs.cloudflare.com/ajax/libs/layui/2.6.4/layui.js" charset="utf-8"></script>

<script>
    layui.use('table', function(){
        var table = layui.table,
            $ = layui.jquery;

        table.render({
            elem: '#test3'
            ,url:'${pageContext.request.contextPath}/user/queryByLimit'
            ,cellMinWidth: 80 //全局定义常规单元格的最小宽度，layui 2.2.1 新增
            ,cols: [[
                {field:'id', width:300, title: 'ID', sort: true}
                ,{field:'name', width:100, title: '用户名',edit: 'text'}
                ,{field:'age', width:80, title: '年龄', sort: true,edit: 'text'}
                ,{field:'sex', width:80, title: '性别',edit: 'text'}
                ,{field:'location', title: '所在地', width: 100, minWidth: 100,edit: 'text'} //minWidth：局部定义当前单元格的最小宽度，layui 2.2.1 新增
                ,{field:'imgUrl', title: '照片'}
            ]]
            ,page: true
        });

        //监听单元格编辑
        table.on('edit(test3)', function(obj){
            var value = obj.value //得到修改后的值
                ,data = obj.data //得到所在行所有键值
                ,field = obj.field; //得到字段
            console.log("value:"+value);
            console.log("data:"+data.id);
            console.log("field:"+field);
            $.ajax({
                type: "PATCH",
                url: "user/updateUser",
                dataType: "json",
                contentType: "application/json; charset=utf-8",
                data: JSON.stringify({
                    "value":value,
                    "field":field,
                    "id":data.id
                }),
                success: function (res) {
                    if (res.code == 0) {
                        layer.msg("success", {icon: 1});
                    } else {
                        layer.msg("error", {icon: 2});
                    }
                },
                error: function () {
                    layer.msg("error", {icon: 2});
                }
            })
        });
    });
</script>

</body>
</html>