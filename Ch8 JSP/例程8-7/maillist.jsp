<%@page contentType="text/html;charset=gb2312"%>
<%@page import="java.io.*"%>
<%@page import="java.util.*"%>

<%!
	//定义一个方法读取并返回文本文件中的每行数据
	Vector getMails(ServletContext application) throws Exception
	{
		//要注意mails.txt文件的位置
		InputStream ips = application.getResourceAsStream("/mails.txt");
		BufferedReader br = 
			new BufferedReader(new InputStreamReader(ips));
		Vector vMails = new Vector();
		String mail = br.readLine();
		
		while(mail != null)
		{
			vMails.add(mail);
			mail = br.readLine();
		}
		
		br.close();
		return vMails;
	}
%>

<script language="javascript">
	function checkAll()
	{
		//如果邮箱中不存在邮件，就直接返回。
		if(document.mailForm.mail == null)
		{
			return;
		}

		/*如果邮箱中存在一封或多封邮件，程序的执行流程才会到达下面的部			分。下面的if条件判断邮箱中只有一封邮件的情况。*/
		if(document.mailForm.mail.length == null)
		{	
			document.mailForm.mail.checked = 
					document.mailForm.ifAll.checked;
			return;
		}
		
		//下面的代码用于处理邮箱中有多封邮件的情况
		var count = document.mailForm.mail.length;
		for(var i=0; i<count; i++)
		{
			document.mailForm.mail[i].checked = 
					document.mailForm.ifAll.checked;
		}
	}
</script>

<form name="mailForm">
	<%
	//调用getMails()方法，读取文本文件中的数据并输出给客户端
	Vector v = getMails(application);
	for(Enumeration e = v.elements();e.hasMoreElements();)
	{
		String mail = (String)e.nextElement();
		out.println("<input type ='checkbox' name='mail'>" + 
				mail + "<br>");
	}
	%>
	<input type="checkbox" name="ifAll" onclick="checkAll()">全选
</form>