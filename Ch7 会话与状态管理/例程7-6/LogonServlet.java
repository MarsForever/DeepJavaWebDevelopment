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
		//����session��ʱ���Ϊ120�룬�Ա���Գ�ʱ�����
		session.setMaxInactiveInterval(120);
		String sessionName = (String)session.getAttribute("name");
		//�����һ���ѵ�¼�û���������ת������ʾ�γ̵�Servlet
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
			out.println("�봫���û�����<br>");
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