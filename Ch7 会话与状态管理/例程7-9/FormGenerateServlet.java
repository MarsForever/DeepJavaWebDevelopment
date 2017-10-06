import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class FormGenerateServlet extends HttpServlet
{
	public void service(HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html;charset=GB2312");
		PrintWriter out = response.getWriter();
		TokenProcessor.getInstance().saveToken(request);
		String token = (String)request.getSession().getAttribute(
					TokenProcessor.FORM_TOKEN_KEY);
		out.println("<form action='FormDealServlet'" + "method='POST'>" +
			"<input type='hidden' name='" + TokenProcessor.FORM_TOKEN_KEY + 
				"' value='" + token + "'>" +
			"×Ö¶Î1£º<input type='text' name='p1'><br>" +
			"<input type='submit' value='Ìá½»'> " +
			"</form>");
	}
}