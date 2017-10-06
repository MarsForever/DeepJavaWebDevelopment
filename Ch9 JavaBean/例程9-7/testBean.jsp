<jsp:useBean id="currentDate" class="java.util.Date"/>
<jsp:setProperty name="currentDate" property="time" 
		value='<%= request.getParameter("timeValue")%>'/>
<jsp:getProperty name="currentDate" property="time"/>