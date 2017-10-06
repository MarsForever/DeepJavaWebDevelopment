import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.Enumeration;

public class RequestHeadersServlet extends HttpServlet
{
	public void service(HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html ;charset=gb2312");
		PrintWriter out = response.getWriter();
		Enumeration headerNames = request.getHeaderNames();
		while(headerNames.hasMoreElements())
		{
			String headerName = (String)headerNames.nextElement();
			out.print(headerName + " : " + request.getHeader(headerName) + "<br>");
			/*���Ҫ����ͬһ������ͷ�����ܳ��ֶ�Σ�
			��ôӦ��������Ĵ���δ�������һ�г������*/
			/*Enumeration values = request.getHeaders(headerName);
			while(values.hasMoreElements())
			{
				out.print(headerName + " : " + (String)values.nextElement() + "<br>");
			}*/
		}
	}
}