package com.study.elk.Service;

import com.study.elk.dto.MatchQueryDto;
import com.study.elk.dto.SearchResponseDto;
import com.study.elk.elasticsearch.ElasticsearchTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class SearchService {

    private final ElasticsearchTemplate elasticsearchTemplate;

    public SearchResponseDto findByKeyword(MatchQueryDto dto){

        return elasticsearchTemplate.findByKeyword(dto);
    }

    public List<String> findPopularKeyword(){
        MatchQueryDto dto = new MatchQueryDto(
                "springlog",
                "logger_name",
                "com.study.elk.controller.SearchController");
        return elasticsearchTemplate.findPopularKeyword(dto);
    }

}
