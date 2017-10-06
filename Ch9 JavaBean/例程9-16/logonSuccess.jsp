<%@ page contentType="text/html;GB2312" %>

<%
	//如果JSP页面的当前执行过程是对注销行为的响应
	if("logout".equals(request.getParameter("action")))
	{
		session.invalidate();
%>
		<jsp:forward page="logon.jsp"/>
<%
	}
	//如果当前会话的用户还没有登录
	if(session.getAttribute("logonUser") == null)
	{
%>
		<jsp:forward page="logon.jsp" />
<%		
	}
%>
<jsp:useBean id="logonUser" class="org.it315.bean.UserBean" scope="session" />

恭喜你，登录成功！<br>
<jsp:getProperty name="logonUser" property="name" /><br>
<jsp:getProperty name="logonUser" property="password" /><br>
<jsp:getProperty name="logonUser" property="email" /><br>
<a href="logonSuccess.jsp?action=logout">注销</a><br>
<a href="logon.jsp">重新登录</a>