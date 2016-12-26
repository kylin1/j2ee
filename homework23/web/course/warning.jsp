<%--
  Created by IntelliJ IDEA.
  User: kylin
  Date: 26/12/2016
  Time: 17:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="kylin" uri="/WEB-INF/tlds/kylin.tld" %>
<%@ page session="false"%>

<html>
<head>
    <title>Warning page</title>
</head>
<body>

<kylin:warning/>

<form method='GET' action='/Login'>
    <input type='submit' name='return' value='return'>
</form>

<kylin:countNumber/>

</body>
</html>
