import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class FormDealServlet extends HttpServlet
{
	public void service(HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html;charset=GB2312");
			
		PrintWriter out = response.getWriter();	
		TokenProcessor tokenProcessor = TokenProcessor.getInstance();
		
		if(!tokenProcessor.isTokenValid(request))
		{
			out.println("�����ظ���Ƿ��ύ!");
			return;
		}
		
		String p1 = request.getParameter("p1");
		if(p1==null || p1.trim().equals(""))
		{
			out.println("����������!");
		}
		else
		{
			out.println("�ύ�����ѱ�����!");
			tokenProcessor.resetToken(request);
		}
	}
}