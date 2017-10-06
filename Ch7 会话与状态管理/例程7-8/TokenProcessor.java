import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class TokenProcessor
{
	private long previous;  //�ϴ����ɱ���ʶ�ŵ�ʱ��ֵ
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
	 *��֤������Ϣ�еı�ʶ���Ƿ���Ч�����������Ϣ�еı���ʶ���뵱ǰ
	 *�û���Session���еı���ʶ����ͬ�����ؽ��Ϊtrue�����򷵻�false��
	 *
	 *@param request ��װ��ǰ������Ϣ��HttpServletRequest����
	 */
	public synchronized boolean isTokenValid(HttpServletRequest request)
	{
		/*Ϊ����Session���󲻴���ʱ����Session����
		�������䲻��request.getSession()*/
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
	 * ����洢�ڵ�ǰ�û�Session�еı���ʶ�š�
	 *
	 *@param request ��װ��ǰ������Ϣ��HttpServletRequest����
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
	 * ��������ʶ�Ų���֮�����ڵ�ǰ�û�Session�С�
	 *
	 *@param request ��װ��ǰ������Ϣ��HttpServletRequest����
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
	 * ��һ���ֽ�����ת����ʮ�����Ƶ��ַ�����ʽ���ء�
	 * @param buffer Ҫ��ת�����ֽ�����
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