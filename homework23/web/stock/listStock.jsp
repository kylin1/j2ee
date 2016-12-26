<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib prefix="stock" uri="/WEB-INF/tlds/stockInfo.tld" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>Watch List</title>
</head>

<BODY>
<table width="650" border="0">
    <tr>
        <td width="650" height="80"
            background="<%=request.getContextPath() + "/image/top.jpg"%>">&nbsp;</td>
    </tr>
    <tr>
        <td><a href="<%=request.getContextPath() + "/user/login.jsp"%>">Login</a>&nbsp;&nbsp;
            <a href="<%=request.getContextPath() + "/user/register.html"%>">Register</a>&nbsp;&nbsp;
            <a href="<%=request.getContextPath() + "/StockListServlet"%>">Watch
                Stock List</a>&nbsp;&nbsp; <a
                    href="<%=request.getContextPath() + "/logout.do"%>">Log off</a>&nbsp;&nbsp;
            <a href="<%=request.getContextPath() + "/loadUser.do"%>">My
                Profile</a>&nbsp;&nbsp; <a
                    href="<%=request.getContextPath() + "/showWatchList.do"%>">Watch
                My Stock List</a>&nbsp;&nbsp; <a
                    href="<%=request.getContextPath() + "/index.do"%>">Order
                Cancellation</a>&nbsp;&nbsp; <a
                    href="<%=request.getContextPath() + "/stock/search.jsp"%>">Search</a>
        </td>
    </tr>
</table>
<H1>Online Stock.</H1>
<H2>
    <BR>
    There are all Stocks.
</H2>
<H4>
    <BR>
    <TABLE width="100%" border="0" cellpadding="0" cellspacing="1">
        <TBODY>
        <TR>
            <TH width="20%">id</TH>
            <TH width="20%">companyName</TH>
            <TH width="20%">type</TH>
            <TH width="20%">price</TH>
            <TH width="20%">date</TH>
        </TR>

        <%--tlds : jsp页中就可使用tag规定的前缀--%>
        <%--JSP程序员把程序的基本功能用自定义的标签库来实现--%>
        <%--美工人员使用这些标签，可以专注于数据的表达,对比原始方法:写java代码遍历--%>
        <stock:stockInfo/>

        </TBODY>
    </TABLE>
</H4>

<h1>Today's Stock Price</h1>
<%--0. set tag attribute value, so handler can get and process them--%>
<p><stock:stockPrice tickerSymbol="PRAS"/></p>
<p><stock:stockPrice tickerSymbol="GIRD"/></p>

<h2>带标签体的标签-迭代器标签</h2>
<hr>
<%
    //创建一个List对象
    List<String> list = new ArrayList<String>();
    list.add("hello");
    list.add("world");
    list.add("java");
    //将List对象放入page范围内
    pageContext.setAttribute("oneList", list);
%>

<table border="1" bgcolor="aaaadd" width="300">
    <!-- 使用迭代器标签，对a集合进行迭代 -->
    <stock:iterator collection="oneList" item="item">
    <tr>
        <td>${pageScope.item}</td>
    <tr>
    </stock:iterator>
</table>

</BODY>
</html>


