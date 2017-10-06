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
			out.println("��֤�봦������!");
			return;
		}
		
		String savedCode = (String)session.getAttribute("check_code");
		if(savedCode == null)
		{
			out.println("��֤�봦������!");
			return;
		}
				
		String checkCode = request.getParameter("check_code");
		if(!savedCode.equals(checkCode))
		{
			/*��֤��δͨ��������Session�����ԭ������֤�룬
			�Ա��û����Ժ��˻ص�¼ҳ�����ʹ��ԭ������֤����е�¼*/
			out.println("��֤����Ч!");
			return;
		}
		/*��֤����ͨ���󣬴�Session�����ԭ������֤�룬
		�Է��û����˻ص�¼ҳ�����ʹ��ԭ������֤����е�¼*/
		session.removeAttribute("check_code");
		out.println("��֤��ͨ��������������У���û���������!");
	}
}