package com.ncrash.code.model.enumeration;

/**
 * AdvReport Code.java
 *
 * @author NCrash
 * @category 24/7adcenter
 * @since 2009.07.20
 */
public enum DayOfWeek {
  Sunday("1"),
  Monday("2"),
  Tuesday("3"),
  Wednesday("4"),
  Thursday("5"),
  Friday("6"),
  Saturday("7");

  private final String value;

  DayOfWeek(String v) {
    this.value = v;
  }

  public String value() {
    return this.value;
  }

  public static DayOfWeek fromValue(String v) {
    for (DayOfWeek c : DayOfWeek.values()) {
      if (c.value.equals(v)) {
        return c;
      }
    }
    throw new IllegalArgumentException(v);
  }
}
