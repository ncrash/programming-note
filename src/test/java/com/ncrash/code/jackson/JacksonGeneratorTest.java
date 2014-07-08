package com.ncrash.code.jackson;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonEncoding;
import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

/**
 * JacksonGeneratorTest.java
 * 
 * @author daekwon.kang
 * @since 2010. 2. 25.
 * @see
 */
public class JacksonGeneratorTest {
	
	private ObjectMapper mapper;

	@Rule
	public TemporaryFolder folder = new TemporaryFolder(); 
	
	@Before
	public void setUp() throws Exception {
	}
	
	@Test
	public void testStreamingAPIJsonGeneratorExample() throws JsonParseException, JsonMappingException, IOException {
		JsonFactory f = new JsonFactory();
		JsonGenerator g = f.createJsonGenerator(folder.newFile("user.json"), JsonEncoding.UTF8);
		mapper = new ObjectMapper();
		
		g.writeStartObject();
		g.writeObjectFieldStart("name");
		g.writeStringField("first", "Joe");
		g.writeStringField("last", "Sixpack");
		g.writeEndObject(); // for field 'name'
		g.writeStringField("gender", User.Gender.MALE.toString());
		g.writeBooleanField("verified", false);
		g.writeFieldName("userImage"); // no 'writeBinaryField' (yet?)
		byte[] binaryData = "Rm9vYmFyIQ==".getBytes();
		g.writeBinary(binaryData);
		g.writeEndObject();
		g.close(); // important: will force flushing of output, close underlying output stream

		File userjsonFile = new File(folder.getRoot().getAbsolutePath() + "/user.json");
		User user = mapper.readValue(userjsonFile, User.class);
		
		assertUser(user);
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
}
