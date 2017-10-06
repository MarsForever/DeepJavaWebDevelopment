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
		int total_len = request.getContentLength();
		byte[] buf = new byte[total_len];
		for(int read_len=0,reading_len=0; read_len < total_len; read_len += reading_len)
		{
			reading_len = sis.read(buf,read_len,total_len-read_len);
		}
		fos.write(buf,0,total_len);
		fos.close();
		sis.close();
	}
}