import java.io.Serializable;

public class Student2 implements Serializable
{
	private int value = 0;
	public void setValue(int value)
	{
		this.value = value;
	}
	
	public int getValue()
	{
		return value;
	}
}