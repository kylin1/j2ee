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
                  <table class="table">
                    <thead class="text-primary">
                    <th>客栈</th>
                    <th>类别</th>
                    <th>主要内容</th>
                    <th>提交时间</th>
                    <th>操作</th>
                    </thead>
                    <tbody>
                    <tr>
                      <td>上海和平饭店</td>
                      <td>修改客栈信息</td>
                      <td>新增空闲房间</td>
                      <td>2017年02月13日10:00:59</td>
                      <td><a href="#">通过</a> <a href="#">否决</a></td>
                    </tr>
                    <tr>
                      <td>上海和平饭店</td>
                      <td>修改客栈信息</td>
                      <td>新增空闲房间</td>
                      <td>2017年02月13日10:00:59</td>
                      <td><a href="#">通过</a> <a href="#">否决</a></td>
                    </tr>
                    <tr>
                      <td>上海和平饭店</td>
                      <td>修改客栈信息</td>
                      <td>新增空闲房间</td>
                      <td>2017年02月13日10:00:59</td>
                      <td><a href="#">通过</a> <a href="#">否决</a></td>
                    </tr>

                    </tbody>
                  </table>

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
                    <tr>
                      <td>上海和平饭店</td>
                      <td>开店申请</td>
                      <td>申请加入Hostel World</td>
                      <td>2017年02月13日10:00:59</td>
                      <td>允许</td>
                      <td><a href="#">详情</a></td>
                    </tr>
                    <tr>
                      <td>上海和平饭店</td>
                      <td>开店申请</td>
                      <td>申请加入Hostel World</td>
                      <td>2017年02月13日10:00:59</td>
                      <td>允许</td>
                      <td><a href="#">详情</a></td>
                    </tr>
                    <tr>
                      <td>上海和平饭店</td>
                      <td>开店申请</td>
                      <td>申请加入Hostel World</td>
                      <td>2017年02月13日10:00:59</td>
                      <td>允许</td>
                      <td><a href="#">详情</a></td>
                    </tr>

                    </tbody>
                  </table>

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
