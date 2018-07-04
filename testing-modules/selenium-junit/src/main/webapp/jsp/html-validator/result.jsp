<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.text.*, java.util.Date" %>
<%
DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.Ms");
Date date = new Date();
String displayDate = dateFormat.format(date);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>html validation result</title>
</head>
<body>

<h4>result - <%=displayDate %></h4>
<pre>${result }</pre>
<br/> 
</body>
</html>