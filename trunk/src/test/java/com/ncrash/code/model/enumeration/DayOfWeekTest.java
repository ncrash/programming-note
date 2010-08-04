package com.ncrash.code.model.enumeration;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

/**
 * DayOfWeekTest.java
 * 
 * @author ncrash
 * @since 2009. 12. 3.
 * @see DayOfWeek
 */
public class DayOfWeekTest {
	
    String fmt    = null;
    String sdate1 = null;
    String sdate2 = null;

    SimpleDateFormat df = null;

    Date date1  = null;
    Date date2  = null;
    Calendar cal1 = null; 
    Calendar cal2 = null;

	@Before public void setup() {
        fmt    = "MM-dd-yyyy HH:mm:ss";
        df = new SimpleDateFormat(fmt);
        
        sdate1 = "12-31-2009 23:59:59";
        sdate2 = "01-01-2003 00:00:01";
        
		try {
			date1 = df.parse(sdate1);
			date2 = df.parse(sdate2);
		} catch (ParseException pe) {
			pe.printStackTrace();
		}
		
        cal1=Calendar.getInstance(); 
        cal2=Calendar.getInstance(); 

		cal1.setTime(date1);  
		cal2.setTime(date2);  
	}
	
	@SuppressWarnings("static-access")
	@Test public void verifyWait() {
		System.out.println(cal1.toString());
		assertEquals(cal1.getInstance().MONDAY, Integer.parseInt(DayOfWeek.Monday.value()));
	}
}
