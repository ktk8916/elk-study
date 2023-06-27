package com.study.elk.search;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class SearchController {

    private final SearchService searchService;
    @GetMapping("/search")
    public List<Map<String, Object>> findByKeyword(
            @RequestParam String index,
            @RequestParam String field,
            @RequestParam String keyword){
        return searchService.findByKeyword(index, field, keyword);
    }
}
