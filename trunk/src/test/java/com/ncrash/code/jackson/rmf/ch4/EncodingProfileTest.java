package com.ncrash.code.jackson.rmf.ch4;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;


public class EncodingProfileTest {

	@Test
	public void objectValueSet() throws Exception {
		EncodingProfile encodingProfile = new EncodingProfile();
		
		encodingProfile.setProfileName("iPad(256)");
//		encodingProfile.setVideoFormat(EncodingProfileVideoFormat.IPHONE);
//		encodingProfile.setVideoCodec(EncodingProfileVideoCodec.LIBX264);
//		
//		List<EncodingProfileVideoBitrate> encodingProfileVideoBitrates = new ArrayList<EncodingProfileVideoBitrate>();
//		encodingProfileVideoBitrates.add(EncodingProfileVideoBitrate.B_256);
//		encodingProfileVideoBitrates.add(EncodingProfileVideoBitrate.B_512);
//		encodingProfileVideoBitrates.add(EncodingProfileVideoBitrate.B_1024);
//		
//		encodingProfile.setVideoBitrate(encodingProfileVideoBitrates);
//		
//		List<EncodingProfileVideoSize> encodingProfileVideoSizes = new ArrayList<EncodingProfileVideoSize>();
//		encodingProfileVideoSizes.add(new EncodingProfileVideoSize(320, 240));
//		encodingProfileVideoSizes.add(new EncodingProfileVideoSize(1024, 768));
//
//		encodingProfile.setVideoSize(encodingProfileVideoSizes);
	}
}
