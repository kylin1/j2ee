<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="ch-ZN">

<jsp:include page='../common/header-with-date.jsp'>
  <jsp:param name="pageTitle" value="申请&审批"/>
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
    <!--登记一个房间的入住人信息-->
    <div class="content">
      <div class="container-fluid">
        <%@include file="../common/error-display.jsp" %>

        <!--预订-->
        <section>
          <h2>预订信息</h2>
          <div class="row">
            <div class="col-md-12">
              <div class="card">
                <div class="card-header" data-background-color="purple">
                  <h4 class="title">预订信息</h4>
                  <p class="category">已预订未入住的房客订单</p>
                </div>

                <div class="card-content table-responsive">
                  <table class="table">
                    <thead class="text-primary">
                    <th>订单号</th>
                    <th>下单时间</th>
                    <th>房间信息</th>
                    <th>分配房间号</th>
                    <th>入住</th>
                    <th>离店</th>
                    <th>联系人</th>
                    <th>联系电话</th>
                    </thead>
                    <c:if test="${!empty reservedList}">
                      <tbody>
                      <c:forEach items="${reservedList}" var="reservedOrder">
                        <tr>
                          <td>${reservedOrder.orderId}</td>
                          <td>${reservedOrder.orderTime}</td>
                          <td>${reservedOrder.strType}*${reservedOrder.roomNumber}</td>
                          <td>${reservedOrder.hotelRoomNumbers}</td>
                          <td>${reservedOrder.date1}</td>
                          <td>${reservedOrder.date2}</td>
                          <td>${reservedOrder.contactPersonName}</td>
                          <td>${reservedOrder.contactPhone}</td>
                        </tr>
                      </c:forEach>
                      </tbody>
                    </c:if>
                  </table>
                </div>
              </div>
            </div>
          </div>
        </section>

        <div class="row">
          <div class="col-md-8">
            <div class="card">
              <div class="card-header" data-background-color="purple">
                <h4 class="title">登记入住人信息</h4>
                <p class="category"></p>
              </div>
              <div class="card-content">
                <form action="${pageContext.request.contextPath}/hotel/register-room" method="post">
                  <!--名称行-->
                  <div class="row">
                    <label class="col-md-1 control-label">酒店</label>
                    <div class="col-md-6">
                      <h4>${hotel.name}</h4>
                    </div>
                  </div>

                  <!--订单号-->
                  <div class="row">
                    <div class="input-group">
                      <div class="col-md-6">
                        <input type="text" value="${checkInVO.orderId}" name="orderId" class="form-control"
                               placeholder="订单号">
                      </div>
                    </div>
                  </div>

                  <div class="row">
                    <div class="input-group">
                      <div class="col-md-3">
                        <input type="text" value="${checkInVO.roomNumbers[0]}" name="roomNumbers" class="form-control"
                               placeholder="房间号">
                      </div>
                      <div class="col-md-2">
                        <input type="text" value="${checkInVO.guests[0]}" name="guests" class="form-control"
                               placeholder="房客1">
                      </div>
                      <div class="col-md-2">
                        <input type="text" value="${checkInVO.cards[0]}" name="cards" class="form-control"
                               placeholder="身份证">
                      </div>
                      <div class="col-md-2">
                        <input type="text" value="${checkInVO.guests[1]}" name="guests" class="form-control"
                               placeholder="房客2">
                      </div>
                      <div class="col-md-2">
                        <input type="text" value="${checkInVO.cards[1]}" name="cards" class="form-control"
                               placeholder="身份证">
                      </div>
                    </div>
                  </div>

                  <div class="row">
                    <div class="input-group">
                      <div class="col-md-3">
                        <input type="text" value="${checkInVO.roomNumbers[1]}" name="roomNumbers" class="form-control"
                               placeholder="房间号">
                      </div>
                      <div class="col-md-2">
                        <input type="text" value="${checkInVO.guests[2]}" name="guests" class="form-control"
                               placeholder="房客1">
                      </div>
                      <div class="col-md-2">
                        <input type="text" value="${checkInVO.cards[2]}" name="cards" class="form-control"
                               placeholder="身份证">
                      </div>
                      <div class="col-md-2">
                        <input type="text" value="${checkInVO.guests[3]}" name="guests" class="form-control"
                               placeholder="房客2">
                      </div>
                      <div class="col-md-2">
                        <input type="text" value="${checkInVO.cards[3]}" name="cards" class="form-control"
                               placeholder="身份证">
                      </div>
                    </div>
                  </div>

                  <!--是否会员-->
                  <div class="row">
                    <label class="col-sm-2 control-label">是否会员</label>

                    <div class="col-sm-2">
                      <div class="radio">
                        <label>
                          <input type="radio" value="1" name="isMember">
                          是
                        </label>
                      </div>
                    </div>

                    <div class="col-sm-2">
                      <div class="radio">
                        <label>
                          <input type="radio" value="0" name="isMember">
                          否
                        </label>
                      </div>
                    </div>
                  </div>

                  <!--付款方式-->
                  <div class="row">
                    <label class="col-sm-2 control-label">付款方式</label>

                    <div class="col-sm-2">
                      <div class="radio">
                        <label>
                          <input type="radio" value="0" name="intPaymentType">
                          会员卡
                        </label>
                      </div>
                    </div>

                    <div class="col-sm-3">
                      <div class="radio">
                        <label>
                          <input type="radio" value="1" name="intPaymentType">
                          现金结账
                        </label>
                      </div>
                    </div>
                  </div>

                  <input type="hidden" name="hotelId" value="${hotelId}">

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

</html>
