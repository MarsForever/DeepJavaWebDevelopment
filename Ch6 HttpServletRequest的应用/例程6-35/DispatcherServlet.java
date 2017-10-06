import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class DispatcherServlet extends HttpServlet
{
	public void service(HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException
	{
		String china = "ÖÐ¹ú";
		RequestDispatcher rd = request.getRequestDispatcher(
				"/servlet/ChineseParamServlet?param1=" + china);
		rd.forward(request,response);
	}
}