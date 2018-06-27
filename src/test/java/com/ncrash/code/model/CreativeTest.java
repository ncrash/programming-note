package com.ncrash.code.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

import org.junit.Before;
import org.junit.Test;

/**
 * AdvReport CreativeTest.java
 *
 * @author NCrash
 * @since 2009.11.11
 * @see Creative
 */
public class CreativeTest {
  private Creative creative;
  private StringBuffer creativeContent;
  private StringBuffer creativeContentSeqRemove;

  @Before
  public void setup() {
    creativeContent = new StringBuffer();
    creativeContent.append("\n").append("</ad>");
    creativeContent.append("\n").append("    id = ff808081-2448b3b9-0124-4ba063f3-0013");
    creativeContent.append("\n").append("    name = Waiting for Approval");
    creativeContent.append("\n").append("    clickUrl = 1212");
    creativeContent.append("\n").append("    discount = Yes");
    creativeContent.append("\n").append("    displayFlag = No");
    creativeContent.append("\n").append("    url = ff808081-2448b3b9-0124-4ba063f3-0013.html");
    creativeContent
        .append("\n")
        .append(
            "    creativeContent = <ad id=\"ff808081-24476442-0124-47db6b93-0020\" type=\"image\">");
    creativeContent
        .append("\n")
        .append("    <interaction type=\"redirect\" id=\"inid_f4babfa1a3d968473f72f55085630f35\">");
    creativeContent.append("\n").append("        <redirect url=\"1212\" protocol=\"http\"/>");
    creativeContent.append("\n").append("    </interaction>");
    creativeContent.append("\n").append("    <creative seq=\"12\"");
    creativeContent
        .append("\n")
        .append(
            "        impression=\"http://168.219.192.142/RealMedia/ads/adstream_lx.ads/%%PAGE%%/%%RAND%%/imp/%%CAMP%%/ff808081-24476442-0124-47dc0c60-0021.html/%%USER%%\"");
    creativeContent
        .append("\n")
        .append(
            "        size=\"25315\" height=\"295\" width=\"295\" type=\"image/jpeg\" id=\"crid_e67fd2b5b867dbca68bbea17170a6be1\">");
    creativeContent.append("\n").append("        <source");
    creativeContent
        .append("\n")
        .append(
            "            url=\"http://localhost:8080/files/creative/netville/ff808081-24476442-0124-47db6b93-0020/1255399509578.jpg\" protocol=\"http\"/>");
    creativeContent.append("\n").append("    </creative>");
    creativeContent
        .append("\n")
        .append(
            "    <creative seq=\"1\" width=\"295\" parentSeq=\"1\"     size=\"6041\" height=\"179\" width=\"295\"");
    creativeContent
        .append("\n")
        .append("        type=\"video/x-msvideo\" id=\"crid_39696b16f6f463cfbdddb27bbe4b1217\">");
    creativeContent.append("\n").append("        <source");
    creativeContent
        .append("\n")
        .append(
            "            url=\"http://localhost:8080/files/creative/netville/ff808081-24476442-0124-47db6b93-0020/1255399509593.avi\" protocol=\"http\"/>");
    creativeContent.append("\n").append("    </creative>");
    creativeContent
        .append("\n")
        .append(
            "    <creative seq=\"2\" parentSeq=\"1\" type=\"text/plain\" id=\"crid_f09567ff61ce48c89ba236338ccb80e8\">");
    creativeContent
        .append("\n")
        .append("        <source protocol=\"none\"><![CDATA[aaaaa]]></source>");
    creativeContent.append("\n").append("    </creative>");
    creativeContent.append("\n").append("</ad>");

    creativeContentSeqRemove = new StringBuffer();
    creativeContentSeqRemove.append("\n").append("</ad>");
    creativeContentSeqRemove.append("\n").append("    id = ff808081-2448b3b9-0124-4ba063f3-0013");
    creativeContentSeqRemove.append("\n").append("    name = Waiting for Approval");
    creativeContentSeqRemove.append("\n").append("    clickUrl = 1212");
    creativeContentSeqRemove.append("\n").append("    discount = Yes");
    creativeContentSeqRemove.append("\n").append("    displayFlag = No");
    creativeContentSeqRemove
        .append("\n")
        .append("    url = ff808081-2448b3b9-0124-4ba063f3-0013.html");
    creativeContentSeqRemove
        .append("\n")
        .append(
            "    creativeContent = <ad id=\"ff808081-24476442-0124-47db6b93-0020\" type=\"image\">");
    creativeContentSeqRemove
        .append("\n")
        .append("    <interaction type=\"redirect\" id=\"inid_f4babfa1a3d968473f72f55085630f35\">");
    creativeContentSeqRemove
        .append("\n")
        .append("        <redirect url=\"1212\" protocol=\"http\"/>");
    creativeContentSeqRemove.append("\n").append("    </interaction>");
    creativeContentSeqRemove
        .append("\n")
        .append(
            "    <creative impression=\"http://168.219.192.142/RealMedia/ads/adstream_lx.ads/%%PAGE%%/%%RAND%%/imp/%%CAMP%%/ff808081-24476442-0124-47dc0c60-0021.html/%%USER%%\"");
    creativeContentSeqRemove
        .append("\n")
        .append(
            "        size=\"25315\" height=\"295\" width=\"295\" type=\"image/jpeg\" id=\"crid_e67fd2b5b867dbca68bbea17170a6be1\">");
    creativeContentSeqRemove.append("\n").append("        <source");
    creativeContentSeqRemove
        .append("\n")
        .append(
            "            url=\"http://localhost:8080/files/creative/netville/ff808081-24476442-0124-47db6b93-0020/1255399509578.jpg\" protocol=\"http\"/>");
    creativeContentSeqRemove.append("\n").append("    </creative>");
    creativeContentSeqRemove
        .append("\n")
        .append("    <creative width=\"295\" size=\"6041\" height=\"179\" width=\"295\"");
    creativeContentSeqRemove
        .append("\n")
        .append("        type=\"video/x-msvideo\" id=\"crid_39696b16f6f463cfbdddb27bbe4b1217\">");
    creativeContentSeqRemove.append("\n").append("        <source");
    creativeContentSeqRemove
        .append("\n")
        .append(
            "            url=\"http://localhost:8080/files/creative/netville/ff808081-24476442-0124-47db6b93-0020/1255399509593.avi\" protocol=\"http\"/>");
    creativeContentSeqRemove.append("\n").append("    </creative>");
    creativeContentSeqRemove
        .append("\n")
        .append("    <creative type=\"text/plain\" id=\"crid_f09567ff61ce48c89ba236338ccb80e8\">");
    creativeContentSeqRemove
        .append("\n")
        .append("        <source protocol=\"none\"><![CDATA[aaaaa]]></source>");
    creativeContentSeqRemove.append("\n").append("    </creative>");
    creativeContentSeqRemove.append("\n").append("</ad>");
  }

  @Test
  public void getCreativeContent() {
    creative = new Creative();
    creative.setCreativeContent(creativeContent.toString());

    assertNotSame(creativeContent.toString(), creative.getCreativeContent());
    assertEquals(creativeContentSeqRemove.toString(), creative.getCreativeContent());
  }
}
