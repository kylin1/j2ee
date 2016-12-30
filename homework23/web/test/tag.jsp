<%--
  Created by IntelliJ IDEA.
  User: kylin
  Date: 27/12/2016
  Time: 13:51
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page session="false" %>

<%@ taglib prefix="kylin" uri="/WEB-INF/tlds/kylin.tld" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>tag test</title>
</head>

<body>

<br>

<h1> before kylin tag</h1>

<kylin:checkLogin>
    <c:redirect url="/Login"/>
</kylin:checkLogin>

<h1> after kylin tag</h1>

</body>
</html>