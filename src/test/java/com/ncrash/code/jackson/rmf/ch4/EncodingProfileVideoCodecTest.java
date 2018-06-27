package com.ncrash.code.jackson.rmf.ch4;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class EncodingProfileVideoCodecTest {
  private String mpeg4Value;
  private String mpeg4Desc;

  @Before
  public void setup() {
    mpeg4Value = "mpeg4";
    mpeg4Desc = "mpeg4";
  }

  @Test
  public void mpeg4() {
    assertEquals(mpeg4Value, EncodingProfileVideoCodec.MPEG4.getValue());
    assertEquals(mpeg4Desc, EncodingProfileVideoCodec.MPEG4.getDesc());
    assertEquals(EncodingProfileVideoCodec.fromValue(mpeg4Value), EncodingProfileVideoCodec.MPEG4);
  }
}
