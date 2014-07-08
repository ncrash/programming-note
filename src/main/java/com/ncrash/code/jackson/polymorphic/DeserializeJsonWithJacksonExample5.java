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

public class DeserializeJsonWithJacksonExample5 {
	public String SimpleDeserializationSerializationWithMixInToFromContainerObjectWithPolymorphicCollection()
			throws JsonParseException, JsonMappingException, IOException {
		File jsonFile = new File(getClass().getResource("input_5.json")
				.getFile());

		ObjectMapper mapper = new ObjectMapper();
		mapper.setPropertyNamingStrategy(new CamelCaseNamingStrategy());
		mapper.getDeserializationConfig().addMixInAnnotations(
				AnimalExample5.class, PolymorphicAnimalExample5.class);
		mapper.getSerializationConfig().addMixInAnnotations(
				AnimalExample5.class, PolymorphicAnimalExample5.class);
		ZooExample5 zoo = mapper.readValue(jsonFile, ZooExample5.class);

		return mapper.defaultPrettyPrintingWriter().writeValueAsString(zoo);
	}
}

class ZooExample5 {
	public Collection<AnimalExample5> animals;
}

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({ @Type(value = CatExample5.class, name = "cat"),
		@Type(value = DogExample5.class, name = "dog") })
abstract class PolymorphicAnimalExample5 {

}

abstract class AnimalExample5 {
	public String name;
}

class DogExample5 extends AnimalExample5 {
	public String breed;
	public String leashColor;
}

class CatExample5 extends AnimalExample5 {
	public String favoriteToy;
}
