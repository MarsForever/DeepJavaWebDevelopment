import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class RefreshServlet extends HttpServlet
{
	public void service(HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException
    {
    	//�ֱ�ע��������������е�һ�����鿴���Ե�����Ч��
		response.setHeader("Refresh","2");
		//response.setHeader("Refresh","2;URL=http://www.it315.org");
		
		response.getWriter().println(new java.util.Date());
    }
}