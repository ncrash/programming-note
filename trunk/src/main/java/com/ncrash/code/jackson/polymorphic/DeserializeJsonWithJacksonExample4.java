package com.ncrash.code.jackson.polymorphic;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.annotate.JsonSubTypes;
import org.codehaus.jackson.annotate.JsonSubTypes.Type;
import org.codehaus.jackson.annotate.JsonTypeInfo;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class DeserializeJsonWithJacksonExample4 {
	public String SimpleDeserializationSerializationToFromContainerObjectWithPolymorphicCollection()
			throws JsonParseException, JsonMappingException, IOException {
		File jsonFile = new File(getClass().getResource("input_4.json")
				.getFile());

		ObjectMapper mapper = new ObjectMapper();
		mapper.setPropertyNamingStrategy(new CamelCaseNamingStrategy());
		Example4 zoo = mapper.readValue(jsonFile, Example4.class);

		return mapper.defaultPrettyPrintingWriter().writeValueAsString(zoo);
	}
}

class Example4 {
	public Collection<AnimalExample4> animals;
}

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({ @Type(value = CatExample4.class, name = "cat"),
		@Type(value = DogExample4.class, name = "dog") })
abstract class AnimalExample4 {
	public String name;
}

class DogExample4 extends AnimalExample4 {
	public String breed;
	public String leashColor;
}

class CatExample4 extends AnimalExample4 {
	public String favoriteToy;
}
