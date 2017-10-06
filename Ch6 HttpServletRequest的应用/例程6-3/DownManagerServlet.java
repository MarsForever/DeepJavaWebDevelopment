import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class DownManagerServlet extends HttpServlet
{
	public void service(HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException
	{
		String referrer = request.getHeader("referer");
		String sitePart = "http://" + request.getServerName();
		if(referrer!=null && referrer.startsWith(sitePart))
		{
			response.setContentType("text/html ;charset=gb2312");
			PrintWriter out = response.getWriter();
			//处理正当的下载请求，这里只进行示意
			out.println("dealing download ...");
		}
		else
		{
			//非法下载请求跳转到本站的下载说明页
			RequestDispatcher rd = request.getRequestDispatcher("/down.html");
			rd.forward(request,response);
		}
	}
}