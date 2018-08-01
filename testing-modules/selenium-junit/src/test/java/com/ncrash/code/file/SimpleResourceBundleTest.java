package com.ncrash.code.file;

import static org.junit.Assert.assertEquals;

import java.util.ResourceBundle;
import org.junit.Test;

/**
 * SimpleResourceBundleTest.java
 *
 * @author ncrash
 * @since 2009. 12. 3.
 * @see SimpleResourceBundle
 */
public class SimpleResourceBundleTest {
  @Test
  public void verifyMessages() {
    ResourceBundle resourceBundle = null;

    resourceBundle = SimpleResourceBundle.greetingKorean();

    assertEquals("반가워!", resourceBundle.getString("hello"));
    assertEquals("좋은 아침!", resourceBundle.getString("hello.morning"));
    assertEquals("저녁은 뭇나?", resourceBundle.getString("hello.afternoon"));
    assertEquals("잘자라!!", resourceBundle.getString("hello.evening"));

    resourceBundle = SimpleResourceBundle.greetingEnglish();

    assertEquals("Hello!!", resourceBundle.getString("hello"));
    assertEquals("Good morning!", resourceBundle.getString("hello.morning"));
    assertEquals("Good Afternoon!", resourceBundle.getString("hello.afternoon"));
    assertEquals("Good evening!", resourceBundle.getString("hello.evening"));
  }
}
