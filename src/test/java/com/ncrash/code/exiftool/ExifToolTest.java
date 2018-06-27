package com.ncrash.code.exiftool;

import static org.junit.Assert.*;
import static org.junit.Assert.assertNotNull;

import com.thebuzzmedia.exiftool.ExifTool;
import com.thebuzzmedia.exiftool.ExifTool.Tag;
import java.io.File;
import java.util.Map;
import org.junit.Test;

/*
 * need to install exiftool
 * http://www.sno.phy.queensu.ca/~phil/exiftool/index.html
 */
public class ExifToolTest {
  @Test
  public void exifSimple() throws Exception {

    File image = new File(getClass().getResource("jabra.jpg").getFile());
    assertNotNull(image);

    ExifTool tool = new ExifTool();

    Map<Tag, String> valueMap = tool.getImageMeta(image, Tag.GPS_LATITUDE, Tag.GPS_LONGITUDE);

    assertEquals("Lat", "37.5011666666667", valueMap.get(Tag.GPS_LATITUDE));
    assertEquals("Long", "127.009", valueMap.get(Tag.GPS_LONGITUDE));
  }
}
