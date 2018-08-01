package com.ncrash.code.jackson.rmf.ch4;

import org.junit.Test;

public class EncodingProfileTest {
  @Test
  public void name() {}

  //	private static final String SIMPLE_ENCODING_PROFILE_JSON = "simple-encoding-profile.json";
  //
  //	@Rule
  //	public TemporaryFolder folder = new TemporaryFolder();
  //
  //	@Before
  //	public void setUp() throws Exception {
  //	}
  //
  //	@Test
  //	public void simpleDeserializationEncodingProfile() throws Exception {
  //		File jsonFile = new File(getClass().getResource(SIMPLE_ENCODING_PROFILE_JSON).getFile());
  //		String metadatacontent = FileUtils.readFileToString(jsonFile);
  //
  //	    ObjectMapper mapper = new ObjectMapper();
  //	    EncodingProfile encodingProfile =
  //	      mapper.readValue(jsonFile, EncodingProfile.class);
  //
  //	    assertEquals(metadatacontent,
  // mapper.defaultPrettyPrintingWriter().writeValueAsString(encodingProfile));
  //	}
  //
  //	@Test
  //	public void serializationDeserializationObjectCompare() throws Exception {
  //		EncodingProfile encodingProfile = new EncodingProfile();
  //
  //		encodingProfile.setProfileName("iPad(256)");
  //		encodingProfile.setVideoFormat(EncodingProfileVideoFormat.IPHONE);
  //		encodingProfile.setVideoCodec(EncodingProfileVideoCodec.LIBX264);
  //
  //		Collection<EncodingProfileVideoBitrate> encodingProfileVideoBitrates = new
  // ArrayList<EncodingProfileVideoBitrate>();
  //		encodingProfileVideoBitrates.add(EncodingProfileVideoBitrate.B_256);
  //		encodingProfileVideoBitrates.add(EncodingProfileVideoBitrate.B_512);
  //		encodingProfileVideoBitrates.add(EncodingProfileVideoBitrate.B_1024);
  //
  //		encodingProfile.setVideoBitrates(encodingProfileVideoBitrates);
  //
  //		Collection<EncodingProfileVideoSize> encodingProfileVideoSizes = new
  // ArrayList<EncodingProfileVideoSize>();
  //
  //		EncodingProfileVideoSize encodingProfileVideoSize;
  //		encodingProfileVideoSize = new EncodingProfileVideoSize();
  //		encodingProfileVideoSize.setWidth(320);
  //		encodingProfileVideoSize.setHeight(240);
  //		encodingProfileVideoSizes.add(encodingProfileVideoSize);
  //		encodingProfileVideoSize = new EncodingProfileVideoSize();
  //		encodingProfileVideoSize.setWidth(1024);
  //		encodingProfileVideoSize.setHeight(768);
  //		encodingProfileVideoSizes.add(encodingProfileVideoSize);
  //		encodingProfile.setVideoSizes(encodingProfileVideoSizes);
  //
  //		ObjectMapper mapper = new ObjectMapper();
  //		JsonFactory f = new JsonFactory();
  //		JsonGenerator g = f.createJsonGenerator(folder.newFile("temp.json"), JsonEncoding.UTF8);
  //		mapper.writeValue(g, encodingProfile);
  //		g.close(); // important: will force flushing of output, close underlying output stream
  //
  //		File tempJsonFile = new File(folder.getRoot().getAbsolutePath() + "/temp.json");
  //		File jsonFile = new File(getClass().getResource(SIMPLE_ENCODING_PROFILE_JSON).getFile());
  //
  //		String actualValue = FileUtils.readFileToString(tempJsonFile);
  //		String expectedValue = FileUtils.readFileToString(jsonFile).replaceAll("\\s+", "");
  //
  //		assertEquals("compare with generated json and fixture json", expectedValue, actualValue);
  //
  //		EncodingProfile loaedEncodingProfile =
  //			mapper.readValue(tempJsonFile, EncodingProfile.class);
  //
  //		assertReflectionEquals(encodingProfile, loaedEncodingProfile);
  //	}
}
