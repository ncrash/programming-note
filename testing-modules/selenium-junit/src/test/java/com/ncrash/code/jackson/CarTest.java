package com.ncrash.code.jackson;

import static org.junit.Assert.*;

import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * CarTest.java
 *
 * @author daekwon.kang
 * @since 2010. 2. 25.
 * @see
 */
public class CarTest {

  private static Validator validator;

  @BeforeClass
  public static void setUp() {
    ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    validator = factory.getValidator();
  }

  @Test
  public void testManufacturerIsNull() {
    Car car = new Car(null, "DD-AB-123");

    Set<ConstraintViolation<Car>> constraintViolations = validator.validate(car);

    assertEquals(1, constraintViolations.size());
    assertEquals("may not be null", constraintViolations.iterator().next().getMessage());
  }

  @Test
  public void testLicensePlateTooShort() {
    Car car = new Car("Morris", "D");

    Set<ConstraintViolation<Car>> constraintViolations = validator.validate(car);

    assertEquals(1, constraintViolations.size());
    assertEquals(
        "size must be between 2 and 14", constraintViolations.iterator().next().getMessage());
  }

  @Test
  public void testCarIsValid() {

    Car car = new Car("Audi", "DD-AB-123");

    Set<ConstraintViolation<Car>> constraintViolations = validator.validate(car);

    assertEquals(0, constraintViolations.size());
  }
}
