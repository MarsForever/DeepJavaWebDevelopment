<%@page contentType="text/html;charset=gb2312"%>
<%@page import="java.io.*"%>
<%@page import="java.util.*"%>

<%!
	//����һ��������ȡ�������ı��ļ��е�ÿ������
	Vector getMails(ServletContext application) throws Exception
	{
		//Ҫע��mails.txt�ļ���λ��
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
		//��������в������ʼ�����ֱ�ӷ��ء�
		if(document.mailForm.mail == null)
		{
			return;
		}

		/*��������д���һ������ʼ��������ִ�����̲Żᵽ������Ĳ�			�֡������if�����ж�������ֻ��һ���ʼ��������*/
		if(document.mailForm.mail.length == null)
		{	
			document.mailForm.mail.checked = 
					document.mailForm.ifAll.checked;
			return;
		}
		
		//����Ĵ������ڴ����������ж���ʼ������
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
	//����getMails()��������ȡ�ı��ļ��е����ݲ�������ͻ���
	Vector v = getMails(application);
	for(Enumeration e = v.elements();e.hasMoreElements();)
	{
		String mail = (String)e.nextElement();
		out.println("<input type ='checkbox' name='mail'>" + 
				mail + "<br>");
	}
	%>
	<input type="checkbox" name="ifAll" onclick="checkAll()">ȫѡ
</form>