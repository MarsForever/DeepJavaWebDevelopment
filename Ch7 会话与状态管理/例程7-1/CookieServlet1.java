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
			out.println("�봫�ݲ���name��nickname�����ʵ�飡");
			return;
		}
		
		/*����ĳ��������øĳ����½ṹ������ǿ������Ķ��ԣ�
			if������
			{
				��
				return;
			}
			��
		��Ϊ�����ں���У�����Ĺ����У����������if�Ӿ�ʱ���Ժ��������Ȼ
		�س����ˡ�if�Ӿ�ִ����󣬳����������ʲô����������	�������if�Ӿ�
		��������return��䣬��Ȼ�Ͳ�������������ʡ�
		*/
		if("".equals(name.trim()) || "".equals(nickname.trim()))
		{
			out.println("name��nickname����Ϊ�հ״�");
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

			/*Ӧ������Ĵ�����Ƴ�һ��ר�����ڲ�ѯĳ�����Ƶ�Cookie�ķ�����
			Ȼ���������������ѯ����Ϊnickname��Cookieֵ��*/
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
				out.println("��ӭ����<b><i>" + lastNickname + "</i></b>��<br>");
			}
			else
			{
				out.println("��ӭ�����¿��ˣ�<br>");
			}
	
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
		}
	}
}