package com.study.elk.search;

import com.study.elk.utility.elasticsearch.ElasticsearchClientConfig;
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
public class SearchService {

    //검색 시 10개밖에 안나오는 문제 해결.. scroll..
    public List<Map<String, Object>> findAll() {

        List<Map<String, Object>> resultList = new ArrayList<>();

        try (RestHighLevelClient elasticsearchClient = ElasticsearchClientConfig.getElasticsearchClient()){

            SearchRequest searchRequest = new SearchRequest("shakespeare");
            SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
            sourceBuilder.query(QueryBuilders.matchAllQuery());

            searchRequest.source(sourceBuilder);

            SearchResponse searchResponse = elasticsearchClient.search(searchRequest, RequestOptions.DEFAULT);

            SearchHits hits = searchResponse.getHits();

            for (SearchHit hit : hits) {
                Map<String, Object> sourceMap = hit.getSourceAsMap();
                resultList.add(sourceMap);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return resultList;
    }

    public List<Map<String, Object>> findByKeyword(String keyword) {

        List<Map<String, Object>> resultList = new ArrayList<>();

        try (RestHighLevelClient elasticsearchClient = ElasticsearchClientConfig.getElasticsearchClient()){

            SearchRequest searchRequest = new SearchRequest("shakespeare");
            SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
            sourceBuilder.query(QueryBuilders.matchQuery("text_entry", keyword));

            searchRequest.source(sourceBuilder);

            SearchResponse searchResponse = elasticsearchClient.search(searchRequest, RequestOptions.DEFAULT);

            SearchHits hits = searchResponse.getHits();

            for (SearchHit hit : hits) {
                Map<String, Object> sourceMap = hit.getSourceAsMap();
                resultList.add(sourceMap);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return resultList;
    }
}

