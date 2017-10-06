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
			//����������������������ֻ����ʾ��
			out.println("dealing download ...");
		}
		else
		{
			//�Ƿ�����������ת����վ������˵��ҳ
			RequestDispatcher rd = request.getRequestDispatcher("/down.html");
			rd.forward(request,response);
		}
	}
}