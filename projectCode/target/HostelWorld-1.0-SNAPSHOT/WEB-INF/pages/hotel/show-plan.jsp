<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="ch-ZN">

<jsp:include page='../common/header-with-date.jsp'>
  <jsp:param name="pageTitle" value="房间&计划"/>
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

        <%--添加房间--%>
        <section>
          <div class="row">
            <div class="col-md-8">
              <div class="card">
                <div class="card-header" data-background-color="purple">
                  <h4 class="title">添加房间</h4>
                  <p class="category"></p>
                </div>
                <div class="card-content">

                  <form action="${pageContext.request.contextPath}/hotel/add-room" method="post">

                    <!--添加房间-->
                    <div class="row">
                      <div class="col-md-3 dropdown">
                        <label class="form-group label-floating">类型
                          <select class="selectpicker" name="roomType">
                            <option value="0">单人间</option>
                            <option value="1">标准间</option>
                            <option value="2">套房</option>
                          </select>
                        </label>
                      </div>

                      <div class="col-md-2">
                        <div class="form-group label-floating">
                          <label class="control-label">房间号</label>
                          <input name="roomNumber" type="text" class="form-control">
                        </div>
                      </div>

                      <div class="col-md-4">
                        <div class="form-group label-floating">
                          <label class="control-label">信息</label>
                          <input name="roomInfo" type="text" class="form-control">
                        </div>
                      </div>
                    </div>
                    <button type="submit" class="btn btn-primary pull-left">
                      确认添加
                    </button>
                    <div class="clearfix"></div>
                  </form>

                </div>
              </div>
            </div>
          </div>
        </section>

        <!--当前已经发布的计划-->
        <div class="card">
          <div class="card-header" data-background-color="purple">
            <h4 class="title">每个房间已经发布的计划</h4>
            <p class="category"></p>
          </div>

          <div class="card-content table-responsive">

            <c:if test="${empty planVOS}">
              <div class="row">
                <div class="col-md-8">
                  <div class="alert alert-warning" role="alert">
                    <span class="glyphicon glyphicon-info-sign" aria-hidden="true"></span>本酒店暂无任何房间计划
                  </div>
                </div>
              </div>
            </c:if>

            <c:if test="${!empty planVOS}">
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
                    <%--延长计划的按钮--%>
                    <td><a href="/hotel/plan/${plan.roomId}?room=${plan.room}&date1=${plan.date1}&date2=${plan.date2}">发布计划</a>
                    </td>
                  </tr>
                </c:forEach>
                </tbody>
              </table>
            </c:if>
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
