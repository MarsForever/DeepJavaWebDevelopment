import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class HelloServlet extends HttpServlet
{
	public void doGet(HttpServletRequest request,
		HttpServletResponse response) throws ServletException,IOException
	{
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<font size=30 color=red>www.it315.org</font><br>");
		out.println("<marquee>" + new java.util.Date() + "</marquee>");
		out.println("</html>");
	}

	//下面是新增的doPost方法
	public void doPost(HttpServletRequest request,
		HttpServletResponse response) throws ServletException,IOException
	{
		doGet(request, response);
	}
}