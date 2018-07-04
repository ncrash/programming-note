package com.gargoylesoftware.htmlunit;

import static org.junit.Assert.fail;

import com.gargoylesoftware.htmlunit.html.HtmlForm;
import com.gargoylesoftware.htmlunit.html.HtmlInput;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

/**
 * HtmlUnitWebClientTest.java
 *
 * @author daekwon.kang
 * @category RichMedia Foundry V3 POC
 * @since 2010. 2. 18.
 * @see
 */
public class HtmlUnitWebClientTest extends WebDriverTestCase {

  public static final String JETTY_WEB_SERVER_URL = "http://localhost:12345/";

  private StringBuffer invalidHtmlSource;

  @Before
  public void before() {
    invalidHtmlSource = new StringBuffer();
    invalidHtmlSource
        .append("\n")
        .append("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
    invalidHtmlSource.append("\n").append("<html>");
    invalidHtmlSource.append("\n").append("<head>");
    invalidHtmlSource.append("\n").append("  <title>JSample3</title>");
    invalidHtmlSource.append("\n").append("</head>");
    invalidHtmlSource.append("\n").append("<body>");
    invalidHtmlSource.append("\n").append("Sample 3: Error in javascript<br>");
    invalidHtmlSource.append("\n").append("<script type=\"text/javascript\">");
    invalidHtmlSource.append("\n").append("");
    invalidHtmlSource.append("\n").append("var doc = document;");
    invalidHtmlSource.append("\n").append("var body = doc.body;");
    invalidHtmlSource.append("\n").append("");
    invalidHtmlSource.append("\n").append("body.appendChild( doc.createElement(\"abc\") );");
    invalidHtmlSource.append("\n").append("");
    invalidHtmlSource.append("\n").append("</script>");
    invalidHtmlSource.append("\n").append("");
    invalidHtmlSource.append("\n").append("</body>");
    invalidHtmlSource.append("\n").append("</html>");
  }

  @Ignore
  @Test
  public void documentCreateElement() throws Exception {
    final WebClient webClient = new WebClient();
    final HtmlPage page = webClient.getPage("http://localhost/validHtmlSource.html");

    //		System.out.println(page.asText());
    //		System.out.println(page.asXml());

    //		for (HtmlElement iterable_element : page.getHtmlElementDescendants()) {
    //			System.out.println(iterable_element.asXml());
    //		}
  }

  @Ignore
  @Test
  public void validateViewGeneratedSource() throws Exception {
    StringBuffer expected = new StringBuffer();

    expected.append("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
    expected.append("\r\n").append("<html>");
    expected.append("\r\n").append("  <head>");
    expected.append("\r\n").append("    <title>");
    expected.append("\r\n").append("      JSample3");
    expected.append("\r\n").append("    </title>");
    expected.append("\r\n").append("  </head>");
    expected.append("\r\n").append("  <body>");
    expected.append("\r\n").append("    ");
    expected.append("\r").append("Sample 3: Error in javascript");
    expected.append("\r\n").append("    <br/>");
    expected.append("\r\n").append("    <script type=\"text/javascript\">");
    expected.append("\r\n").append("//<![CDATA[");
    expected.append("\r\n").append("");
    expected.append("\r").append("");
    expected.append("\r").append("var doc = document;");
    expected.append("\r").append("var body = doc.body;");
    expected.append("\r").append("");
    expected.append("\r").append("body.appendChild( doc.createElement(\"abc\") );");
    expected.append("\r").append("");
    expected.append("\r").append("");
    expected.append("\r\n").append("//]]>");
    expected.append("\r\n").append("    </script>");
    expected.append("\r\n").append("    <abc/>");
    expected.append("\r\n").append("  </body>");
    expected.append("\r\n").append("</html>");
    expected.append("\r\n");

    final WebClient webClient = new WebClient();
    final HtmlPage page = webClient.getPage("http://localhost/validHtmlSource.html");

    String pageAsXml = page.asXml();
    pageAsXml = pageAsXml.replaceFirst("<\\?xml.*>", getHtmlPageDoctype(page));
    String es = expected.toString();
    System.out.println(es.toString().length());
    System.out.println(pageAsXml.toString().length());
    assertEquals(es.toString(), pageAsXml.toString());
  }

  @Ignore
  @Test
  public void validHtmlSourcDoctypeGenerated() throws Exception {
    final WebClient webClient = new WebClient();
    final HtmlPage page = webClient.getPage("http://localhost/validHtmlSource.html");

    String originalDoctype = "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">";

    assertEquals(originalDoctype, getHtmlPageDoctype(page));
  }

  @Ignore
  @Test
  public void invalidHtmlDoctypeGenerated() throws Exception {
    final WebClient webClient = new WebClient();
    final HtmlPage page = webClient.getPage("http://localhost/invalid.html");

    String originalDoctype =
        "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.1//EN\" \"http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd\">";

    assertEquals(originalDoctype, getHtmlPageDoctype(page));
  }

  private String getHtmlPageDoctype(final HtmlPage page) {
    StringBuffer result = new StringBuffer();
    result.append("<!DOCTYPE ");
    result.append(page.getDoctype().getName());
    result.append(" ");
    result.append("PUBLIC \"");
    result.append(page.getDoctype().getPublicId());

    if (page.getDoctype().getSystemId() != null) {
      result.append("\" \"");
      result.append(page.getDoctype().getSystemId());
    }

    result.append("\">");

    return result.toString();
  }

  @Ignore
  @Test
  public void documentWrite() throws Exception {
    final WebClient webClient = new WebClient();

    final HtmlPage page = webClient.getPage("http://localhost/test.html");
    final HtmlForm form = page.getFormByName("form1");
    for (int i = 1; i <= 5; i++) {
      final String expectedName = "textfield" + i;
      assertEquals("text", form.<HtmlInput>getInputByName(expectedName).getTypeAttribute());
    }

    try {
      form.getInputByName("textfield0");
      fail("Expected an ElementNotFoundException");
    } catch (final ElementNotFoundException e) {
      // Expected path
    }

    try {
      form.getInputByName("textfield6");
      fail("Expected an ElementNotFoundException");
    } catch (final ElementNotFoundException e) {
      // Expected path
    }
  }

  @Ignore
  @Test
  public void dynamicValidationWithJetty() throws Exception {
    loadPageWithHtml(invalidHtmlSource.toString());

    final WebClient webClient = new WebClient();
    final HtmlPage page = webClient.getPage(JETTY_WEB_SERVER_URL);

    String originalDoctype = "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">";

    assertEquals(originalDoctype, getHtmlPageDoctype(page));
  }
}
