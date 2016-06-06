<!DOCTYPE html>
<html>

<head>
    <meta name="layout" content="main"/>
    <title><g:meta name="info.project.name"/>-维护菜单</title>
    <asset:stylesheet src="css/plugins/dropzone/basic.css"/>
    <asset:stylesheet src="css/plugins/dropzone/dropzone.css"/>
    <!-- Sweet Alert -->
    <asset:stylesheet src="css/plugins/sweetalert/sweetalert.css"/>
    <!-- CheckBox -->
    <asset:stylesheet src="css/plugins/iCheck/custom.css"/>
    <asset:stylesheet src="css/plugins/awesome-bootstrap-checkbox/awesome-bootstrap-checkbox.css"/>
    <style>
    .dropzone {
        min-height: 270px;
    }
    </style>
</head>

<body>
<div class="row wrapper border-bottom white-bg page-heading">
    <div class="col-lg-10">
        <h2>维护菜单</h2>
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
    <g:if test="${flash.type == 'error'}">
        <div class="row">
            <div class="col-lg-12">
                <div class="alert alert-danger alert-dismissable">
                    <button aria-hidden="true" data-dismiss="alert" class="close" type="button">×</button>
                    ${flash.message}
                </div>
            </div>
        </div>
    </g:if>
    <g:elseif test="${flash.type == 'success'}">
        <div class="row">
            <div class="col-lg-12">
                <div class="alert alert-success alert-dismissable">
                    <button aria-hidden="true" data-dismiss="alert" class="close" type="button">×</button>
                    ${flash.message.toString()}<g:link controller='release' action='index'
                                                       class='alert-link'>《已发布菜单》</g:link>
                </div>
            </div>
        </div>
    </g:elseif>
    <div class="row">

        <div class="col-lg-3">
            <a data-toggle="modal" href="#modal-form" class="btn btn-w-m btn-primary"
               id="createMenu">新建菜单</a>
            <a class="btn btn-w-m btn-success"
               id="releaseMenu">发布菜单</a>
        </div>
    </div>
</div>

<div class="wrapper wrapper-content animated fadeIn">
    <div class="row">
        <g:each in="${mealMenuList}" var="mealMenu">
            <div class="col-md-4 menuPanel">
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
                                <button class="btn btn-sm btn-info updateBtn" type="button" data-toggle="modal"
                                        data-target="#modal-edit-form"
                                        menu_id="${mealMenu.getId()}"
                                        menu_name="${mealMenu.getName()}"
                                        menu_price="${mealMenu.getPrice()}"
                                        menu_pic="${mealMenu.getMealPics().size() > 0 ? grailsApplication.config.picShowPath + mealMenu.getMealPics().getAt(0).getPicUrl() : ''}">
                                    <i class="fa fa-paste"></i>
                                    <span class="bold">编辑</span>
                                </button>
                                <button class="btn btn-sm btn-warning deleteMenu" type="button"
                                        menu_id="${mealMenu.getId()}">
                                    <i class="fa fa-warning"></i>
                                    <span class="bold">删除</span>
                                </button>
                                <label class="pull-right">
                                    <div class="icheckbox_square-green" style="position: relative;">
                                        <input type="checkbox" class="i-checks" style="position: absolute; opacity: 0;"
                                               menu_id="${mealMenu.getId()}">
                                        <ins class="iCheck-helper"
                                             style="position: absolute; top: 0%; left: 0%; display: block; width: 100%; height: 100%; margin: 0px; padding: 0px; border: 0px; opacity: 0; background: rgb(255, 255, 255);"></ins>
                                    </div> 选中我发布
                                </label>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </g:each>
    </div>
</div>

<!-- 新建菜单模态框 -->
<div id="modal-form" class="modal fade" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-body">
                <div class="row">
                    <div class="col-sm-12">
                        <h3 class="m-t-none m-b">新建菜单</h3>

                        <p>新建菜单的名字、价格以及图片</p>

                        <form role="form" id="menuForm" action="saveMenu" method="post">
                            <div class="form-group">
                                <label>菜名</label>
                                <input id="menuName" name="menuName" type="text" placeholder="请输入菜名"
                                       class="form-control">
                            </div>

                            <div class="form-group">
                                <label>价格</label>
                                <input id="menuPrice" name="menuPrice" type="number" placeholder="请输入价格"
                                       class="form-control" min="0" max="1000000" step="0.01">
                            </div>

                            <div class="form-group">

                                <label>上传配图</label>

                                <p>仅支持上传一张图片（建议图片比例为16:9，这样能够在移动端有更好的显示效果）</p>

                                <div id="my-awesome-dropzone" class="dropzone">
                                    <div class="dropzone-previews"></div>

                                    <div class="dz-message">把要上传的图片扔进来或者点击选择要上传的文件</div>

                                </div>
                                <input id="savePathString" name="savePathString" type="text"
                                       placeholder="请上传图片" class="form-control"
                                       style="position: absolute;width: 100px;margin-top: -35px;
                                       z-index: -1;">
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

<!-- 编辑菜单模态框 -->
<div id="modal-edit-form" class="modal fade" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-body">
                <form role="form" id="menuFormToEdit" action="updateMenu" method="post">
                    <g:hiddenField name="menuId"/>
                    <div class="row">
                        <div class="col-sm-6 b-r">
                            <h3 class="m-t-none m-b">编辑菜单</h3>

                            <p>编辑菜单的名字、价格以及图片</p>

                            <div class="form-group">
                                <label>菜名</label>
                                <input id="menuNameToEdit" name="menuNameToEdit" type="text" placeholder="请输入菜名"
                                       class="form-control">
                            </div>

                            <div class="form-group">
                                <label>价格</label>
                                <input id="menuPriceToEdit" name="menuPriceToEdit" type="number" placeholder="请输入价格"
                                       class="form-control" min="0" max="1000000" step="0.01">
                            </div>
                        </div>

                        <div class="col-sm-6">
                            <h3 class="m-t-none m-b">已上传图片</h3>

                            <p>修改后将无法恢复该图</p>
                            <img src="" style="height: 100%;width: 100%" id="menuPicToShow">
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-sm-12">
                            <div class="form-group">

                                <label>上传配图</label>

                                <p>仅支持上传一张图片（建议图片比例为16:9，这样能够在移动端有更好的显示效果）</p>

                                <div id="my-awesome-dropzone-to-edit" class="dropzone">
                                    <div class="dropzone-previews"></div>

                                    <div class="dz-message">把要上传的图片扔进来或者点击选择要上传的文件</div>

                                </div>
                                <input id="savePathStringToEdit" name="savePathStringToEdit" type="text"
                                       placeholder="请上传图片" class="form-control"
                                       style="position: absolute;width: 100px;margin-top: -35px;
                                       z-index: -1;">
                            </div>

                            <div>
                                <button class="btn btn-sm btn-primary pull-right m-t-n-xs"
                                        type="submit"><strong>提交</strong></button>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

<div id="selectedMenuTemplate"></div>

<!-- DROPZONE -->
<asset:javascript src="plugins/dropzone/dropzone.js"/>

<!-- Sweet alert -->
<asset:javascript src="plugins/sweetalert/sweetalert.min.js"/>

<!-- Jquery Validate -->
<asset:javascript src="plugins/jquery-ui/jquery-ui.min.js"/>
<asset:javascript src="plugins/validate/jquery.validate.min.js"/>
<asset:javascript src="plugins/validate/jquery.form.min.js"/>

<!-- 页面js -->
<asset:javascript src="js/maintenance/maintenance_view_index.js"/>

<!-- iCheck -->
<asset:javascript src="plugins/iCheck/icheck.min.js"/>
</body>
</html>
