<%@ page contentType="text/html;charset=GB2312" %>
<%@ page import="org.it315.util.DbUtil" %>
<%@ page import="org.it315.bean.UserBean" %>

<%
	//如果当前会话的用户已经登录
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
//如果JSP页面的当前执行过程是对表单提交的响应
if(request.getParameter("submit") != null)
{
	//如果表单字段中填写的内容格式没有问题
	if(logonForm.validate())
	{
		DbUtil db = DbUtil.getInstance();
		UserBean user = db.getUser(logonForm.getName());
		//如果数据库中不存在登录用户名的记录
		if(user == null)
		{
			logonForm.setErrorMsg("name","no this user!");
		}
		else
		{
			//如果用户密码不正确
			if(user.validatePassword(logonForm.getPassword()))
			{
				/*用户成功登录后的一系列会话活动中都可能要使用
				当前用户的信息，所以，应该将当前登录用户的信息
				保存到Session域中*/	
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
如果下面的FORM表单是登录失败后的再次显示，其中的各个字段应自动设置为
上次输入的内容，并在发生错误的字段旁用红色字体显示出错误的提示信息。
--%> 
<form action="logon.jsp" method="post">
姓名：<input type="text" name="name" value='<%=logonForm.getName()%>'>
	<font color="red"><%=logonForm.getErrorMsg("name")%></font><br>
密码：<input type="password" name="password" value='<%=logonForm.getPassword()%>'>
	<font color="red"><%=logonForm.getErrorMsg("password")%></font><br>
<input type="submit" name="submit" value="登录">
</form>