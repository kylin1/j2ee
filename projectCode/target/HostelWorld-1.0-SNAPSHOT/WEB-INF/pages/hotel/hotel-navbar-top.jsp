<%--
  Created by IntelliJ IDEA.
  User: kylin
  Date: 11/03/2017
  Time: 16:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!--1.导航栏-->
<nav class="navbar navbar-primary navbar-absolute">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="#">Hi, 客栈工作人员 :)</a>
    </div>
    <!--右侧三个小按钮-->
    <div class="collapse navbar-collapse" id="example-navbar-primary">
      <ul class="nav navbar-nav navbar-right">

        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown">
            <i class="material-icons">notifications</i>
            <span class="notification">2</span>
            <p class="hidden-lg hidden-md">Notifications</p>
            Messages
          </a>
          <ul class="dropdown-menu">
            <li><a href="#">您最近一个申请信息正在等待审批！</a></li>
            <li><a href="#">本店上月的本店统计信息已经发布，可以查看！</a></li>
          </ul>
        </li>

        <li class="active">
          <a href="#">
            <i class="material-icons">account_circle</i>
            Dashboard
          </a>
        </li>

        <li>
          <a href="#">
            <i class="material-icons">settings</i>
            Settings
          </a>
        </li>
      </ul>
    </div>
  </div>
</nav>
