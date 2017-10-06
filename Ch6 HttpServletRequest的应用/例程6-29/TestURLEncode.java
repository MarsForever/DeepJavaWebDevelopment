import java.net.*;
public class TestURLEncode
{
	public static void main(String [] args) throws Exception
	{
		String utf8_url = URLEncoder.encode("中国","UTF-8"); 
		String gb2312_url = URLEncoder.encode("中国","gb2312");
		System.out.println("中国的UTF-8码的URL编码为：" + utf8_url); 
		System.out.println("中国的GB2312码的URL编码为：" + gb2312_url); 
		System.out.println(
			"将" + gb2312_url + "按GB2312码进行URL解码的结果为：" + 
			URLDecoder.decode(gb2312_url,"gb2312")); 
		System.out.println(
			"将" + gb2312_url + "按iso8859-1码进行URL解码的结果为：" + 
			URLDecoder.decode(gb2312_url,"iso8859-1")); 
	}
}