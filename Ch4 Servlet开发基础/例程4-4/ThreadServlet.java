package org.it315;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ThreadServlet extends HttpServlet
{
	private int count = 0;
	public void service(HttpServletRequest request,
		HttpServletResponse response) throws ServletException,IOException
	{
		count++;
		try
		{
			Thread.sleep(500);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		System.out.println("这是第" + count + "次访问" +
			"，这次访问的线程名称为：" + Thread.currentThread().getName());
	}
}