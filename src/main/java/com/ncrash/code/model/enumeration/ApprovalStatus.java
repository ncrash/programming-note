package com.ncrash.code.model.enumeration;

/**
 * AdvReport ApprovalType
 * 
 * @author NCrash
 * @category 24/7adcenter
 * @since 2009.07.20 
 */
public enum ApprovalStatus {
	Wait("W"),  		// 대기
	Deny("D"),  		// 거부
	Approval("A");  	// 승인
	
	private final String value;
	ApprovalStatus(String v) {
		this.value = v;
    }
	
	public String value() {
        return this.value;
    }
	
	public String getValue() {
		return value();
	}
	
	public static ApprovalStatus fromValue(String v) {
        for (ApprovalStatus c: ApprovalStatus.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
}
