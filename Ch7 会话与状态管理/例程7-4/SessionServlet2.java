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
		//����ǵ�һ�η��ʣ���session�����в�������Ϊ"count"�����ԡ�
		if(sessionCount != null)
		{
			count = sessionCount.intValue();
		}
		out.println("��ǰ�Ự�з�����" + (++count) + "�η���<br>");
		session.setAttribute("count",new Integer(count));
		
		count = 0;
		ServletContext application = getServletContext();
		Integer applicationCount = 
				(Integer)application.getAttribute("count");
		//����ǵ�һ�η��ʣ���application�����в�������Ϊ"count"�����ԡ�
		if(applicationCount != null)
		{
			count = applicationCount.intValue();
		}
		out.println("WEBӦ�ó����з�����" + (++count) + "�η���<br>");
		application.setAttribute("count",new Integer(count));
						
		out.println("<a href='SessionServlet1'>����SessionServlet1</a>");
	}
}