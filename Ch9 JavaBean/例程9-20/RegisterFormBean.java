package org.it315.bean;
import java.util.*;

/*RegisterFormBean���ڷ�װע�������Ϣ�����ж������ĸ����ԣ�name��password1��
password2��email��RegisterFormBean�������ĸ����Խ��л����ĸ�ʽ��֤�����
��������Ӧ�Ĵ�����Ϣ���浽һ��HashTable�����У�ͬʱҲ�����˹�JSPҳ��
����������Ϣ�ķ�����*/
public class RegisterFormBean
{
	private String name = "";
	private String password1 = "";
	private String password2 = "";
	private String email = "";
	private Hashtable errors = new Hashtable();
	
	public void setName(String name)
	{
		this.name = name;
	}
	public String getName()
	{
		return this.name;
	}
	
	public void setPassword1(String password1)
	{
		this.password1 = password1;
	}
	public String getPassword1()
	{
		return this.password1;
	}
	
	public void setPassword2(String password2)
	{
		this.password2 = password2;
	}
	public String getPassword2()
	{
		return this.password2;
	}
	
	public void setEmail(String email)
	{
		this.email = email;
	}
	public String getEmail()
	{
		return this.email;
	}
	
	public boolean validate()
	{
		boolean allOk = true;
		if(name.trim().equals(""))
		{
			errors.put("name","Please input your name.");
			allOk = false;
		}
		if(password1.length()>10 || password1.length()<6)
		{
			errors.put("password1","password must have 6-10 characters.");
			allOk = false;
		}
		if(!password2.equals(password1))
		{
			errors.put("password2","passwords do not match.");
			allOk = false;
		}
		/*��email��ʽ��У�������������ʽ������������ʽ�ļ���ϸ�ڣ�
		��ο����߱�д�ġ�JavaScript��ҳ������һ��*/
		if(!email.matches("[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+"))
		{
			errors.put("email","illegal email.");
			allOk = false;			
		}
		return allOk;
	}
	
	public void setErrorMsg(String err,String errMsg)
	{
		if((err != null) && (errMsg != null))
		{
			errors.put(err,errMsg);
		}
	}
	
	public String getErrorMsg(String err)
	{
		String err_msg = (String)errors.get(err);
		return (err_msg == null) ? "" : err_msg;
	}
}