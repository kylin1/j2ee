<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: kylin
  Date: 11/03/2017
  Time: 12:56
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
        <%@include file="../common/error-display.jsp"%>

        <!--业务介绍行-->
        <div class="description" style="margin: 0 10em 5em 0;">
          <h2>Make your choice</h2>
        </div>

        <!-- 搜索信息 -->
        <div class="row">
          <div class="col-md-10">
            <div class="card">
              <div class="card-header" data-background-color="purple">
                <h4 class="title">198 家酒店:${searchInputVO.location},${searchInputVO.fromDate}至${searchInputVO.endDate}</h4>
                <p class="category"></p>
              </div>

              <div class="card-content table-responsive">

                <%--搜索结果为空--%>
                <c:if test="${empty searchResult}">
                  <div class="alert alert-warning" role="alert">
                    <span class="glyphicon glyphicon-info-sign" aria-hidden="true"></span>抱歉,没有找到符合条件的酒店信息
                  </div>
                </c:if>

                <%--如果搜索结果不为空--%>
                <c:if test="${!empty searchResult}">
                  <table class="table">
                    <thead class="text-primary">
                    <th>名称</th>
                    <th>类型</th>
                    <th>地址</th>
                    <th>起价</th>
                    <th>操作</th>
                    </thead>

                    <tbody>
                      <%--遍历所有结果--%>
                    <c:forEach items="${searchResult}" var="hotel">
                      <tr>
                        <td>${hotel.hotelName}</td>
                        <td>${hotel.strHotelLevel}</td>
                        <td>${hotel.hotelAddress}</td>
                        <td>¥${hotel.lowestPerNightPrice}</td>
                        <td><a href="${pageContext.request.contextPath}/guest/selectHotel?hotelName=${hotel.hotelName}&hotelId=${hotel.hotelId}&fromDate=${searchInputVO.fromDate}&endDate=${searchInputVO.endDate}&roomTypeInt=${searchInputVO.roomTypeInt}&roomNumber=${searchInputVO.roomNumber}&perPrice=${hotel.lowestPerNightPrice}">预定</a></td>
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
