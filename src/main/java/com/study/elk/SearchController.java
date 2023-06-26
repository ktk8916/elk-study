package com.study.elk;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class SearchController {

    private final SearchService searchService;

    @GetMapping("/search")
    public List<Map<String, Object>> findAll(){
        return searchService.findAll();
    }

    @GetMapping("/search/{keyword}")
    public List<Map<String, Object>> findByKeyword(@PathVariable String keyword){
        return searchService.findByKeyword(keyword);
    }
}
