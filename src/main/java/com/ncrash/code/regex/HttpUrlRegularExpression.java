package com.ncrash.code.regex;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * HttpUrlRegularExpression.java
 * 
 * @author NCrash
 * @category Samsung InternetTV 2nd
 * @since 2009.11.11 
 */
public class HttpUrlRegularExpression {

	public String getImageSourceUri(String imgTag) {
		if(org.apache.commons.lang.StringUtils.isEmpty(imgTag)) {
			return null;
		} else {
			List<String> result = this.getImageSourceUri(Arrays.asList(imgTag));
			
			if(result.size() > 0) {
				return result.get(0);
			} else {
				return null;
			}
		}
	}
	
	public List<String> getImageSourceUri(List<String> imgTags) {
		List<String> resultImgSrcList = new ArrayList<String>();
		
		for (String imgTag : imgTags) {
			if(imgTag.contains("OasDefault/default/empty.gif")) {
				Pattern p = Pattern.compile("(?i)(<img)(\\s*src=\")(\\b[^\"]*)(\")(.*)");
				Matcher m = p.matcher(imgTag);
				
				while(m.find()) {
					resultImgSrcList.add(m.group(3));
				}
			}
		}
		
		return resultImgSrcList;
	}
}
