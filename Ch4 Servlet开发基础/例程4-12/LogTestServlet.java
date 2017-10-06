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
				//刻意营造一个异常
				int x = 3/0;
			}
			catch(Exception e)
			{
				/*this.*/log("LogTestServlet happen exception",e); 
			}
    }
}