<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" errorPage="/error.jsp" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ include file="/taglibs.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>java-code-practice-with-tdd</title>
</head>
<body>
	<h1>Html Validation with javascript</h1>
	<h3>정팀장님이 메일로 보내주신 소스</h3>
	<ul>
		<li><a href="${ctx}/html/GetDOMHTMLSource.html" target="_blank">GetDOMHTMLSource.html</a></li>
	</ul>
	<h3>정팀장님 소스를 활용한 예제</h3>
	<ul>
		<li>
			<a href="${ctx}/html/GetDOMHTMLSourceWithValidation.html" target="_blank">GetDOMHTMLSource.html 소스에 validation logic 호출부분 삽입해서 테스트한 소스</a>
			<pre>
  1. Preview에 validation 기능 넣어서 쉽게 구현해보기
   - ajax를 통해 source의 내용을 서버로 전달하고 서버는 전달받은 소스를 validation
   - 결과를 client return 해주는 것 구현해보기
			</pre>
		</li>
		<li>
			<a href="${ctx}/html/HtmlValidationForIframe.jsp" target="_blank">IFRAME을 통한 Validation 구현</a>
			<pre>
  2. URL 호출을 통해서 Validation 하기
  - http://users.skynet.be/mgueury/mozilla/sample/jsample3.html - 소스 캐치 하는 부분 구현해보기
			</pre>
		</li>
	</ul>
</body>
</html>