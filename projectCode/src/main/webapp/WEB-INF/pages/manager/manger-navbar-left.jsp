<%--
  Created by IntelliJ IDEA.
  User: kylin
  Date: 12/03/2017
  Time: 14:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--整个左侧导航栏--%>
<div class="sidebar" data-color="purple" data-image="../assets/img/sidebar-1.jpg">

  <!--导航左上角的图标-->
  <div class="logo">
    <a href="#" class="simple-text">
      Hostel World-经理
    </a>
  </div>

  <!--导航栏整体-->
  <div class="sidebar-wrapper">
    <ul class="nav">
      <li>
        <a href="approve.jsp">
          <i class="material-icons">today</i>
          <p>审批请求</p>
        </a>
      </li>

      <!--这是一个导航的图标-->
      <li>
        <a href="settle.jsp">
          <!-- 导航图标的样式-->
          <i class="material-icons">timeline</i>
          <!--显示的文字-->
          <p>结算管理</p>
        </a>
      </li>

      <!--下面是其他的item代表更多的导航-->
      <li>
        <a href="statistic.jsp">
          <i class="material-icons">stars</i>
          <p>统计信息</p>
        </a>
      </li>
      <li>
        <a href="member.jsp">
          <i class="material-icons">group</i>
          <p>会员信息</p>
        </a>
      </li>

    </ul>
  </div>
</div>
