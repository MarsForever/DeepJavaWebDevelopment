package org.it315;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ActionServlet extends HttpServlet
{
	public void service(HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException
	{
		/*ע�����洫�ݸ�getParameter�����Ĳ�����Ҫ���ύ�����
		  FORM���е���Ӧ�ֶ�Ԫ�����ϸ�һ�¡�
		*/
		String name = request.getParameter("user");
		String email = request.getParameter("email");
		
		User user = new User();
		user.setName(name);
		user.setEmail(email);
		/*��ʵ��Ӧ���У������и����ҵ�����������У���û�����email����ȷ�ԡ�
		  ���û�ע����Ϣ���浽���ݿ⡢����������ʱ������ת����ע��ҳ����
		  �û�����ע�ᡣ
		*/
		request.setAttribute("user",user);
		RequestDispatcher rd = request.getRequestDispatcher("JspResultServlet");
		rd.forward(request,response);
	}
}