package com.ncrash.code.findbugs;

/**
 * <pre>
 * SamsungInsenTv.java
 * Source Scan 작업하면서 발견한 Findbugs 유형, eclipse -> findbugs 수행하면 warring 확인 가능
 * </pre>
 * 
 * @author NCrash
 * @category Samsung InternetTV 2nd
 * @since 2009.11.11 
 * @see 
 */
public class SamsungInsenTv {

	static Float clickRate;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Long billing;
		
//		Bug: Method com.ncrash.code.findbugs.SamsungInsenTv.main(String[]) invokes inefficient new Long(long) constructor; use Long.valueOf(long) instead
//		Pattern id: DM_NUMBER_CTOR, type: Bx, category: PERFORMANCE
		billing = new Long(0);
		System.out.println(billing);
		billing = Long.valueOf(0L);
		System.out.println(billing);
		
//		Bug: Method com.ncrash.code.findbugs.SamsungInsenTv.main(String[]) invokes inefficient new Integer(int) constructor; use Integer.valueOf(int) instead
//		Pattern id: DM_NUMBER_CTOR, type: Bx, category: PERFORMANCE
		Integer pageNum = 0;
		Long pageSize = Long.valueOf(0L);
		pageNum = new Integer((pageNum.intValue() - 1) * pageSize.intValue());
		System.out.println(pageNum);
		pageNum = Integer.valueOf((pageNum.intValue() - 1) * pageSize.intValue());
		System.out.println(pageNum);
		
//		Bug: integral division result cast to double or float
//		Pattern id: ICAST_IDIV_CAST_TO_DOUBLE, type: ICAST, category: STYLE
		float clickRate;
		clickRate = (float) (getTotalClickthrus() / getTotalImpressions()) * 100;
		System.out.println(clickRate);
		clickRate = (float) (getTotalClickthrus() / (float) getTotalImpressions()) * 100;
		System.out.println(clickRate);
	}

	private static int getTotalImpressions() {
		// TODO Auto-generated method stub
		return 1000;
	}

	private static int getTotalClickthrus() {
		// TODO Auto-generated method stub
		return 1010;
	}
	
    public static Float getClickRate() {
        if (clickRate == null)    clickRate = new Float(0);
        if (clickRate == 0.0 && getImpressions() != 0) {
            clickRate = (Float) (getClickthrus().intValue() / getImpressions().floatValue()) * 100;
        }
        return clickRate;
    }

	private static Float getClickthrus() {
		// TODO Auto-generated method stub
		return null;
	}

	private static Integer getImpressions() {
		// TODO Auto-generated method stub
		return 0;
	}
}
