<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="ch-ZN">

<jsp:include page='../common/header-with-date.jsp'>
  <jsp:param name="pageTitle" value="数据统计"/>
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
        <%@include file="../common/error-display.jsp" %>

        <!--入住-->
        <section>
          <h2>入住信息</h2>
          <div class="row">
            <div class="col-md-10">
              <div class="card">
                <div class="card-header" data-background-color="purple">
                  <h4 class="title">房间入住信息</h4>
                  <p class="category">本日每房间入住情况与房客信息</p>
                </div>

                <div class="card-content table-responsive">
                  <c:if test="${!empty roomStatusVOS}">
                    <table class="table">
                      <thead class="text-primary">
                      <th>日期</th>
                      <th>房间号</th>
                      <th>类型</th>
                      <th>状态</th>
                      <th>操作</th>
                      </thead>
                      <tbody>
                      <c:forEach items="${roomStatusVOS}" var="status">
                        <tr>
                          <td>${status.strDate}</td>
                          <td>${status.roomNumber}</td>
                          <td>${status.roomType}</td>
                          <td>${status.strStatus}</td>
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

        <!--财务-->
        <section>
          <h2>财务统计</h2>
          <div class="row">
            <div class="col-md-10">
              <div class="card">
                <div class="card-header card-chart" data-background-color="red">
                  <div class="ct-chart" id="hotelIncomeChart"></div>
                </div>
                <div class="card-content">
                  <div class="row">
                    <div class="col-sm-12">
                      <h4 class="title">每日收入折线图, 本酒店总收入:${hotel.income}</h4>
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

<%@include file="../common/js-file.jsp" %>

<script src="<%=request.getContextPath() %>/assets/js/my-chart.js"></script>

<!--使用JS绘制图表-->
<script>
  function drawChart() {
    // data from
    var data = ${data};
    var lowBond = ${lowBond};
    var upBond = ${upBond};
    DrawChart.createLineChart('hotelIncomeChart', data, upBond, lowBond, "元")
  }
</script>

<script>
  $(document).ready(function () {
    drawChart();
  });
</script>
</html>
