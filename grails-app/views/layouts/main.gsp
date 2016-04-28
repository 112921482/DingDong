<!DOCTYPE html>
<html lang="zh-cmn-Hans">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title><g:layoutTitle default="${grailsApplication.config.info?.project?.name}"/></title>

    <asset:stylesheet src="css/bootstrap.min.css"/>
    <asset:stylesheet src="font-awesome/css/font-awesome.css"/>

    <asset:stylesheet src="css/animate.css"/>
    <asset:stylesheet src="css/style.css"/>

    <g:layoutHead/>

    <style>
    body {
        font-family: "open sans", "Helvetica Neue", 微软雅黑, Arial, sans-serif;
    }
    </style>
</head>

<body>
<div id="wrapper">

    <g:render template="/layouts/leftMenu"/>

    <div id="page-wrapper" class="gray-bg">
        <g:render template="/layouts/header"/>

        <g:layoutBody/>

        <g:render template="/layouts/footer"/>
    </div>
</div>

</body>
</html>
