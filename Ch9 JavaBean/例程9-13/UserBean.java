package org.it315.bean;
import java.io.Serializable;

/**UserBean�н����Ƕ������������ԣ�name��password��email��
ע�⣺Ҫ�洢��Session���л��JVM�����JavaBeanӦʵ��Serializable�ӿ�
*/
public class UserBean implements Serializable
{
	private String name = "";
	private String password = "";
	private String email = "";

	public void setName(String name)
	{
		this.name = name;
	}
	public String getName()
	{
		return this.name;
	}
	
	public void setPassword(String password)
	{
		this.password = password;
	}
	public String getPassword()
	{
		return this.password;
	}
	
	public void setEmail(String email)
	{
		this.email = email;
	}
	public String getEmail()
	{
		return this.email;
	}

	public boolean validatePassword(String password)
	{
		if(this.password.equals(password))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}