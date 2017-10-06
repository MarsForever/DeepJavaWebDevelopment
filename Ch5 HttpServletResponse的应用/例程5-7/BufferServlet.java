import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class BufferServlet extends HttpServlet
{
	public void service(HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException
	{
		//将缓冲区的大写设置为0，接着在后台查看实际缓冲区的大小
		response.setBufferSize(0);
		int len = response.getBufferSize();
		System.out.println(len);
		
		PrintWriter out = response.getWriter();
		//让输出的内容正好填满整个缓冲区
		for(int i=0; i<len/*-1*/; i++)
		{
			out.print("w");
		}
	}
}