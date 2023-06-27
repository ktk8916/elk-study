package com.study.elk.search;

import com.study.elk.search.dto.MatchQueryDto;
import com.study.elk.utility.elasticsearch.ElasticsearchClientConfig;
import com.study.elk.utility.elasticsearch.ElasticsearchTemplate;
import lombok.RequiredArgsConstructor;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
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

