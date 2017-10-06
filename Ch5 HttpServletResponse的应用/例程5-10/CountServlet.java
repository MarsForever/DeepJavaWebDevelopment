import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.awt.*;
import java.awt.image.*;
import javax.imageio.ImageIO;
import java.util.Properties;

public class CountServlet extends HttpServlet
{
	public void doGet(HttpServletRequest request,
		HttpServletResponse response) throws ServletException,IOException
	{		
		response.setContentType("image/jpeg");
		//�����������Ҫ�����ͼƬ
		response.setHeader("Pragma","No-cache");
		response.setHeader("Cache-Control","no-cache");
		response.setDateHeader("Expires", 0);

		ServletOutputStream sos = response.getOutputStream();

		BufferedImage image = 
				new BufferedImage(80, 20, BufferedImage.TYPE_INT_RGB); 
		Graphics g = image.getGraphics();
		/*g.setColor(Color.BLACK);
		g.fillRect(0, 0, width, height);*/
		g.setColor(Color.WHITE);
		g.setFont(new Font(null,Font.ITALIC|Font.BOLD,18));
		String value = getAccessCount(request);
		int len = value.length();
		//�����ʴ������ܳ���9999999
		if(len > 7)
		{
			value = "9999999";
		}
		else
		{
			/*��ΪStringBuffer���append���������������߼��������
			����Ч�ʽ����ߣ���������Լ��޸�һ��*/
			String tmp="";
			for(int i=0;i<7-len;i++)
			{
				tmp = tmp +"0";
			}
			value = tmp + value;
		}
		g.drawString(value,0,18);
		//����ͼ��Ļ��ƹ��̣����ͼ��
		g.dispose();
	
		ImageIO.write(image, "JPEG", sos);
		sos.close();
	}
	
	private String getAccessCount(HttpServletRequest request)
	{
		//�õ�����ҳ���URL��ַ�����Դ���Ϊ���ʴ����ļ����ؼ���
		String pageKey = request.getHeader("referer");
		if(pageKey == null)
		{
			return "0";
		}

		Properties settings = new Properties();
		//count.txt���ڲ��ļ�����Ǳ�����WEB-INFĿ¼��
		String countFilePath = getServletContext().getRealPath("/count.txt");
		try
		{
			//��������û��ʹ��close�����ر�������ȱ�ݣ�
			settings.load(new FileInputStream(countFilePath));
		}
		catch(Exception e){}

		String count = "0";
		try
		{
			count = settings.getProperty(pageKey);
			if(count == null)
			{
				count = "0";
			}
			int c = Integer.parseInt(count) + 1;
			count = new Integer(c).toString();
			settings.put(pageKey,count);
			//��������û��ʹ��close�����ر�������ȱ�ݣ�
			settings.store(new FileOutputStream(countFilePath),
					"the page is accessed:");
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return count;		
	}
}