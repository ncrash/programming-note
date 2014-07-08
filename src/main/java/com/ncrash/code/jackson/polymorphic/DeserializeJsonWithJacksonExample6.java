package com.ncrash.code.jackson.polymorphic;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.Version;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.deser.StdDeserializer;
import org.codehaus.jackson.map.module.SimpleModule;
import org.codehaus.jackson.node.ObjectNode;

public class DeserializeJsonWithJacksonExample6 {
	public String SimpleDeserializationWithoutTypeElementToContainerObjectWithPolymorphicCollection()
			throws IOException {
		File jsonFile = new File(getClass().getResource("input_6.json")
				.getFile());

		AnimalDeserializer deserializer = new AnimalDeserializer();
		deserializer.registerAnimal("leash_color", DogExample6.class);
		deserializer.registerAnimal("favorite_toy", CatExample6.class);
		deserializer.registerAnimal("wing_span", BirdExample6.class);
		SimpleModule module = new SimpleModule(
				"PolymorphicAnimalDeserializerModule", new Version(1, 0, 0,
						null));
		module.addDeserializer(AnimalExample6.class, deserializer);

		ObjectMapper mapper = new ObjectMapper();
		mapper.setPropertyNamingStrategy(new CamelCaseNamingStrategy());
		mapper.registerModule(module);

		ZooExample6 zoo = mapper.readValue(jsonFile, ZooExample6.class);

		return mapper.defaultPrettyPrintingWriter().writeValueAsString(zoo);
	}
}

class AnimalDeserializer extends StdDeserializer<AnimalExample6> {
	private Map<String, Class<? extends AnimalExample6>> registry = new HashMap<String, Class<? extends AnimalExample6>>();

	AnimalDeserializer() {
		super(AnimalExample6.class);
	}

	void registerAnimal(String uniqueAttribute,
			Class<? extends AnimalExample6> animalClass) {
		registry.put(uniqueAttribute, animalClass);
	}

	@Override
	public AnimalExample6 deserialize(JsonParser jp, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {
		ObjectMapper mapper = (ObjectMapper) jp.getCodec();
		ObjectNode root = (ObjectNode) mapper.readTree(jp);
		Class<? extends AnimalExample6> animalClass = null;
		Iterator<Entry<String, JsonNode>> elementsIterator = root.getFields();
		while (elementsIterator.hasNext()) {
			Entry<String, JsonNode> element = elementsIterator.next();
			String name = element.getKey();
			if (registry.containsKey(name)) {
				animalClass = registry.get(name);
				break;
			}
		}
		if (animalClass == null)
			return null;
		return mapper.readValue(root, animalClass);
	}
}

class ZooExample6 {
	public Collection<AnimalExample6> animals;
}

abstract class AnimalExample6 {
	public String name;
}

class DogExample6 extends AnimalExample6 {
	public String breed;
	public String leashColor;
}

class CatExample6 extends AnimalExample6 {
	public String favoriteToy;
}

class BirdExample6 extends AnimalExample6 {
	public String wingSpan;
	public String preferredFood;
}