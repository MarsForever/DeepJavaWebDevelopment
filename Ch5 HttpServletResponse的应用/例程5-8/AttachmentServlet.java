import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Attachment extends HttpServlet
{
	public void doGet(HttpServletRequest request,
		HttpServletResponse response) throws ServletException,IOException
	{
		response.setContentType ("application/x-msdownload");
		response.addHeader("Content-Disposition","attachment;filename=aaa.txt");
		
		ServletOutputStream sos = response.getOutputStream();
		sos.write("hello www.it315.org".getBytes());	
		sos.close();
	}
}