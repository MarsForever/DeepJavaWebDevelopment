<%
	out.println("<html>");
	out.println("<head>");
	out.println("<title>a simple jsp</title>");
	out.println("</head>");
	out.println("<body>");
	out.print("current time is <i><u>");
	String currentTime = new java.util.Date().toString();
	out.println(currentTime);
	out.println("</u></i></body>");
	out.println("</html>")
%>