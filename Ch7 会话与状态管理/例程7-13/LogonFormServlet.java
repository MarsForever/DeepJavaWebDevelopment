import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class LogonFormServlet extends HttpServlet
{
	public void service(HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html;charset=GB2312");				
		PrintWriter out = response.getWriter();	
		
		HttpSession session = request.getSession(false);
		if(session == null)
		{
			out.println("验证码处理问题!");
			return;
		}
		
		String savedCode = (String)session.getAttribute("check_code");
		if(savedCode == null)
		{
			out.println("验证码处理问题!");
			return;
		}
				
		String checkCode = request.getParameter("check_code");
		if(!savedCode.equals(checkCode))
		{
			/*验证码未通过，不从Session中清除原来的验证码，
			以便用户可以后退回登录页面继续使用原来的验证码进行登录*/
			out.println("验证码无效!");
			return;
		}
		/*验证码检查通过后，从Session中清除原来的验证码，
		以防用户后退回登录页面继续使用原来的验证码进行登录*/
		session.removeAttribute("check_code");
		out.println("验证码通过，服务器正在校验用户名和密码!");
	}
}