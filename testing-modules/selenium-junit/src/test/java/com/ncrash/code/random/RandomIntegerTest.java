package com.ncrash.code.random;

import java.util.Random;
import org.junit.Test;

/**
 * @author Korea R&D Team Daekwon.Kang
 *     <p>http://www.javapractices.com/topic/TopicAction.do?Id=62
 */
public class RandomIntegerTest {

  @Test
  public void randomInteger() throws Exception {
    // note a single Random object is reused here
    Random randomGenerator = new Random();
    for (int idx = 1; idx <= 10; ++idx) {
      int randomInt = randomGenerator.nextInt(100);

      log("idx(" + idx + ") : " + randomInt);
    }
  }

  @Test
  public void randomRange() throws Exception {
    int START = 10;
    int END = 20;
    Random random = new Random();
    for (int idx = 1; idx <= 10; ++idx) {
      showRandomInteger(START, END, random);
    }

    log("Done.");
  }

  private void showRandomInteger(int aStart, int aEnd, Random aRandom) {
    if (aStart > aEnd) {
      throw new IllegalArgumentException("Start cannot exceed End.");
    }
    // get the range, casting to long to avoid overflow problems
    long range = (long) aEnd - (long) aStart + 1;
    // compute a fraction of the range, 0 <= frac < range
    long fraction = (long) (range * aRandom.nextDouble());
    int randomNumber = (int) (fraction + aStart);
    log("Generated : " + randomNumber);
  }

  @Test
  public void randomGaussian() throws Exception {
    RandomGaussian gaussian = new RandomGaussian();
    double MEAN = 100.0f;
    double VARIANCE = 5.0f;
    for (int idx = 1; idx <= 10; ++idx) {
      log("Generated : " + gaussian.getGaussian(MEAN, VARIANCE));
    }
  }

  private static void log(Object aMsg) {
    System.out.println(String.valueOf(aMsg));
  }
}
