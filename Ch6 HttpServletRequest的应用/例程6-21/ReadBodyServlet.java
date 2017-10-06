import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ReadBodyServlet extends HttpServlet
{
	public void doPost(HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException
	{
		ServletInputStream sis = request.getInputStream();
		String filePath = getServletContext().getRealPath("/body.out");
		FileOutputStream fos = new FileOutputStream(filePath);
		byte[] buf = new byte[1024];
		int len = sis.read(buf,0,1024);
		while(len != -1)
		{
			fos.write(buf,0,len);
			len = sis.read(buf,0,1024);
		}
		fos.close();
		sis.close();
	}
}