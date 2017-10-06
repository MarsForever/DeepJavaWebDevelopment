import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ForwardTestServlet extends HttpServlet
{
	public void service(HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html;charset=gb2312");
		
		//��ֹ��������棬����Ӱ��ʵ��Ч��
		response.setDateHeader("Expires",0);
		response.setHeader("Cache-Control","no-cache"); 
		response.setHeader("Pragma","no-cache"); 		
		
		PrintWriter out = response.getWriter();
		out.println("before forward");
		//���ڽ��������е�����ǿ��ˢ�µ��ͻ���
		//response.flushBuffer();
		RequestDispatcher rd = 
			getServletContext().getRequestDispatcher("/test.html");
		rd.forward(request,response);
		out.println("after forwarding");
		System.out.println("after forwarding");
	}
}