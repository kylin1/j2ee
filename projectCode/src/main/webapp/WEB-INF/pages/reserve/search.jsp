<%--
  Created by IntelliJ IDEA.
  User: kylin
  Date: 11/03/2017
  Time: 12:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
  <meta charset="utf-8"/>
  <link rel="icon" type="image/png" href="<%=request.getContextPath() %>/assets/img/favicon.ico">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
  <title>Hostel World</title>
  <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport'/>
  <meta name="viewport" content="width=device-width"/>

  <!-- Bootstrap core CSS     -->
  <link href="<%=request.getContextPath() %>/assets/css/bootstrap.min.css" rel="stylesheet" />

  <!--  Material Dashboard CSS    -->
  <link href="<%=request.getContextPath() %>/assets/css/material-dashboard.css" rel="stylesheet"/>

  <!--  CSS for Demo Purpose, don't include it in your project     -->
  <link href="<%=request.getContextPath() %>/assets/css/demo.css" rel="stylesheet" />

  <!--     Fonts and icons     -->
  <link href="http://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css" rel="stylesheet">
  <link href='http://fonts.googleapis.com/css?family=Roboto:400,700,300|Material+Icons' rel='stylesheet' type='text/css'>


  <!-- 日期选择 -->
  <link rel="stylesheet" href="<%=request.getContextPath() %>/assets/datepicker/css/datepicker.css">

</head>
<body>

<div class="wrapper">

  <nav class="navbar navbar-transparent navbar-top" role="navigation">
    <div class="container">
      <!-- Brand and toggle get grouped for better mobile display -->
      <div class="navbar-header">
        <button id="menu-toggle" type="button" class="navbar-toggle"
                data-toggle="collapse" data-target="#example">
          <span class="sr-only">Toggle navigation</span>
          <span class="icon-bar bar1"></span>
          <span class="icon-bar bar2"></span>
          <span class="icon-bar bar3"></span>
        </button>
        <a href="#">
          <div class="logo-container">
            <div class="logo">
              <img src="<%=request.getContextPath() %>/assets/img/new_logo.png" alt="Creative Tim Logo">
            </div>
            <div class="brand">
              com.kylin sports
            </div>
          </div>
        </a>
      </div>
      <!-- Collect the nav links, forms, and other content for toggling -->
      <div class="collapse navbar-collapse" id="example">
        <ul class="nav navbar-nav navbar-right">
          <li>
            <a href="today.html">
              Trips
            </a>
          </li>
          <li>
            <a href="login.html">
              Help
            </a>
          </li>
          <li>
            <a href="signup.html">
              Membership
            </a>
          </li>
        </ul>
      </div>
      <!-- /.navbar-collapse -->
    </div>
  </nav>


  <div class="container-fluid container-sharing" style="margin: 3em 0 5em 4em;">

    <!--业务介绍行-->
    <div class="row" style="margin: 0 40em 5em 0;">
      <h2>Airbnb Find unique homes, experiences, and local guides for your trip.</h2>
    </div>

    <!-- 搜索信息 -->
    <div class="row">
      <form>
        <div class="row">

          <div class="col-md-2">
            <div class="form-group label-floating">
              <label class="control-label">where</label>
              <input type="text" class="form-control">
            </div>
          </div>

          <div class="col-md-4">
            <div class="row">

              <div class="col-sm-6">
                <div class="form-group label-floating">
                  <label class="control-label">check in</label>
                  <input type="text" id="dpd1" class="form-control">
                </div>
              </div>

              <div class="col-sm-6">
                <div class="form-group label-floating">
                  <label class="control-label">check out</label>
                  <input type="text" id="dpd2" class="form-control">
                </div>
              </div>

            </div>

          </div>

          <div class="col-md-4">
            <div class="row">

              <div class="col-md-6">
                <div class="form-group label-floating">
                  <label class="control-label">guests</label>
                  <input type="text" class="form-control">
                </div>
              </div>

              <div class="col-md-6">
                <button type="submit" class="btn btn-primary pull-left" style="margin-top: 1.7em">
                  search
                </button>
              </div>
            </div>

          </div>


        </div>

      </form>
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

<script type="text/javascript">
    var nowTemp = new Date();
    var now = new Date(nowTemp.getFullYear(), nowTemp.getMonth(), nowTemp.getDate(), 0, 0, 0, 0);

    var checkin = $('#dpd1').datepicker({
        onRender: function (date) {
            return date.valueOf() < now.valueOf() ? 'disabled' : '';
        }
    }).on('changeDate', function (ev) {
        if (ev.date.valueOf() > checkout.date.valueOf()) {
            var newDate = new Date(ev.date)
            newDate.setDate(newDate.getDate() + 1);
            checkout.setValue(newDate);
        }
        checkin.hide();
        $('#dpd2')[0].focus();
    }).data('datepicker');
    var checkout = $('#dpd2').datepicker({
        onRender: function (date) {
            return date.valueOf() <= checkin.date.valueOf() ? 'disabled' : '';
        }
    }).on('changeDate', function (ev) {
        checkout.hide();
    }).data('datepicker');
</script>


</html>

