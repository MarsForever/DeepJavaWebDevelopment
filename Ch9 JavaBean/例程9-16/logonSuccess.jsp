<%@ page contentType="text/html;GB2312" %>

<%
	//���JSPҳ��ĵ�ǰִ�й����Ƕ�ע����Ϊ����Ӧ
	if("logout".equals(request.getParameter("action")))
	{
		session.invalidate();
%>
		<jsp:forward page="logon.jsp"/>
<%
	}
	//�����ǰ�Ự���û���û�е�¼
	if(session.getAttribute("logonUser") == null)
	{
%>
		<jsp:forward page="logon.jsp" />
<%		
	}
%>
<jsp:useBean id="logonUser" class="org.it315.bean.UserBean" scope="session" />

��ϲ�㣬��¼�ɹ���<br>
<jsp:getProperty name="logonUser" property="name" /><br>
<jsp:getProperty name="logonUser" property="password" /><br>
<jsp:getProperty name="logonUser" property="email" /><br>
<a href="logonSuccess.jsp?action=logout">ע��</a><br>
<a href="logon.jsp">���µ�¼</a>