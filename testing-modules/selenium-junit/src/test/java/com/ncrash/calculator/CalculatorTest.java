package com.ncrash.calculator;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @author daekwon.kang
 * @since 2010. 7. 7.
 * @see
 */
public class CalculatorTest {

  private Calculator calc;

  @Before
  public void before() {
    calc = new Calculatorimpl();
  }

  @Test
  public void testAdd() throws Exception {
    assertNotNull("calc is null", calc);
    assertEquals(101, calc.add(23, 78));

    try {
      calc.add(Integer.MAX_VALUE, 100);
      fail(OverflowException.class.getName() + " is excepted");
    } catch (OverflowException e) {

    }

    try {
      calc.add(Integer.MIN_VALUE, -1);
      fail(UnderflowException.class.getName() + " is excepted");
    } catch (UnderflowException e) {

    }
  }

  @Test
  public void testSub() throws Exception {
    assertNotNull("calc is null", calc);
    assertEquals(10, calc.sub(20, 10));

    try {
      calc.sub(Integer.MIN_VALUE, 100);
      fail(UnderflowException.class.getName() + " is excepted");
    } catch (UnderflowException e) {

    }

    try {
      calc.sub(Integer.MAX_VALUE, -10);
      fail(OverflowException.class.getName() + " is excepted");
    } catch (OverflowException e) {

    }
  }
}
