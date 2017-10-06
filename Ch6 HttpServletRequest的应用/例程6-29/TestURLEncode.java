import java.net.*;
public class TestURLEncode
{
	public static void main(String [] args) throws Exception
	{
		String utf8_url = URLEncoder.encode("�й�","UTF-8"); 
		String gb2312_url = URLEncoder.encode("�й�","gb2312");
		System.out.println("�й���UTF-8���URL����Ϊ��" + utf8_url); 
		System.out.println("�й���GB2312���URL����Ϊ��" + gb2312_url); 
		System.out.println(
			"��" + gb2312_url + "��GB2312�����URL����Ľ��Ϊ��" + 
			URLDecoder.decode(gb2312_url,"gb2312")); 
		System.out.println(
			"��" + gb2312_url + "��iso8859-1�����URL����Ľ��Ϊ��" + 
			URLDecoder.decode(gb2312_url,"iso8859-1")); 
	}
}