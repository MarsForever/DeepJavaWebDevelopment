import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class RefreshServlet extends HttpServlet
{
	public void service(HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException
    {
    	//分别注释下面两条语句中的一条，查看各自的运行效果
		response.setHeader("Refresh","2");
		//response.setHeader("Refresh","2;URL=http://www.it315.org");
		
		response.getWriter().println(new java.util.Date());
    }
}