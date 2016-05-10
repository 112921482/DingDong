/**
 * 菜单维护
 * Created by DengYang on 2016/5/9.
 */
$(document).ready(function () {

    /**
     * 表单验证
     */
    var menuForm = $("#menuForm");

    var createValidator = menuForm.validate({
        rules: {
            menuName: {
                required: true
            },
            menuPrice: {
                required: true
            },
            savePathString: {
                required: true
            }
        },
        messages: {
            menuName: {
                required: "这菜总有个名字吧！"
            },
            menuPrice: {
                number: "请输入一个有效的数字！",
                min: "请填写一个有效价格！",
                max: "请填写一个大家能够消费的价格！",
                step: "仅支持到“分”的支付金额",
                required: "不是说不能免费，但是你写个0我才好处理你说是不？"
            },
            savePathString: {
                required: "没图我怎么有食欲？！"
            }
        }, submitHandler: function (form) {
            $(form).ajaxSubmit({
                success: function (data) {
                    if (data["result"] == true) {
                        swal({
                            title: "已添加！",
                            type: "success"
                        }, function () {
                            location.reload();
                        });
                    } else {
                        swal({
                            title: "添加失败！",
                            type: "error"
                        });
                    }
                }
            });
            return false;
        }
    });

    /**
     * 删除菜单
     */
    $(".deleteMenu").on("click", function () {
        var menuId = $(this).attr("menu_id");
        swal({
            title: "你确定要这么做？",
            text: "你将无法恢复这道菜！",
            type: "warning",
            showCancelButton: true,
            confirmButtonColor: "#DD6B55",
            confirmButtonText: "是的!",
            cancelButtonText: "我再想想",
            closeOnConfirm: false
        }, function () {
            $.getJSON(
                "deleteMenu",
                {
                    id: menuId
                },
                function (result) {
                    if (result["result"] == true) {
                        swal({
                            title: "已删除！",
                            type: "success"
                        }, function () {
                            location.reload();
                        });
                    }
                }
            )
        });
    });

    //上传数量限制
    var maxFiles = 1;

    /**
     * 上传控件初始化（新建）
     */
    Dropzone.options.myAwesomeDropzone = {

        url: "uploadMenuPic",
        method: "post",
        autoProcessQueue: true,
        uploadMultiple: true,
        parallelUploads: 100,
        maxFiles: maxFiles,
        addRemoveLinks: true,
        acceptedFiles: "image/*",
        dictInvalidFileType: "只接受后缀为BMP、JPG、JPEG、PNG、GIF等文件",
        dictRemoveFile: "取消上传",

        // Dropzone settings
        init: function () {
            var myDropzone = this;
            //每次点击都会重置上传插件
            $("#modal-form").on("hidden.bs.modal", function () {
                //重置菜名
                $("#menuName").val("");
                //重置价格
                $("#menuPrice").val("");
                myDropzone.removeAllFiles();
                createValidator.resetForm();
            });
            this.on("sendingmultiple", function () {
            });
            this.on("successmultiple", function (files, response) {
            });
            this.on("errormultiple", function (files, response) {
            });
            this.on("success", function (file, data) {
                if (data["result"] == true) {
                    var savePathString = "";
                    $.each(data["savePathList"], function (name, value) {
                        savePathString = savePathString + value + ",";
                    });
                    $("#savePathString").val(savePathString);
                    createValidator.element("#savePathString");
                    //不能继续上传，目前仅支持上传一个图片
                    if (myDropzone.getAcceptedFiles().length >= maxFiles) {
                        myDropzone.disable();
                    }
                }
            });
            this.on("removedfile", function () {
                var savePathStringElm = $("#savePathString");
                //每次删除后，重新初始化savePathString
                savePathStringElm.val("");
                var acceptedFiles = myDropzone.getAcceptedFiles();
                var savePathString = "";
                $.each(acceptedFiles, function () {
                    var data = jQuery.parseJSON(this.xhr.responseText);
                    savePathString = savePathString + data["savePathList"][0] + ",";
                });
                savePathStringElm.val(savePathString);
                createValidator.element("#savePathString");
                if (myDropzone.getAcceptedFiles().length < maxFiles) {
                    myDropzone.enable();
                }
            });
        }

    };

    /**
     * 上传控件初始化（编辑）
     */
    Dropzone.options.myAwesomeDropzoneToEdit = {

        url: "uploadMenuPic",
        method: "post",
        autoProcessQueue: true,
        uploadMultiple: true,
        parallelUploads: 100,
        maxFiles: maxFiles,
        addRemoveLinks: true,
        acceptedFiles: "image/*",
        dictInvalidFileType: "只接受后缀为BMP、JPG、JPEG、PNG、GIF等文件",
        dictRemoveFile: "取消上传",

        // Dropzone settings
        init: function () {
            var myDropzone = this;
            //每次点击都会重置上传插件
            $("#modal-form").on("hidden.bs.modal", function () {
                //重置菜名
                $("#menuName").val("");
                //重置价格
                $("#menuPrice").val("");
                myDropzone.removeAllFiles();
            });
            this.on("sendingmultiple", function () {
            });
            this.on("successmultiple", function (files, response) {
            });
            this.on("errormultiple", function (files, response) {
            });
            this.on("success", function (file, data) {
                if (data["result"] == true) {
                    var savePathString = "";
                    $.each(data["savePathList"], function (name, value) {
                        savePathString = savePathString + value + ",";
                    });
                    $("#savePathString").val(savePathString);
                    //不能继续上传，目前仅支持上传一个图片
                    if (myDropzone.getAcceptedFiles().length >= maxFiles) {
                        myDropzone.disable();
                    }
                }
            });
            this.on("removedfile", function () {
                var savePathStringElm = $("#savePathString");
                //每次删除后，重新初始化savePathString
                savePathStringElm.val("");
                var acceptedFiles = myDropzone.getAcceptedFiles();
                var savePathString = "";
                $.each(acceptedFiles, function () {
                    var data = jQuery.parseJSON(this.xhr.responseText);
                    savePathString = savePathString + data["savePathList"][0] + ",";
                });
                savePathStringElm.val(savePathString);
                if (myDropzone.getAcceptedFiles().length < maxFiles) {
                    myDropzone.enable();
                }
            });
        }
    };

    $(".updateBtn").click(function () {
        //菜ID
        var menuId = $(this).attr("menu_id");
        //菜名称
        var menuName = $(this).attr("menu_name");
        //菜价格
        var menuPrice = $(this).attr("menu_price");
        //菜图片
        var menuPic = $(this).attr("menu_pic");
        //为编辑modal赋值
        var menuFormToEdit = $("#menuFormToEdit");
        menuFormToEdit.find("#menuNameToEdit").val(menuName);
        menuFormToEdit.find("#menuPriceToEdit").val(menuPrice);
        menuFormToEdit.find("#menuPicToShow").attr("src", menuPic);

    });
});