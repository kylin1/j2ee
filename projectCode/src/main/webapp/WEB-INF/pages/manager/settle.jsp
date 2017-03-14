<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="ch-ZN">

<jsp:include page='../common/header-basic.jsp'>
  <jsp:param name="pageTitle" value="结算管理"/>
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
        <%@include file="../common/error-display.jsp"%>

        <section>
          <h2>等待结算</h2>
          <div class="row">
            <div class="col-md-10">
              <div class="card">
                <div class="card-header" data-background-color="purple">
                  <h4 class="title">没有处理的会员卡付款</h4>
                  <p class="category">将会员卡支付结算给各店</p>
                </div>

                <div class="card-content table-responsive">
                  <c:if test="${!empty waitingList}">
                    <table class="table">
                      <thead class="text-primary">
                      <th>客栈</th>
                      <th>会员</th>
                      <th>支付时间</th>
                      <th>金额</th>
                      <th>操作</th>
                      </thead>
                      <tbody>
                      <c:forEach items="${waitingList}" var="wait">
                        <tr>
                          <td>${wait.hotelName}</td>
                          <td>${wait.memberName}</td>
                          <td>${wait.strTime}</td>
                          <td>￥${wait.price}</td>
                          <td>
                            <a href="/my-manager/payment/settle/${wait.id}" type="button"
                               class="btn btn-sm btn-success">通过</a>
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
        </section>


        <section>
          <h2>已经结算</h2>
          <div class="row">
            <div class="col-md-10">
              <div class="card">
                <div class="card-header" data-background-color="purple">
                  <h4 class="title">已经处理的会员卡付款</h4>
                </div>

                <div class="card-content table-responsive">
                  <c:if test="${!empty doneList}">
                    <table class="table">
                      <thead class="text-primary">
                      <th>客栈</th>
                      <th>会员</th>
                      <th>支付时间</th>
                      <th>金额</th>
                      <th>操作</th>
                      </thead>
                      <tbody>
                      <c:forEach items="${doneList}" var="done">
                        <tr>
                          <td>${done.hotelName}</td>
                          <td>${done.memberName}</td>
                          <td>${done.strTime}</td>
                          <td>￥${done.price}</td>
                          <td>
                            <a href="/my-manager/payment/${done.id}" type="button"
                               class="btn btn-sm btn-info">详情</a>
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

</html>

