import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class CookieServlet2 extends HttpServlet
{
	public void service(HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html;charset=gb2312");
		PrintWriter out = response.getWriter();
		
		Cookie ckEmail = new Cookie("email","test2@it315.org");
		//ckEmail.setPath("/");		
		Cookie ckPhone = new Cookie("phone","2222222");
		//ckPhone.setPath("/");
		ckPhone.setMaxAge(0);
		Cookie ckTest = new Cookie("sign","it315");
		response.addCookie(ckEmail);
		response.addCookie(ckPhone);
		response.addCookie(ckTest);	

		String cookieHeader = request.getHeader("Cookie");
		if(cookieHeader != null)
		{
			out.println("����ͷ�е�Cookieͷ�ֶ�����:<br>");
			out.println("Cookie: " + cookieHeader + "<br>");
		}
		else
		{
			out.println("����ͷ��û��Cookieͷ�ֶ�<br>");
		}
		
		Cookie [] cks = request.getCookies();
		for(int i=0; cks!=null && i<cks.length; i++)
		{
			out.println(cks[i].getName() + ":" + cks[i].getValue() + "<br>");
		} 	
	}
}