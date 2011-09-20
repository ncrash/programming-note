package com.ncrash.code.jackson.rmf.ch4;

import java.util.List;

public class EncodingProfile {

	private String profileName;
//	private EncodingProfileVideoFormat videoFormat;
//	private EncodingProfileVideoCodec videoCodec;
//	private List<EncodingProfileVideoBitrate> videoBitrate;
//	private List<EncodingProfileVideoSize> videoSize;
	
	public EncodingProfile() {
	}
	
	
//	public EncodingProfile(String profileName,
//			EncodingProfileVideoFormat videoFormat,
//			EncodingProfileVideoCodec videoCodec,
//			List<EncodingProfileVideoBitrate> videoBitrate,
//			List<EncodingProfileVideoSize> videoSize) {
//		super();
//		this.profileName = profileName;
//		this.videoFormat = videoFormat;
//		this.videoCodec = videoCodec;
//		this.videoBitrate = videoBitrate;
//		this.videoSize = videoSize;
//	}

	public EncodingProfile(String profileName) {
		super();
		this.profileName = profileName;
	}


	public String getProfileName() {
		return profileName;
	}

	public void setProfileName(String profileName) {
		this.profileName = profileName;
	}


	public String toString() {
		return "EncodingProfile [profileName=" + profileName + "]";
	}

//	public EncodingProfileVideoFormat getVideoFormat() {
//		return videoFormat;
//	}
//
//	public void setVideoFormat(EncodingProfileVideoFormat videoFormat) {
//		this.videoFormat = videoFormat;
//	}
//
//	public EncodingProfileVideoCodec getVideoCodec() {
//		return videoCodec;
//	}
//
//	public void setVideoCodec(EncodingProfileVideoCodec videoCodec) {
//		this.videoCodec = videoCodec;
//	}
//
//	public List<EncodingProfileVideoBitrate> getVideoBitrate() {
//		return videoBitrate;
//	}
//
//	public void setVideoBitrate(List<EncodingProfileVideoBitrate> videoBitrate) {
//		this.videoBitrate = videoBitrate;
//	}
//
//	public List<EncodingProfileVideoSize> getVideoSize() {
//		return videoSize;
//	}
//
//	public void setVideoSize(List<EncodingProfileVideoSize> videoSize) {
//		this.videoSize = videoSize;
//	}
//
//	@Override
//	public String toString() {
//		return "EncodingProfile [profileName=" + profileName + ", videoFormat="
//				+ videoFormat + ", videoCodec=" + videoCodec
//				+ ", videoBitrate=" + videoBitrate + ", videoSize=" + videoSize
//				+ "]";
//	}
}
