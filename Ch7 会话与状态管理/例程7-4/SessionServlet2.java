import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class SessionServlet2 extends HttpServlet
{
	public void service(HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html;charset=gb2312");
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession();
		Integer sessionCount = (Integer)session.getAttribute("count");
		int count = 0;
		//如果是第一次访问，则session对象中不存在名为"count"的属性。
		if(sessionCount != null)
		{
			count = sessionCount.intValue();
		}
		out.println("当前会话中发生了" + (++count) + "次访问<br>");
		session.setAttribute("count",new Integer(count));
		
		count = 0;
		ServletContext application = getServletContext();
		Integer applicationCount = 
				(Integer)application.getAttribute("count");
		//如果是第一次访问，则application对象中不存在名为"count"的属性。
		if(applicationCount != null)
		{
			count = applicationCount.intValue();
		}
		out.println("WEB应用程序中发生了" + (++count) + "次访问<br>");
		application.setAttribute("count",new Integer(count));
						
		out.println("<a href='SessionServlet1'>访问SessionServlet1</a>");
	}
}