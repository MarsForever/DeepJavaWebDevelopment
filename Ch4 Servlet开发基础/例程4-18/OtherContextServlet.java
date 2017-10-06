import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class OtherContextServlet extends HttpServlet
{
	public void service(HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException
    {
			PrintWriter out = response.getWriter();
			out.println(getServletContext().getContext("/").getRealPath(""));
    }
}