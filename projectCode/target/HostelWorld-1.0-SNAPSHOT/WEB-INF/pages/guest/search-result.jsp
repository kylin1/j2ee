<%--
  Created by IntelliJ IDEA.
  User: kylin
  Date: 11/03/2017
  Time: 12:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html lang="en">
<jsp:include page='../common/header-with-date.jsp'>
  <jsp:param name="pageTitle" value="搜索"/>
</jsp:include>

<body>

<div class="wrapper">

  <%@include file="reserve-navbar-top.jsp"%>

  <div class="container-fluid container-sharing" style="margin: 3em 0 5em 4em;">

    <!--业务介绍行-->
    <div class="description" style="margin: 0 40em 5em 0;">
      <h2>Make your choice</h2>
    </div>

    <!-- 搜索信息 -->
    <div class="row">
      <div class="col-md-10">
        <div class="card">
          <div class="card-header" data-background-color="purple">
            <h4 class="title">198 家酒店</h4>
            <p class="category"></p>
          </div>

          <div class="card-content table-responsive">
            <table class="table">
              <thead class="text-primary">
              <th>名称</th>
              <th>类型</th>
              <th>地址</th>
              <th>起价</th>
              <th>操作</th>
              </thead>

              <tbody>
              <tr>
                <td>上海中环国际酒店</td>
                <td>五星级酒店</td>
                <td>普陀区富平路800号，近真金路。</td>
                <td>¥583</td>
                <td><a href="#">详情</a> <a href="#">预定</a></td>
              </tr>

              <tr>
                <td>上海中环国际酒店</td>
                <td>五星级酒店</td>
                <td>普陀区富平路800号，近真金路。</td>
                <td>¥583</td>
                <td><a href="#">详情</a> <a href="#">预定</a></td>
              </tr>
              <tr>
                <td>上海中环国际酒店</td>
                <td>五星级酒店</td>
                <td>普陀区富平路800号，近真金路。</td>
                <td>¥583</td>
                <td><a href="#">详情</a> <a href="#">预定</a></td>
              </tr>
              <tr>
                <td>上海中环国际酒店</td>
                <td>五星级酒店</td>
                <td>普陀区富平路800号，近真金路。</td>
                <td>¥583</td>
                <td><a href="#">详情</a> <a href="#">预定</a></td>
              </tr>
              <tr>
                <td>上海中环国际酒店</td>
                <td>五星级酒店</td>
                <td>普陀区富平路800号，近真金路。</td>
                <td>¥583</td>
                <td><a href="#">详情</a> <a href="#">预定</a></td>
              </tr>

              </tbody>
            </table>

          </div>
        </div>
      </div>
    </div>

  </div>

  <%@include file="../common/footer.jsp" %>
</div>

</body>

<%@include file="../common/js-file.jsp" %>

<script type="text/javascript">
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
