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
	<%-- from StockListServlet no bean is instantiated.--%>
	<jsp:useBean id="listStock"
				 type="edu.nju.action.business.StockListBean"
				 scope="session">
	</jsp:useBean>

	<%-- instantiates the specified bean class --%>
	<jsp:useBean id="item" class="edu.nju.model.Stock"
				 scope="page">
	</jsp:useBean>
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
		<stock:stockInfo/>

		<%--原始方法:写java代码遍历--%>

		</TBODY>
	</TABLE>
</H4>
</BODY>
</html>


