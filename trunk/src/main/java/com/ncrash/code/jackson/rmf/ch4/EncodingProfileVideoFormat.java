package com.ncrash.code.jackson.rmf.ch4;

public enum EncodingProfileVideoFormat {
	IPHONE("iphone", "apple iphone"),
	PSP("psp", "sony play station"),
	ANDROID("android", "google android");

	private final String value;
	private final String desc;
	
	EncodingProfileVideoFormat(String value, String desc) {
		this.value = value;
		this.desc = desc;
    }
	
	public String value() {
        return this.value;
    }
	
	public String getValue() {
		return value();
	}
	
	public String desc() {
		return this.desc;
	}
	
	public String getDesc() {
		return desc();
	}
	
	public static EncodingProfileVideoFormat fromValue(String v) {
        for (EncodingProfileVideoFormat encodingProfileVideoFormat: EncodingProfileVideoFormat.values()) {
            if (encodingProfileVideoFormat.value.equals(v)) {
                return encodingProfileVideoFormat;
            }
        }
        throw new IllegalArgumentException(v);
    }
}
