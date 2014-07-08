<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
    "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.ParseException"%>
<%!

private Date parseDate(String dateValue)
{
    Date returnDate = null;
    
    try
    {
        // this is not the most efficient of methods, and try...catch
        // statements ideally should not be used as business exception
        // processing...
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        returnDate = dateFormat.parse(dateValue);
        
    } catch (ParseException pe)
    {
        // do nothing... 
    }
    
    return returnDate;
}

%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="<%= request.getRequestURI() %>" method="POST">
<input type="hidden" value="process" name="action" />
<label for="name">Your name:<br />
<input type="text" id="name" name="name" />
</label>
<br />
<label for="birthdate">Your birth date (in MM/DD/YYYY format):<br />
<input type="text" id="birthdate" name="birthdate" />
</label>
<br />
<%

    if ("process".equals(request.getParameter("action")))
    {
        // verify the date
        Date birthDate = parseDate(request.getParameter("birthdate"));
        
        if (birthDate == null)
        {
            // display the error messages...
            out.write("<p class=\"error\">Please enter a valid date.</p>");
        } else {
            // display the nice messages...
        }
        
    }

%>
<input type="submit" value="Submit" />
</form>
</body>
</html>