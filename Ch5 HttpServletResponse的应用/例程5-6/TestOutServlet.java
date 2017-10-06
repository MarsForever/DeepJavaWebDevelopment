import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class TestOutServlet extends HttpServlet
{
	public void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html");
		PrintWriter out1 = response.getWriter();
		PrintWriter out2 = response.getWriter();
		if(out1 == out2)
		{
			out1.print("content outputed by out1<br>");
			out2.println("content outputed by out2<br>");			
		}
	}
}