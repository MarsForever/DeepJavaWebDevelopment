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
			/*如果要考虑同一个请求头名可能出现多次，
			那么应该用下面的代码段代替上面一行程序代码*/
			/*Enumeration values = request.getHeaders(headerName);
			while(values.hasMoreElements())
			{
				out.print(headerName + " : " + (String)values.nextElement() + "<br>");
			}*/
		}
	}
}