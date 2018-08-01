package com.ncrash.code.jackson.polymorphic;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.codehaus.jackson.map.ObjectMapper;

public class DeserializeJsonWithJacksonExample1 {
  public String SimpleObjectDeserializationAndSerialization() throws IOException {
    File jsonFile = new File(getClass().getResource("input_1.json").getFile());
    String jsonInput = FileUtils.readFileToString(jsonFile);

    ObjectMapper mapper = new ObjectMapper();
    AnimalExample1 animal = mapper.readValue(jsonInput, AnimalExample1.class);

    return mapper.writeValueAsString(animal);
  }
}

class AnimalExample1 {
  public String type;
  public String name;
}
