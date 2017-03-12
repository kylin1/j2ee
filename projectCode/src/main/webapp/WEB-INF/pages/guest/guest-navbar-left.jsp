<%--
  Created by IntelliJ IDEA.
  User: kylin
  Date: 11/03/2017
  Time: 16:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="sidebar" data-color="purple" data-image="../assets/img/sidebar-1.jpg">

  <!--导航左上角的图标-->
  <div class="logo">
    <a href="#" class="simple-text">
      Hostel World
    </a>
  </div>

  <!--导航栏整体-->
  <div class="sidebar-wrapper">
    <ul class="nav">

      <li>
        <a href="${pageContext.request.contextPath}/guest/membership">
          <i class="material-icons">today</i>
          <p>Membership</p>
        </a>
      </li>

      <!--这是一个导航的图标-->
      <li>
        <a href="${pageContext.request.contextPath}/guest/orders">
          <!-- 导航图标的样式-->
          <i class="material-icons">timeline</i>
          <!--显示的文字-->
          <p>Orders</p>
        </a>
      </li>

      <!--下面是其他的item代表更多的导航-->
      <li>
        <a href="${pageContext.request.contextPath}/guest/pocket">
          <i class="material-icons">stars</i>
          <p>Pocket</p>
        </a>
      </li>
      <li>
        <a href="${pageContext.request.contextPath}/guest/profile">
          <i class="material-icons">group</i>
          <p>Profile</p>
        </a>
      </li>

    </ul>
  </div>
</div>