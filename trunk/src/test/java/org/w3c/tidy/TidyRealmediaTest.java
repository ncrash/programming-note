package org.w3c.tidy;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

/**
 * TidyRealmediaTest.java
 * 
 * @author ncrash
 * @since 2010. 1. 26.
 * @see
 */
public class TidyRealmediaTest {
	TidyRealmedia tidyRealmedia; 
	TidyRealmediaMessageListener messageListener;
	StringBuffer sb;
	
	@Before public void setUp() throws Exception {
		tidyRealmedia = new TidyRealmedia();
		sb = new StringBuffer();
		
		sb.append("\n").append("InputStream: Doctype given is \"-//W3C//DTD XHTML 1.1//EN\"");
		sb.append("\n").append("InputStream: Document content looks like XHTML 1.0 Strict");
		sb.append("\n").append("no warnings or errors were found");
	}
	
	@Ignore
	@Test public void xhtmlValidationWithFile() throws Exception {
		messageListener = tidyRealmedia.executeTidyValidation("invalid.html");
		
		assertEquals(0, messageListener.getParseErrors());
		assertEquals(0, messageListener.getParseWarnings());
		assertEquals(3, messageListener.getReceived().size());
		assertEquals(sb.toString(), messageListener.getParseMessages());
	}
	
	@Test public void xhtmlValidationWithString() throws Exception {
	}
	
	@Test public void xhtmlValidationWithUri() throws Exception {
	}
}
