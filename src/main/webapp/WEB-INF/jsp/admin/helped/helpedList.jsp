<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>helpedList</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/layui/2.6.4/css/layui.css" media="all">
</head>
<body>

<table class="layui-hide" id="test3" lay-filter="test3"></table>


<script src="https://cdnjs.cloudflare.com/ajax/libs/layui/2.6.4/layui.js" charset="utf-8"></script>
<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>
<script>

    var tipsImgVal = null;

    function showImgTips(url) {
        layui.use('layer', function () {
            tipsImgVal = layer.tips('<img src="' + url + '" width="200px"/>', '#preImg', {
                tips: 4,
                anim: 5,
                tips: [4, 'rgba(255,255,255,0)']
            });
        })
    }

    function closeImgTips() {
        layer.close(tipsImgVal);
    }

    var tipsImgVal2 = null;

    function showImgTips2(url) {
        layui.use('layer', function () {
            tipsImgVal2 = layer.tips('<img src="' + url + '" width="200px"/>', '#afterImg', {
                tips: 4,
                anim: 5,
                tips: [4, 'rgba(255,255,255,0)']
            });
        })
    }

    function closeImgTips2() {
        layer.close(tipsImgVal2);
    }

    layui.use('table', function () {
        var table = layui.table,
            $ = layui.jquery;

        table.render({
            elem: '#test3'
            , url: '${pageContext.request.contextPath}/helped/queryByLimit'
            , cellMinWidth: 80 //全局定义常规单元格的最小宽度，layui 2.2.1 新增
            , cols: [[
                {field: 'id', width: 180, title: 'ID', sort: true}
                , {field: 'helpId', width: 80, title: '救援者id', edit: 'text'}
                , {field: 'publisherId', width: 80, title: '发布者id', sort: true, edit: 'text'}
                , {field: 'time', width: 80, title: '时间', sort: true, edit: 'text'}
                , {field: 'name', width: 80, title: '宠物昵称', edit: 'text'}
                , {field: 'type', width: 80, title: '宠物类型', edit: 'text'}
                , {field: 'age', width: 80, title: '宠物年龄', edit: 'text'}
                , {field: 'state', width: 80, title: '宠物现状', edit: 'text'}
                , {field: 'location', title: '所在地', width: 80, minWidth: 80, edit: 'text'} //minWidth：局部定义当前单元格的最小宽度，layui 2.2.1 新增
                , {field: 'experience', title: '救助经历', width: 100, minWidth: 100, edit: 'text'} //minWidth：局部定义当前单元格的最小宽度，layui 2.2.1 新增
                , {
                    field: 'imgUrl', title: '救助前照片',
                    templet: function (res) {
                        return '<img id="preImg" src="' + res.preImgUrl + '" onmouseover="showImgTips(\' ' + res.preImgUrl + ' \')" onmouseleave="closeImgTips()"/>';
                    }
                }
                , {
                    field: 'imgUrl', title: '救助后照片',
                    templet: function (res) {
                        return '<img id="afterImg" src="' + res.aftImgUrl + '" onmouseover="showImgTips2(\' ' + res.aftImgUrl + ' \')" onmouseleave="closeImgTips2()"/>';
                    }
                }
                , {fixed: 'right', title: '操作', width: 150, align: 'center', toolbar: '#barDemo'} //这里的toolbar值是模板元素的选择器
            ]]
            , page: true
        });

        //监听单元格编辑
        table.on('edit(test3)', function (obj) {
            var value = obj.value //得到修改后的值
                , data = obj.data //得到所在行所有键值
                , field = obj.field; //得到字段
            $.ajax({
                type: "PATCH",
                url: "${pageContext.request.contextPath}/helped/updateHelped",
                dataType: "json",
                contentType: "application/json; charset=utf-8",
                data: JSON.stringify({
                    "value": value,
                    "field": field,
                    "id": data.id
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

        //工具条事件（删除功能）
        table.on('tool(test3)', function (obj) { //注：tool 是工具条事件名，test 是 table 原始容器的属性 lay-filter="对应的值"
            var data = obj.data; //获得当前行数据
            var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
            if (layEvent === 'del') { //删除
                layer.confirm('真的删除行么', function (index) {
                    //向服务端发送删除指令
                    $.ajax({
                        type: "DELETE",
                        url: "${pageContext.request.contextPath}/helped/deleteHelped",
                        dataType: "json",
                        contentType: "application/json; charset=utf-8",
                        data: JSON.stringify({
                            "id": data.id
                        }),
                        success: function (res) {
                            if (res.code == 0) {
                                obj.del(); //删除对应行（tr）的DOM结构，并更新缓存
                                layer.close(index);
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
            }
        });
    });
</script>

</body>
</html>