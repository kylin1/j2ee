<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!doctype html>
<html lang="ch-ZN">

<jsp:include page='../common/header-basic.jsp'>
  <jsp:param name="pageTitle" value="order"/>
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
      <div class="container-fluid">
        <%@include file="../common/error-display.jsp"%>

        <!--recent order-->
        <div class="row">
          <div class="col-md-12">
            <div class="card">
              <div class="card-header" data-background-color="purple">
                <h4 class="title">全部订单</h4>
              </div>
              <div class="card-content table-responsive">

                <c:if test="${!empty orderVOList}">
                  <table class="table">
                    <thead class="text-primary">
                    <tr>
                      <th>酒店</th>
                      <th>预定日期</th>
                      <th>出行人</th>
                      <th>出行日期</th>
                      <th>总金额</th>
                      <th>状态</th>
                      <th>操作</th>
                    </tr>
                    </thead>

                    <tbody>
                    <c:forEach items="${orderVOList}" var="order">
                      <tr>
                        <td>${order.hotelName}</td>
                        <td>${order.stringOrderDate}</td>
                        <td>${order.stringCustomers}</td>
                        <td>${order.stringCheckInDate}至${order.stringCheckOutDate}</td>
                        <td class="text-primary">¥${order.totalPrice}</td>
                        <td>${order.orderStatus.stringStatus}</td>
                        <td><a href="#">点评酒店</a></td>
                      </tr>
                    </c:forEach>
                    </tbody>

                  </table>
                </c:if>

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