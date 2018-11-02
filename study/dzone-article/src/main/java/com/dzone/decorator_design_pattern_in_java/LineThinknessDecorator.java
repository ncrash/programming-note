package com.dzone.decorator_design_pattern_in_java;

/**
 * programming-note
 * Created by daekwon.kang@gmail.com on 16/10/2018
 * Blog : http://ncrash.github.io/
 * Github : http://github.com/ncrash
 */
public class LineThinknessDecorator extends ShapeDecorator {
  protected double thickness;

  public LineThinknessDecorator(Shape decoratedShape, double thickness) {
    super(decoratedShape);
    this.thickness = thickness;
  }

  @Override
  public void draw() {
    decoratedShape.draw();
    System.out.println("Line thickness" + thickness);
  }

  @Override
  public void resize() {
    decoratedShape.resize();
  }

  @Override
  public String description() {
    return decoratedShape.description() + "drawn with line thickness " + thickness + ".";
  }

  @Override
  public boolean isHide() {
    return decoratedShape.isHide();
  }
}
