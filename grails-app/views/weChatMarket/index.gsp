<!DOCTYPE html>
<html lang="zh-cmn-Hans">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0">
    <title>WeUI</title>
    <asset:stylesheet src="wechat/weui.min.css"/>
    <asset:stylesheet src="wechat/example.css"/>
    <asset:stylesheet src="wechat/index.css"/>
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
        <h1 class="page_title">${grailsApplication.config.info.project.name}</h1>
    </div>

    <div class="bd">
        <g:each in="${releaseMenuDetailList}" var="releaseMenuDetail">
            <g:if test="${releaseMenuDetail.getEnable()}">
                <div class="weui_panel">
                    <div class="weui_panel_bd">
                        <a href="javascript:void(0);" class="weui_media_box weui_media_appmsg">
                            <asset:image src="loading.gif" class="w_100"/>
                        </a>
                    </div>

                    <div class="weui_panel_hd order_bar">
                        <div class="f_l">
                            ${releaseMenuDetail.getMealMenu().getName()}
                        </div>


                        <div class="f_r">
                            <button class="order_btn">+</button>
                            <span>0</span>
                            <button class="order_btn">-</button>
                        </div>

                        <div class="f_r m_r_2">
                            ¥${releaseMenuDetail.getPrice()}元/份
                        </div>
                    </div>
                </div>
            </g:if>
        </g:each>
    </div>
</div>
</body>
</html>