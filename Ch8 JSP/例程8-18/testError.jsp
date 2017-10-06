<%@ page errorPage="dealError.jsp"%>
<%
	out.println("before exception!");
	int x = 1/0;
	out.println("after exception!");
%>