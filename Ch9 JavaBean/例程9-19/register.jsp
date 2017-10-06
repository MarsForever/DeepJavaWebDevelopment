<%@ page contentType="text/html;GB2312" %>
<%-- 注册失败也回到此页面，此时，FORM表单中的各个字段应自动设置为
上次输入的内容，并在发生错误的字段旁用红色字体显示出错误的提示信息。
 --%>

<jsp:useBean id="registerForm" class="org.it315.bean.RegisterFormBean" 
		scope="request"/>
<form action="../servlet/controller" method="post">
姓名：<input type="text" name="name" 
	value='<jsp:getProperty name="registerForm" property="name" />'>
	<font color="red"><%=registerForm.getErrorMsg("name")%></font><br>
密码：<input type="password" name="password1" 
	value='<jsp:getProperty name="registerForm" property="password1" />'>
	<font color="red"><%=registerForm.getErrorMsg("password1")%></font><br>
确认密码：<input type="password" name="password2" 
	value='<jsp:getProperty name="registerForm" property="password2" />'>
	<font color="red"><%=registerForm.getErrorMsg("password2")%></font><br>
Email:<input type="text" name="email" 
	value='<jsp:getProperty name="registerForm" property="email" />'>
	<font color="red"><%=registerForm.getErrorMsg("email")%></font><br>
<input type="submit" name="submit" value="注册">
</form>