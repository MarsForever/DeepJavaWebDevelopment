import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.Properties;
import java.net.URL;

public class ResourceServlet extends HttpServlet
{
	public void service(HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException
    {
    	PrintWriter out = response.getWriter();
    	
		URL urlIt315 = getServletContext().getResource(
						"/WEB-INF/classes/it315.properties");
		out.println(urlIt315.toString());
			
		//下面两条语句可以完成同样的功能
		InputStream ips = getServletContext().getResourceAsStream(
								"/WEB-INF/classes/it315.properties");
		/*InputStream ips = getClass().getResourceAsStream(
								"/it315.properties");*/
		Properties props = new Properties();
		props.load(ips);
		out.println("database=" + props.getProperty("database"));
		out.println("username=" + props.getProperty("username"));
		out.println("password=" + props.getProperty("password"));	
		ips.close();	
    }
}