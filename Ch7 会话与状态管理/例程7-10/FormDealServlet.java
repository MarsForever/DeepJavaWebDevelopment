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
			out.println("这是重复或非法提交!");
			return;
		}
		
		String p1 = request.getParameter("p1");
		if(p1==null || p1.trim().equals(""))
		{
			out.println("请输入内容!");
		}
		else
		{
			out.println("提交内容已被处理!");
			tokenProcessor.resetToken(request);
		}
	}
}