package com.study.elk.search.service;

import com.study.elk.search.dto.MatchQueryDto;
import com.study.elk.elasticsearch.ElasticsearchTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class SearchService {

    private final ElasticsearchTemplate elasticsearchTemplate;

    public List<Map<String, Object>> findByKeyword(
            String index,
            String field,
            String keyword) {

        return elasticsearchTemplate.findByKeyword(new MatchQueryDto(index, field, keyword));
    }
}

