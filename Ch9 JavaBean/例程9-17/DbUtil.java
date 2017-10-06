package org.it315.util;
import org.it315.bean.UserBean;
import java.util.Hashtable;

/**DbUtil����һ�������࣬������WebӦ�ó�����ֻ�ܴ���DbUtil���һ��ʵ������
��DbUtil���ڲ�Ԥ�洢�������û���¼�����ṩ�����Ӻͼ����û���¼�ķ�����*/
public class DbUtil
{
	private static DbUtil instance = new DbUtil();
	private Hashtable users = new Hashtable();
	
	private DbUtil()
	{
		UserBean user1 = new UserBean();
		user1.setName("zxx");
		user1.setPassword("12345678");
		user1.setEmail("zxx@it315.org");
		users.put("zxx",user1);
		
		UserBean user2 = new UserBean();
		user2.setName("flx");
		user2.setPassword("abcdefg");
		user2.setEmail("flx@it315.org");
		users.put("flx",user2);			
	}
	
	public static DbUtil getInstance()
	{
		return instance;
	}
	
	public UserBean getUser(String userName)
	{
		UserBean user = (UserBean)users.get(userName);
		return user;
	}
	
	public void insertUser(UserBean user) throws DbUtilException
	{
		if(user == null)
		{
			return;
		}
		
		String userName = user.getName();
		if(users.get(userName) != null)
		{
			DbUtilException ex = new DbUtilException();
			ex.setErrorMsg("name","username have used.");
			throw ex;
		}
		//��ʵ��Ӧ�����и�����쳣��Ϣ�����磬email�ظ���������Ч��
		users.put(userName,user);
	}
}