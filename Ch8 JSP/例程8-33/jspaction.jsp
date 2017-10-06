<jsp:directive.page import="java.util.Date" />
<jsp:declaration>
	int count = 1;
</jsp:declaration>
<jsp:scriptlet>
	String currentTime = new Date().toString();
</jsp:scriptlet>
<jsp:text>
<![CDATA[
<html>
<head>
<title>a simple jsp</title>
</head>
<body>
current time is <i><u>
]]>
</jsp:text>
<jsp:expression>currentTime</jsp:expression>
<jsp:text><![CDATA[
</u></i>
</body>
</html>
]]>
</jsp:text>