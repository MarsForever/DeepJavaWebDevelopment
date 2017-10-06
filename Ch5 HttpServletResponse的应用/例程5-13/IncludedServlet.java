import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class IncludedServlet extends HttpServlet
{
	public void service(HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html;charset=GB2312");
		response.setCharacterEncoding("GB2312");
		PrintWriter out = response.getWriter();
		out.println("ÖÐ¹ú" + "<br>");
		out.println("URI:" + request.getRequestURI() + "<br>");
		out.println("QueryString:" + request.getQueryString() + "<br>");
		out.println("parameter p1:" + request.getParameter("p1") + "<br>");
	}
}