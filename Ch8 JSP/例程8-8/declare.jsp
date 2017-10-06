<%!
static { System.out.println("loading Servlet!"); }
private int globalVar = 0;
public void jspInit()
{
	System.out.println("initializing jsp!");
}
%>
<%!
public void jspDestroy()
{
	System.out.println("destroying jsp!");
}
%>
<%
	int localVar = 0;
%>
globalVar:<%= ++globalVar %><br> 
localVar:<%= ++localVar %>