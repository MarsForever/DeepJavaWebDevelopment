package org.it315;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ReportServlet extends HttpServlet
{
	private int count = 0;
	public void service(HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html;charset=UTF-8");
		
		//禁止浏览器缓存
		response.setDateHeader("Expires",0);
		response.setHeader("Cache-Control","no-cache"); 
		response.setHeader("Pragma","no-cache"); 		
		
		String department = request.getParameter("dept");
		synchronized(this)
		{
			System.out.println(++count + ":" + department);
			String path = getServletContext().getRealPath("/WEB-INF/report.html");
			ReportTool rt = new ReportTool();
			rt.setCount(count);
			rt.setDepartment(department);
			rt.createReportHTML(path);
			RequestDispatcher rd = getServletContext().getRequestDispatcher(
										"/WEB-INF/report.html");
			rd.forward(request,response);
		}
	}
}