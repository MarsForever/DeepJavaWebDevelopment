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
		out.println("本次响应的随机数为：" + Math.random());
		out.println("<form action='NotServlet'" + "method='POST'>" +
			"第一个参数：<input type='text' name='p1'><br>" +
			"第二个参数：<textarea name='p2'></textarea><br>" +
			"<input type='submit' value='提交'> " +
			"</form>");
	}
}