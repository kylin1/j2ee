<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="ch-ZN">
<head>
    <meta charset="utf-8" />
    <link rel="apple-touch-icon" sizes="76x76" href="../../assets/img/apple-icon.png" />
    <link rel="icon" type="image/png" href="../../assets/img/favicon.png" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

    <title>Pocket</title>

    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />


    <!-- Bootstrap core CSS     -->
    <link href="../../assets/css/bootstrap.min.css" rel="stylesheet" />

    <!--  Material Dashboard CSS    -->
    <link href="../../assets/css/material-dashboard.css" rel="stylesheet"/>

    <!--  CSS for Demo Purpose, don't include it in your project     -->
    <link href="../../assets/css/demo.css" rel="stylesheet" />

    <!--     Fonts and icons     -->
    <link href="http://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css" rel="stylesheet">
    <link href='http://fonts.googleapis.com/css?family=Roboto:400,700,300|Material+Icons' rel='stylesheet' type='text/css'>

</head>

<body>

<div class="wrapper">
    <!--整个左侧导航栏-->
    <div class="sidebar" data-color="purple" data-image="../assets/img/sidebar-1.jpg">

        <!--导航左上角的图标-->
        <div class="logo">
            <a href="search.html" class="simple-text">
                Hostel World
            </a>
        </div>

        <!--导航栏整体-->
        <div class="sidebar-wrapper"    >
            <ul class="nav">

                <li>
                    <a href="membership.jsp">
                        <i class="material-icons">today</i>
                        <p>Membership</p>
                    </a>
                </li>

                <!--这是一个导航的图标-->
                <li>
                    <a href="order.jsp">
                        <!-- 导航图标的样式-->
                        <i class="material-icons">timeline</i>
                        <!--显示的文字-->
                        <p>Orders</p>
                    </a>
                </li>

                <!--下面是其他的item代表更多的导航-->
                <li>
                    <a href="pocket.jsp">
                        <i class="material-icons">stars</i>
                        <p>Pocket</p>
                    </a>
                </li>
                <li>
                    <a href="profile.jsp">
                        <i class="material-icons">group</i>
                        <p>Profile</p>
                    </a>
                </li>

            </ul>
        </div>
    </div>

    <!--主体界面-->
    <div class="main-panel">
        <!--1.导航栏-->
        <nav class="navbar navbar-primary navbar-absolute">
            <div class="container-fluid">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="#">Hi, com.kylin :)</a>
                </div>
                <!--右侧三个小按钮-->
                <div class="collapse navbar-collapse" id="example-navbar-primary">
                    <ul class="nav navbar-nav navbar-right">

                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                <i class="material-icons">notifications</i>
                                <span class="notification">2</span>
                                <p class="hidden-lg hidden-md">Notifications</p>
                                Messages
                            </a>
                            <ul class="dropdown-menu">
                                <li><a href="#">You membership will come to an end soon!</a></li>
                                <li><a href="#">Invite your co-worker to join Hostel World and you’ll get ￥206 after their first trip.</a></li>
                            </ul>
                        </li>

                        <li class="active">
                            <a href="dashboard.jsp">
                                <i class="material-icons">account_circle</i>
                                Dashboard
                            </a>
                        </li>

                        <li>
                            <a href="#setting">
                                <i class="material-icons">settings</i>
                                Settings
                            </a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>

        <!--2.内容-->
        <div class="content">
            <div class="container-fluid">

                <!--recent order-->
                <div class="row">
                    <div class="col-md-8">
                        <div class="card">
                            <div class="card-header" data-background-color="purple">
                                <h4 class="title">账户充值</h4>
                            </div>

                            <div class="card-content">
                                <form action="{{ url('competition') }}" method="POST">

                                    <div class="row">
                                        <div class="col-sm-3">
                                            <label class="control-label">当前余额</label>
                                        </div>

                                        <div class="col-sm-3">
                                            <p class="text-info">￥800</p>
                                        </div>
                                    </div>

                                    <div class="row">

                                        <div class="col-sm-3">
                                            <label class="control-label">充值金额(￥)</label>
                                        </div>

                                        <div class="col-sm-3">
                                            <input type="text" name="name">
                                        </div>
                                    </div>

                                    <div class="row">

                                        <div class="col-sm-3">
                                            <label class="control-label">使用积分(100积分=￥1)</label>
                                        </div>

                                        <div class="col-sm-3">
                                            <input type="text" name="name">
                                        </div>
                                    </div>

                                    <div class="row">
                                        <div class="col-md-3">
                                            <button type="submit" class="btn btn-primary pull-left">
                                                确定</button>
                                        </div>

                                        <div class="col-md-3">
                                            <button type="submit" class="btn btn-danger pull-left">
                                                取消</button>
                                        </div>
                                    </div>
                                    <div class="clearfix"></div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!--3.页脚-->
        <footer class="footer">
            <div class="container-fluid">
                <nav class="pull-left">
                    <ul>
                        <li>
                            <a href="#">
                                Hostel World
                            </a>
                        </li>
                        <li>
                            <a href="#">
                                About Us
                            </a>
                        </li>
                        <li>
                            <a href="#">
                                Licenses
                            </a>
                        </li>
                    </ul>
                </nav>
                <div class="copyright pull-right">
                    &copy; 2016, made with <i class="fa fa-heart heart"></i> by Hostel World
                </div>
            </div>
        </footer>
    </div>
</div>

</body>

<!--   Core JS Files   -->
<script src="../../assets/js/jquery-3.1.0.min.js" type="text/javascript"></script>
<script src="../../assets/js/bootstrap.min.js" type="text/javascript"></script>
<script src="../../assets/js/material.min.js" type="text/javascript"></script>

<!--  Charts Plugin -->
<script src="../../assets/js/chartist.min.js"></script>

<!--  Notifications Plugin    -->
<script src="../../assets/js/bootstrap-notify.js"></script>

<!--  Google Maps Plugin    -->
<script type="text/javascript" src="https://maps.googleapis.com/maps/api/js"></script>

<!-- Material Dashboard javascript methods -->
<script src="../../assets/js/material-dashboard.js"></script>

<!--  Plugin for the Datepicker, full documentation here: http://www.eyecon.ro/bootstrap-datepicker/ -->
<script src="../../assets/datepicker/js/bootstrap-datepicker.js" type="text/javascript"></script>

</html>
