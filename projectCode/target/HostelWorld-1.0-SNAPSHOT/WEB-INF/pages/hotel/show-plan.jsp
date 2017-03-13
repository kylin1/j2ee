<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="ch-ZN">

<jsp:include page='../common/header-with-date.jsp'>
  <jsp:param name="pageTitle" value="发布计划"/>
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
        <!--当前已经发布的计划-->
        <div class="card">
          <div class="card-header" data-background-color="purple">
            <h4 class="title">每个房间已经发布的计划</h4>
            <p class="category"></p>
          </div>

          <c:if test="${!empty planVOS}">
            <div class="card-content table-responsive">
              <table class="table">
                <thead class="text-primary">
                <th>房间</th>
                <th>类型</th>
                <th>起点时间</th>
                <th>终点时间</th>
                <th>操作</th>
                </thead>

                <tbody>
                <c:forEach items="${planVOS}" var="plan">
                  <tr>
                    <td>${plan.room}</td>
                    <td>${plan.strType}</td>
                    <td>${plan.date1}</td>
                    <td>${plan.date2}</td>
                    <td><a href="/hotel/plan/${plan.roomId}?room=${plan.room}&date1=${plan.date1}&date2=${plan.date2}">发布计划</a></td>
                  </tr>
                </c:forEach>
                </tbody>
              </table>
            </div>
          </c:if>


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
