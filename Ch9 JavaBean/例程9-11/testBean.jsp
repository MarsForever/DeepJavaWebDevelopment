<jsp:useBean id="currentDate" class="java.util.Date"/>
<% currentDate.setTime(1234567);%>
<jsp:getProperty name="currentDate" property="time"/>