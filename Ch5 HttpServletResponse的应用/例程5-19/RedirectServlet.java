import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class RedirectServlet extends HttpServlet
{
	public void service(HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException
	{
		PrintWriter out = response.getWriter();
		out.println("before sendRedirect");
		response.sendRedirect(request.getContextPath() + "/test.html");
		out.println("after sendRedirect");
		System.out.println("after sendRedirect");
	}
}