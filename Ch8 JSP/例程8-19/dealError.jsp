<%@ page isErrorPage="true" %>
<%@ page import="java.io.PrintWriter" %>
<%
	out.println("output of dealError!<br>");
	exception.printStackTrace(new PrintWriter(out));
%>