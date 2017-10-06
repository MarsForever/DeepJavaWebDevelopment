package org.it315;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

/**这是一个模拟JSP产生输出的Servlet程序，它里面几乎没有业务逻辑处理，
   只负责产生显示给用户的网页文档内容。
*/
public class JspResultServlet extends HttpServlet
{
	public void service(HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html;charset=GB2312");
		PrintWriter out = response.getWriter();
		User user = (User)request.getAttribute("user");
		if(user != null)
		{
			out.println("<h1>你的注册信息如下：</h1>");
			out.println("用户名：" + user.getName() + "<br>");
			out.println("Email：" + user.getEmail() + "<br>");
		}
		out.close();
	}
}