<!DOCTYPE html>
<html lang="zh-cmn-Hans">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0">
    <title>WeUI</title>
    <asset:stylesheet src="wechat/weui.min.css"/>
    <asset:stylesheet src="wechat/example.css"/>
</head>

<body ontouchstart="">
<div class="hd">
    <h1 class="page_title">Panel</h1>
</div>

<div class="bd">
    <div class="weui_panel">
        <div class="weui_panel_hd">图文组合列表</div>

        <div class="weui_panel_bd">
            <g:each in="${releaseMenuList}" var="releaseMenu">
                <g:each in="${releaseMenu.getReleaseMenuDetails()}" var="releaseMenuDetails">
                    <a href="javascript:void(0);" class="weui_media_box weui_media_appmsg">
                        <div class="weui_media_hd">
                            <img class="weui_media_appmsg_thumb"
                                 src="${webRequest.getBaseUrl().replace("8090", "8080") + "/images/" + releaseMenuDetails.getMealMenu().getMealPics().getAt(0).getPicUrl()}"
                                 alt="">
                        </div>

                        <div class="weui_media_bd">
                            <h4 class="weui_media_title">${releaseMenuDetails.getMealMenu().getName()}</h4>

                            <p class="weui_media_desc">由各种物质组成的巨型球状天体，叫做星球。星球有一定的形状，有自己的运行轨道。</p>
                        </div>
                    </a>
                </g:each>
            </g:each>
        </div>
    </div>
</div>
</body>
</html>
