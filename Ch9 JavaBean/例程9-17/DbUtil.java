package org.it315.util;
import org.it315.bean.UserBean;
import java.util.Hashtable;

/**DbUtil类是一个单件类，在整个Web应用程序中只能创建DbUtil类的一个实例对象，
在DbUtil类内部预存储了两个用户记录，并提供了增加和检索用户记录的方法。*/
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
		//在实际应用中有更多的异常消息，例如，email重复、密码无效等
		users.put(userName,user);
	}
}