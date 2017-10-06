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
		
		//打印出所有头字段
		Enumeration headerNames = request.getHeaderNames();
		System.out.println("------begin------");
		while(headerNames.hasMoreElements())
		{
			String headerName = (String)headerNames.nextElement();
			System.out.println(headerName + " : " + request.getHeader(headerName));
		}
		System.out.println("------end------");
		
		String encodedAuth = request.getHeader("Authorization");
		//要求客户端发送身份认证信息,并且只能是BASIC认证方式中
		if (encodedAuth == null || !encodedAuth.toUpperCase().startsWith("BASIC"))
		{
			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			response.setHeader("WWW-Authenticate","BASIC realm=\"it315\"");
			//当用户单击登录框中的“取消”按钮时，将输出下面的内容
			out.println("没有传递用户身份!");
			return ;
		}

		BASE64Decoder decoder = new BASE64Decoder();
		/*
	提示：对于BASIC验证方式，客户端把用冒号（:）分隔的用户名和密码进行Base64 编码之后传送给WEB服务器。例如，要发送用户名为“zxx”和密码为“123456”的认证信息，使用的请求头字段内容应该如下： 
	Authorization: Basic enh4OjEyMzQ1Ng==
		*/
		byte [] decodedBytes = decoder.decodeBuffer(encodedAuth.substring(6));
		/*读者可以试试对于中文的用户名，下行代码该选择什么字符集进行解码？*/
		String decodedInfo = new String(decodedBytes); 
		int idx = decodedInfo.indexOf(":");
		if (idx < 0) 
		{
			out.println("信息格式不完整");
			return ;
		}
		String user = decodedInfo.substring(0, idx);
		String password = decodedInfo.substring(idx + 1);
		//简单地校验用户名和密码，真实应用中可能涉及数据库查询
		if ("zxx".equals(user) && "123456".equals(password)) 
		{
			out.println("这就是你要看的信息！");
		}
		else
		{
			out.println("你无权访问此信息！");
		}
	}
}