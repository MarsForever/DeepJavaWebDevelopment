import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class DelArticleServlet extends HttpServlet
{
	public void doGet(HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html;charset=gb2312");
		request.setCharacterEncoding("gb2312");
		PrintWriter out = response.getWriter();
		String [] paramValues = request.getParameterValues("article_id");
		if(paramValues != null)
		{
			//����������ö�����������
			StringBuffer params = new StringBuffer(paramValues[0]); 
			for(int i=1;i<paramValues.length;i++)
			{
				params.append(",");
				params.append(paramValues[i]);
			}
			String sql = "";
			if("����ɾ��".equals(request.getParameter("del")))
			{
				sql = "delete from lyb_Articles where ArticleId in (" + 
					params + ")";
			}
			else if("ɾ��������Ͱ".equals(request.getParameter("del")))
			{
				sql = "update lyb_Articles set IsDel=1 where ArticleId in (" + 
					params + ")";
			}
			out.println("�����ݿ�ϵͳ��������sql���<br>");
			out.println(sql);
		}
		else
		{
			out.println("û��ѡ��Ҫɾ�������ӣ�");
		}
	}
	
	public void doPost(HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException
	{
		doGet(request,response);
	}
}