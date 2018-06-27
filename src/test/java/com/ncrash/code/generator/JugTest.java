package com.ncrash.code.generator;

import org.junit.Before;
import org.junit.Test;

public class JugTest {

  @Before
  public void setUp() throws Exception {}

  @Test
  public void generateRandomBasedUUID() {
    System.out.println(org.safehaus.uuid.UUIDGenerator.getInstance().generateRandomBasedUUID());
    System.out.println(
        org.safehaus.uuid.UUIDGenerator.getInstance().getRandomNumberGenerator().nextInt());
  }
}
