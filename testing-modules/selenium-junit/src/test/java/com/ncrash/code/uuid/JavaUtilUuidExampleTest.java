package com.ncrash.code.uuid;

import static org.junit.Assert.*;

import java.util.UUID;

/**
 * @author daekwon.kang
 * @since 2010. 12. 7.
 * @see
 */
public class JavaUtilUuidExampleTest {

  public static void main(String[] args) {
    //
    // Creating a random UUID (Universally unique identifier).
    //
    UUID uuid1 = UUID.randomUUID();
    String randomUUIDString1 = uuid1.toString();

    UUID uuid2 = UUID.randomUUID();
    String randomUUIDString2 = uuid2.toString();

    assertNotSame(randomUUIDString1, randomUUIDString2);
    assertEquals(uuid1.version(), uuid2.version());
    assertEquals(uuid1.variant(), uuid2.variant());
  }
}
