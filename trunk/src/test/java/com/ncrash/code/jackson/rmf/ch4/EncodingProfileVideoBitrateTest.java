package com.ncrash.code.jackson.rmf.ch4;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class EncodingProfileVideoBitrateTest {
	private int b256Value;
	private String b256Desc;

	@Before
	public void setup() {
		b256Value = 256;
		b256Desc = "256Kbps";
	}

	@Test
	public void iphone() {
		assertEquals(b256Value, EncodingProfileVideoBitrate.B_256.getValue());
		assertEquals(b256Desc, EncodingProfileVideoBitrate.B_256.getDesc());
		assertEquals(EncodingProfileVideoBitrate.fromValue(b256Value),
				EncodingProfileVideoBitrate.B_256);
	}
}