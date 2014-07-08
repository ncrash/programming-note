package com.ncrash.code.model.enumeration;

/**
 * AdvReport MemberType.java
 * 
 * @author NCrash
 * @category 24/7adcenter
 * @since 2009.07.20 
 */
public enum MemberType {
	Admin("0"),			// 관리자 
	Advertiser("1"), 	// 광고주
	Agency("2"), 		// 대행사
	AdManager("3"); 	// 사용자(24/7 rmkMember)
	
	private final String value;
	MemberType(String v) {
		this.value = v;
    }
	
	public int value() {
        return Integer.parseInt(this.value);
    }
	
	public static MemberType fromValue(String v) {
        for (MemberType c: MemberType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
}
