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

  <%@include file="reserve-navbar-top.jsp"%>

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

  <%@include file="../common/footer.jsp" %>
</div>

</body>

<%@include file="../common/js-file.jsp" %>

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

