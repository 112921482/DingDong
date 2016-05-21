<!DOCTYPE html>
<html lang="zh-cmn-Hans">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0">
    <title>WeUI</title>
    <asset:stylesheet src="wechat/weui.min.css"/>
    <asset:stylesheet src="wechat/example.css"/>
    <asset:stylesheet src="wechat/menu_list_view.css"/>
    <asset:stylesheet src="font-awesome/css/font-awesome.min.css"/>
    <style>
    .weui_media_box {
        padding: 0 !important;
    }
    </style>
</head>

<body ontouchstart="" class="m_b_50">
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

                    <div class="weui_panel_hd order_bar l_0">
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

    <div class="footer_submit_bar">
        <div class="footer_bar_msg">
            <div class="f_l">已点<span id="totalAmount">0</span>份，</div>

            <div class="f_l">共<span id="totalCost">0</span>元</div>
        </div>

        <div class="f_r">
            <a href="javascript:;" class="weui_btn weui_btn_primary b_d_0">马上下单</a>
        </div>

    </div>
</div>
</body>
</html>