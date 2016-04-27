<!DOCTYPE html>
<html lang="zh-cmn-Hans">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title><g:meta name="info.project.name"/></title>

    <asset:stylesheet src="css/bootstrap.min.css"/>
    <asset:stylesheet src="font-awesome/css/font-awesome.css"/>
    
    <asset:stylesheet src="css/animate.css"/>
    <asset:stylesheet src="css/style.css"/>

</head>

<body class="gray-bg">

<div class="middle-box text-center loginscreen animated fadeInDown">
    <div>
        <div>

            %{--<h1 class="logo-name"><asset:image src="logo.jpg"/></h1>--}%
            <asset:image src="logo.jpg" style="width: 300px;"/>
        </div>

        <h3>A.山海經——美食外卖</h3>

        <p>唯美食与爱情不可辜负</p>

        <form class="m-t" role="form" action="${postUrl ?: '/login/authenticate'}" method="POST" id="loginForm"
              autocomplete="off">
            <div class="form-group">
                <input type="text" class="form-control"
                       placeholder="<g:message code='springSecurity.login.username.label'/>" required="" name="username"
                       id="username">
            </div>

            <div class="form-group">
                <input type="password" class="form-control"
                       placeholder="<g:message code='springSecurity.login.password.label'/>" required="" name="password"
                       id="password">
            </div>
            <button type="submit" class="btn btn-primary block full-width m-b"><g:message
                    code='springSecurity.login.button'/></button>

            %{--<a href="login.html#"><small>Forgot password?</small></a>--}%

            %{--<p class="text-muted text-center"><small>Do not have an account?</small></p>--}%
            %{--<a class="btn btn-sm btn-white btn-block" href="register.html">Create an account</a>--}%
        </form>

        %{--<p class="m-t"><small>Inspinia we app framework base on Bootstrap 3 &copy; 2014</small></p>--}%
    </div>
</div>

<!-- Mainly scripts -->
<asset:javascript src="jquery-2.2.3.min.js"/>
<asset:javascript src="bootstrap.min.js"/>

</body>

</html>
