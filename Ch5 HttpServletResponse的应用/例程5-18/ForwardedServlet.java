import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ForwardedServlet extends HttpServlet
{
	public void service(HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html;charset=GB2312");
		PrintWriter out = response.getWriter();
		
		/*
		String basePath = request.getScheme() + "://"+ request.getServerName()
			 + ":" + request.getServerPort() + request.getRequestURI();
		out.println("<base href=\"" + basePath + "\">");
		*/
		
		out.println("<a href='ForwardedServlet'>·ÃÎÊ×Ô¼º</a><br>");
		out.println("URI:" + request.getRequestURI() + "<br>");
		out.println("QueryString:" + request.getQueryString() + "<br>");
		out.println("URL:" + request.getRequestURL() + "<br>");
		String p1 = request.getParameter("p1");
		String chP1 = null;
		if(p1 != null)
		{
			chP1 = new String(p1.getBytes("iso8859-1"),"GB2312");
		}
		out.println("parameter p1:" + chP1 + "<br>");
	}
}