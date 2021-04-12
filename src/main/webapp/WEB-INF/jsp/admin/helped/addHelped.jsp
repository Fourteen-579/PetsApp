<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>addHelped</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/layui/2.6.4/css/layui.css" media="all">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/layui/2.6.4/layui.js" charset="utf-8"></script>
</head>
<body>
<form class="layui-form" action="" method="post" lay-filter="example" onsubmit="return false" enctype="multipart/form-data">
    <div class="layui-form-item">
        <label class="layui-form-label">救助者id</label>
        <div class="layui-input-block">
            <input type="text" name="helpId" lay-verify="title" autocomplete="off" placeholder="请输入救助者id"
                   class="layui-input" required>
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">发布者id</label>
        <div class="layui-input-block">
            <input type="text" name="publisherId" lay-verify="title" autocomplete="off" placeholder="请输入发布者id"
                   class="layui-input" required>
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">昵称</label>
        <div class="layui-input-block">
            <input type="text" name="name" lay-verify="title" autocomplete="off" placeholder="请输入宠物昵称"
                   class="layui-input" required>
        </div>
    </div>


    <div class="layui-form-item">
        <label class="layui-form-label">类型</label>
        <div class="layui-input-block">
            <input type="text" name="type" lay-verify="title" autocomplete="off" placeholder="请输入宠物类型"
                   class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">年龄</label>
        <div class="layui-input-block">
            <input type="number" name="age" placeholder="请输入宠物年龄" autocomplete="off" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item layui-form-text">
        <label class="layui-form-label">救助经历</label>
        <div class="layui-input-block">
            <textarea name="experience" placeholder="请输入救助经历" class="layui-textarea"></textarea>
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">现状</label>
        <div class="layui-input-block">
            <input type="radio" name="state" value="已收养" title="已收养" checked="">
            <input type="radio" name="state" value="待收养" title="待收养">
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

    <div class="layui-inline">
        <label class="layui-form-label">日期时间选择器</label>
        <div class="layui-input-inline">
            <input type="text" name="time" class="layui-input" id="test5" placeholder="yyyy-MM-dd HH:mm:ss">
        </div>
    </div>



    <div class="layui-upload-drag" id="test10" style="margin-bottom: 10px; margin-left: 110px">
        <i class="layui-icon"></i>
        <p>点击上传，或将文件拖拽到此处</p>
        <div class="layui-hide" id="uploadDemoView">
            <hr>
            <img id="user_imgUrl" src="" alt="上传成功后渲染" style="max-width: 196px">
        </div>
    </div>

    <div class="layui-upload-drag" id="test10_2" style="margin-bottom: 10px; margin-left: 110px">
        <i class="layui-icon"></i>
        <p>点击上传，或将文件拖拽到此处</p>
        <div class="layui-hide" id="uploadDemoView2">
            <hr>
            <img id="user_imgUrl2" src="" alt="上传成功后渲染" style="max-width: 196px">
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
            , $ = layui.jquery
            ,upload = layui.upload
            ,laydate = layui.laydate;

        //日期时间选择器
        laydate.render({
            elem: '#test5'
            ,type: 'datetime'
        });

        //拖拽上传 前
        upload.render({
            elem: '#test10'
            ,url: '${pageContext.request.contextPath}/helped/uploadImg' //必填项
            ,method: 'post'  //可选项。HTTP类型，默认post
            , done: function (res) {
                layui.$('#uploadDemoView').removeClass('layui-hide').find('img').attr('src', res.data);
            }
        });

        //拖拽上传 后
        upload.render({
            elem: '#test10_2'
            ,url: '${pageContext.request.contextPath}/helped/uploadImg' //必填项
            ,method: 'post'  //可选项。HTTP类型，默认post
            , done: function (res) {
                layui.$('#uploadDemoView2').removeClass('layui-hide').find('img').attr('src', res.data);
            }
        });

        //监听提交
        form.on('submit(demo1)', function (data) {
            var imgUrl = $("#user_imgUrl").attr("src");
            var imgUrl2 = $("#user_imgUrl2").attr("src");
            console.log(data)
            if (data.field.publisherId == "" || data.field.helpId == "")
                return false;
            else {
                $.ajax({
                    type: "post",
                    url: "${pageContext.request.contextPath}/helped/addHelped",
                    dataType: "json",
                    contentType: "application/json; charset=utf-8",
                    data: JSON.stringify({
                        "preImgUrl":imgUrl,
                        "aftImgUrl":imgUrl2,
                        "time":data.field.time,
                        "name": data.field.name,
                        "helpId": data.field.helpId,
                        "experience": data.field.experience,
                        "publisherId": data.field.publisherId,
                        "type": data.field.type,
                        "age": data.field.age,
                        "state": data.field.state,
                        "location": data.field.location
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
