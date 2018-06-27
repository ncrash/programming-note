package com.ncrash.code.regex;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * HttpUrlRegularExpressionTest.java
 *
 * @author 강대권
 * @since 2009. 11. 12.
 * @see
 */
public class HttpUrlRegularExpressionTest {

  private HttpUrlRegularExpression httpUrlRegularExpression;
  private StringBuffer imgTagBefore;
  private StringBuffer imgTagAfter;

  @Before
  public void setUp() throws Exception {
    imgTagBefore = new StringBuffer();
    imgTagBefore.append(
        "<A HREF=\"http://adengine.internetat.tv/RealMedia/ads/adstream_lx.ads/site/pssage/623657940/x01/OasDefault/default/empty.gif/32313232363662653461653638363730\" target=\"_top\"><IMG SRC=\"http://adengine.internetat.tv/RealMedia/ads/Creatives/default/empty.gif\"  WIDTH=2 HEIGHT=2 ALT=\"\" BORDER=0 BORDER=\"0\"></A>");

    imgTagAfter = new StringBuffer();
    imgTagAfter.append("http://adengine.internetat.tv/RealMedia/ads/Creatives/default/empty.gif");
  }

  @Test
  public void getImageSourceUri() {
    httpUrlRegularExpression = new HttpUrlRegularExpression();

    assertEquals(
        imgTagAfter.toString(),
        httpUrlRegularExpression.getImageSourceUri(imgTagBefore.toString()));
  }
}
