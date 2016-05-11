<!DOCTYPE html>
<html>

<head>
    <meta name="layout" content="main"/>
    <title><g:meta name="info.project.name"/>-已发布菜单</title>
</head>

<body>
<div class="row wrapper border-bottom white-bg page-heading">
    <div class="col-lg-10">
        <h2>已发布菜单</h2>
        <ol class="breadcrumb">
            <li>
                <g:link controller="welcome">首页</g:link>
            </li>
            <li>
                <span>送餐菜单</span>
            </li>
            <li class="active">
                <strong>已发布菜单</strong>
            </li>
        </ol>
    </div>

    <div class="col-lg-2">

    </div>
</div>

<div class="wrapper wrapper-content animated fadeIn">

    <div class="p-w-md m-t-sm">
        <div class="row">
            <div class="col-lg-12">
                <div class="ibox">

                    <div class="ibox-content">

                        <div class="table-responsive">
                            <table class="table table-striped">
                                <thead>
                                <tr>
                                    <th>菜品名称</th>
                                    <th>供应时间段</th>
                                    <th>原价（元）</th>
                                    <th>出售价格（元）</th>
                                    <th>备货余量（份）</th>
                                </tr>
                                </thead>
                                <tbody>
                                <g:each in="${releaseMenuList}" var="releaseMenu">
                                    <g:each in="${releaseMenu.getReleaseMenuDetails()}" var="releaseMenuDetail">
                                        <tr>
                                            <td>${releaseMenuDetail.getMealMenu().getName()}</td>
                                            <g:if test="${releaseMenu.getType() == 0}">
                                                <td>全时段</td>
                                            </g:if>
                                            <g:elseif test="${releaseMenu.getType() == 1}">
                                                <td>早餐</td>
                                            </g:elseif>
                                            <g:elseif test="${releaseMenu.getType() == 2}">
                                                <td>午餐</td>
                                            </g:elseif>
                                            <g:elseif test="${releaseMenu.getType() == 3}">
                                                <td>晚餐</td>
                                            </g:elseif>
                                            <g:elseif test="${releaseMenu.getType() == 4}">
                                                <td>夜宵</td>
                                            </g:elseif>
                                            <td>￥${releaseMenuDetail.getMealMenu().getPrice()}</td>
                                            <td>￥${releaseMenuDetail.getPrice()}</td>
                                            <td>${releaseMenuDetail.getAmount()}</td>
                                        </tr>
                                    </g:each>
                                </g:each>
                                </tbody>
                            </table>
                        </div>

                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
