<%--
  Created by IntelliJ IDEA.
  User: kylin
  Date: 12/03/2017
  Time: 14:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<nav class="navbar navbar-transparent navbar-top" role="navigation">
  <div class="container">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button id="menu-toggle" type="button" class="navbar-toggle"
              data-toggle="collapse" data-target="#example">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar bar1"></span>
        <span class="icon-bar bar2"></span>
        <span class="icon-bar bar3"></span>
      </button>
      <a href="#">
        <div class="logo-container">
          <div class="logo">
            <img src="<%=request.getContextPath() %>/assets/img/new_logo.png" alt="Creative Tim Logo">
          </div>
          <div class="brand">
            com.kylin sports
          </div>
        </div>
      </a>
    </div>
    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="example">
      <ul class="nav navbar-nav navbar-right">
        <li>
          <a href="today.html">
            Trips
          </a>
        </li>
        <li>
          <a href="login.html">
            Help
          </a>
        </li>
        <li>
          <a href="signup.html">
            Membership
          </a>
        </li>
      </ul>
    </div>
    <!-- /.navbar-collapse -->
  </div>
</nav>