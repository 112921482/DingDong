<!DOCTYPE html>
<html lang="zh-cmn-Hans">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0">
    <title>WeUI</title>
    <asset:stylesheet src="wechat/weui.min.css"/>
    <asset:stylesheet src="wechat/example.css"/>
    <asset:stylesheet src="font-awesome/css/font-awesome.min.css"/>
    <style>
    .weui_media_box {
        padding: 0 !important;
    }
    </style>
</head>

<body ontouchstart="">
<div class="container" id="container">
    <div class="hd">
        <h1 class="page_title">Panel</h1>
    </div>

    <div class="bd">

        <div class="weui_panel">
            %{--<div class="weui_panel_hd">图文组合列表</div>--}%
            <div class="weui_panel_bd">
                <g:each in="${releaseMenuList}" var="releaseMenu">
                    <g:each in="${releaseMenu.getReleaseMenuDetails()}" var="releaseMenuDetails">
                        <a href="javascript:void(0);" class="weui_media_box weui_media_appmsg">
                            <img class="weui_media_appmsg_thumb"
                                 src="${webRequest.getBaseUrl().replace("8090", "8080") + "/images/" + releaseMenuDetails.getMealMenu().getMealPics().getAt(0).getPicUrl()}"
                                 alt="">
                        </a>

                        <div class="weui_media_box weui_media_text">
                            <h4 class="weui_media_title w_50 f_l">标题一</h4>

                            <div class="f_r">
                                <a href="javascript:;" class="weui_btn weui_btn_mini weui_btn_primary">
                                    <i class="fa fa-plus"></i>
                                </a>
                                <a href="javascript:;" class="weui_btn weui_btn_mini weui_btn_primary">
                                    <i class="fa fa-minus"></i>
                                </a>
                            </div>

                            <p class="weui_media_desc w_100">由各种物质组成的巨型球状天体，叫做星球。星球有一定的形状，有自己的运行轨道。</p>
                            <ul class="weui_media_info">
                                <li class="weui_media_info_meta">文字来源</li>
                                <li class="weui_media_info_meta">时间</li>
                                <li class="weui_media_info_meta weui_media_info_meta_extra">

                                </li>
                            </ul>
                        </div>
                    </g:each>
                </g:each>
            </div>
        </div>
    </div>
</div>
</body>
</html>
