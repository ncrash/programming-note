package pupustory.log4j.gettingstart;

import org.apache.log4j.*;

public class StartApp_UseProperties {
  static Logger logger = Logger.getLogger(StartApp_UseProperties.class);

  public static void main(String arg[]) {
    // 로그를 계속 쌓아두기 위해 MAX_COUNT값을 정의 함.
    final int MAX_COUNT = 10;
    for (int i = 0; i < MAX_COUNT; i++) {
      // 각각의 레벨에 맞춰 로그를 남김
      logger.debug("debug 로그");
      logger.info("info 로그");
      logger.warn("warn 로그");
      logger.error("error 로그");
      logger.fatal("fatal 로그");
    }
  }
}
