package org.it315;
public class RegisterBean
{
	private String nickName = null;
	private boolean male = false;

	public void setNickName(String nickName)
	{
		this.nickName = nickName;
	}
	public String getNickName()
	{	
		return nickName;
	}

	public void setMale(boolean male)
	{
		this.male = male;
	}
	public boolean isMale()
	{
		return male;
	}
}