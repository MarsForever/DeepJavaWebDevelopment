import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class BufferServlet extends HttpServlet
{
	public void service(HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException
	{
		//���������Ĵ�д����Ϊ0�������ں�̨�鿴ʵ�ʻ������Ĵ�С
		response.setBufferSize(0);
		int len = response.getBufferSize();
		System.out.println(len);
		
		PrintWriter out = response.getWriter();
		//�����������������������������
		for(int i=0; i<len/*-1*/; i++)
		{
			out.print("w");
		}
	}
}