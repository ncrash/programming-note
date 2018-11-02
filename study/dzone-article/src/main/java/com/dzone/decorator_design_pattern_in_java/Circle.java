package com.dzone.decorator_design_pattern_in_java;

/**
 * programming-note
 * Created by daekwon.kang@gmail.com on 16/10/2018
 * Blog : http://ncrash.github.io/
 * Github : http://github.com/ncrash
 */
public class Circle implements Shape {
  @Override
  public void draw() {
    System.out.println("Drawing Circle");
  }

  @Override
  public void resize() {
    System.out.println("Resizing Circle");
  }

  @Override
  public String description() {
    return "Circle object";
  }

  @Override
  public boolean isHide() {
    return false;
  }
}
