package com.study.elk.utility.elasticsearch;

import com.study.elk.search.dto.MatchQueryDto;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class ElasticsearchTemplate {
    public List<Map<String, Object>> findByKeyword(MatchQueryDto dto){

        List<Map<String, Object>> resultList = new ArrayList<>();

        SearchRequest searchRequest = new SearchRequest(dto.getIndex());
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        sourceBuilder.query(
                QueryBuilders.matchQuery(
                        dto.getField(),
                        dto.getKeyword()
                )
        );
        searchRequest.source(sourceBuilder);

        SearchResponse searchResponse = execute(searchRequest);

        SearchHits hits = searchResponse.getHits();

        for (SearchHit hit : hits) {
            Map<String, Object> sourceMap = hit.getSourceAsMap();
            resultList.add(sourceMap);
        }

        return resultList;
    }

    public SearchResponse execute(SearchRequest searchRequest){

        SearchResponse searchResponse = null;

        try (RestHighLevelClient elasticsearchClient = ElasticsearchClientConfig.getElasticsearchClient()){

            searchResponse = elasticsearchClient.search(searchRequest, RequestOptions.DEFAULT);


        } catch (IOException e) {
            e.printStackTrace();
        }

        return searchResponse;
    }
}
