<%@ page contentType="text/html;charset=gb2312" 
	import="javax.servlet.jsp.tagext.BodyContent"%>
<%
	JspWriter anotherOut = pageContext.getOut();
	if(anotherOut == out)
	{
		out.println("1. ��ʼ��pageContext.getOut�����ķ���ֵ" +
			"������ʽout����<br>");
	}
	
	BodyContent out1 = pageContext.pushBody();
	JspWriter out2 = pageContext.getOut();
	if(out1 == out2)
	{
		out.println("2. pageContext.pushBody��������������õ�" + 
			"pageContext.getOut�����ķ���ֵ��ͬ��");
	} 
	if(out2 != out)
	{
		out.println("�������ֵ��������ʽout����");
		out2.println("��ʱд�뵽pageContext.getOut�������ص�" +
			"JspWriter�����е����ݲ��ᷢ�͸��ͻ��ˣ������Ժ����" + 
			"����Щ����ֱ��д�뵽����һ���ַ�����������У�����" + 
			"����Щ�������ַ������غ����������ʽ�Ĵ���<br>");

		/*BodyContent.getEnclosingWriter�����ķ���ֵ���ǵ���pushBody
		����ǰ��PageContext�����еġ�out������ָ���JspWriter����
		��ʱout2.getEnclosingWriter�����ķ���ֵ������ʽout����
		����Ĵ��벢û�а���������д������Ϊ���ö��߸��õ����out1��
		out2��out2.getEnclosingWriter�����ķ���ֵ��out�ȼ��߼�Ĺ�ϵ��			*/
		out1.writeOut(((BodyContent)out2).getEnclosingWriter());
		out.println("�������������ַ������غ������һ�飺" + 
			out1.getString());
	}
	
	JspWriter out3 = pageContext.popBody();
	JspWriter out4 = pageContext.getOut();
	if(out3 == out4)
	{
		out.println("3. pageContext.popBody��������������õ�" + 
			"pageContext.getOut�����ķ���ֵ��ͬ��");
	} 
	if(out4 == out)
	{
		out.println("�������ֵ�ֵ�����ʽout�����ˡ�<br>");
	}
%>