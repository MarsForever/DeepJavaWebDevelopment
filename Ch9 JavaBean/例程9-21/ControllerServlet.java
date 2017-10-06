package org.it315.servlet;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import org.it315.bean.*;
import org.it315.util.*;

public class ControllerServlet extends HttpServlet
{
	public void doGet(HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException
	{
		RequestDispatcher rd = null;
		
		String name = request.getParameter("name");
		String password1 = request.getParameter("password1");
		String password2 = request.getParameter("password2");
		String email = request.getParameter("email");
		
		RegisterFormBean registerForm = new RegisterFormBean();
		registerForm.setName(name);
		registerForm.setPassword1(password1);
		registerForm.setPassword2(password2);
		registerForm.setEmail(email);
		request.setAttribute("registerForm",registerForm);
		
		//如果表单字段中填写的内容格式有问题，则跳转到注册页面
		if(!registerForm.validate())
		{
			rd = request.getRequestDispatcher("/jsp/register.jsp");
			rd.forward(request,response);
			return;
		}

		UserBean user = new UserBean();
		user.setName(name);
		user.setPassword(password1);		
		user.setEmail(email);
		try
		{
			DbUtil db = DbUtil.getInstance();
			db.insertUser(user);
		}
		catch(DbUtilException ex)
		{
			/*如果用户注册不成功，则取出不成功的原因并跳转到注册
			页面。在实际应用中可能有更多的异常消息，本例子只演示
			名称重复的问题。*/
			registerForm.setErrorMsg("name",ex.getErrorMsg("name"));
			rd = request.getRequestDispatcher("/jsp/register.jsp");
			rd.forward(request,response);
			return;
		}
		
		/*用户成功注册的同时也自动完成登录，直接进入成功登录后的页面，
		所以，应该将当前注册的用户信息要保存到Session域中*/
		HttpSession session = request.getSession();
		session.setAttribute("logonUser",user);		
		rd = request.getRequestDispatcher("/jsp/logonSuccess.jsp");
		rd.forward(request,response);		
	}
	
	public void doPost(HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException
	{
		doGet(request,response);
	}
}