<%
	RequestDispatcher rd = application.getRequestDispatcher("/test.html");
	rd.forward(request,response);
%>