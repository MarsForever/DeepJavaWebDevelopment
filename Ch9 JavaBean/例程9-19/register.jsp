<%@ page contentType="text/html;GB2312" %>
<%-- ע��ʧ��Ҳ�ص���ҳ�棬��ʱ��FORM���еĸ����ֶ�Ӧ�Զ�����Ϊ
�ϴ���������ݣ����ڷ���������ֶ����ú�ɫ������ʾ���������ʾ��Ϣ��
 --%>

<jsp:useBean id="registerForm" class="org.it315.bean.RegisterFormBean" 
		scope="request"/>
<form action="../servlet/controller" method="post">
������<input type="text" name="name" 
	value='<jsp:getProperty name="registerForm" property="name" />'>
	<font color="red"><%=registerForm.getErrorMsg("name")%></font><br>
���룺<input type="password" name="password1" 
	value='<jsp:getProperty name="registerForm" property="password1" />'>
	<font color="red"><%=registerForm.getErrorMsg("password1")%></font><br>
ȷ�����룺<input type="password" name="password2" 
	value='<jsp:getProperty name="registerForm" property="password2" />'>
	<font color="red"><%=registerForm.getErrorMsg("password2")%></font><br>
Email:<input type="text" name="email" 
	value='<jsp:getProperty name="registerForm" property="email" />'>
	<font color="red"><%=registerForm.getErrorMsg("email")%></font><br>
<input type="submit" name="submit" value="ע��">
</form>