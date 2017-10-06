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
			/*���Ҫ����ͬһ�����������ܳ��ֶ�Σ�
			��ôӦ��������Ĵ���δ�������һ�г������*/
			/*String [] paramValues = request.getParameterValues(paramName);
			//���õı��ϰ�ߣ���ʹ�ö��������֮ǰ���ж����Ƿ�Ϊnull
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