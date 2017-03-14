<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="ch-ZN">

<jsp:include page='../common/header-with-date.jsp'>
  <jsp:param name="pageTitle" value="申请&审批"/>
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

        <%@include file="../common/error-display.jsp"%>

        <!--开店申请-->
        <section>
          <h2>开店申请</h2>
          <div class="row">
            <div class="col-md-8">
              <div class="card">
                <div class="card-header" data-background-color="purple">
                  <h4 class="title">开店申请</h4>
                  <p class="category"></p>
                </div>
                <div class="card-content">
                  <%--开店申请表格--%>
                  <form action="${pageContext.request.contextPath}/hotel/request-open" method="post">
                    <%--基本信息--%>
                    <%@include file="hotel-form.jsp"%>

                    <button type="submit" class="btn btn-primary pull-left">
                      提交申请
                    </button>
                    <div class="clearfix"></div>
                  </form>

                </div>
              </div>
            </div>
          </div>
        </section>

        <!--修改信息-->
        <section>
          <div class="row">
            <div class="col-md-8">
              <div class="card">
                <div class="card-header" data-background-color="purple">
                  <h4 class="title">修改信息</h4>
                  <p class="category"></p>
                </div>
                <div class="card-content">
                  <form action="${pageContext.request.contextPath}/hotel/request-modify" method="post">

                    <%@include file="hotel-form.jsp"%>

                    <!--其他信息-->
                    <div class="row">
                      <div class="col-md-4">
                        <div class="form-group label-floating">
                          <label class="control-label">酒店电话</label>
                          <input value="${hotel.phone}" name="phone" type="text" class="form-control">
                        </div>
                      </div>
                      <div class="col-md-4">
                        <div class="form-group label-floating">
                          <label class="control-label">法人信息</label>
                          <input value="${hotel.representative}" name="legalRepresentative" type="text" class="form-control">
                        </div>
                      </div>
                    </div>

                    <button type="submit" class="btn btn-primary pull-left">
                      提交申请
                    </button>
                    <div class="clearfix"></div>
                  </form>
                </div>
              </div>
            </div>
          </div>
        </section>

        <!--正在审批-->
        <section>
          <h2>正在审批</h2>
          <div class="row">
            <div class="col-md-10">
              <div class="card">
                <div class="card-header" data-background-color="purple">
                  <h4 class="title">正在审批的申请</h4>
                  <p class="category">开店申请/修改店信息需Hostel World经理审批</p>
                </div>

                <div class="card-content table-responsive">
                  <c:if test="${!empty waitingList}">
                    <table class="table">
                      <thead class="text-primary">
                      <th>类别</th>
                      <th>主要内容</th>
                      <th>提交时间</th>
                      <th>操作</th>
                      </thead>
                      <tbody>
                      <c:forEach items="${waitingList}" var="one">
                        <tr>
                          <td>${one.strType}</td>
                          <td>${one.mainContent}</td>
                          <td>${one.strTime}</td>
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

        <!--已经通过-->
        <section>
          <h2>已经通过</h2>
          <div class="row">
            <div class="col-md-10">
              <div class="card">
                <div class="card-header" data-background-color="purple">
                  <h4 class="title">已经通过的申请</h4>
                  <p class="category">Hostel World经理审批过的申请，可以开始执行</p>
                </div>

                <div class="card-content table-responsive">
                  <c:if test="${!empty passedList}">
                    <table class="table">
                      <thead class="text-primary">
                      <th>类别</th>
                      <th>主要内容</th>
                      <th>提交时间</th>
                      <th>操作</th>
                      </thead>
                      <tbody>
                      <c:forEach items="${passedList}" var="one">
                        <tr>
                          <td>${one.strType}</td>
                          <td>${one.mainContent}</td>
                          <td>${one.strTime}</td>
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

        <!--没有通过-->
        <section>
          <h2>没有通过</h2>
          <div class="row">
            <div class="col-md-10">
              <div class="card">
                <div class="card-header" data-background-color="purple">
                  <h4 class="title">没有通过的申请</h4>
                  <p class="category">Hostel World经理审批过的申请，可以开始执行</p>
                </div>

                <div class="card-content table-responsive">
                  <c:if test="${!empty deniedList}">
                    <table class="table">
                      <thead class="text-primary">
                      <th>类别</th>
                      <th>主要内容</th>
                      <th>提交时间</th>
                      <th>操作</th>
                      </thead>
                      <tbody>
                      <c:forEach items="${deniedList}" var="one">
                        <tr>
                          <td>${one.strType}</td>
                          <td>${one.mainContent}</td>
                          <td>${one.strTime}</td>
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
      </div>
    </div>

    <!--3.页脚-->
    <%@include file="../common/footer.jsp" %>
  </div>
</div>

</body>

<%@include file="../common/js-file.jsp" %>

</html>
