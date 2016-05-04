<!DOCTYPE html>
<html>

<head>
    <meta name="layout" content="main"/>
    <title>首页</title>
    <asset:stylesheet src="css/plugins/dropzone/basic.css"/>
    <asset:stylesheet src="css/plugins/dropzone/dropzone.css"/>
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
            <a data-toggle="modal" href="form_basic.html#modal-form" class="btn btn-block btn-primary compose-mail"
               href="javascript:void(0);">新建菜单</a>
        </div>

        <div id="modal-form" class="modal fade" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-body">
                        <div class="row">
                            <div class="col-sm-12">
                                <h3 class="m-t-none m-b">新建菜单</h3>

                                <p>新建菜单的名字、价格以及图片</p>

                                <form role="form">
                                    <div class="form-group">
                                        <label>菜名</label>
                                        <input id="menuName" name="menuName" type="text" placeholder="请输入菜名"
                                               class="form-control" required>
                                    </div>

                                    <div class="form-group">
                                        <label>价格</label>
                                        <input id="menuPrice" name="menuPrice" type="number" placeholder="请输入价格"
                                               class="form-control" step="0.01" min="0.01" required>
                                    </div>

                                    <div class="form-group">

                                        <label>上传配图</label>

                                        <p>仅支持上传一张图片</p>

                                        <div id="my-awesome-dropzone" class="dropzone">
                                            <div class="dropzone-previews"></div>

                                            <div class="dz-message">把要上传的图片扔进来或者点击选择要上传的文件</div>
                                        </div>
                                    </div>

                                    <div>
                                        <button class="btn btn-sm btn-primary pull-right m-t-n-xs"
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

                        <div class="product-imitation" style="padding-top: 0px;padding-bottom: 0px;">
                            <img style="height: 100%;width: 100%;"
                                 src="${grailsApplication.config.picShowPath + mealMenu.getMealPics()[0].getPicUrl()}">
                        </div>

                        <div class="product-desc">
                            <span class="product-price">
                                ￥${mealMenu.price}
                            </span>
                            %{--<small class="text-muted">Category</small>--}%
                            <a href="ecommerce_products_grid.html#" class="product-name">${mealMenu.getName()}</a>


                            %{--<div class="small m-t-xs">--}%
                                %{--Many desktop publishing packages and web page editors now.--}%
                            %{--</div>--}%

                            <div class="m-t text-righ">

                                <a href="ecommerce_products_grid.html#"
                                   class="btn btn-xs btn-outline btn-primary">Info <i
                                        class="fa fa-long-arrow-right"></i></a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </g:each>
    </div>
</div>

<!-- Mainly scripts -->
<asset:javascript src="jquery-2.2.3.min.js"/>
<asset:javascript src="bootstrap.min.js"/>
<asset:javascript src="plugins/metisMenu/jquery.metisMenu.js"/>
<asset:javascript src="plugins/slimscroll/jquery.slimscroll.min.js"/>

<!-- Custom and plugin javascript -->
<asset:javascript src="inspinia.js"/>
<asset:javascript src="plugins/pace/pace.min.js"/>

<!-- DROPZONE -->
<asset:javascript src="plugins/dropzone/dropzone.js"/>

<script>
    $(document).ready(function () {

        Dropzone.options.myAwesomeDropzone = {

            url: "saveMenu",
            autoProcessQueue: false,
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
                document.querySelector("button[type=submit]").addEventListener("click", function (e) {
                    e.preventDefault();
                    e.stopPropagation();
                    myDropzone.processQueue();
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
                //表单提交数组组装
                this.on("sending", function (file, xhr, formData) {
                    //菜名
                    formData.append("menuName", $("#menuName").val());
                    //菜价
                    formData.append("menuPrice", $("#menuPrice").val());
                });
                //生成缩略图时调用，用来判断分辨率，高宽比
                this.on("thumbnail", function (file, dataUrl) {
                    if ((file.width / 16) != (file.height / 9)) {
                        myDropzone.removeFile(file);
                    }
                });
            }

        }

    });
</script>
</body>
</html>
