<%--
  Created by IntelliJ IDEA.
  User: kylin
  Date: 27/12/2016
  Time: 13:51
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html; charset=GBK" language="java" %>
<%@ page session="false" %>
<%@ taglib prefix="kylin" uri="/WEB-INF/tlds/kylin.tld" %>

<html>
<head>
    <title>tag test</title>
</head>

<body>

<br>

<h1> before kylin tag</h1>

<kylin:loop counts="2">
    <%--����ʱ���ǣ�<%=new java.util.Date().toString()%><br>--%>

    <%-- //SKIP_BODY:Ҫ��JSP������������ ���Կ��ƽ������ת��� --%>
    <jsp:forward page="/Login" />

</kylin:loop>

<h1> after kylin tag</h1>

</body>
</html>