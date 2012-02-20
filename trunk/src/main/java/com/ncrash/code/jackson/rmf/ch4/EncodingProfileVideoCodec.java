package com.ncrash.code.jackson.rmf.ch4;

public enum EncodingProfileVideoCodec {
	H264("h264", "h.264"),
	MPEG4("mpeg4", "mpeg4"),
	LIBX264("libx264", "libx264");

	private final String value;
	private final String desc;
	
	EncodingProfileVideoCodec(String value, String desc) {
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
	
	public static EncodingProfileVideoCodec fromValue(String v) {
        for (EncodingProfileVideoCodec encodingProfileVideoFormat: EncodingProfileVideoCodec.values()) {
            if (encodingProfileVideoFormat.value.equals(v)) {
                return encodingProfileVideoFormat;
            }
        }
        throw new IllegalArgumentException(v);
    }
}