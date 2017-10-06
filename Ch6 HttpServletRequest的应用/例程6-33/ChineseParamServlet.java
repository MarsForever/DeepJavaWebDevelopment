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
			out.println("请传递一个正确的参数");
			return;
		}
		
		out.println("刚才输入的参数值为：" + paramValue);
		//也可以使用如下语句解决本程序的中文乱码问题
		/*out.println("刚才输入的参数值为：" + 
			new String(paramValue.getBytes("iso8859-1"),"gb2312"));*/
		System.out.println("参数的字符集编码为：" + 
							request.getCharacterEncoding());
		int numsOfChar = paramValue.length();
		System.out.println("参数值为：" + paramValue);
		System.out.println("参数值中的字符个数：" + numsOfChar);
		System.out.print("参数中的每个字符的Unicode码值：");
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