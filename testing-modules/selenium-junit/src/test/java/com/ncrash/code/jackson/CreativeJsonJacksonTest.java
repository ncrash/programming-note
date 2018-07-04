package com.ncrash.code.jackson;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;

/**
 * CreativeJsonJacksonTest.java
 *
 * @author daekwon.kang
 * @since 2010. 3. 26.
 * @see
 */
public class CreativeJsonJacksonTest {

  @Test
  public void testTreeModelExample() throws JsonParseException, JsonMappingException, IOException {
    File creativeJsonFile =
        new File(getClass().getClassLoader().getResource("creative.json").getFile());
    ObjectMapper m = new ObjectMapper();
    // can either use mapper.readTree(JsonParser), or bind to JsonNode
    JsonNode rootNode = m.readValue(creativeJsonFile, JsonNode.class);
    // ensure that "last name" isn't "Xmler"; if is, change to "Jsoner"
    JsonNode multiClicksNode = rootNode.path("multiClicks");

    // basic assertion
    assertEquals(
        "assertion for adformat value is 'Banner'",
        "Banner",
        rootNode.path("adFormat").getTextValue());
    assertEquals("assertion for multiClicks element count", 3, multiClicksNode.size());

    // multiClicks assertion data setting
    List<String> verifyClickUrlList =
        new ArrayList<String>() {
          {
            add("www.daum.net");
            add("www.naver.net");
            add("www.nate.com");
          }
        };

    List<String> verifyCreativeIdList =
        new ArrayList<String>() {
          {
            add("c01");
            add("c02");
            add("c03");
          }
        };

    List<String> verifyPositionList =
        new ArrayList<String>() {
          {
            add("left");
            add("center");
            add("right");
          }
        };

    // multiClicks assertion
    int i = 0;
    for (JsonNode clickUrlNode : multiClicksNode) {
      assertEquals(verifyClickUrlList.get(i), clickUrlNode.path("url").getTextValue());
      assertEquals(verifyCreativeIdList.get(i), clickUrlNode.path("creativeId").getTextValue());
      assertEquals(verifyPositionList.get(i), clickUrlNode.path("position").getTextValue());
      i++;

      //			for (String jsonNode : clickUrlNode.getFieldNames()) {
      //
      //			}
    }
  }
}
