import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class HelloServlet extends HttpServlet
{
	//从HttpServlet类的帮助文档中复制service方法的声明部分可避免书写错误
	public void service(HttpServletRequest request,
		HttpServletResponse response) throws ServletException,IOException
	{
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<font size=30 color=red>www.it315.org</font><br>");
		out.println("<marquee>" + new java.util.Date() + "</marquee>");
		out.println("</html>");
	}
}