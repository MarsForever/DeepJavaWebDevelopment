import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class TokenProcessor
{
	private long previous;  //上次生成表单标识号的时间值
	private static TokenProcessor instance = new TokenProcessor();
	public static String FORM_TOKEN_KEY = "FORM_TOKEN_KEY";
	
	private TokenProcessor()
	{
	}
	
	public static TokenProcessor getInstance()
	{
		return instance;
	}

	/**
	 *验证请求消息中的标识号是否有效，如果请求消息中的表单标识号与当前
	 *用户的Session域中的表单标识号相同，返回结果为true，否则返回false。
	 *
	 *@param request 封装当前请求消息的HttpServletRequest对象
	 */
	public synchronized boolean isTokenValid(HttpServletRequest request)
	{
		/*为避免Session对象不存在时创建Session对象，
		下面的语句不用request.getSession()*/
		HttpSession session = request.getSession(false);
		if (session == null)
		{
			return false;
		}

		String saved = (String) session.getAttribute(FORM_TOKEN_KEY);
		if (saved == null)
		{
			return false;
		}
		
		String token = request.getParameter(FORM_TOKEN_KEY);
		if (token == null)
		{
			return false;
		}

		return saved.equals(token);
	}

	/**
	 * 清除存储在当前用户Session中的表单标识号。
	 *
	 *@param request 封装当前请求消息的HttpServletRequest对象
	 */
	public synchronized void resetToken(HttpServletRequest request)
	{
		HttpSession session = request.getSession(false);
		if (session == null)
		{
			return;
		}
		
		session.removeAttribute(FORM_TOKEN_KEY);
	}

	/**
	 * 产生表单标识号并将之保存在当前用户Session中。
	 *
	 *@param request 封装当前请求消息的HttpServletRequest对象
	 */
	public synchronized void saveToken(HttpServletRequest request)
	{
		HttpSession session = request.getSession();
		try 
		{
			byte id[] = session.getId().getBytes();
			long current = System.currentTimeMillis();
			if (current == previous)
			{
				current++;
			}
			previous = current;
			byte now[] = String.valueOf(current).getBytes();
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(id);
			md.update(now);
			String token = toHex(md.digest());
			session.setAttribute(FORM_TOKEN_KEY, token);
		}
		catch (NoSuchAlgorithmException e)
		{
			;
		}
	}

	/**
	 * 将一个字节数组转换成十六进制的字符串形式返回。
	 * @param buffer 要被转换的字节数组
	 */
	private String toHex(byte buffer[])
	{
		StringBuffer sb = new StringBuffer(buffer.length * 2);
		for (int i = 0; i < buffer.length; i++)
		{
  			sb.append(Character.forDigit((buffer[i] & 0xf0) >> 4, 16));
			sb.append(Character.forDigit(buffer[i] & 0x0f, 16));
		}
		return sb.toString();
	}
}