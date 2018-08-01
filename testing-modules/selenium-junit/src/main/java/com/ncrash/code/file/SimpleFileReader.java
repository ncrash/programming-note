package com.ncrash.code.file;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * SimpleFileReader.java
 *
 * @author 강대권
 * @since 2009. 11. 12.
 * @see
 */
public class SimpleFileReader {
  public static String fileRead(String fileName) {
    String line;
    StringBuffer sb = new StringBuffer();

    try {
      BufferedReader rdr = new BufferedReader(new FileReader(fileName));

      while ((line = rdr.readLine()) != null) {
        sb.append(line);
      }
    } catch (FileNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    return sb.toString();
  }
}
