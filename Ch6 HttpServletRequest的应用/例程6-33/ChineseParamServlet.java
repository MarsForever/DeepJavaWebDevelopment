import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ChineseParamServlet extends HttpServlet
{
	public void doGet(HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html;charset=gb2312");
		PrintWriter out = response.getWriter();
		
		request.setCharacterEncoding("gb2312");
		String paramValue = request.getParameter("param1");
		if(paramValue == null || paramValue.equals(""))
		{
			out.println("�봫��һ����ȷ�Ĳ���");
			return;
		}
		
		out.println("�ղ�����Ĳ���ֵΪ��" + paramValue);
		//Ҳ����ʹ������������������������������
		/*out.println("�ղ�����Ĳ���ֵΪ��" + 
			new String(paramValue.getBytes("iso8859-1"),"gb2312"));*/
		System.out.println("�������ַ�������Ϊ��" + 
							request.getCharacterEncoding());
		int numsOfChar = paramValue.length();
		System.out.println("����ֵΪ��" + paramValue);
		System.out.println("����ֵ�е��ַ�������" + numsOfChar);
		System.out.print("�����е�ÿ���ַ���Unicode��ֵ��");
		for(int i=0; i<numsOfChar; i++)
		{
			int ch = paramValue.charAt(i);
			System.out.print("[" + Integer.toHexString(ch) + "]");
		}
		System.out.println(); 
	}
	
	public void doPost(HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException
	{
		doGet(request,response);
	}
}