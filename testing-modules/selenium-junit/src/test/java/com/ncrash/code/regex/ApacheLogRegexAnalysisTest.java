package com.ncrash.code.regex;

import static org.junit.Assert.assertEquals;

import java.io.File;
import org.junit.Before;
import org.junit.Test;

public class ApacheLogRegexAnalysisTest {
  private File accessLogFile;

  @Before
  public void setUp() throws Exception {
    accessLogFile = new File(getClass().getResource("access_log").getFile());
  }

  @Test
  public void testSimpleApacheLog() throws Exception {
    String txt = "127.0.0.1 - - [25/Aug/2010:15:40:26 +0900] \"GET /favicon.ico HTTP/1.1\" 404 209";

    ApacheLog apacheLog = new ApacheLog(txt);
    //		assertTrue(m.find());
    assertEquals("127.0.0.1", apacheLog.getIpAddress());
    assertEquals("-", apacheLog.getUnknowField1());
    assertEquals("-", apacheLog.getUnknowField2());
    assertEquals("25/Aug/2010:15:40:26 +0900", apacheLog.getAccessDate());
    assertEquals("GET /favicon.ico HTTP/1.1", apacheLog.getMethodAndUrl());
    assertEquals("404", apacheLog.getReturnCode());
    assertEquals("209", apacheLog.getResponseBytes());
  }

  @Test
  public void testAccessLogFile() throws Exception {
    // TODO 시간이 되면 파일을 읽어서 테스트 완성해보기
  }
}
