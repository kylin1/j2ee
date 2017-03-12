<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!doctype html>
<html lang="ch-ZN">

<jsp:include page='../common/header-basic.jsp'>
  <jsp:param name="pageTitle" value="审批申请"/>
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
        <!--新的申请-->
        <section>
          <h2>新的申请</h2>
          <div class="row">
            <div class="col-md-10">
              <div class="card">
                <div class="card-header" data-background-color="purple">
                  <h4 class="title">还未处理的申请</h4>
                  <p class="category">新的开店申请/修改店信息申请</p>
                </div>

                <div class="card-content table-responsive">
                  <c:if test="${!empty waitingList}">
                    <table class="table">
                      <thead class="text-primary">
                      <th>客栈</th>
                      <th>类别</th>
                      <th>主要内容</th>
                      <th>提交时间</th>
                      <th>操作</th>
                      </thead>
                      <tbody>
                      <c:forEach items="${waitingList}" var="wait">
                        <tr>
                          <td>${wait.hotelName}</td>
                          <td>${wait.mainContent}</td>
                          <td>${wait.detailContent}</td>
                          <td>${wait.strTime}</td>
                          <td>
                            <a href="/my-manager/approve/pass/${wait.id}" type="button" class="btn btn-sm btn-success">通过</a><a href="/my-manager/approve/deny/${wait.id}" type="button" class="btn btn-sm btn-danger">否决</a>
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

        <!--已经处理-->
        <section>
          <h2>已经处理</h2>
          <div class="row">
            <div class="col-md-10">
              <div class="card">
                <div class="card-header" data-background-color="purple">
                  <h4 class="title">已经处理的申请</h4>
                  <p class="category">可以开始查看详情</p>
                </div>

                <div class="card-content table-responsive">
                  <c:if test="${!empty doneList}">
                    <table class="table">
                      <thead class="text-primary">
                      <th>客栈</th>
                      <th>类别</th>
                      <th>主要内容</th>
                      <th>提交时间</th>
                      <th>处理结果</th>
                      <th>操作</th>
                      </thead>
                      <tbody>
                      <c:forEach items="${doneList}" var="done">
                        <tr>
                          <td>${done.hotelName}</td>
                          <td>${done.strType}</td>
                          <td>${done.mainContent}</td>
                          <td>${done.strTime}</td>
                          <td>${done.strStatus}</td>
                          <td>
                            <a href="/my-manager/approve/show/${done.id}" type="button" class="btn btn-sm btn-success">详情</a>
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
