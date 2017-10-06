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
		
		//������ֶ�����д�����ݸ�ʽ�����⣬����ת��ע��ҳ��
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
			/*����û�ע�᲻�ɹ�����ȡ�����ɹ���ԭ����ת��ע��
			ҳ�档��ʵ��Ӧ���п����и�����쳣��Ϣ��������ֻ��ʾ
			�����ظ������⡣*/
			registerForm.setErrorMsg("name",ex.getErrorMsg("name"));
			rd = request.getRequestDispatcher("/jsp/register.jsp");
			rd.forward(request,response);
			return;
		}
		
		/*�û��ɹ�ע���ͬʱҲ�Զ���ɵ�¼��ֱ�ӽ���ɹ���¼���ҳ�棬
		���ԣ�Ӧ�ý���ǰע����û���ϢҪ���浽Session����*/
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