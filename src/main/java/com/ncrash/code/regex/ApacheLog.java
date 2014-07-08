package com.ncrash.code.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ApacheLog {

	public String ipAddress;
	public String unknowField1;
	public String unknowField2;
	public String accessDate;
	public String methodAndUrl;
	public String returnCode;
	public String responseBytes;

	public ApacheLog(String txt) {
		int i = 1;
		String re1 = "^([\\d.]+)"; // IP Part
		String re2 = " (\\S+)"; // Non whitespace character(-)
		String re3 = " (\\S+)"; // Non whitespace character(-)
		String re4 = " \\[([\\w:/]+\\s[+\\-]\\d{4})\\]";  // Date
		String re5 = " \"(.+?)\"";   // Method and URL 
		String re6 = " (\\d{3})"; 	// return code
		String re7 = " (\\d+)";		// response bytes
		// 브라우저 유형, Caller의 정보 등은 별 필요없음.
		
		Pattern p = Pattern.compile(re1 + re2 + re3 + re4 + re5 + re6 + re7, Pattern.CASE_INSENSITIVE
				| Pattern.DOTALL);
		Matcher m = p.matcher(txt);
		
		if(m.find()) {
			ipAddress = m.group(i++);
			unknowField1 = m.group(i++);
			unknowField2 = m.group(i++);
			accessDate = m.group(i++);
			methodAndUrl = m.group(i++);
			returnCode = m.group(i++);
			responseBytes = m.group(i++);
		}
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public String getUnknowField1() {
		return unknowField1;
	}

	public void setUnknowField1(String unknowField1) {
		this.unknowField1 = unknowField1;
	}

	public String getUnknowField2() {
		return unknowField2;
	}

	public void setUnknowField2(String unknowField2) {
		this.unknowField2 = unknowField2;
	}

	public String getAccessDate() {
		return accessDate;
	}

	public void setAccessDate(String accessDate) {
		this.accessDate = accessDate;
	}

	public String getMethodAndUrl() {
		return methodAndUrl;
	}

	public void setMethodAndUrl(String methodAndUrl) {
		this.methodAndUrl = methodAndUrl;
	}

	public String getReturnCode() {
		return returnCode;
	}

	public void setReturnCode(String returnCode) {
		this.returnCode = returnCode;
	}

	public String getResponseBytes() {
		return responseBytes;
	}

	public void setResponseBytes(String responseBytes) {
		this.responseBytes = responseBytes;
	}
}
