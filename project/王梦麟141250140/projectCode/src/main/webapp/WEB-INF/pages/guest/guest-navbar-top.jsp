<%--
  Created by IntelliJ IDEA.
  User: kylin
  Date: 11/03/2017
  Time: 16:18
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
      <a class="navbar-brand" href="#">Hi, com.kylin :)</a>
    </div>
    <!--右侧三个小按钮-->
    <div class="collapse navbar-collapse" id="example-navbar-primary">
      <ul class="nav navbar-nav navbar-right">

        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown">
            <i class="material-icons">notifications</i>
            <span class="notification">3</span>
            <p class="hidden-lg hidden-md">Notifications</p>
            Messages
          </a>
          <ul class="dropdown-menu">
            <li><a href="#">一只麟请求加您为好友</a></li>
            <li><a href="#">您的今日目标还未达到,要加油啦~</a></li>
            <li><a href="#">竞赛:"7日100公里"即将结束,请抓紧时间上传数据</a></li>
          </ul>
        </li>

        <li>
          <a href="/logout/${userID}">
            <i class="material-icons">account_circle</i>logout
          </a>
        </li>
      </ul>
    </div>
  </div>
</nav>