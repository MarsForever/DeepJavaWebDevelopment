import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class DispatcherServlet extends HttpServlet
{
	public void service(HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException
	{
		String china = "ÖÐ¹ú";
		response.sendRedirect(request.getContextPath() + 
			"/servlet/ChineseParamServlet?param1=" + 
			java.net.URLEncoder.encode(china,"GB2312"));
	}
}