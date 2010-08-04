package com.ncrash.code.model.enumeration;

/**
 * <pre>
 * AdvReport MimeType.java
 * Content-Type 설정을 위한 확장자 : content-type
 * 
 * reference : http://www.iana.org/assignments/media-types/
 * Content-Type: Application/octet-stream
 * Content-Type: Application/x-shockwave-flash
 * Content-Type: Application/x-www-form-urlencode
 * Content-Type: text/css
 * Content-Type: text/html
 * Content-Type: text/javascript
 * Content-Type: text/plain
 * Content-Type: text/xml
 * Content-Type: image/jpeg
 * Content-Type: image/gif
 * Content-Type: image/png
 * </pre>
 * 
 * @author NCrash
 * @category 24/7adcenter
 * @since 2009.07.20 
 */

public enum MimeType {

		// reference : http://www.webmaster-toolkit.com/mime-types.shtml
    	swf("application/x-shockwave-flash"),
    	xls("application/vnd.ms-excel"),
    	ppt("application/vnd.ms-powerpoint"),
    	doc("application/msword"),
    	pdf("application/pdf"),
    	jpg("image/jpeg"),
    	jpeg("image/jpeg"),
    	gif("image/gif"),
    	png("image/png"),
    	bmp("image/bmp"),
    	txt("text/plain"),
    	xml("text/xml"),
    	html("text/html"),
    	bin("Application/octet-stream"),
    	zip("application/x-compressed");

	private final String value;
	
	MimeType(String v) {
		this.value = v;
    }
	
	public String value() {
	    return this.value;
    }
	
	public static MimeType fromValue(String v) {
		for (MimeType c: MimeType.values()) {
		    if (c.value.equals(v)) {
		        return c;
		    }
		}
		
        throw new IllegalArgumentException(v);
    }
	
	public static MimeType fromValueNotFoundReturnBin(String v) {
		try {
			return fromValue(v);
		} catch(IllegalArgumentException iae) {
			return MimeType.bin;
		}
	}
	
	public static String getFileExtension(String fileName) {
		if(fileName.length() > 0 && fileName.indexOf(".") > 0) {
			return fileName.substring(fileName.lastIndexOf(".")+1).toLowerCase();
		} else {
			return "";
		}
	}
}
