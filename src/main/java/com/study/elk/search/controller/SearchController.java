package com.study.elk.search.controller;

import com.study.elk.search.service.SearchService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@Slf4j
public class SearchController {

    //private Logger loggerFactory = LoggerFactory.getLogger(SearchController.class);

    private final SearchService searchService;
    @GetMapping("/search")
    public List<Map<String, Object>> findByKeyword(
            @RequestParam String index,
            @RequestParam String field,
            @RequestParam String keyword){

        log.info("findByKeyword - " + " index : " + index + ", field : " + field  + ", keyword : " + keyword);

        return searchService.findByKeyword(index, field, keyword);
    }
}
