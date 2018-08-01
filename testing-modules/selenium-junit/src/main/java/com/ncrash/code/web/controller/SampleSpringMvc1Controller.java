package com.ncrash.code.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author daekwon.kang
 * @since 2011. 1. 12.
 * @see
 */
@Controller
public class SampleSpringMvc1Controller {
  @RequestMapping("/sample/view")
  public ModelAndView view() {
    return new ModelAndView("sample/view", "result", "HelloWorld!");
  }
}
