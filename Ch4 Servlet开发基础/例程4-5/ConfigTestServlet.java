import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.Enumeration;

public class ConfigTestServlet extends HttpServlet
{
	public void service(HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException
    {
		//下面这一句的作用可以参看第5章的中文输出问题，
		//建议读者暂且不要关心这个问题。
		response.setContentType("text/html;charset=GB2312");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		//取消下面语句中的注释符号，程序可能更容易理解
		out.println("Servlet名称为：" + /*this.*/getServletName() + "<br>");
		Enumeration e = /*getServletConfig().*/getInitParameterNames();
		out.println("下面是为Servlet设置的初始化参数：" + "<br>");
		while (e.hasMoreElements())
		{
			String key = (String)e.nextElement();
			String value = getInitParameter(key);
			out.println("&nbsp;&nbsp;" + key + "=" + value + "<br>"); 
		}
		ServletContext context = getServletContext();
		String path = context.getRealPath("/");
		out.println("当前WEB应用程序的本地目录为：" + path + "<br>"); 	
		out.println("</html>");
    }
}