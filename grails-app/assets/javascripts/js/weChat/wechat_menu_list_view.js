/**
 * 微信菜单列表页
 * Created by DengYang on 2016/5/21.
 */
$(document).ready(function () {
    $(".order_btn").click(function () {
        //按钮的父元素
        var parentElm = $(this).parent();
        //按钮中的计数器
        var amountAlone = parentElm.children("span");
        var amountAloneVal = parseInt(amountAlone.html());
        //底部中的计数器
        var amountTotal = $("#totalAmount");
        var amountTotalVal = parseInt(amountTotal.html());
        //底部中的总价
        var totalCost = $("#amountTotal");
        var totalCostVal = totalCost.html();
        //点击加号
        if ($(this).hasClass("add")) {
            amountAlone.html(amountAloneVal + 1);
            amountTotal.html(amountTotalVal + 1);
        }
        //点击减号
        if ($(this).hasClass("minus")) {
            if (amountAloneVal > 0) {
                amountAlone.html(amountAloneVal - 1);
            }
        }
    });
});