package com.study.elk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class findController {

    @GetMapping("/main")
    public String home(){
        return "main";
    }

    @GetMapping("/search")
    public ModelAndView search(
        @ModelAttribute ModelAndView mav,
        @RequestParam(required = false) String keyword
    ){
        mav.addObject("null");
        mav.setViewName("search");
        return mav;
    }
}
