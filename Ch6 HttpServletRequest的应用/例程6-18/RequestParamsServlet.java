import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.Enumeration;

public class RequestParamsServlet extends HttpServlet
{
	public void doGet(HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html ;charset=gb2312");
		PrintWriter out = response.getWriter();
		Enumeration paramNames = request.getParameterNames();
		while(paramNames.hasMoreElements())
		{
			String paramName = (String)paramNames.nextElement();
			out.print(paramName + " : " + request.getParameter(paramName) + "<br>");
			/*如果要考虑同一个参数名可能出现多次，
			那么应该用下面的代码段代替上面一行程序代码*/
			/*String [] paramValues = request.getParameterValues(paramName);
			//良好的编程习惯，在使用对象和数组之前先判断其是否为null
			if(paramValues != null)
			{
				for(int i=0;i<paramValues.length;i++)
				{
					out.print(paramName + " : " + (String)paramValues[i] + "<br>");
				}
			}*/
		}
	}
	
	public void doPost(HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException
	{
		doGet(request,response);
	}
}