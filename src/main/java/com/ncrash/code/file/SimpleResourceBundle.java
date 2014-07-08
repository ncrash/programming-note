package com.ncrash.code.file;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * SimpleResourceBundle.java
 * 
 * @author ncrash
 * @since 2009. 12. 3.
 * @see
 */
public class SimpleResourceBundle {
	
	public static ResourceBundle greetingKorean() {
		ResourceBundle rb = ResourceBundle.getBundle("hello", Locale.KOREAN);
	
		return rb;
	}
	public static ResourceBundle greetingEnglish() {
		ResourceBundle rb = ResourceBundle.getBundle("hello", Locale.ENGLISH);
		
		return rb;
	}
	public static ResourceBundle greetingDefault() {
		ResourceBundle rb = ResourceBundle.getBundle("hello", Locale.getDefault());
		
		return rb;
	}
}
