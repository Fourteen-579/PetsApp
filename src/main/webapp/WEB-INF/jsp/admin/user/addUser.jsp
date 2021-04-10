<%--
  Created by IntelliJ IDEA.
  User: Fourteen
  Date: 2021/4/10
  Time: 10:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>Layui</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/layui/2.6.4/css/layui.css" media="all">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/layui/2.6.4/layui.js" charset="utf-8"></script>
</head>
<body>
<form class="layui-form" action="POST" lay-filter="example" onsubmit="return false">
    <div class="layui-form-item">
        <label class="layui-form-label">用户名</label>
        <div class="layui-input-block">
            <input type="text" name="name" lay-verify="title" autocomplete="off" placeholder="请输入昵称"
                   class="layui-input" required>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">密码框</label>
        <div class="layui-input-block">
            <input type="password" name="pwd" placeholder="请输入密码" autocomplete="off" class="layui-input" required>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">手机号</label>
        <div class="layui-input-block">
            <input type="text" name="phone" placeholder="请输入手机号" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">年龄</label>
        <div class="layui-input-block">
            <input type="number" name="age" placeholder="请输入年龄" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">所在地</label>
        <div class="layui-input-block">
            <select name="location" lay-filter="aihao">
                <option value="-1">隐藏</option>
                <option value="0" selected="">四川</option>
                <option value="1">浙江</option>
                <option value="2">黑龙江</option>
                <option value="3">新疆</option>
                <option value="4">内蒙古</option>
            </select>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">单选框</label>
        <div class="layui-input-block">
            <input type="radio" name="sex" value="男" title="男" checked="">
            <input type="radio" name="sex" value="女" title="女">
        </div>
    </div>

    <div class="layui-upload-drag" id="test10">
        <i class="layui-icon"></i>
        <p>点击上传，或将文件拖拽到此处</p>
        <div class="layui-hide" id="uploadDemoView">
            <hr>
            <img id="user_imgUrl" src="https://www.baidu.com/img/PCtm_d9c8750bed0b3c7d089fa7d55720d6cf.png" alt="上传成功后渲染" style="max-width: 196px">
        </div>
    </div>

    <div class="layui-form-item">
        <div class="layui-input-block">
            <button type="submit" class="layui-btn" lay-submit="" lay-filter="demo1">立即提交</button>
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
        </div>
    </div>
</form>
<script>
    layui.use(['upload', 'form'], function () {
        var form = layui.form
            , layer = layui.layer
            , $ = layui.jquery;

        // //拖拽上传
        //TODO
        // upload.render({
        //     elem: '#test10'
        //     , url: 'https://httpbin.org/post' //改成您自己的上传接口
        //     , done: function (res) {
        //         layer.msg('上传成功');
        //         layui.$('#uploadDemoView').removeClass('layui-hide').find('img').attr('src', res.files.file);
        //         console.log(res)
        //     }
        // });

        //监听提交
        form.on('submit(demo1)', function (data) {
            var imgUrl = $("#user_imgUrl").attr("src");
            if (data.field.name == "" || data.field.pwd == "")
                return false;
            else {
                $.ajax({
                    type: "POST",
                    url: "${pageContext.request.contextPath}/user/addUser",
                    dataType: "json",
                    contentType: "application/json; charset=utf-8",
                    data: JSON.stringify({
                        "imgUrl":imgUrl,
                        "name": data.field.name,
                        "pwd": data.field.pwd,
                        "phone": data.field.phone,
                        "location": data.field.location,
                        "sex": data.field.sex,
                        "age": data.field.age
                    }),
                    success: function (res) {
                        console.log(res);
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
            }
        });

    });
</script>
</body>
</html>
