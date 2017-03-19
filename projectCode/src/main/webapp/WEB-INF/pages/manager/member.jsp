<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!doctype html>
<html lang="ch-ZN">

<jsp:include page='../common/header-basic.jsp'>
  <jsp:param name="pageTitle" value="会员查询"/>
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

        <!--查询会员信息-->
        <section>
          <div class="row">
            <div class="col-md-5">
              <div class="card card-signup">
                <form class="form" method="post" action="${pageContext.request.contextPath}/my-manager/search-member">
                  <div class="row">
                    <div class="header header-primary text-center">
                      <h4>请输入会员姓名进行查询</h4>
                    </div>
                  </div>

                  <div class="row">
                    <div class="col-md-9 col-md-offset-1">
                      <div class="content">
                        <div class="input-group">
										<span class="input-group-addon">
											<i class="material-icons">email</i>
										</span>
                          <input required="required" name="input" type="text" class="form-control" placeholder="会员姓名...">
                        </div>
                      </div>
                    </div>
                  </div>

                  <div class="footer text-center">
                    <button type="submit" class="btn btn-primary" style="margin-top: 1.7em">
                      search
                    </button>
                  </div>
                </form>
              </div>
            </div>
          </div>
        </section>

        <!--会员预订/消费情况-->
        <c:if test="${!empty searchResult}">
          <section>
            <h2>搜索结果</h2>
            <div class="row">
              <div class="col-md-10">
                <div class="card">
                  <div class="card-header" data-background-color="purple">
                    <h4 class="title">会员预订/消费情况</h4>
                  </div>

                  <div class="card-content table-responsive">
                    <table class="table">
                      <thead class="text-primary">
                      <th>会员姓名</th>
                      <th>下单日期</th>
                      <th>客栈</th>
                      <th>房间</th>
                      <th>金额</th>
                      <th>操作</th>
                      </thead>
                      <tbody>
                      <c:forEach items="${searchResult}" var="oneOrder">
                        <tr>
                          <td>${oneOrder.memberName}</td>
                          <td>${oneOrder.date}</td>
                          <td>${oneOrder.hotelName}</td>
                          <td>${oneOrder.strType}*${oneOrder.roomNumber}</td>
                          <td>￥${oneOrder.price}</td>
                          <td><a href="#">详情</a></td>
                        </tr>
                      </c:forEach>
                      </tbody>
                    </table>

                  </div>
                </div>
              </div>
            </div>

          </section>
        </c:if>
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
