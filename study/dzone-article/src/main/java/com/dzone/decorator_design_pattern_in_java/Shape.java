package com.dzone.decorator_design_pattern_in_java;

/**
 * programming-note
 * Created by daekwon.kang@gmail.com on 16/10/2018
 * Blog : http://ncrash.github.io/
 * Github : http://github.com/ncrash
 */
public interface Shape {
  void draw();
  void resize();
  String description();
  boolean isHide();
}
