<%--
  Created by IntelliJ IDEA.
  User: kylin
  Date: 26/12/2016
  Time: 20:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="kylin" uri="/WEB-INF/tlds/kylin.tld" %>
<%@ page session="false"%>
<html>
<head>
    <title>Log in</title>
</head>
<body>

<form method='POST' action='${pageContext.request.contextPath}/show'>
    login: <input type='text' name='login' value='kylin2'>
    password: <input type='password' name='password' value=''>
    <input type='submit' name='Submit' value='Submit'>
</form>

<kylin:countNumber/>

</body>
</html>
