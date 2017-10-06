import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class HideJSServlet extends HttpServlet
{
	public void service(HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/javascript;charset=GB2312");
		response.setDateHeader("Expires",0);
		response.setHeader("Cache-Control","no-cache"); 
		response.setHeader("Pragma","no-cache"); 
		
		PrintWriter out = response.getWriter();
		String referrer = request.getHeader("referer");
		String sitePart = "http://" + request.getServerName();
		if(referrer!=null && referrer.startsWith(sitePart))
		{
			//��ͻ������javascript��document.write(...)���
			out.println(
				"document.write('�������Ǻܶ���Ҫ��Javascript�����ִ�н��');");
		}
	}
}