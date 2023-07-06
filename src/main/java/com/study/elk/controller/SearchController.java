package com.study.elk.controller;

import com.study.elk.dto.MatchQueryDto;
import com.study.elk.dto.SearchResponseDto;
import com.study.elk.service.SearchService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
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

        log.info("search_keyword : " + keyword);

        SearchResponseDto responseDto = searchService.findByKeyword(
                //일단 고정으로 박아두기..
                new MatchQueryDto(
                        "petitions*",
                        "title",
                        keyword));

        List<String> popularKeyword = searchService.findPopularKeyword();

        mav.addObject("popularKeyword", popularKeyword);
        mav.addObject("result", responseDto);
        mav.setViewName("search");
        return mav;
    }
}
