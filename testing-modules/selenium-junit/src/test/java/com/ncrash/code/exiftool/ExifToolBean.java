package com.ncrash.code.exiftool;

import java.io.Serializable;

public class ExifToolBean implements Serializable {

  /** */
  private static final long serialVersionUID = 1L;

  private String exifToolVersion;

  public String getExifToolVersion() {
    return exifToolVersion;
  }

  public void setExifToolVersion(String exifToolVersion) {
    this.exifToolVersion = exifToolVersion;
  }
}
