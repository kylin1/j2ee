<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="ch-ZN">

<jsp:include page='../common/header-with-date.jsp'>
  <jsp:param name="pageTitle" value="发布计划"/>
</jsp:include>

<body>

<div class="wrapper">

  <!--整个左侧导航栏-->
  <%@include file="hotel-navbar-left.jsp" %>

  <!--主体界面-->
  <div class="main-panel">

    <!--1.导航栏-->
    <%@include file="hotel-navbar-top.jsp" %>

    <!--2.内容-->
    <div class="content">
      <div class="container-fluid">

        <%@include file="../common/error-display.jsp"%>

        <!--发布计划-->
        <div class="row">
          <div class="col-md-8">
            <div class="card">
              <div class="card-header" data-background-color="purple">
                <h4 class="title">发布计划</h4>
                <p class="category"></p>
              </div>
              <div class="card-content">


                <form action="${pageContext.request.contextPath}/hotel/new-plan" method="post">

                  <!--名称行-->
                  <div class="row">
                    <label class="col-md-1 control-label">酒店</label>
                    <div class="col-md-6">
                      <h4>${hotel.name}</h4>
                    </div>
                  </div>

                  <!--房间号码-->
                  <div class="row">
                    <label class="col-md-1 control-label">房间</label>
                    <div class="col-md-6">
                      <h4>${room}</h4>
                    </div>
                  </div>


                  <input type="hidden" name="hotelId" value="${hotelId}">
                  <input type="hidden" name="hotelRoomId" value="${hotelRoomId}">
                  <input type="hidden" name="room" value="${room}">

                  <!--time-->
                  <div class="row">
                    <div class="col-md-1">
                      <label class="control-label">开始</label>
                    </div>

                    <div class="col-sm-3">
                      <div class="form-group label-floating">
                        <input name="startDate" value="${newPlanDate}" type="text" id="dpd1" data-date-format="yyyy-mm-dd" class="form-control">
                      </div>
                    </div>

                    <div class="col-md-1">
                      <label class="control-label">结束</label>
                    </div>

                    <div class="col-sm-3">
                      <div class="form-group label-floating">
                        <input name="endDate" type="text" id="dpd2" data-date-format="yyyy-mm-dd" class="form-control">
                      </div>
                    </div>

                    <label class="col-md-2 control-label">单价(每间每晚)</label>
                    <div class="col-md-2">
                      <input name="price" type="text" class="form-control">
                    </div>
                  </div>



                  <button type="submit" class="btn btn-primary pull-left">
                    确定
                  </button>
                  <div class="clearfix"></div>
                </form>
              </div>
            </div>
          </div>
        </div>

      </div>
    </div>

    <!--3.页脚-->
    <%@include file="../common/footer.jsp" %>
  </div>
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
