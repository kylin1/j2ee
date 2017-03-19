<%--
  Created by IntelliJ IDEA.
  User: kylin
  Date: 11/03/2017
  Time: 12:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="ch-ZN">

<jsp:include page='../common/header-with-date.jsp'>
  <jsp:param name="pageTitle" value="搜索"/>
</jsp:include>

<body>

<div class="wrapper">
  <!--整个左侧导航栏-->
  <%@include file="guest-navbar-left.jsp" %>

  <!--主体界面-->
  <div class="main-panel">
    <!--1.导航栏-->
    <%@include file="guest-navbar-top.jsp" %>

    <!--2.内容-->
    <div class="content">
      <div class="container-fluid container-sharing" style="margin: 3em 0 5em 4em;">
        <%@include file="../common/error-display.jsp" %>

        <!--业务介绍行-->
        <div class="row" style="margin: 0 10em 5em 0;">
          <h2>Hostel World find unique homes, experiences, and local guides for your trip.</h2>
        </div>

        <!-- 搜索信息 -->
        <div class="row">
          <form action="${pageContext.request.contextPath}/guest/search" method="post">

            <%--地点时间--%>
            <div class="row">
              <div class="col-md-2">
                <div class="form-group label-floating">
                  <label class="control-label">where</label>
                  <input required="required" value="${city}" type="text" name="location" class="form-control">
                </div>
              </div>

              <div class="col-md-2">
                <div class="form-group label-floating">
                  <label class="control-label">check in</label>
                  <input required="required" value="${today}" type="text" name="fromDate" id="dpd1" data-date-format="yyyy-mm-dd"
                         class="form-control">
                </div>
              </div>

              <div class="col-md-2">
                <div class="form-group label-floating">
                  <label class="control-label">check out</label>
                  <input required="required" value="${tomorrow}" type="text" name="endDate" id="dpd2" data-date-format="yyyy-mm-dd"
                         class="form-control">
                </div>
              </div>

              <div class="col-md-2">
                <label class="form-group label-floating">类型
                  <select class="selectpicker" name="roomTypeInt">
                    <option value="0">单人间</option>
                    <option value="1">标准间</option>
                    <option value="2">套房</option>
                  </select>
                </label>
              </div>

              <div class="col-md-2">
                <button type="submit" class="btn btn-primary pull-left">
                  search
                </button>
              </div>

            </div>
        </div>

        <input required="required" type="hidden" name="roomNumber" value="1">
      </div>
    </div>
  </div>

  <!--3.页脚-->
  <%@include file="../common/footer.jsp" %>
</div>

</body>

<%@include file="../common/js-file.jsp" %>

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

