import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class HelloServlet extends HttpServlet
{
	//只是在下面将service方法名修改成了doGet
	public void doGet(HttpServletRequest request,
		HttpServletResponse response) throws ServletException,IOException
	{
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<font size=30 color=red>www.it315.org</font><br>");
		out.println("<marquee>" + new java.util.Date() + "</marquee>");
		out.println("</html>");
	}
}