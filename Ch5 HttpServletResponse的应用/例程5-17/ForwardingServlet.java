import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ForwardingServlet extends HttpServlet
{
	public void service(HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html;charset=UTF-8");
		//PrintWriter out = response.getWriter();
		
		response.setDateHeader("Expires",0);
		response.setHeader("Cache-Control","no-cache"); 
		response.setHeader("Pragma","no-cache");
		 
		String china = "中国";
		RequestDispatcher rd = getServletContext().getRequestDispatcher(
			"/ForwardedServlet?p1=" + 
			java.net.URLEncoder.encode(china,"GB2312"));
		rd.forward(request,response);
	}
}