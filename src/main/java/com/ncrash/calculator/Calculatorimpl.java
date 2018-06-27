package com.ncrash.calculator;

/**
 * @author daekwon.kang
 * @since 2010. 7. 7.
 * @see
 */
public class Calculatorimpl implements Calculator {

  public int add(int i, int j) {
    long a = i;
    long b = j;
    long result = a + b;

    return CheckAndReturn(result);
  }

  private int CheckAndReturn(long result) {
    if (result > Integer.MAX_VALUE) {
      throw new OverflowException();
    }
    if (result < Integer.MIN_VALUE) {
      throw new UnderflowException();
    }

    return (int) result;
  }

  public int sub(int i, int j) {
    long a = i;
    long b = j;
    long result = a - b;

    return CheckAndReturn(result);
  }
}
