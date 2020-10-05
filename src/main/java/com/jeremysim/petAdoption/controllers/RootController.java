package com.jeremysim.petAdoption.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class RootController {

  @GetMapping
  public ModelAndView redirect() {
    return new ModelAndView("redirect:/pets");
  }

}
