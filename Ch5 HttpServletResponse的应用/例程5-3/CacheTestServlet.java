import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class CacheTestServlet extends HttpServlet
{
	public void service(HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html;charset=GB2312");
		/*
		response.setDateHeader("Expires",0);
		response.setHeader("Cache-Control","no-cache"); 
		response.setHeader("Pragma","no-cache"); 
		*/
		PrintWriter out = response.getWriter();
		out.println("������Ӧ�������Ϊ��" + Math.random());
		out.println("<form action='NotServlet'" + "method='POST'>" +
			"��һ��������<input type='text' name='p1'><br>" +
			"�ڶ���������<textarea name='p2'></textarea><br>" +
			"<input type='submit' value='�ύ'> " +
			"</form>");
	}
}