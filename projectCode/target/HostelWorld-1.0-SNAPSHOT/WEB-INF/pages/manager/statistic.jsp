<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!doctype html>
<html lang="ch-ZN">

<jsp:include page='../common/header-basic.jsp'>
  <jsp:param name="pageTitle" value="统计信息"/>
</jsp:include>

<body>

<div class="wrapper">

  <!--整个左侧导航栏-->
  <%@include file="manger-navbar-left.jsp" %>

  <!--主体界面-->
  <div class="main-panel">
    <!--1.导航栏-->
    <%@include file="manager-navbar-top.jsp" %>

    <!--2.内容-->
    <div class="content">
      <div class="container-fluid">
        <%@include file="../common/error-display.jsp" %>

        <!--各店入住情况-->
        <section>
          <h2>各店入住情况</h2>
          <div class="row">
            <div class="col-md-10">
              <div class="card">
                <div class="card-header" data-background-color="purple">
                  <h4 class="title">本日各店入住情况</h4>
                </div>

                <div class="card-content table-responsive">
                  <c:if test="${!empty list}">
                    <table class="table">
                      <thead class="text-primary">
                      <th>日期</th>
                      <th>客栈</th>
                      <th>已入住/已预定房间</th>
                      <th>空闲房间</th>
                      <th>不可用房间</th>
                      <th>操作</th>
                      </thead>
                      <tbody>
                      <c:forEach items="${list}" var="hotelInfo">
                        <tr>
                          <td>${hotelInfo.strDate}</td>
                          <td>${hotelInfo.hotelName}</td>
                          <td>${hotelInfo.busyRoom}</td>
                          <td>${hotelInfo.emptyRoom}</td>
                          <td>${hotelInfo.notAvail}</td>
                          <td><a href="#">详情</a></td>
                        </tr>
                      </c:forEach>
                      </tbody>
                    </table>
                  </c:if>
                </div>
              </div>
            </div>
          </div>
        </section>

        <!--财务情况-->
        <section>
          <h2>财务情况</h2>
          <div class="row">
            <div class="col-md-8">
              <div class="card">
                <div class="card-header card-chart" data-background-color="orange">
                  <div class="ct-chart" id="managerPaymentChart"></div>
                </div>
                <div class="card-content">
                  <div class="row">
                    <div class="col-sm-4">
                      <h4 class="title">收入折线图</h4>
                    </div>
                    <div class="col-sm-8">
                      <ul class="nav navbar-nav navbar-right">
                        <li><a href="#" style="padding-top: 5px;padding-bottom: 5px;">日</a></li>
                        <li><a href="#" style="padding-top: 5px;padding-bottom: 5px;">周</a></li>
                        <li><a href="#" style="padding-top: 5px;padding-bottom: 5px;">月</a></li>
                      </ul>
                    </div>
                  </div>

                </div>
              </div>
            </div>
          </div>

        </section>
      </div>
    </div>

    <!--3.页脚-->
    <%@include file="../common/footer.jsp" %>
  </div>
</div>

</body>

<%--js--%>
<%@include file="../common/js-file.jsp" %>

<script src="<%=request.getContextPath() %>/assets/js/my-chart.js"></script>

<!--使用JS绘制图表-->
<script>
    function drawChart() {
        // data from
        var data = ${data};
        var lowBond = ${lowBond};
        var upBond = ${upBond};
        DrawChart.createLineChart('managerPaymentChart', data, upBond, lowBond, "元")
    }
</script>

<script>
    $(document).ready(function () {
        drawChart();
    });
</script>
</html>
