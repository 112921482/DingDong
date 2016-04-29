<!DOCTYPE html>
<html>

<head>
    <meta name="layout" content="main"/>
    <title>首页</title>
    <asset:stylesheet src="css/plugins/dropzone/basic.css"/>
    <asset:stylesheet src="css/plugins/dropzone/dropzone.css"/>
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
                            <div class="col-sm-6 b-r"><h3 class="m-t-none m-b">新建菜单</h3>

                                <p>新建菜单的名字、价格以及图片</p>

                                <form role="form">
                                    <div class="form-group">
                                        <label>菜名</label>
                                        <input type="text" placeholder="请输入菜名" class="form-control">
                                    </div>

                                    <div class="form-group">
                                        <label>价格</label>
                                        <input type="number" placeholder="请输入价格" class="form-control">
                                    </div>

                                    <div>
                                        <button class="btn btn-sm btn-primary pull-right m-t-n-xs"
                                                type="submit"><strong>提交</strong></button>
                                    </div>
                                </form>
                            </div>

                            <div class="col-sm-6"><h4>Not a member?</h4>

                                <p>You can create an account:</p>

                                <form id="my-awesome-dropzone" class="dropzone" action="form_file_upload.html#">
                                    <i class="fa fa-upload big-icon"></i>
                                    <div class="dropzone-previews"></div>
                                    %{--<button type="submit" class="btn btn-primary pull-right">Submit this form!</button>--}%
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
        <div class="col-md-3">
            <div class="ibox">
                <div class="ibox-content product-box">

                    <div class="product-imitation">
                        [ INFO ]
                    </div>

                    <div class="product-desc">
                        <span class="product-price">
                            ￥10
                        </span>
                        <small class="text-muted">Category</small>
                        <a href="ecommerce_products_grid.html#" class="product-name">Product</a>


                        <div class="small m-t-xs">
                            Many desktop publishing packages and web page editors now.
                        </div>

                        <div class="m-t text-righ">

                            <a href="ecommerce_products_grid.html#"
                               class="btn btn-xs btn-outline btn-primary">Info <i
                                    class="fa fa-long-arrow-right"></i></a>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div class="col-md-3">
            <div class="ibox">
                <div class="ibox-content product-box">

                    <div class="product-imitation">
                        [ INFO ]
                    </div>

                    <div class="product-desc">
                        <span class="product-price">
                            $10
                        </span>
                        <small class="text-muted">Category</small>
                        <a href="ecommerce_products_grid.html#" class="product-name">Product</a>


                        <div class="small m-t-xs">
                            Many desktop publishing packages and web page editors now.
                        </div>

                        <div class="m-t text-righ">

                            <a href="ecommerce_products_grid.html#"
                               class="btn btn-xs btn-outline btn-primary">Info <i
                                    class="fa fa-long-arrow-right"></i></a>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div class="col-md-3">
            <div class="ibox">
                <div class="ibox-content product-box active">

                    <div class="product-imitation">
                        [ INFO ]
                    </div>

                    <div class="product-desc">
                        <span class="product-price">
                            $10
                        </span>
                        <small class="text-muted">Category</small>
                        <a href="ecommerce_products_grid.html#" class="product-name">Product</a>


                        <div class="small m-t-xs">
                            Many desktop publishing packages and web page editors now.
                        </div>

                        <div class="m-t text-righ">

                            <a href="ecommerce_products_grid.html#"
                               class="btn btn-xs btn-outline btn-primary">Info <i
                                    class="fa fa-long-arrow-right"></i></a>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div class="col-md-3">
            <div class="ibox">
                <div class="ibox-content product-box">

                    <div class="product-imitation">
                        [ INFO ]
                    </div>

                    <div class="product-desc">
                        <span class="product-price">
                            $10
                        </span>
                        <small class="text-muted">Category</small>
                        <a href="ecommerce_products_grid.html#" class="product-name">Product</a>


                        <div class="small m-t-xs">
                            Many desktop publishing packages and web page editors now.
                        </div>

                        <div class="m-t text-righ">

                            <a href="ecommerce_products_grid.html#"
                               class="btn btn-xs btn-outline btn-primary">Info <i
                                    class="fa fa-long-arrow-right"></i></a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
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

            autoProcessQueue: false,
            uploadMultiple: true,
            parallelUploads: 100,
            maxFiles: 1,

            // Dropzone settings
            init: function () {
                var myDropzone = this;
//                this.element.querySelector("button[type=submit]")
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
            }

        }

    });
</script>
</body>
</html>
