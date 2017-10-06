import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class IncludingServlet extends HttpServlet
{
	public void service(HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException
	{
		//response.setContentType("text/html;charset=gb2312");
		//PrintWriter out = response.getWriter();
		RequestDispatcher rd = request.getRequestDispatcher(
			"/test.html"); 
		rd.include(request,response);
	}
}