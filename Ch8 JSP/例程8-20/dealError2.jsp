<%@ page isErrorPage="true" %>
<%@ page import="java.io.PrintWriter" %>
<%
	out.println("output of dealError2!<br>");
	exception.printStackTrace(new PrintWriter(out));
%>