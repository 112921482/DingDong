/**
 * 已发布菜单首页
 * Created by DengYang on 2016/5/12.
 */
$(document).ready(function () {

    /**
     * 下架按钮点击
     */
    $(".menu_disable").click(function () {
        var releaseMenuDetailId = $(this).attr("release_menu_detail_id");
        swal({
            title: "你确定要这么做？",
            type: "warning",
            showCancelButton: true,
            confirmButtonColor: "#DD6B55",
            confirmButtonText: "是的!",
            cancelButtonText: "我再想想",
            closeOnConfirm: false
        }, function () {
            $.getJSON(
                "updateSellStatus",
                {
                    id: releaseMenuDetailId,
                    enable: false
                },
                function (result) {
                    if (result["result"] == true) {
                        swal({
                            title: "已下架！",
                            type: "success"
                        }, function () {
                            location.reload();
                        });
                    }
                }
            )
        });
    });

    $(".menu_enable").click(function () {
        var releaseMenuDetailId = $(this).attr("release_menu_detail_id");
        swal({
            title: "你确定要这么做？",
            type: "warning",
            showCancelButton: true,
            confirmButtonColor: "#DD6B55",
            confirmButtonText: "是的!",
            cancelButtonText: "我再想想",
            closeOnConfirm: false
        }, function () {
            $.getJSON(
                "updateSellStatus",
                {
                    id: releaseMenuDetailId,
                    enable: true
                },
                function (result) {
                    if (result["result"] == true) {
                        swal({
                            title: "已上架！",
                            type: "success"
                        }, function () {
                            location.reload();
                        });
                    }
                }
            )
        });
    })
});