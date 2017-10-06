<%@ page contentType="text/html;charset=GB2312" %>
<%@ page import="org.it315.util.DbUtil" %>
<%@ page import="org.it315.bean.UserBean" %>

<%
	//�����ǰ�Ự���û��Ѿ���¼
	if(session.getAttribute("logonUser") != null)
	{
%>
		<jsp:forward page="logonSuccess.jsp" />
<%		
	}
%>
<jsp:useBean id="logonForm" class="org.it315.bean.LogonFormBean" scope="page"/>
<jsp:setProperty name="logonForm" property="*" />
<%
//���JSPҳ��ĵ�ǰִ�й����ǶԱ��ύ����Ӧ
if(request.getParameter("submit") != null)
{
	//������ֶ�����д�����ݸ�ʽû������
	if(logonForm.validate())
	{
		DbUtil db = DbUtil.getInstance();
		UserBean user = db.getUser(logonForm.getName());
		//������ݿ��в����ڵ�¼�û����ļ�¼
		if(user == null)
		{
			logonForm.setErrorMsg("name","no this user!");
		}
		else
		{
			//����û����벻��ȷ
			if(user.validatePassword(logonForm.getPassword()))
			{
				/*�û��ɹ���¼���һϵ�лỰ��ж�����Ҫʹ��
				��ǰ�û�����Ϣ�����ԣ�Ӧ�ý���ǰ��¼�û�����Ϣ
				���浽Session����*/	
				session.setAttribute("logonUser",user);
%>
				<jsp:forward page="logonSuccess.jsp" />
<%
			}
			else
			{
				logonForm.setErrorMsg("password","password error!");
			}
		}
	}
}
%>

<%-- 
��������FORM���ǵ�¼ʧ�ܺ���ٴ���ʾ�����еĸ����ֶ�Ӧ�Զ�����Ϊ
�ϴ���������ݣ����ڷ���������ֶ����ú�ɫ������ʾ���������ʾ��Ϣ��
--%> 
<form action="logon.jsp" method="post">
������<input type="text" name="name" value='<%=logonForm.getName()%>'>
	<font color="red"><%=logonForm.getErrorMsg("name")%></font><br>
���룺<input type="password" name="password" value='<%=logonForm.getPassword()%>'>
	<font color="red"><%=logonForm.getErrorMsg("password")%></font><br>
<input type="submit" name="submit" value="��¼">
</form>