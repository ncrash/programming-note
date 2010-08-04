package com.ncrash.code.stringutils;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.ncrash.code.regex.HttpUrlRegularExpression;


/**
 * Contains.java
 * 
 * @author ncrash
 * @since 2010. 1. 21.
 * @see
 */
public class StringUtilsContain {

	private StringBuffer message;
	
	@Before
	public void setUp() throws Exception {
		message = new StringBuffer();
		message.append("Tidy (vers 4th August 2004) Parsing \"InputStream\"");
	}
	
	@Test
	public void testStringUtilsContainMethodAction() {
		assertTrue(org.apache.commons.lang.StringUtils.contains(message.toString(), "Tidy (vers 4th August 2004) Parsing \"InputStream\""));
	}
}
