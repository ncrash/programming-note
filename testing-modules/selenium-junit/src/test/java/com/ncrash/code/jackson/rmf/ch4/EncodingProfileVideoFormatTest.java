package com.ncrash.code.jackson.rmf.ch4;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class EncodingProfileVideoFormatTest {
  private String iphoneValue;
  private String iphoneDesc;

  @Before
  public void setup() {
    iphoneValue = "iphone";
    iphoneDesc = "apple iphone";
  }

  @Test
  public void iphone() {
    assertEquals(iphoneValue, EncodingProfileVideoFormat.IPHONE.getValue());
    assertEquals(iphoneDesc, EncodingProfileVideoFormat.IPHONE.getDesc());
    assertEquals(
        EncodingProfileVideoFormat.fromValue(iphoneValue), EncodingProfileVideoFormat.IPHONE);
  }
}
