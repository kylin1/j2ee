<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: kylin
  Date: 11/03/2017
  Time: 12:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html lang="ch-ZN">
<jsp:include page='../common/header-with-date.jsp'>
  <jsp:param name="pageTitle" value="哎呀操作失败了~"/>
</jsp:include>


<body>

<div class="wrapper">
  <!--整个左侧导航栏-->
  <%@include file="guest-navbar-left.jsp" %>

  <!--主体界面-->
  <div class="main-panel">
    <!--1.导航栏-->
    <%@include file="guest-navbar-top.jsp" %>

    <!--2.内容-->
    <div class="content">
      <div class="container-fluid container-sharing" style="margin: 3em 0 5em 4em;">
        <%@include file="../common/error-display.jsp" %>
      </div>

    </div>

    <!--3.页脚-->
    <%@include file="../common/footer.jsp" %>
  </div>
</div>

</body>

<%@include file="../common/js-file.jsp" %>

</html>
