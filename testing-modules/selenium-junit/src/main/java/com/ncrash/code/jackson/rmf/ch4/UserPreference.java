package com.ncrash.code.jackson.rmf.ch4;

import java.util.Collection;

public class UserPreference {

  public String userId = "";
  public String wmode = "";
  public String content = "";
  public String countondownload = "false";
  public String encoding_notify = "";
  public Collection<EncodingProfile> encoding_profiles;

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public String getWmode() {
    return wmode;
  }

  public void setWmode(String wmode) {
    this.wmode = wmode;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public String getCountondownload() {
    return countondownload;
  }

  public void setCountondownload(String countondownload) {
    this.countondownload = countondownload;
  }

  public String getEncoding_notify() {
    return encoding_notify;
  }

  public void setEncoding_notify(String encoding_notify) {
    this.encoding_notify = encoding_notify;
  }

  public Collection<EncodingProfile> getEncoding_profiles() {
    return encoding_profiles;
  }

  public void setEncoding_profiles(Collection<EncodingProfile> encoding_profiles) {
    this.encoding_profiles = encoding_profiles;
  }
}
