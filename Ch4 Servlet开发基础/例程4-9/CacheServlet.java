import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class CacheServlet extends HttpServlet
{
	public void doGet(HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException
	{
		PrintWriter out = response.getWriter();
		long now = System.currentTimeMillis();
		out.println("doGet:" + now);
		System.out.println("doGet:" + now);
	}
	
	/*protected long getLastModified(HttpServletRequest req)
	{
		long now = System.currentTimeMillis();
		System.out.println("getLastModified:" + now);
		return now;
	}*/
}