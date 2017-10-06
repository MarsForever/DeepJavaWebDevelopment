package org.it315;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

/**����һ��ģ��JSP���������Servlet���������漸��û��ҵ���߼�����
   ֻ���������ʾ���û�����ҳ�ĵ����ݡ�
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
			out.println("<h1>���ע����Ϣ���£�</h1>");
			out.println("�û�����" + user.getName() + "<br>");
			out.println("Email��" + user.getEmail() + "<br>");
		}
		out.close();
	}
}