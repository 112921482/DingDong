<!DOCTYPE html>
<html lang="zh-cmn-Hans">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <asset:link rel="icon" href="favicon.ico" type="image/x-ico"/>

    <title><g:meta name="info.project.name"/></title>

    <!-- Bootstrap core CSS -->
    <asset:stylesheet src="bootstrap.min.css"/>

    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <asset:stylesheet src="bugFix/ie10-viewport-bug-workaround.css"/>

    <!-- Custom styles for this template -->
    <asset:stylesheet src="jumbotron.css"/>


    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <asset:javascript src="bugFix/html5shiv.min.js"/>
    <asset:javascript src="bugFix/respond.min.js"/>
    <![endif]-->
</head>

<body>

<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar"
                    aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#"><g:meta name="info.project.name"/></a>
        </div>

        <div id="navbar" class="navbar-collapse collapse">
            <g:if test='${flash.message}'>
                <small class="navbar-brand" style="font-size: 12px!important; color: red;padding: 15px 0!important;">${flash.message}</small>
            </g:if>
            <form action="${postUrl ?: '/login/authenticate'}" method="POST" id="loginForm" autocomplete="off"
                  class="navbar-form navbar-right">
                <div class="form-group">
                    <input type="text" placeholder="<g:message code='springSecurity.login.username.label'/>"
                           class="form-control" name="username" id="username"/>
                </div>

                <div class="form-group">
                    <input type="password" placeholder="<g:message code='springSecurity.login.password.label'/>"
                           class="form-control" name="password" id="password">
                </div>

                <button type="submit" id="submit" class="btn btn-success"><g:message
                        code='springSecurity.login.button'/></button>
            </form>
        </div><!--/.navbar-collapse -->
    </div>
</nav>

<!-- Main jumbotron for a primary marketing message or call to action -->
<div class="jumbotron">
    <div class="container">
        <h1>Hello, world!</h1>

        <p>This is a template for a simple marketing or informational website. It includes a large callout called a jumbotron and three supporting pieces of content. Use it as a starting point to create something more unique.</p>

        <p><a class="btn btn-primary btn-lg" href="#" role="button">Learn more &raquo;</a></p>
    </div>
</div>

<div class="container">
    <!-- Example row of columns -->
    <div class="row">
        <div class="col-md-4">
            <h2>Heading</h2>

            <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui.</p>

            <p><a class="btn btn-default" href="#" role="button">View details &raquo;</a></p>
        </div>

        <div class="col-md-4">
            <h2>Heading</h2>

            <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui.</p>

            <p><a class="btn btn-default" href="#" role="button">View details &raquo;</a></p>
        </div>

        <div class="col-md-4">
            <h2>Heading</h2>

            <p>Donec sed odio dui. Cras justo odio, dapibus ac facilisis in, egestas eget quam. Vestibulum id ligula porta felis euismod semper. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus.</p>

            <p><a class="btn btn-default" href="#" role="button">View details &raquo;</a></p>
        </div>
    </div>

    <hr>

    <footer>
        <p>&copy; 2015 Company, Inc.</p>
    </footer>
</div> <!-- /container -->


<!-- Bootstrap core JavaScript
    ================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<asset:javascript src="jquery-1.12.3.min.js"/>
<asset:javascript src="bootstrap.min.js"/>
<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<asset:javascript src="bugFix/ie10-viewport-bug-workaround.js"/>
</body>
</html>