import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.Enumeration;

public class ConfigTestServlet extends HttpServlet
{
	public void service(HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException
    {
		//������һ������ÿ��Բο���5�µ�����������⣬
		//����������Ҳ�Ҫ����������⡣
		response.setContentType("text/html;charset=GB2312");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		//ȡ����������е�ע�ͷ��ţ�������ܸ��������
		out.println("Servlet����Ϊ��" + /*this.*/getServletName() + "<br>");
		Enumeration e = /*getServletConfig().*/getInitParameterNames();
		out.println("������ΪServlet���õĳ�ʼ��������" + "<br>");
		while (e.hasMoreElements())
		{
			String key = (String)e.nextElement();
			String value = getInitParameter(key);
			out.println("&nbsp;&nbsp;" + key + "=" + value + "<br>"); 
		}
		ServletContext context = getServletContext();
		String path = context.getRealPath("/");
		out.println("��ǰWEBӦ�ó���ı���Ŀ¼Ϊ��" + path + "<br>"); 	
		out.println("</html>");
    }
}