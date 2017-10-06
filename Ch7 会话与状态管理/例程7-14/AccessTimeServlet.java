import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.Date;
import java.text.SimpleDateFormat;
import sun.misc.BASE64Encoder;
import sun.misc.BASE64Decoder;

public class AccessTimeServlet extends HttpServlet
{
	public void service(HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html;charset=gb2312");
		PrintWriter out = response.getWriter();
		
		//获取记录用户上次访问站点时间的Cookie
		Cookie [] cks = request.getCookies();
		String lastAccessTime = getCookie(cks,"access_time");
		if(lastAccessTime == null)
		{
			out.println("没有您上次的访问记录");
		}
		else
		{
			BASE64Decoder decoder = new BASE64Decoder();
			String decodedAccessTime = new String(
				decoder.decodeBuffer(lastAccessTime),"GB2312");
			out.println("您上次的访问时间为" + decodedAccessTime);
		}
		//将用户开始本次访问的时间存储到客户端Cookie中
		HttpSession session = request.getSession();
		if(session.isNew())
		{
			long createTime = session.getCreationTime();
			Date dateCreateTime = new Date(createTime);
			SimpleDateFormat sdf = 
				new SimpleDateFormat("yyyy年MM月dd HH点mm分ss秒");
			String formatedCreateTime = sdf.format(dateCreateTime);
			BASE64Encoder encoder = new sun.misc.BASE64Encoder();
			String base64CreateTime = encoder.encode(
				formatedCreateTime.getBytes("GB2312"));
			Cookie ckAccessTime = new Cookie("access_time",base64CreateTime);
			ckAccessTime.setMaxAge(365*24*3600);
			out.println(formatedCreateTime);
			response.addCookie(ckAccessTime);
		}
	}
	
	private String getCookie(Cookie [] cks,String cookieName)
	{
		String cookieValue = null;
		for(int i=0; cks!=null && i<cks.length; i++)
		{
			if(cookieName.equals(cks[i].getName()))
			{
				cookieValue = cks[i].getValue();
				break;
			} 
		} 
		return cookieValue;
	}
}