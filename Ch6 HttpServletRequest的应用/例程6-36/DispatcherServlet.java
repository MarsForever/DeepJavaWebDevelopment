import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class DispatcherServlet extends HttpServlet
{
	public void service(HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException
	{
		String china = "�й�";
		RequestDispatcher rd = request.getRequestDispatcher(
				"/servlet/ChineseParamServlet?param1=" + 
				java.net.URLEncoder.encode(china,"GB2312")); 
		rd.forward(request,response);
	}
}