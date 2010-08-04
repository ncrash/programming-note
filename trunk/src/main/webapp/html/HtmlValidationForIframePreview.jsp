<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" errorPage="/error.jsp" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ include file="/taglibs.jsp" %>
<%
	String fileName = (String) request.getParameter("filename");

	if(null == fileName) {
		fileName = "jsample3.html";
	}
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!--<meta http-equiv="refresh" content="1"/>-->
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.4/jquery.min.js"></script>
<title>java-code-practice-with-tdd</title>
</head>
<body>
<SCRIPT type="text/javascript"> 
<!--
	function htmlValidationStruts() {
		var htmlSource = getIframeHtmlSource(); 
		var htmlSourceForDisplay = htmlSource.replace(/\n/g, "\t"); 
		//alert(htmlSourceForDisplay);
		
		var workform = document.forms['formPost'];
		workform.action = "${ctx}/Html-Validator.do";
		workform.html_source.value = htmlSourceForDisplay;
		workform.submit();
	}	

	function getIframeHtmlSource() {
		var iframeHtmlSource;
		var iframeInnerHtmlSource;
		var doctypeSource;
		var doctypes = getDOCTYPE(document.getElementById("validateTargetFrame").contentWindow.document);
		var doctypeInspect = '';
		
		doctypeInspect += 'dtd : ' + doctypes.dtd + '\n'; 
		doctypeInspect += 'publicId : ' + doctypes.publicId + '\n'; 
		doctypeInspect += 'systemId : ' + doctypes.systemId + '\n'; 
		doctypeInspect += 'language : ' + doctypes.language + '\n'; 
		doctypeInspect += 'type : ' + doctypes.type + '\n'; 
		doctypeInspect += 'version : ' + doctypes.version + '\n';
		// alert(doctypeInspect);

		doctypeSource = "";
		doctypeSource += "<!DOCTYPE ";
		doctypeSource += doctypes.language;
		doctypeSource += " ";
		doctypeSource += "PUBLIC \"";
		doctypeSource += doctypes.publicId;
		if(doctypes.systemId != "") {
			doctypeSource += "\" \"";
			doctypeSource += doctypes.systemId;
		}
		doctypeSource += "\">";
		// alert(doctypeSource);

		// call iframe function for set html source variable  
		document.getElementById("validateTargetFrame").contentWindow.getHtmlSource();
		iframeInnerHtmlSource = document.getElementById("validateTargetFrame").contentWindow.vHtmlSource;

		// wrapping source
		iframeHtmlSource = '';
		iframeHtmlSource += doctypeSource + "\n";
		iframeHtmlSource += "<html>" + "\n";
		iframeHtmlSource += iframeInnerHtmlSource + "\n";
		iframeHtmlSource += "</html>" + "\n";
		
		return iframeHtmlSource;
	}

	
//-->
</SCRIPT>

<SCRIPT type="text/javascript"> 
<!--

function getDOCTYPE(vDocument){
	  //loc=locEval(loc)||self; // locEval is a function i use <strong class="highlight">to</strong> qualify window/frame paths
	  var pid,sid,val,lng,ver,typ;

	  try{ // this is the node model that should be supported by all browsers. IE gets a hard error with it though.
	    pid=String(vDocument.doctype.publicId);
	    sid=String(vDocument.doctype.systemId);
	  }
	  catch(err){
	    val=String(vDocument.body.parentNode.parentNode.firstChild.nodeValue) // seems <strong class="highlight">to</strong> only work in IE
	    //val=document.getElementsByTagName("!")[0].nodeValue  // works in IE as well

	    pid=val.replace(/^[^\"]*\"([^\"]+)\".*/,"$1");
	    sid=((/http/).test(val))?val.replace(/^.*\"\s\"(http.*)/,"$1"):null
	  }

	  lng=((/xhtml/i).test(pid+sid))?"XHTML":"HTML";
	  typ=((/strict/i).test(pid+sid))?"Strict": ((/trans|loose/i).test(pid+sid))?"Transitional": ((/frame/i).test(pid+sid))?"Frameset": ((/basic/i).test(pid+sid))?"Basic": ((/mobile/i).test(pid+sid))?"Mobile": null;
	  ver=((/html\s*\d+\.?\d*/i).test(pid))?pid.replace(/^.*html\s*(\d+\.?\d*)\D*/i,"$1"):null;

	  return {publicId:pid,systemId:sid,language:lng,type:typ,version:ver,dtd:lng+" "+typ+" "+ver}
	}

	//alert(getDOCTYPE().dtd)

//-->
</SCRIPT>


<SCRIPT type="text/javascript"> 
<!--
 
jQuery(document).ready(function(){
	var iframe = document.getElementById("validateTargetFrame");
	if (navigator.userAgent.indexOf("MSIE") > -1 && !window.opera) {
		if (iframe.readyState == "complete") {
			htmlValidationStruts();
		}
	} else {	
		jQuery('#validateTargetFrame').load(function() {
			htmlValidationStruts();
		});
	}
});
 
	

//-->
</SCRIPT>

<h1>Html Validation For Iframe Preview</h1> 
	 
<table width="100%" border=1>
 <tr>
   <th>
   	target iframe - 
   	<a href="HtmlValidationForIframe.jsp?filename=jsample3.html">Sample 3: Error in javascript</a>
   	</th>
 </tr>
 <tr>
   <td width="100%">
		<iframe id="validateTargetFrame" src="<%=fileName%>" width="100%" ></iframe>
   </td>
 </tr>
 <tr>
   <th>result</th>
 </tr>
 <tr>
   <td width="100%" height="300">
		<iframe id="validateResultFrame" name="validateResultFrame" src="about:blank" width="98%" height="340"></iframe>
   </td>
 </tr>
</table>
<br/>

<form name="formPost" action="${ctx}/html/validator.do" target="validateResultFrame" method="post">
	<input type="hidden" name="html_source" value="" />
</form>

</body>
</html>