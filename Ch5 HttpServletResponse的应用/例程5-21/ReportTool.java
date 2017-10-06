package org.it315;
import java.io.*;

public class ReportTool
{
	private int count = 0;
	private String department = "";
	public void setCount(int count)
	{
		this.count = count;
	}
	public void setDepartment(String department)
	{
		this.department = department;
	}
	public void createReportHTML(String path) throws IOException
	{
		FileOutputStream fos = new FileOutputStream(path);
		OutputStreamWriter ops = new OutputStreamWriter(fos,"UTF-8");
		ops.write(String.valueOf(count) + ":" + department + "的统计信息");
		ops.close();
	}
}