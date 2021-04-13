<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>addRescueInfor</title>
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
        <label class="layui-form-label">位置</label>
        <div class="layui-input-block">
            <input type="text" name="locale" lay-verify="title" autocomplete="off" placeholder="请输入发生地点"
                   class="layui-input" required>
        </div>
    </div>

    <div class="layui-form-item layui-form-text">
        <label class="layui-form-label">状态</label>
        <div class="layui-input-block">
            <textarea name="state" placeholder="请输入现在的状态" class="layui-textarea"></textarea>
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">发起人</label>
        <div class="layui-input-block">
            <select name="label1" lay-filter="aihao" id="label1">
                <option value="0">个人</option>
                <option value="1" selected="">组织</option>
            </select>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">供/需</label>
        <div class="layui-input-block">
            <select name="label2" lay-filter="aihao" id="label2">
                <option value="0">供应</option>
                <option value="1" selected="">需求</option>
            </select>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">类型</label>
        <div class="layui-input-block">
            <select name="label3" lay-filter="aihao" id="label3">
                <option value="0">其他</option>
                <option value="1">场地</option>
                <option value="2">资金</option>
                <option value="3" selected="">物资</option>
            </select>
        </div>
    </div>

    <div class="layui-form-item layui-form-text">
        <label class="layui-form-label">描述</label>
        <div class="layui-input-block">
            <textarea name="describe" placeholder="简述" class="layui-textarea"></textarea>
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
            var label = $("#label1 option:selected").val()+","+$("#label2 option:selected").val()+","+$("#label3 option:selected").val();
            if (data.field.userId == "")
                return false;
            else {
                $.ajax({
                    type: "post",
                    url: "${pageContext.request.contextPath}/rescueInfor/addRescueInfor",
                    dataType: "json",
                    contentType: "application/json; charset=utf-8",
                    data: JSON.stringify({
                        "locale": data.field.locale,
                        "userId": data.field.userId,
                        "state":data.field.state,
                        "label":label,
                        "describe":data.field.describe
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
