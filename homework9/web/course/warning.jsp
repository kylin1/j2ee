<%--
  Created by IntelliJ IDEA.
  User: kylin
  Date: 26/12/2016
  Time: 17:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="false"%>

<%@ taglib prefix="kylin" uri="/WEB-INF/tlds/kylin.tld" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Warning page</title>
</head>
<body>

<%--<kylin:checkLogin>--%>
    <%--<c:redirect url="/Login"/>--%>
<%--</kylin:checkLogin>--%>

<kylin:warning/>

<form method='GET' action='/Login'>
    <input type='submit' name='return' value='return'>
</form>

<kylin:countNumber/>

</body>
</html>
