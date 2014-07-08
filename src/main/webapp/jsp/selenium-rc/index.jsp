<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

    if ("process".equals(request.getParameter("action")))
    {
        if ("user".equals(request.getParameter("username")) &&
                "secret".equals(request.getParameter("password")))
        {
            response.sendRedirect("enterInfo.jsp");
            return;
        }
    }

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Test Login Page</title>
</head>
<body>
<form action="<%= request.getRequestURI() %>" method="POST">
<input type="hidden" value="process" name="action" />
<label for="username">Username:<br />
<input type="text" id="username" name="username" />
</label>
<br />
<label for="password">Password:<br />
<input type="password" id="password" name="password" />
</label>
<br />
<input type="submit" value="Login" />
</form>
</body>
</html>