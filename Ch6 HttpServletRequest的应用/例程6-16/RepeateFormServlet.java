import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class RepeateFormServlet extends HttpServlet
{
	public void service(HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html;charset=GB2312");				
		PrintWriter out = response.getWriter();
		try
		{
			Thread.sleep(6000);
		}catch(Exception e){}
		out.println("�Ѵ������ύ����Ϣ!");
		System.out.println("�Ѵ������ύ����Ϣ!");
	}
}