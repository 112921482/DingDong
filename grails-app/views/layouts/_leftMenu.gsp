<nav class="navbar-default navbar-static-side" role="navigation">
    <div class="sidebar-collapse">
        <ul class="nav metismenu" id="side-menu">
            <li class="${controllerName.equals("welcome") ? 'active' : ''}">
                <g:link controller="welcome"><i class="fa fa-diamond"></i> <span class="nav-label">总揽</span></g:link>
            </li>
            <li class="${controllerName.equals("mealMenu") ? 'active' : ''}">
                <a><i class="fa fa-th-large"></i> <span class="nav-label">送餐菜单</span> <span
                        class="fa arrow"></span></a>
                <ul class="nav nav-second-level">
                    <li><a href="index.html">维护</a></li>
                    <li><a href="dashboard_2.html">发布</a></li>
                </ul>
            </li>
        </ul>
    </div>
</nav>