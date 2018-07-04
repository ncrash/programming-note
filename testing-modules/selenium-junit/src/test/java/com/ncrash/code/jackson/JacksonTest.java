package com.ncrash.code.jackson;

import static org.junit.Assert.assertEquals;

import com.ncrash.code.jackson.User.Name;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.node.ObjectNode;
import org.codehaus.jackson.type.TypeReference;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

/**
 * JacksonTest.java
 *
 * @author daekwon.kang
 * @since 2010. 2. 25.
 * @see
 */
public class JacksonTest {

  private File userjsonFile;
  private ObjectMapper mapper;

  @Before
  public void setUp() throws Exception {
    userjsonFile = new File(getClass().getClassLoader().getResource("user.json").getFile());
    mapper = new ObjectMapper();
  }

  @After
  public void tearDown() throws Exception {
    userjsonFile = null;
    mapper = null;
  }

  private void assertLastname(String lastName) {
    assertEquals("Sixpack", lastName);
  }

  private void assertFirstname(String firstName) {
    assertEquals("Joe", firstName);
  }

  private void assertGender(String gender) {
    assertEquals(User.Gender.MALE.toString(), gender);
  }

  private void assertVerified(boolean verified) {
    assertEquals(false, verified);
  }

  private void assertUser(User user) {
    assertFirstname(user.getName().getFirst());
    assertLastname(user.getName().getLast());
    assertGender(user.getGender().toString());
    assertVerified(user.isVerified());
  }

  @Test
  public void testDataBiding() throws JsonParseException, JsonMappingException, IOException {
    User user = mapper.readValue(userjsonFile, User.class);

    assertUser(user);

    // TODO 해결 할 수 있다면 아래의 user.getUserImage()도 assertion 처리해야 함
    //		assertEquals("Rm9vYmFyIQ==", user.getUserImage());
  }

  @SuppressWarnings("unchecked")
  @Test
  public void testSimpleDataBindingExample()
      throws JsonParseException, JsonMappingException, IOException {
    Map<String, Object> userData = mapper.readValue(userjsonFile, Map.class);
    Map<String, String> nameStruct = (Map<String, String>) userData.get("name");

    assertFirstname(nameStruct.get("first"));
    assertLastname(nameStruct.get("last"));
    assertGender(userData.get("gender").toString());
    assertVerified(new Boolean(userData.get("verified").toString()));
  }

  @SuppressWarnings("unchecked")
  @Ignore
  @Test
  public void testDataBindingWithGenerics()
      throws JsonParseException, JsonMappingException, IOException {
    // TODO 아래 구문에서 org.codehaus.jackson.map.JsonMappingException 발생
    // Unrecognized field "first" (Class com.ncrash.code.jackson.User), not marked as ignorable
    Map<?, ?> result = mapper.readValue(userjsonFile, new TypeReference<Map<String, User>>() {});
  }

  @Test
  public void testTreeModelExample() throws JsonParseException, JsonMappingException, IOException {
    // can either use mapper.readTree(JsonParser), or bind to JsonNode
    JsonNode rootNode = mapper.readValue(userjsonFile, JsonNode.class);
    // ensure that "last name" isn't "Xmler"; if is, change to "Jsoner"
    JsonNode nameNode = rootNode.path("name");

    assertFirstname(nameNode.path("first").getTextValue());
    assertLastname(nameNode.path("last").getTextValue());
    assertGender(rootNode.path("gender").getTextValue());
    assertVerified(rootNode.path("verified").getBooleanValue());

    String lastName = nameNode.path("last").getTextValue();
    if ("sixpack".equalsIgnoreCase(lastName)) {
      ((ObjectNode) nameNode).put("last", "Jsoner");
    }

    // and write it out:
    //		m.writeValue(new File("user-modified.json"), rootNode);

    assertEquals("Jsoner", nameNode.path("last").getTextValue());
  }

  @Test
  public void testStreamingAPIExample() throws JsonParseException, IOException {

    JsonFactory f = new JsonFactory();
    JsonParser jp = f.createJsonParser(userjsonFile);
    User user = new User();
    jp.nextToken(); // will return JsonToken.START_OBJECT (verify?)
    while (jp.nextToken() != JsonToken.END_OBJECT) {
      String fieldname = jp.getCurrentName();
      jp.nextToken(); // move to value, or START_OBJECT/START_ARRAY
      if ("name".equals(fieldname)) { // contains an object
        Name name = new Name();
        while (jp.nextToken() != JsonToken.END_OBJECT) {
          String namefield = jp.getCurrentName();
          jp.nextToken(); // move to value
          if ("first".equals(namefield)) {
            name.setFirst(jp.getText());
          } else if ("last".equals(namefield)) {
            name.setLast(jp.getText());
          } else {
            throw new IllegalStateException("Unrecognized field '" + fieldname + "'!");
          }
        }
        user.setName(name);
      } else if ("gender".equals(fieldname)) {
        user.setGender(User.Gender.valueOf(jp.getText()));
      } else if ("verified".equals(fieldname)) {
        user.setVerified(jp.getCurrentToken() == JsonToken.VALUE_TRUE);
      } else if ("userImage".equals(fieldname)) {
        user.setUserImage(jp.getBinaryValue());
      } else {
        throw new IllegalStateException("Unrecognized field '" + fieldname + "'!");
      }
    }
    jp.close(); // ensure resources get cleaned up timely and properly

    assertUser(user);
  }
}
