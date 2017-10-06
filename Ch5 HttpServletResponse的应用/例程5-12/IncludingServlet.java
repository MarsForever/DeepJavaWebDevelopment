import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class IncludingServlet extends HttpServlet
{
	public void service(HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException
	{
		//response.setContentType("text/html;charset=gb2312");
		PrintWriter out = response.getWriter();
		String china = "ÖÐ¹ú";
		RequestDispatcher rd = getServletContext().getRequestDispatcher(
			"/servlet/IncludedServlet?p1=" + china); 
		out.println("before including" + "<br>");
		rd.include(request,response);
		out.println("after including" + "<br>");
	}
}