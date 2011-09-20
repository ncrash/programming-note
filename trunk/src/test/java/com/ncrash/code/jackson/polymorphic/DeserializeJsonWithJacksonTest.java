package com.ncrash.code.jackson.polymorphic;

import static org.junit.Assert.*;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/*
 * http://programmerbruce.blogspot.com/2011/05/deserialize-json-with-jackson-into.html
 */

public class DeserializeJsonWithJacksonTest {
	DeserializeJsonWithJacksonExample1 deserializeJsonWithJacksonExample1;
	DeserializeJsonWithJacksonExample2 deserializeJsonWithJacksonExample2;
	DeserializeJsonWithJacksonExample3 deserializeJsonWithJacksonExample3;
	DeserializeJsonWithJacksonExample4 deserializeJsonWithJacksonExample4;
	DeserializeJsonWithJacksonExample5 deserializeJsonWithJacksonExample5;
	DeserializeJsonWithJacksonExample6 deserializeJsonWithJacksonExample6;
	
	@Before
	public void setUp() throws Exception {
		deserializeJsonWithJacksonExample1 = new DeserializeJsonWithJacksonExample1();
		deserializeJsonWithJacksonExample2 = new DeserializeJsonWithJacksonExample2();
		deserializeJsonWithJacksonExample3 = new DeserializeJsonWithJacksonExample3();
		deserializeJsonWithJacksonExample4 = new DeserializeJsonWithJacksonExample4();
		deserializeJsonWithJacksonExample5 = new DeserializeJsonWithJacksonExample5();
		deserializeJsonWithJacksonExample6 = new DeserializeJsonWithJacksonExample6();
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void example1() throws Exception {
		File jsonFile = new File(getClass().getResource("input_1.json").getFile());
		String metadatacontent = FileUtils.readFileToString(jsonFile);

		assertEquals(metadatacontent, deserializeJsonWithJacksonExample1.SimpleObjectDeserializationAndSerialization());
	}
	
	@Test
	public void example2() throws Exception {
		File jsonFile = new File(getClass().getResource("input_2.json").getFile());
		String metadatacontent = FileUtils.readFileToString(jsonFile);
		
		assertEquals(metadatacontent, deserializeJsonWithJacksonExample2.SimpleCollectionDeserializationAndSerialization("TypeReference"));
		assertEquals(metadatacontent, deserializeJsonWithJacksonExample2.SimpleCollectionDeserializationAndSerialization("ConstructParametricType"));
	}
	
	@Test
	public void example3() throws Exception {
		File jsonFile = new File(getClass().getResource("input_3.json").getFile());
		String metadatacontent = FileUtils.readFileToString(jsonFile);
		
		assertEquals(metadatacontent, deserializeJsonWithJacksonExample3.SimpleDeserializationSerializationToFromContainerObjectWithCollection());
	}
	
	@Test
	public void example4() throws Exception {
		File jsonFile = new File(getClass().getResource("input_4.json").getFile());
		String metadatacontent = FileUtils.readFileToString(jsonFile);
		
		assertEquals(metadatacontent, deserializeJsonWithJacksonExample4.SimpleDeserializationSerializationToFromContainerObjectWithPolymorphicCollection());
	}
	
	@Test
	public void example5() throws Exception {
		File jsonFile = new File(getClass().getResource("input_5.json").getFile());
		String metadatacontent = FileUtils.readFileToString(jsonFile);
		
		assertEquals(metadatacontent, deserializeJsonWithJacksonExample5.SimpleDeserializationSerializationWithMixInToFromContainerObjectWithPolymorphicCollection());
	}
	
	@Test
	public void example6() throws Exception {
		File jsonFile = new File(getClass().getResource("input_6.json").getFile());
		String metadatacontent = FileUtils.readFileToString(jsonFile);
		
		assertEquals(metadatacontent, deserializeJsonWithJacksonExample6.SimpleDeserializationWithoutTypeElementToContainerObjectWithPolymorphicCollection());
	}
}
