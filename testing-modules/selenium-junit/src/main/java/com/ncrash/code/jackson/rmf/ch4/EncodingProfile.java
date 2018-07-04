package com.ncrash.code.jackson.rmf.ch4;

import java.util.Collection;

public class EncodingProfile {

  public String profileName;
  public EncodingProfileVideoFormat videoFormat;
  public EncodingProfileVideoCodec videoCodec;
  public Collection<EncodingProfileVideoBitrate> videoBitrates;
  public Collection<EncodingProfileVideoSize> videoSizes;

  public String getProfileName() {
    return profileName;
  }

  public void setProfileName(String profileName) {
    this.profileName = profileName;
  }

  public EncodingProfileVideoFormat getVideoFormat() {
    return videoFormat;
  }

  public void setVideoFormat(EncodingProfileVideoFormat videoFormat) {
    this.videoFormat = videoFormat;
  }

  public EncodingProfileVideoCodec getVideoCodec() {
    return videoCodec;
  }

  public void setVideoCodec(EncodingProfileVideoCodec videoCodec) {
    this.videoCodec = videoCodec;
  }

  public Collection<EncodingProfileVideoBitrate> getVideoBitrates() {
    return videoBitrates;
  }

  public void setVideoBitrates(Collection<EncodingProfileVideoBitrate> videoBitrates) {
    this.videoBitrates = videoBitrates;
  }

  public Collection<EncodingProfileVideoSize> getVideoSizes() {
    return videoSizes;
  }

  public void setVideoSizes(Collection<EncodingProfileVideoSize> videoSizes) {
    this.videoSizes = videoSizes;
  }
}
