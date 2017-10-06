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
		/*如果用户没有登录，sessionName为null，或者上次访问后的空闲时间
		超过了session的限制，getSession方法返回的是一个新Session对象，
		sessionName也为null*/
		if(sessionName == null)
		{
			/*因为下面是在同一个WEB应用程序内部跳转，最好是采用forward
			方法进行请求转发，这里仅仅是为了复习sendRedirect方法*/
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
					out.println(sessionName + "，你以前选择过了" + 
							courseSelect + "<hr>");
				}
				else
				{
					/*vCourses是指向Session中的一个属性对象的引用，
					对vCourses的操作直接影响那个属性对象，不用再将
					vCourses重新增加进Session中*/					
					vCourses.add(courseSelect);
				}
			}
		}
		
		String [] courses = {"c","c++","vc++","java","jsp"};
		out.println(sessionName + "，请选择你要选修的课程：<br>");
		for(int i=0; i<courses.length; i++)
		{
			//对参数中的特殊字符应进行URL编码
			out.println(courses[i] + 
				"&nbsp;&nbsp;&nbsp;&nbsp;<a href='CoursesServlet?course=" + 
				URLEncoder.encode(courses[i],"gb2312") + "'>选修</a><br>");
		}
		out.println("<hr>");
		
		Vector vCourses = (Vector)session.getAttribute("courses");
		out.println(sessionName + "，你已经选择了下面的课程：<br>");
		if(vCourses != null)
		{
			for(Enumeration e=vCourses.elements();e.hasMoreElements();)
			{
				out.println((String)e.nextElement() + "<br>");
			}
		}
	}
}