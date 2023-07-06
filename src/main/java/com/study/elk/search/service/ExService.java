package com.study.elk.search.service;

import com.study.elk.search.dto.ExDto;
import com.study.elk.elasticsearch.ElasticsearchTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ExService {

    private final ElasticsearchTemplate elasticsearchTemplate;

//    public List<Map<String, Object>> findByKeyword(
//            String index,
//            String field,
//            String keyword) {
//
//        return elasticsearchTemplate.findByKeyword(new ExDto(index, field, keyword));
//    }
}

