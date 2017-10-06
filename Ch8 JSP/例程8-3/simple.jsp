<html>
<head>
<title>a simple jsp</title>
</head>
<body>
current time is <i><u>
<%
	String currentTime = new java.util.Date().toString();
	out.println(currentTime);
%>
</u></i></body>
</html>