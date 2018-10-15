package com.dzone.decorator_design_pattern_in_java;

/**
 * programming-note
 * Created by daekwon.kang@gmail.com on 16/10/2018
 * Blog : http://ncrash.github.io/
 * Github : http://github.com/ncrash
 */
public class LineStyleDecorator extends ShapeDecorator {
  protected LineStyle style;

  public LineStyleDecorator(Shape decoratedShape, LineStyle style) {
    super(decoratedShape);
    this.style = style;
  }

  @Override
  public void draw() {
    decoratedShape.draw();
    System.out.println("Line Style: " + style);
  }

  @Override
  public void resize() {
    decoratedShape.resize();
  }

  @Override
  public String description() {
    return decoratedShape.description() + " drawn with " + style + " lines.";
  }

  @Override
  public boolean isHide() {
    return decoratedShape.isHide();
  }
}
