package com.ncrash.code.jackson.rmf.ch4;

public enum EncodingProfileVideoBitrate {
  B_256(256, "256"),
  B_512(512, "512"),
  B_1024(1024, "1024");

  private final int value;
  private final String desc;

  EncodingProfileVideoBitrate(int value, String desc) {
    this.value = value;
    this.desc = desc;
  }

  public int value() {
    return this.value;
  }

  public int getValue() {
    return value();
  }

  public String desc() {
    return this.desc + "Kbps";
  }

  public String getDesc() {
    return desc();
  }

  public static EncodingProfileVideoBitrate fromValue(int v) {
    for (EncodingProfileVideoBitrate encodingProfileVideoFormat :
        EncodingProfileVideoBitrate.values()) {
      if (encodingProfileVideoFormat.getValue() == v) {
        return encodingProfileVideoFormat;
      }
    }
    throw new IllegalArgumentException(v + "");
  }
}
