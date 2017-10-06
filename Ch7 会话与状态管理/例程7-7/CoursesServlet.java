import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.net.URLEncoder;
import java.util.Vector;
import java.util.Enumeration;

public class CoursesServlet extends HttpServlet
{
	public void service(HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html;charset=gb2312");
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession();
		String sessionName = (String)session.getAttribute("name");
		/*����û�û�е�¼��sessionNameΪnull�������ϴη��ʺ�Ŀ���ʱ��
		������session�����ƣ�getSession�������ص���һ����Session����
		sessionNameҲΪnull*/
		if(sessionName == null)
		{
			/*��Ϊ��������ͬһ��WEBӦ�ó����ڲ���ת������ǲ���forward
			������������ת�������������Ϊ�˸�ϰsendRedirect����*/
			response.sendRedirect("../logon.html");
			return;
		}
		
		String courseSelect = request.getParameter("course");
		if(courseSelect != null)
		{
			Vector vCourses = (Vector)session.getAttribute("courses");
			if(vCourses == null)
			{
				vCourses = new Vector();
				vCourses.add(courseSelect);
				session.setAttribute("courses",vCourses);
			}
			else
			{
				if(vCourses.contains(courseSelect))
				{
					out.println(sessionName + "������ǰѡ�����" + 
							courseSelect + "<hr>");
				}
				else
				{
					/*vCourses��ָ��Session�е�һ�����Զ�������ã�
					��vCourses�Ĳ���ֱ��Ӱ���Ǹ����Զ��󣬲����ٽ�
					vCourses�������ӽ�Session��*/					
					vCourses.add(courseSelect);
				}
			}
		}
		
		String [] courses = {"c","c++","vc++","java","jsp"};
		out.println(sessionName + "����ѡ����Ҫѡ�޵Ŀγ̣�<br>");
		for(int i=0; i<courses.length; i++)
		{
			//�Բ����е������ַ�Ӧ����URL����
			out.println(courses[i] + 
				"&nbsp;&nbsp;&nbsp;&nbsp;<a href='CoursesServlet?course=" + 
				URLEncoder.encode(courses[i],"gb2312") + "'>ѡ��</a><br>");
		}
		out.println("<hr>");
		
		Vector vCourses = (Vector)session.getAttribute("courses");
		out.println(sessionName + "�����Ѿ�ѡ��������Ŀγ̣�<br>");
		if(vCourses != null)
		{
			for(Enumeration e=vCourses.elements();e.hasMoreElements();)
			{
				out.println((String)e.nextElement() + "<br>");
			}
		}
	}
}