<%--
  Created by IntelliJ IDEA.
  User: kylin
  Date: 11/03/2017
  Time: 12:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">

<jsp:include page='../common/header-basic.jsp'>
  <jsp:param name="pageTitle" value="membership"/>
</jsp:include>

<body>

<div class="wrapper">

  <%@include file="reserve-navbar-top.jsp"%>

  <div class="container-fluid container-sharing" style="margin: 3em 0 5em 4em;">

    <div class="row">
      <div class="col-md-8">
        <div class="card">
          <div class="card-header" data-background-color="purple">
            <h4 class="title">Reservation Information</h4>
            <p class="category"></p>
          </div>
          <div class="card-content">
            <form>
              <!--名称行-->
              <div class="row">
                <label class="col-md-1 control-label">酒店</label>
                <div class="col-md-6">
                  <h4>上海中环国际酒店</h4>
                </div>
              </div>

              <!--time-->
              <div class="row">
                <div class="col-md-1">
                  <label class="control-label">入住</label>
                </div>

                <div class="col-sm-3">
                  <div class="form-group label-floating">
                    <input type="text" id="dpd1" class="form-control">
                  </div>
                </div>

                <div class="col-md-1">
                  <label class="control-label">离店</label>
                </div>

                <div class="col-sm-3">
                  <div class="form-group label-floating">
                    <input type="text" id="dpd2" class="form-control">
                  </div>
                </div>
              </div>

              <!--房间类型-->
              <div class="row">
                <div class="col-md-1">
                  <label class="control-label">房间</label>
                </div>
                <div class="col-md-3 dropdown">
                  <a href="#" class="btn btn-simple dropdown-toggle" data-toggle="dropdown">
                    类型
                    <b class="caret"></b>
                  </a>
                  <ul class="dropdown-menu">
                    <li><a href="#">标准间</a></li>
                    <li><a href="#">单人间</a></li>
                    <li><a href="#">套房</a></li>
                  </ul>
                </div>

                <div class="col-md-1">
                  <label class="control-label">数目</label>
                </div>

                <div class="col-md-1">
                  <input type="text">
                </div>
              </div>

              <!--名称行-->
              <div class="row">
                <label class="col-md-1 control-label">联系人</label>
                <div class="col-md-6">
                  <h6>一只麟</h6>
                </div>
              </div>

              <div class="row">
                <label class="col-md-1 control-label">电话</label>
                <div class="col-md-3">
                  <input type="text">
                </div>
              </div>

              <div class="row">
                <label class="col-md-1 control-label">邮箱</label>
                <div class="col-md-3">
                  <input type="text">
                </div>
              </div>

              <div class="row">
                <label class="col-md-1 control-label">金额</label>
                <div class="col-md-6">
                  <h4>¥1614</h4>
                </div>
              </div>



              <button type="submit" class="btn btn-primary pull-left">
                确定</button>
              <div class="clearfix"></div>
            </form>
          </div>
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

</body>

<%@include file="../common/js-file.jsp"%>

<script>
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

