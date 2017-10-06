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
			out.println("本次与上次的pageContext相同<br>");
		}
		else
		{
			out.println("本次与上次的pageContext不相同<br>");
		}
	
		String x = (String)pageContext.getAttribute("x");
		if("abc".equals(x))
		{
			out.println("本次已获得上次存储在pageContext中的属性<br>");
		}
		else
		{
			out.println("本次未获得上次存储在pageContext中的属性<br>");
		}
	
	}
	lastPageContext = pageContext;
	pageContext.setAttribute("x",new String("abc"));
	count++;
%>