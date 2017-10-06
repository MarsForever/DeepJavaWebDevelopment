import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.Enumeration;
import sun.misc.BASE64Decoder;

public class AuthenticateServlet extends HttpServlet
{
	public void service(HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html;charset=gb2312");
		PrintWriter out = response.getWriter();
		
		//��ӡ������ͷ�ֶ�
		Enumeration headerNames = request.getHeaderNames();
		System.out.println("------begin------");
		while(headerNames.hasMoreElements())
		{
			String headerName = (String)headerNames.nextElement();
			System.out.println(headerName + " : " + request.getHeader(headerName));
		}
		System.out.println("------end------");
		
		String encodedAuth = request.getHeader("Authorization");
		//Ҫ��ͻ��˷��������֤��Ϣ,����ֻ����BASIC��֤��ʽ��
		if (encodedAuth == null || !encodedAuth.toUpperCase().startsWith("BASIC"))
		{
			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			response.setHeader("WWW-Authenticate","BASIC realm=\"it315\"");
			//���û�������¼���еġ�ȡ������ťʱ����������������
			out.println("û�д����û����!");
			return ;
		}

		BASE64Decoder decoder = new BASE64Decoder();
		/*
	��ʾ������BASIC��֤��ʽ���ͻ��˰���ð�ţ�:���ָ����û������������Base64 ����֮���͸�WEB�����������磬Ҫ�����û���Ϊ��zxx��������Ϊ��123456������֤��Ϣ��ʹ�õ�����ͷ�ֶ�����Ӧ�����£� 
	Authorization: Basic enh4OjEyMzQ1Ng==
		*/
		byte [] decodedBytes = decoder.decodeBuffer(encodedAuth.substring(6));
		/*���߿������Զ������ĵ��û��������д����ѡ��ʲô�ַ������н��룿*/
		String decodedInfo = new String(decodedBytes); 
		int idx = decodedInfo.indexOf(":");
		if (idx < 0) 
		{
			out.println("��Ϣ��ʽ������");
			return ;
		}
		String user = decodedInfo.substring(0, idx);
		String password = decodedInfo.substring(idx + 1);
		//�򵥵�У���û��������룬��ʵӦ���п����漰���ݿ��ѯ
		if ("zxx".equals(user) && "123456".equals(password)) 
		{
			out.println("�������Ҫ������Ϣ��");
		}
		else
		{
			out.println("����Ȩ���ʴ���Ϣ��");
		}
	}
}