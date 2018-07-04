package com.ncrash.code.jackson.rmf.ch4;

// import org.junit.FixMethodOrder;

import org.junit.Test;

// import org.junit.runners.MethodSorters;

/*
 * http://davinci.realads.com/projects/lynx/wiki/RMF/OAS11/R4/Design#a3.UserPreference
 * To be model implement testcase
 */
// @FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserPreferenceTest {

  @Test
  public void name() {}

  //	private static final String USER_PREFERENCE_TOBE_FROM_WIKI_JSON =
  // "user-preference-tobe-from-wiki.json";
  //
  //	@Rule
  //	public TemporaryFolder folder = new TemporaryFolder();
  //
  //	@Before
  //	public void setUp() throws Exception {
  //	}
  //
  //	@Test
  //	public void test1_simpleDeserializationUserPreference() throws Exception {
  //		File jsonFile = new
  // File(getClass().getResource(USER_PREFERENCE_TOBE_FROM_WIKI_JSON).getFile());
  //		String metadatacontent = FileUtils.readFileToString(jsonFile);
  //
  //	    ObjectMapper mapper = new ObjectMapper();
  //	    UserPreference userPreference =
  //	      mapper.readValue(jsonFile, UserPreference.class);
  //
  //	    assertEquals(metadatacontent,
  // mapper.defaultPrettyPrintingWriter().writeValueAsString(userPreference));
  //	}
  //
  //	@Test
  //	public void test2_serializationDeserializationObjectCompare() throws Exception {
  //		UserPreference userPreference = new UserPreference();
  //
  //		userPreference.setContent("cover");
  //		userPreference.setUserId("daekwon");
  //		userPreference.setWmode("window");
  //		userPreference.setCountondownload("");
  //		userPreference.setEncoding_notify("daekwon.kang@247realmedia.com");
  //
  //		Collection<EncodingProfile> encoding_profiles = new ArrayList<EncodingProfile>();
  //
  //		EncodingProfile encodingProfile = null;
  //		Collection<EncodingProfileVideoBitrate> encodingProfileVideoBitrates = null;
  //		Collection<EncodingProfileVideoSize> encodingProfileVideoSizes = null;
  //		EncodingProfileVideoSize encodingProfileVideoSize = null;
  //
  //		/* #1 */
  //		encodingProfile = new EncodingProfile();
  //		encodingProfile.setProfileName("iPad(256)");
  //		encodingProfile.setVideoFormat(EncodingProfileVideoFormat.IPHONE);
  //		encodingProfile.setVideoCodec(EncodingProfileVideoCodec.LIBX264);
  //
  //		encodingProfileVideoBitrates = new ArrayList<EncodingProfileVideoBitrate>();
  //		encodingProfileVideoBitrates.add(EncodingProfileVideoBitrate.B_256);
  //		encodingProfileVideoBitrates.add(EncodingProfileVideoBitrate.B_512);
  //		encodingProfileVideoBitrates.add(EncodingProfileVideoBitrate.B_1024);
  //
  //		encodingProfile.setVideoBitrates(encodingProfileVideoBitrates);
  //
  //		encodingProfileVideoSizes = new ArrayList<EncodingProfileVideoSize>();
  //
  //		encodingProfileVideoSize = new EncodingProfileVideoSize();
  //		encodingProfileVideoSize.setWidth(320);
  //		encodingProfileVideoSize.setHeight(240);
  //		encodingProfileVideoSizes.add(encodingProfileVideoSize);
  //		encodingProfileVideoSize = new EncodingProfileVideoSize();
  //		encodingProfileVideoSize.setWidth(1024);
  //		encodingProfileVideoSize.setHeight(768);
  //		encodingProfileVideoSizes.add(encodingProfileVideoSize);
  //		encodingProfile.setVideoSizes(encodingProfileVideoSizes);
  //		encoding_profiles.add(encodingProfile);
  //
  //		/* #2 */
  //		encodingProfile = new EncodingProfile();
  //		encodingProfile.setProfileName("iPad(512)");
  //		encodingProfile.setVideoFormat(EncodingProfileVideoFormat.IPHONE);
  //		encodingProfile.setVideoCodec(EncodingProfileVideoCodec.LIBX264);
  //
  //		encodingProfileVideoBitrates = new ArrayList<EncodingProfileVideoBitrate>();
  //		encodingProfileVideoBitrates.add(EncodingProfileVideoBitrate.B_512);
  //		encodingProfileVideoBitrates.add(EncodingProfileVideoBitrate.B_1024);
  //
  //		encodingProfile.setVideoBitrates(encodingProfileVideoBitrates);
  //
  //		encodingProfileVideoSizes = new ArrayList<EncodingProfileVideoSize>();
  //
  //		encodingProfileVideoSize = new EncodingProfileVideoSize();
  //		encodingProfileVideoSize.setWidth(320);
  //		encodingProfileVideoSize.setHeight(240);
  //		encodingProfileVideoSizes.add(encodingProfileVideoSize);
  //		encodingProfileVideoSize = new EncodingProfileVideoSize();
  //		encodingProfileVideoSize.setWidth(368);
  //		encodingProfileVideoSize.setHeight(192);
  //		encodingProfileVideoSizes.add(encodingProfileVideoSize);
  //		encodingProfileVideoSize = new EncodingProfileVideoSize();
  //		encodingProfileVideoSize.setWidth(1024);
  //		encodingProfileVideoSize.setHeight(768);
  //		encodingProfileVideoSizes.add(encodingProfileVideoSize);
  //		encodingProfile.setVideoSizes(encodingProfileVideoSizes);
  //		encoding_profiles.add(encodingProfile);
  //
  //		userPreference.setEncoding_profiles(encoding_profiles);
  //
  //		ObjectMapper mapper = new ObjectMapper();
  //		JsonFactory f = new JsonFactory();
  //		JsonGenerator g = f.createJsonGenerator(folder.newFile("temp.json"), JsonEncoding.UTF8);
  //		mapper.writeValue(g, userPreference);
  //		g.close(); // important: will force flushing of output, close underlying output stream
  //
  //		File tempJsonFile = new File(folder.getRoot().getAbsolutePath() + "/temp.json");
  //		File jsonFile = new
  // File(getClass().getResource(USER_PREFERENCE_TOBE_FROM_WIKI_JSON).getFile());
  //
  //		String actualValue = FileUtils.readFileToString(tempJsonFile);
  //		String expectedValue = FileUtils.readFileToString(jsonFile).replaceAll("\\s+", "");
  //
  //		assertEquals("compare with generated json and fixture json", expectedValue, actualValue);
  //
  //		UserPreference loaedUserPreference =
  //			mapper.readValue(tempJsonFile, UserPreference.class);
  //
  //		assertReflectionEquals(userPreference, loaedUserPreference);
  //	}
}
