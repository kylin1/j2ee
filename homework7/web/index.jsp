<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>

<body>
<h1>Welcome to j2ee homework</h1>

<p>jsp declaration</p>
<%!
    int x = 5;

    private int method(int y) {
        return x * y;
    }
%>

<p>jsp expression 呈现某个值 </p>
<%= new java.util.Date() %>

<p> jsp scriptlet, service method in serlvet</p>
<ul>
    <%
        for (int i = 0; i < 3; i++) {
    %>
    <li><%= method(i + x)%>
    </li>
    <%
        }
    %>
</ul>

</body>
</html>
