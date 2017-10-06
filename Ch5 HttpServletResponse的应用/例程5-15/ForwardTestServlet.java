import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ForwardTestServlet extends HttpServlet
{
	public void service(HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException
	{
		//禁止浏览器缓存，以免影响实验效果
		response.setDateHeader("Expires",0);
		response.setHeader("Cache-Control","no-cache"); 
		response.setHeader("Pragma","no-cache"); 		
		
		RequestDispatcher rd = 
			getServletContext().getRequestDispatcher("/test.html");
		rd.forward(request,response);
	}
}