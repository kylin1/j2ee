<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="ch-ZN">

<jsp:include page='../common/header-with-date.jsp'>
  <jsp:param name="pageTitle" value="住客登记"/>
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

        <!--酒店输入日期,房间类型:查找合适房间列表-->
        <div class="row">
          <div class="col-md-8">
            <div class="card">
              <div class="card-header" data-background-color="purple">
                <h4 class="title">查找本酒店房间</h4>
                <p class="category"></p>
              </div>
              <div class="card-content">

                <form action="${pageContext.request.contextPath}/hotel/search-room" method="post">
                  <!--time-->
                  <div class="row">
                    <div class="col-md-1">
                      <label class="control-label">开始</label>
                    </div>

                    <div class="col-sm-3">
                      <div class="form-group label-floating">
                        <input required="required" name="startDate" type="text" value="${startDate}" id="dpd1" data-date-format="yyyy-mm-dd"
                               class="form-control">
                      </div>
                    </div>

                    <div class="col-md-1">
                      <label class="control-label">结束</label>
                    </div>

                    <div class="col-sm-3">
                      <div class="form-group label-floating">
                        <input required="required" name="endDate" type="text" value="${endDate}" id="dpd2" data-date-format="yyyy-mm-dd"
                               class="form-control">
                      </div>
                    </div>

                    <div class="col-md-2 dropdown">
                      <label class="form-group label-floating">类型
                        <select name="roomType">
                          <option value="0">单人间</option>
                          <option value="1">标准间</option>
                          <option value="2">套房</option>
                        </select>
                      </label>
                    </div>

                    <div class="col-sm-2">
                      <button type="submit" class="btn btn-primary pull-left">
                        确定
                      </button>
                      <div class="clearfix"></div>
                    </div>

                  </div>
                </form>
              </div>
            </div>
          </div>
        </div>

        <%--搜索结果为空--%>
        <%@include file="../common/error-display.jsp" %>

        <!--合适房间列表:在列表中点击一个房间进行预订-->
        <c:if test="${!empty remainRoomList}">
          <div class="row">
            <div class="col-md-10">
              <div class="card">
                <div class="card-header" data-background-color="purple">
                  <h4 class="title">请为客人选择空闲房间</h4>
                  <p class="category"></p>
                </div>

                <div class="card-content table-responsive">
                  <table class="table">
                    <thead class="text-primary">
                    <th>房间号</th>
                    <th>类型</th>
                    <th>状态</th>
                    <th>价格</th>
                    <th>其他信息</th>
                    <th>操作</th>
                    </thead>
                    <tbody>
                    <c:forEach items="${remainRoomList}" var="room">
                      <tr>
                        <td>${room.room}</td>
                        <td>${room.strType}</td>
                        <td>${room.strStatus}</td>
                        <td>${room.price}</td>
                        <td>${room.information}</td>
                          <%--选择房间进行入住操作--%>
                        <td><a
                            href="${pageContext.request.contextPath}/hotel/select-room/${room.roomId}?startDate=${startDate}&endDate=${endDate}&room=${room.room}&roomType=${room.strType}&price=${room.price}">入住</a>
                        </td>
                      </tr>
                    </c:forEach>
                    </tbody>
                  </table>

                </div>
              </div>
            </div>
          </div>
        </c:if>

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
