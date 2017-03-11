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

        <!--recent order-->
        <div class="row">
          <div class="col-md-12">
            <div class="card">
              <div class="card-header" data-background-color="purple">
                <h4 class="title">全部订单</h4>
              </div>
              <div class="card-content table-responsive">
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
                  <tr>
                    <td>海友良品酒店（上海罗山路地铁站店）</td>
                    <td>2017-02-01</td>
                    <td>一只麟</td>
                    <td>2017-02-08至2017-02-10</td>
                    <td class="text-primary">¥386</td>
                    <td>已成交</td>
                    <td><a href="#">点评酒店</a></td>
                  </tr>

                  <tr>
                    <td>海友良品酒店（上海罗山路地铁站店）</td>
                    <td>2017-02-01</td>
                    <td>一只麟</td>
                    <td>2017-02-08至2017-02-10</td>
                    <td class="text-primary">¥386</td>
                    <td>已成交</td>
                    <td><a href="#">点评酒店</a></td>
                  </tr>

                  <tr>
                    <td>海友良品酒店（上海罗山路地铁站店）</td>
                    <td>2017-02-01</td>
                    <td>一只麟</td>
                    <td>2017-02-08至2017-02-10</td>
                    <td class="text-primary">¥386</td>
                    <td>已成交</td>
                    <td><a href="#">点评酒店</a></td>
                  </tr>

                  <tr>
                    <td>海友良品酒店（上海罗山路地铁站店）</td>
                    <td>2017-02-01</td>
                    <td>一只麟</td>
                    <td>2017-02-08至2017-02-10</td>
                    <td class="text-primary">¥386</td>
                    <td>已成交</td>
                    <td><a href="#">点评酒店</a></td>
                  </tr>

                  </tbody>
                </table>

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