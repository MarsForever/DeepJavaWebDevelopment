import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.Enumeration;

public class ContextParameterServlet extends HttpServlet
{
	public void service(HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException
    {
		PrintWriter out = response.getWriter();
		out.println("<html>");
		Enumeration e = getServletContext().getInitParameterNames();
		out.println("Context Parameter:" + "<br>");
		while (e.hasMoreElements())
		{
			String key = (String)e.nextElement();
			String value = getServletContext().getInitParameter(key);
			out.println("&nbsp;&nbsp;" + key + "=" + value + "<br>"); 
		}
		out.println("</html>");
    }
}