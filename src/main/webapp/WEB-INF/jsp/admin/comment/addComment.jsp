<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>addComment</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/layui/2.6.4/css/layui.css" media="all">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/layui/2.6.4/layui.js" charset="utf-8"></script>
</head>
<body>
<form class="layui-form" action="" method="post" lay-filter="example" onsubmit="return false" enctype="multipart/form-data">
    <div class="layui-form-item">
        <label class="layui-form-label">用户id</label>
        <div class="layui-input-block">
            <input type="text" name="userId" lay-verify="title" autocomplete="off" placeholder="请输入发布者id"
                   class="layui-input" required>
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">文章id</label>
        <div class="layui-input-block">
            <input type="text" name="articleId" lay-verify="title" autocomplete="off" placeholder="请输入文章id"
                   class="layui-input" required>
        </div>
    </div>

    <div class="layui-form-item layui-form-text">
        <label class="layui-form-label">评论内容</label>
        <div class="layui-input-block">
            <textarea name="content" placeholder="请输入评论" class="layui-textarea"></textarea>
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

        //监听提交
        form.on('submit(demo1)', function (data) {
            var imgUrl = $("#user_imgUrl").attr("src");
            if (data.field.userId == "")
                return false;
            else {
                $.ajax({
                    type: "post",
                    url: "${pageContext.request.contextPath}/comment/addComment",
                    dataType: "json",
                    contentType: "application/json; charset=utf-8",
                    data: JSON.stringify({
                        "content": data.field.content,
                        "userId": data.field.userId,
                        "articleId":data.field.articleId
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
            }
        });

    });
</script>
</body>
</html>
