<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="ch-ZN">
<head>
    <meta charset="utf-8" />
    <link rel="apple-touch-icon" sizes="76x76" href="<%=request.getContextPath() %>/assets/img/apple-icon.png" />
    <link rel="icon" type="image/png" href="<%=request.getContextPath() %>/assets/img/favicon.png" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

    <title>结算管理</title>

    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />

    <!--  Bootstrap core CSS     -->
    <link href="<%=request.getContextPath() %>/assets/css/bootstrap.min.css" rel="stylesheet" />
    <!--  Material Dashboard CSS    -->
    <link href="<%=request.getContextPath() %>/assets/css/material-dashboard.css" rel="stylesheet"/>
    <!--  CSS for Demo Purpose, don't include it in your project     -->
    <link href="<%=request.getContextPath() %>/assets/css/demo.css" rel="stylesheet" />

    <!--  Fonts and icons     -->
    <link href="http://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css" rel="stylesheet">
    <link href='http://fonts.googleapis.com/css?family=Roboto:400,700,300|Material+Icons' rel='stylesheet' type='text/css'>

</head>

<body>

<div class="wrapper">

    <!--整个左侧导航栏-->
    <div class="sidebar" data-color="purple" data-image="../assets/img/sidebar-1.jpg">

        <!--导航左上角的图标-->
        <div class="logo">
            <a href="#" class="simple-text">
                Hostel World-经理
            </a>
        </div>

        <!--导航栏整体-->
        <div class="sidebar-wrapper"    >
            <ul class="nav">
                <li>
                    <a href="approve.jsp">
                        <i class="material-icons">today</i>
                        <p>审批请求</p>
                    </a>
                </li>

                <!--这是一个导航的图标-->
                <li>
                    <a href="settle.jsp">
                        <!-- 导航图标的样式-->
                        <i class="material-icons">timeline</i>
                        <!--显示的文字-->
                        <p>结算管理</p>
                    </a>
                </li>

                <!--下面是其他的item代表更多的导航-->
                <li>
                    <a href="statistic.jsp">
                        <i class="material-icons">stars</i>
                        <p>统计信息</p>
                    </a>
                </li>
                <li>
                    <a href="member.jsp">
                        <i class="material-icons">group</i>
                        <p>会员信息</p>
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
                    <a class="navbar-brand" href="#">Hi, 经理 :)</a>
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
                                <li><a href="#">您有3个新的申请需要进行审批！</a></li>
                                <li><a href="#">Hostel World上月的统计信息已经发布，可以查看！</a></li>
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
                <section>
                    <h2>等待结算</h2>
                    <div class="row">
                        <div class="col-md-10">
                            <div class="card">
                                <div class="card-header" data-background-color="purple">
                                    <h4 class="title">没有处理的会员卡付款</h4>
                                    <p class="category">将会员卡支付结算给各店</p>
                                </div>

                                <div class="card-content table-responsive">
                                    <table class="table">
                                        <thead class="text-primary">
                                        <th>客栈</th>
                                        <th>会员</th>
                                        <th>支付时间</th>
                                        <th>金额</th>
                                        <th>操作</th>
                                        </thead>
                                        <tbody>
                                        <tr>
                                            <td>上海和平饭店</td>
                                            <td>一只麟</td>
                                            <td>2017年02月13日10:00:59</td>
                                            <td>￥389</td>
                                            <td><a href="#">结算</a></td>
                                        </tr>
                                        <tr>
                                            <td>上海和平饭店</td>
                                            <td>一只麟</td>
                                            <td>2017年02月13日10:00:59</td>
                                            <td>￥389</td>
                                            <td><a href="#">结算</a></td>
                                        </tr>
                                        <tr>
                                            <td>上海和平饭店</td>
                                            <td>一只麟</td>
                                            <td>2017年02月13日10:00:59</td>
                                            <td>￥389</td>
                                            <td><a href="#">结算</a></td>
                                        </tr>

                                        </tbody>
                                    </table>

                                </div>
                            </div>
                        </div>
                    </div>
                </section>


                <section>
                    <h2>已经结算</h2>
                    <div class="row">
                        <div class="col-md-10">
                            <div class="card">
                                <div class="card-header" data-background-color="purple">
                                    <h4 class="title">已经处理的会员卡付款</h4>
                                </div>

                                <div class="card-content table-responsive">
                                    <table class="table">
                                        <thead class="text-primary">
                                        <th>客栈</th>
                                        <th>会员</th>
                                        <th>支付时间</th>
                                        <th>金额</th>
                                        <th>操作</th>
                                        </thead>
                                        <tbody>
                                        <tr>
                                            <td>上海和平饭店</td>
                                            <td>一只麟</td>
                                            <td>2017年02月13日10:00:59</td>
                                            <td>￥389</td>
                                            <td><a href="#">详情</a></td>
                                        </tr>
                                        <tr>
                                            <td>上海和平饭店</td>
                                            <td>一只麟</td>
                                            <td>2017年02月13日10:00:59</td>
                                            <td>￥389</td>
                                            <td><a href="#">详情</a></td>
                                        </tr>


                                        </tbody>
                                    </table>

                                </div>
                            </div>
                        </div>
                    </div>
                </section>
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
<script src="<%=request.getContextPath() %>/assets/js/jquery-3.1.0.min.js" type="text/javascript"></script>
<script src="<%=request.getContextPath() %>/assets/js/bootstrap.min.js" type="text/javascript"></script>
<script src="<%=request.getContextPath() %>/assets/js/material.min.js" type="text/javascript"></script>

<!--  Charts Plugin -->
<script src="<%=request.getContextPath() %>/assets/js/chartist.min.js"></script>

<!--  Notifications Plugin    -->
<script src="<%=request.getContextPath() %>/assets/js/bootstrap-notify.js"></script>

<!-- Material Dashboard javascript methods -->
<script src="<%=request.getContextPath() %>/assets/js/material-dashboard.js"></script>

<!--  Plugin for the Datepicker, full documentation here: http://www.eyecon.ro/bootstrap-datepicker/ -->
<script src="<%=request.getContextPath() %>/assets/datepicker/js/bootstrap-datepicker.js" type="text/javascript"></script>

</html>
