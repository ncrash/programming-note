package com.ncrash.code.jackson;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonEncoding;
import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonGenerator;
import org.junit.Test;

/**
 * JacksonGeneratorTest.java
 * 
 * @author daekwon.kang
 * @since 2010. 2. 25.
 * @see
 */
public class JacksonGeneratorTest {

	@Test
	public void testStreamingAPIJsonGeneratorExample() throws IOException {
		JsonFactory f = new JsonFactory();
		JsonGenerator g = f.createJsonGenerator(new File("user.json"), JsonEncoding.UTF8);

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

	}
}
