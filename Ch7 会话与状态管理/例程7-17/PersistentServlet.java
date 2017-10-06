import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class PersistentServlet extends HttpServlet
{
	public void service(HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html;charset=gb2312");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		
		Student1 student1 = (Student1)session.getAttribute("student1");
		if(student1 == null)
		{
			student1 = new Student1();
			student1.setValue(35);
			session.setAttribute("student1",student1);
			out.println("将student1保存到了Session中！<br>");
		}
		else
		{
			out.println("读取student1:" + student1.getValue() + "<br>");
		}
		
		Student2 student2 = (Student2)session.getAttribute("student2");
		if(student2 == null)
		{
			student2 = new Student2();
			student2.setValue(33);
			session.setAttribute("student2",student2);
			out.println("将student2保存到了Session中！<br>");
		}
		else
		{
			out.println("读取student2:" + student2.getValue() + "<br>");
		}
	}
}