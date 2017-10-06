import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class RequestLineServlet extends HttpServlet
{
	public void service(HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html ;charset=gb2312");
		PrintWriter out = response.getWriter();
		out.println("getMethod : " + request.getMethod() + "<br>");
		out.println("getRequestURI : " + request.getRequestURI() + "<br>");
		out.println("getQueryString : " + request.getQueryString() + "<br>");
		out.println("getProtocol : " + request.getProtocol() + "<br>");
		out.println("getContextPath : " + request.getContextPath() + "<br>");
		out.println("getPathInfo : " + request.getPathInfo() + "<br>");
		out.println("getPathTranslated : " + request.getPathTranslated() + "<br>");
		out.println("getServletPath : " + request.getServletPath() + "<br>");
	}
}