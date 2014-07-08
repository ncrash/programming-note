package com.ncrash.code.jackson.polymorphic;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class DeserializeJsonWithJacksonExample3 {
	public String SimpleDeserializationSerializationToFromContainerObjectWithCollection()
			throws JsonParseException, JsonMappingException, IOException {
		File jsonFile = new File(getClass().getResource("input_3.json")
				.getFile());

		ObjectMapper mapper = new ObjectMapper();

		ZooExample3 zoo = mapper.readValue(jsonFile, ZooExample3.class);

		return mapper.defaultPrettyPrintingWriter().writeValueAsString(zoo);
	}
}

class ZooExample3 {
	public Collection<AnimalExample3> animals;
}

class AnimalExample3 {
	public String type;
	public String name;
}