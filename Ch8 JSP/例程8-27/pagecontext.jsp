<%@ page contentType="text/html;charset=GB2312"%>
<%!
	PageContext lastPageContext = null;
	int count = 0;
%>
<%
	if(count != 0)
	{
		if(lastPageContext == pageContext)
		{
			out.println("�������ϴε�pageContext��ͬ<br>");
		}
		else
		{
			out.println("�������ϴε�pageContext����ͬ<br>");
		}
	
		String x = (String)pageContext.getAttribute("x");
		if("abc".equals(x))
		{
			out.println("�����ѻ���ϴδ洢��pageContext�е�����<br>");
		}
		else
		{
			out.println("����δ����ϴδ洢��pageContext�е�����<br>");
		}
	
	}
	lastPageContext = pageContext;
	pageContext.setAttribute("x",new String("abc"));
	count++;
%>