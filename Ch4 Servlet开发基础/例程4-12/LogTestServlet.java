import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class LogTestServlet extends HttpServlet
{
	public void service(HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException
    {
			/*getServletContext().*/log("LogTestServlet is running.");
			try
			{
				//����Ӫ��һ���쳣
				int x = 3/0;
			}
			catch(Exception e)
			{
				/*this.*/log("LogTestServlet happen exception",e); 
			}
    }
}