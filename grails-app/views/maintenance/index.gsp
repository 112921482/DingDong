<!DOCTYPE html>
<html>

<head>
    <meta name="layout" content="main"/>
    <title>首页</title>
    <asset:stylesheet src="css/plugins/dropzone/basic.css"/>
    <asset:stylesheet src="css/plugins/dropzone/dropzone.css"/>
    <!-- Sweet Alert -->
    <asset:stylesheet src="css/plugins/sweetalert/sweetalert.css"/>
    <style>
    #my-awesome-dropzone {
        min-height: 270px;
    }
    </style>
</head>

<body>
<div class="row wrapper border-bottom white-bg page-heading">
    <div class="col-lg-10">
        <h2>菜单维护</h2>
        <ol class="breadcrumb">
            <li>
                <g:link controller="welcome">首页</g:link>
            </li>
            <li>
                <span>送餐菜单</span>
            </li>
            <li class="active">
                <strong>菜单维护</strong>
            </li>
        </ol>
    </div>

    <div class="col-lg-2">

    </div>
</div>

<div class="wrapper wrapper-content" style="margin-bottom: -40px;">
    <div class="row">
        <div class="col-lg-1">
            <a data-toggle="modal" href="#modal-form" class="btn btn-block btn-primary compose-mail"
               id="createMenu">新建菜单</a>
        </div>

        <div id="modal-form" class="modal fade" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-body">
                        <div class="row">
                            <div class="col-sm-12">
                                <h3 class="m-t-none m-b">新建菜单</h3>

                                <p>新建菜单的名字、价格以及图片</p>

                                <form role="form" method="post" id="menuForm">
                                    <div class="form-group">
                                        <label>菜名</label>
                                        <input id="menuName" name="menuName" type="text" placeholder="请输入菜名"
                                               class="form-control">
                                    </div>

                                    <div class="form-group">
                                        <label>价格</label>
                                        <input id="menuPrice" name="menuPrice" type="number" placeholder="请输入价格"
                                               class="form-control" max="100000000" step="0.01" min="0.01">
                                    </div>

                                    <div class="form-group">

                                        <label>上传配图</label>

                                        <p>仅支持上传一张图片（建议图片比例为16:9，这样能够在移动端有更好的显示效果）</p>

                                        <div id="my-awesome-dropzone" class="dropzone">
                                            <div class="fallback">
                                                <input name="file" type="file" multiple/>
                                            </div>

                                            <div class="dropzone-previews"></div>

                                            <div class="dz-message">把要上传的图片扔进来或者点击选择要上传的文件</div>

                                        </div>
                                        <input id="savePathString" name="savePathString" type="text"
                                               placeholder="请上传图片" class="form-control" style="
                                        position: absolute;width: 100px;margin-top: -35px;z-index: -1;
                                        ">
                                    </div>

                                    <div>
                                        <button class="btn btn-sm btn-primary pull-right m-t-n-xs" id="submitBtn"
                                                type="submit"><strong>提交</strong></button>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<div class="wrapper wrapper-content animated fadeInRight">
    <div class="row">
        <g:each in="${mealMenuList}" var="mealMenu">
            <div class="col-md-3">
                <div class="ibox">
                    <div class="ibox-content product-box">
                        <g:if test="${mealMenu.getMealPics().size() > 0}">
                            <div class="product-imitation" style="padding-top: 0;padding-bottom: 0;">

                                <img style="height: 100%;width: 100%;"
                                     src="${grailsApplication.config.picShowPath + mealMenu.getMealPics().getAt(0).getPicUrl()}">

                            </div>
                        </g:if>
                        <g:else>
                            <div class="product-imitation">
                                [ 图没了 ]
                            </div>
                        </g:else>


                        <div class="product-desc">
                            <span class="product-price">
                                ￥${mealMenu.price}
                            </span>

                            <a href="javascript:void(0);" class="product-name">${mealMenu.getName()}</a>

                            <div class="m-t text-righ">
                                <button class="btn btn-info " type="button">
                                    <i class="fa fa-paste"></i>
                                    <span class="bold">编辑</span>
                                </button>
                                <button class="btn btn-warning deleteMenu" type="button" menu_id="${mealMenu.getId()}">
                                    <i class="fa fa-warning"></i>
                                    <span class="bold">删除</span>
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </g:each>
    </div>
</div>

<!-- DROPZONE -->
<asset:javascript src="plugins/dropzone/dropzone.js"/>

<!-- Sweet alert -->
<asset:javascript src="plugins/sweetalert/sweetalert.min.js"/>

<!-- Jquery Validate -->
<asset:javascript src="plugins/jquery-ui/jquery-ui.min.js"/>
<asset:javascript src="plugins/validate/jquery.validate.min.js"/>
<asset:javascript src="plugins/validate/jquery.form.min.js"/>

<script>
    $(document).ready(function () {

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
                                    title: "已删除!",
                                    text: "再也没有人能吃到这道菜了！",
                                    type: "success"
                                }, function () {
                                    location.reload();
                                });
                            }
                        }
                )
            });
        });


        /**
         * 上传控件初始化
         */
        Dropzone.options.myAwesomeDropzone = {

            url: "uploadMenuPic",
            method: "post",
            autoProcessQueue: true,
            uploadMultiple: true,
            parallelUploads: 100,
            maxFiles: 1,
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
                //当超出maxFiles时删除多余的上传文件
                this.on("maxfilesexceeded", function (file) {
                    myDropzone.removeFile(file);
                });
                this.on("success", function (file, data) {
                    if (data["result"] == true) {
                        var savePathString = "";
                        $.each(data["savePathList"], function (name, value) {
                            savePathString = savePathString + value + ",";
                        });
                        $("#savePathString").val(savePathString);
                    }
                });
            }

        };

        /**
         * 表单验证
         */
        var menuForm = $("#menuForm");
        menuForm.ajaxForm({
            url: "saveMenu",
            success: function (data) {
                if (data["result"] == true) {
                    swal({
                        title: "已添加!",
                        text: "再也没有人能吃到这道菜了！",
                        type: "success"
                    }, function () {
                        location.reload();
                    });
                }
            }
        });
        menuForm.validate({
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
                    required: "不是说不能免费，但是你写个0我才好处理你说是不？"
                },
                savePathString: {
                    required: "没图我怎么有食欲？！"
                }
            },
            submitHandler: function (form) {
                $(form).ajaxSubmit();
            }
        });
    });
</script>
</body>
</html>
