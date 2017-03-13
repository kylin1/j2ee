<%--
  Created by IntelliJ IDEA.
  User: kylin
  Date: 11/03/2017
  Time: 16:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!--整个左侧导航栏-->
<div class="sidebar" data-color="purple" data-image="../assets/img/sidebar-1.jpg">

  <!--导航左上角的图标-->
  <div class="logo">
    <a href="request.jsp" class="simple-text">
      Hostel World-客栈管理
    </a>
  </div>

  <!--导航栏整体-->
  <div class="sidebar-wrapper">
    <ul class="nav">
      <li>
        <a href="${pageContext.request.contextPath}/hotel/room-search">
          <i class="material-icons">search</i>
          <p>房间搜索</p>
        </a>
      </li>

      <li>
        <a href="${pageContext.request.contextPath}/hotel/customer-register">
          <i class="material-icons">today</i>
          <p>住客登记</p>
        </a>
      </li>

      <!--这是一个导航的图标-->
      <li>
        <a href="${pageContext.request.contextPath}/hotel/post-plan">
          <!-- 导航图标的样式-->
          <i class="material-icons">timeline</i>
          <!--显示的文字-->
          <p>发布计划</p>
        </a>
      </li>

      <!--下面是其他的item代表更多的导航-->
      <li>
        <a href="${pageContext.request.contextPath}/hotel/request">
          <i class="material-icons">stars</i>
          <p>申请&审批</p>
        </a>
      </li>

      <li>
        <a href="${pageContext.request.contextPath}/hotel/statistic">
          <i class="material-icons">group</i>
          <p>统计信息</p>
        </a>
      </li>

    </ul>
  </div>
</div>