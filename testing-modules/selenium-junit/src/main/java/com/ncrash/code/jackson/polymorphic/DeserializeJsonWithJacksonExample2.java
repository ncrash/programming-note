package com.ncrash.code.jackson.polymorphic;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.type.TypeFactory;
import org.codehaus.jackson.type.TypeReference;

public class DeserializeJsonWithJacksonExample2 {
  public String SimpleCollectionDeserializationAndSerialization(String runType) throws IOException {

    File jsonFile = new File(getClass().getResource("input_2.json").getFile());

    ObjectMapper mapper = new ObjectMapper();
    Collection<AnimalExample2> animals = null;

    if ("TypeReference".equals(runType)) {
      animals = mapper.readValue(jsonFile, new TypeReference<Collection<AnimalExample2>>() {});
    } else if ("ConstructParametricType".equals(runType)) {
      animals =
          mapper.readValue(
              jsonFile,
              TypeFactory.defaultInstance()
                  .constructParametricType(Collection.class, AnimalExample2.class));
    }

    return mapper.defaultPrettyPrintingWriter().writeValueAsString(animals);
  }
}

class ZooExample2 {
  public Collection<AnimalExample2> animals;
}

class AnimalExample2 {
  public String type;
  public String name;
}
