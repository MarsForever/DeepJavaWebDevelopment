import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ForwardTestServlet extends HttpServlet
{
	public void service(HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html;charset=gb2312");
		
		//禁止浏览器缓存，以免影响实验效果
		response.setDateHeader("Expires",0);
		response.setHeader("Cache-Control","no-cache"); 
		response.setHeader("Pragma","no-cache"); 		
		
		PrintWriter out = response.getWriter();
		out.println("before forward");
		//用于将缓冲区中的内容强制刷新到客户端
		//response.flushBuffer();
		RequestDispatcher rd = 
			getServletContext().getRequestDispatcher("/test.html");
		rd.forward(request,response);
		out.println("after forwarding");
		System.out.println("after forwarding");
	}
}