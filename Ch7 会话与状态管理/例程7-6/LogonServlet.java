import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class LogonServlet extends HttpServlet
{
	public void service(HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html;charset=gb2312");
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession();
		//设置session超时间隔为120秒，以便测试超时的情况
		session.setMaxInactiveInterval(120);
		String sessionName = (String)session.getAttribute("name");
		//如果是一个已登录用户，则将请求转发给显示课程的Servlet
		if(sessionName != null)
		{
			RequestDispatcher rd = 
				request.getRequestDispatcher("CoursesServlet");
			rd.forward(request,response);
			return;
		}
		
		String paramName = request.getParameter("name");
		if(paramName == null || paramName.trim().equals(""))
		{
			out.println("请传递用户名！<br>");
			RequestDispatcher rd = 
				request.getRequestDispatcher("../logon.html");
			rd.include(request,response);
		}
		else
		{
			session.setAttribute("name",paramName);
			RequestDispatcher rd = 
				request.getRequestDispatcher("CoursesServlet");
			rd.forward(request,response);
		}
	}
}