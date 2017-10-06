<%@ page contentType="text/html;charset=gb2312" 
	import="javax.servlet.jsp.tagext.BodyContent"%>
<%
	JspWriter anotherOut = pageContext.getOut();
	if(anotherOut == out)
	{
		out.println("1. 初始的pageContext.getOut方法的返回值" +
			"就是隐式out对象。<br>");
	}
	
	BodyContent out1 = pageContext.pushBody();
	JspWriter out2 = pageContext.getOut();
	if(out1 == out2)
	{
		out.println("2. pageContext.pushBody方法与它后面调用的" + 
			"pageContext.getOut方法的返回值相同，");
	} 
	if(out2 != out)
	{
		out.println("这个返回值不等于隐式out对象，");
		out2.println("此时写入到pageContext.getOut方法返回的" +
			"JspWriter对象中的内容不会发送给客户端，但是以后可以" + 
			"将这些内容直接写入到另外一个字符输出流对象中，或者" + 
			"将这些内容以字符串返回后进行其他方式的处理！<br>");

		/*BodyContent.getEnclosingWriter方法的返回值就是调用pushBody
		方法前的PageContext对象中的“out”属性指向的JspWriter对象，
		此时out2.getEnclosingWriter方法的返回值就是隐式out对象，
		下面的代码并没有按常理来编写，就是为了让读者更好地理解out1、
		out2、out2.getEnclosingWriter方法的返回值、out等几者间的关系。			*/
		out1.writeOut(((BodyContent)out2).getEnclosingWriter());
		out.println("将上面内容以字符串返回后再输出一遍：" + 
			out1.getString());
	}
	
	JspWriter out3 = pageContext.popBody();
	JspWriter out4 = pageContext.getOut();
	if(out3 == out4)
	{
		out.println("3. pageContext.popBody方法与它后面调用的" + 
			"pageContext.getOut方法的返回值相同，");
	} 
	if(out4 == out)
	{
		out.println("这个返回值又等于隐式out对象了。<br>");
	}
%>