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

        <div class="row">
          <div class="col-md-8">
            <div class="card">
              <div class="card-header" data-background-color="purple">
                <h4 class="title">登记入住人信息</h4>
                <p class="category"></p>
              </div>
              <div class="card-content">
                <form action="${pageContext.request.contextPath}/hotel/register-room-non" method="post">
                  <!--名称行-->
                  <div class="row">
                    <label class="col-md-1 control-label">酒店</label>
                    <div class="col-md-6">
                      <h4>${hotel.name}</h4>
                    </div>
                  </div>

                  <div class="row">
                    <label class="col-md-1 control-label">房间号</label>
                    <div class="col-md-6">
                      <h4>${roomNumber}</h4>
                    </div>
                  </div>

                  <%--日期--%>
                  <div class="row">
                    <label class="col-md-1 control-label">日期</label>
                    <div class="col-md-6">
                      <h4>${startDate} 至 ${endDate}</h4>
                    </div>
                  </div>

                  <%--总价--%>
                  <div class="row">
                    <label class="col-md-1 control-label">总价</label>
                    <div class="col-md-6">
                      <h4>${totalPrice}</h4>
                    </div>
                  </div>

                  <div class="row">
                    <div class="input-group">

                      <div class="col-md-2">
                        <input required="required" type="text" name="guest1" class="form-control"
                               placeholder="房客1">
                      </div>
                      <div class="col-md-2">
                        <input required="required" type="number" pattern="[0-9]*" name="card1" class="form-control"
                               placeholder="身份证">
                      </div>
                      <div class="col-md-2">
                        <input type="text" name="guest2" class="form-control"
                               placeholder="房客2">
                      </div>
                      <div class="col-md-2">
                        <input type="number" pattern="[0-9]*" name="card2" class="form-control"
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
                          <input required="required" type="radio" value="1" name="isMember">
                          是
                        </label>
                      </div>
                    </div>

                    <div class="col-sm-2">
                      <div class="radio">
                        <label>
                          <input required="required" type="radio" value="0" name="isMember" checked>
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
                          <input required="required" type="radio" value="0" name="intPaymentType">
                          会员卡
                        </label>
                      </div>
                    </div>

                    <div class="col-sm-3">
                      <div class="radio">
                        <label>
                          <input required="required" type="radio" value="1" name="intPaymentType" checked>
                          现金结账
                        </label>
                      </div>
                    </div>
                  </div>

                  <input required="required" type="hidden" name="roomNumber" value="${roomNumber}">
                  <input required="required" type="hidden" name="orderId" value="1">
                  <input required="required" type="hidden" name="hotelId" value="${hotelId}">
                  <input required="required" type="hidden" name="endDate" value="${endDate}">
                  <input required="required" type="hidden" name="startDate" value="${startDate}">
                  <input required="required" type="hidden" name="price" value="${totalPrice}">

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
