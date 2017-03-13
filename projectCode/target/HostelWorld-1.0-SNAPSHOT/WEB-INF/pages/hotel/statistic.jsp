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

        <!--预订-->
        <section>
          <h2>预订信息</h2>
          <div class="row">
            <div class="col-md-10">
              <div class="card">
                <div class="card-header" data-background-color="purple">
                  <h4 class="title">预订信息</h4>
                  <p class="category">已预订未入住的房客订单</p>
                </div>

                <div class="card-content table-responsive">
                  <table class="table">
                    <thead class="text-primary">
                    <th>下单时间</th>
                    <th>房间信息</th>
                    <th>入住</th>
                    <th>离店</th>
                    <th>联系人</th>
                    <th>联系电话</th>
                    </thead>
                    <tbody>
                    <tr>
                      <td>2017年02月13日10:00:59</td>
                      <td>标准间*2</td>
                      <td>2017年02月13日</td>
                      <td>2017年02月15日</td>
                      <td>一只麟</td>
                      <td>18795853969</td>
                    </tr>
                    <tr>
                      <td>2017年02月13日10:00:59</td>
                      <td>标准间*2</td>
                      <td>2017年02月13日</td>
                      <td>2017年02月15日</td>
                      <td>一只麟</td>
                      <td>18795853969</td>
                    </tr>
                    <tr>
                      <td>2017年02月13日10:00:59</td>
                      <td>标准间*2</td>
                      <td>2017年02月13日</td>
                      <td>2017年02月15日</td>
                      <td>一只麟</td>
                      <td>18795853969</td>
                    </tr>
                    </tbody>
                  </table>

                </div>
              </div>
            </div>
          </div>
        </section>

        <!--入住-->
        <section>
          <h2>入住信息</h2>
          <div class="row">
            <div class="col-md-10">
              <div class="card">
                <div class="card-header" data-background-color="purple">
                  <h4 class="title">房间入住信息</h4>
                  <p class="category">每日每房间入住情况与房客信息</p>
                </div>

                <div class="card-content table-responsive">
                  <table class="table">
                    <thead class="text-primary">
                    <th>日期</th>
                    <th>房间号</th>
                    <th>入住人数</th>
                    <th>操作</th>
                    </thead>
                    <tbody>
                    <tr>
                      <td>2017年02月13日</td>
                      <td>8401</td>
                      <td>2</td>
                      <td><a href="#">详情</a></td>
                    </tr>
                    <tr>
                      <td>2017年02月13日</td>
                      <td>8401</td>
                      <td>2</td>
                      <td><a href="#">详情</a></td>
                    </tr>
                    <tr>
                      <td>2017年02月13日</td>
                      <td>8401</td>
                      <td>2</td>
                      <td><a href="#">详情</a></td>
                    </tr>

                    </tbody>
                  </table>

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
                  <div class="ct-chart" id="heartRateChart"></div>
                </div>
                <div class="card-content">

                  <div class="row">
                    <div class="col-sm-4">
                      <h4 class="title">每日收入</h4>
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

<script src="<%=request.getContextPath() %>/assets/js/sport.js"></script>

<!--使用JS绘制图表-->
<script>
    $(document).ready(function () {
        // Javascript method's body can be found in assets/js/demos.js
        sport.initSportsCharts();
    });
</script>

</html>
