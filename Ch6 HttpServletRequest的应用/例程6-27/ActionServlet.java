package org.it315;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ActionServlet extends HttpServlet
{
	public void service(HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException
	{
		/*注意下面传递给getParameter方法的参数名要与提交请求的
		  FORM表单中的相应字段元素名严格一致。
		*/
		String name = request.getParameter("user");
		String email = request.getParameter("email");
		
		User user = new User();
		user.setName(name);
		user.setEmail(email);
		/*在实际应用中，这里有更多的业务操作，例如校验用户名和email的正确性、
		  将用户注册信息保存到数据库、或遇到错误时将请求转发到注册页面让
		  用户重新注册。
		*/
		request.setAttribute("user",user);
		RequestDispatcher rd = request.getRequestDispatcher("JspResultServlet");
		rd.forward(request,response);
	}
}