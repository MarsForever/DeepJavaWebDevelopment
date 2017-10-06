import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ChineseServlet extends HttpServlet
{
	public void service(HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException
	{
    	
		//response.setCharacterEncoding("GB2312");
		//response.setContentType("text/html;charset=GB2312");
		//response.setLocale(new java.util.Locale("zh","CN"));

		PrintWriter out = response.getWriter();
		out.println("<s>IT资讯交流网</s>");
	}
}