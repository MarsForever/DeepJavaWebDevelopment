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
			//将多个参数用逗号连接起来
			StringBuffer params = new StringBuffer(paramValues[0]); 
			for(int i=1;i<paramValues.length;i++)
			{
				params.append(",");
				params.append(paramValues[i]);
			}
			String sql = "";
			if("彻底删除".equals(request.getParameter("del")))
			{
				sql = "delete from lyb_Articles where ArticleId in (" + 
					params + ")";
			}
			else if("删除到垃圾桶".equals(request.getParameter("del")))
			{
				sql = "update lyb_Articles set IsDel=1 where ArticleId in (" + 
					params + ")";
			}
			out.println("向数据库系统发送如下sql命令：<br>");
			out.println(sql);
		}
		else
		{
			out.println("没有选择要删除的帖子！");
		}
	}
	
	public void doPost(HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException
	{
		doGet(request,response);
	}
}