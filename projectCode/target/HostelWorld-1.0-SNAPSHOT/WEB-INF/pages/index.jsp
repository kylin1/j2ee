<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8"/>
  <link rel="apple-touch-icon" sizes="76x76" href="<%=request.getContextPath() %>/assets/img/apple-icon.png">
  <link rel="icon" type="image/png" href="<%=request.getContextPath() %>/assets/img/favicon.png">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>

  <title>登录-Hostel World</title>

  <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport'/>

  <!--     Fonts and icons     -->
  <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons"/>
  <link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700"/>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css"/>

  <!-- CSS Files -->
  <link href="<%=request.getContextPath() %>/assets/css/bootstrap.min.css" rel="stylesheet"/>
  <link href="<%=request.getContextPath() %>/assets/css/material-kit.css" rel="stylesheet"/>

</head>

<body class="signup-page">
<nav class="navbar navbar-transparent navbar-absolute">
  <div class="container">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navigation-example">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="../guest/search.html">返回主页</a>
    </div>

    <div class="collapse navbar-collapse" id="navigation-example">
      <ul class="nav navbar-nav navbar-right">
        <li>
          <a href="#" target="_blank" class="btn btn-simple btn-white btn-just-icon">
            <i class="fa fa-twitter"></i>
          </a>
        </li>
        <li>
          <a href="#" target="_blank" class="btn btn-simple btn-white btn-just-icon">
            <i class="fa fa-facebook-square"></i>
          </a>
        </li>
        <li>
          <a href="#" target="_blank" class="btn btn-simple btn-white btn-just-icon">
            <i class="fa fa-instagram"></i>
          </a>
        </li>
      </ul>
    </div>
  </div>
</nav>

<div class="wrapper">
  <div class="header header-filter"
       style="background-image: url('../../assets/img/city.jpg'); background-size: cover; background-position: top center;">
    <div class="container">
      <div class="row">
        <div class="col-md-4 col-md-offset-4 col-sm-6 col-sm-offset-3">
          <div class="card card-signup">


            <form:form action="login" method="post" role="form">
              <div class="header header-primary text-center">
                <h4>Welcome Back!</h4>
                <div class="social-line">
                  <a href="#pablo" class="btn btn-simple btn-just-icon">
                    <i class="fa fa-facebook-square"></i>
                  </a>
                  <a href="#pablo" class="btn btn-simple btn-just-icon">
                    <i class="fa fa-twitter"></i>
                  </a>
                  <a href="#pablo" class="btn btn-simple btn-just-icon">
                    <i class="fa fa-google-plus"></i>
                  </a>
                </div>
              </div>
              <div class="content">

                <div class="input-group">
										<span class="input-group-addon">
											<i class="material-icons">email</i>
										</span>
                  <input id="account" name="account" type="text" class="form-control" placeholder="账户">
                </div>

                <div class="input-group">
										<span class="input-group-addon">
											<i class="material-icons">lock_outline</i>
										</span>
                  <input id="password" name="password" type="password" placeholder="密码" class="form-control"/>
                </div>

              </div>

              <div class="footer text-center">
                <button type="submit" class="btn btn-simple btn-primary btn-lg">提交</button>
              </div>

            </form:form>


          </div>
        </div>
      </div>
    </div>

    <footer class="footer">
      <div class="container">
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
<script src="<%=request.getContextPath() %>/assets/js/material.min.js"></script>

<!--  Plugin for the Sliders, full documentation here: http://refreshless.com/nouislider/ -->
<script src="<%=request.getContextPath() %>/assets/js/nouislider.min.js" type="text/javascript"></script>

<!-- Control Center for Material Kit: activating the ripples, parallax effects, scripts from the example pages etc -->
<script src="<%=request.getContextPath() %>/assets/js/material-kit.js" type="text/javascript"></script>

</html>
