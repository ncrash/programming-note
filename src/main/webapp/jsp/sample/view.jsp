<%@ page language="java" errorPage="/error.jsp" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ include file="/jsp/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
this page path : /src/main/webapp/jsp/sample/view.jsp<br/>
Hello World!!<br/>

<br/>
<br/>

<h4>Server Info</h4>
${pageContext.request.localAddr}<br/>
${pageContext.request.localName}<br/>
${pageContext.request.serverPort}<br/>
${pageContext.request.protocol}<br/>
 
<h4>Parameter</h4>
Parameter : ${result}<br/>

<h4>Taglibs</h4>
Context Name : ${ctx}<br/>

<h4>Message</h4>
Date Pattern : ${datePattern}<br/>
<c:set var="webappname"><fmt:message key="webapp.name"/></c:set>
Webapp Name : ${webappname}<br/>

<h4>web resource path</h4>
<img style="border: 0" src="<c:url value="/images/404.jpg"/>" alt="Emerald Lake - Western Canada" />

</body>
</html>