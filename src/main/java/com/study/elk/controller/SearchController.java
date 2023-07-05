package com.study.elk.controller;

import com.study.elk.dto.MatchQueryDto;
import com.study.elk.dto.SearchResponseDto;
import com.study.elk.service.SearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
public class SearchController {
    private final SearchService searchService;

    @GetMapping("/main")
    public String home(){
        return "main";
    }

    @GetMapping("/search")
    public ModelAndView search(
        @ModelAttribute ModelAndView mav,
        @RequestParam(required = false) String keyword
    ){

        SearchResponseDto responseDto = searchService.findByKeyword(
                //일단 고정으로 박아두기..
                new MatchQueryDto(
                        "petitions*",
                        "title",
                        keyword));

        mav.addObject("result", responseDto);
        mav.setViewName("search");
        return mav;
    }
}
