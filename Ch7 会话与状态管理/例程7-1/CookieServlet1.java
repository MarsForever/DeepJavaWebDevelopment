import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class CookieServlet1 extends HttpServlet
{
	public void service(HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html;charset=gb2312");
		PrintWriter out = response.getWriter();
		
		String name = request.getParameter("name");
		String nickname = request.getParameter("nickname");
		if(name == null || nickname == null)
		{
			out.println("请传递参数name和nickname后继续实验！");
			return;
		}
		
		/*下面的程序代码最好改成如下结构，以增强代码的阅读性：
			if（…）
			{
				…
				return;
			}
			…
		因为笔者在后来校对书稿的过程中，读到下面的if从句时，脑海里面很自然
		地出现了“if从句执行完后，程序继续干了什么？”的疑问	，如果在if从句
		中增加了return语句，显然就不会产生这种疑问。
		*/
		if("".equals(name.trim()) || "".equals(nickname.trim()))
		{
			out.println("name和nickname不能为空白串");
		}
		else
		{
			Cookie ckName = new Cookie("name",name);
			Cookie ckNickname = new Cookie("nickname",nickname);
			ckNickname.setMaxAge(365*24*3600);
			Cookie ckEmail = new Cookie("email","test1@it315.org");
			Cookie ckPhone = new Cookie("phone","1111111");
			response.addCookie(ckName);
			response.addCookie(ckNickname);
			response.addCookie(ckEmail);
			response.addCookie(ckPhone);

			/*应将下面的代码设计成一个专门用于查询某个名称的Cookie的方法，
			然后用这个方法来查询名称为nickname的Cookie值。*/
			String lastNickname = null;
			Cookie [] cks = request.getCookies();
			for(int i=0; cks!=null && i<cks.length; i++)
			{
				if("nickname".equals(cks[i].getName()))
				{
					lastNickname = cks[i].getValue();
					break;
				} 
			} 
			if(lastNickname != null)
			{
				out.println("欢迎您，<b><i>" + lastNickname + "</i></b>！<br>");
			}
			else
			{
				out.println("欢迎您，新客人！<br>");
			}
	
			String cookieHeader = request.getHeader("Cookie");
			if(cookieHeader != null)
			{
				out.println("请求头中的Cookie头字段如下:<br>");
				out.println("Cookie: " + cookieHeader + "<br>");
			}
			else
			{
				out.println("请求头中没有Cookie头字段<br>");
			}
		}
	}
}