package com.study.elk.elasticsearch;

import com.study.elk.search.dto.MatchQueryDto;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.unit.Fuzziness;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.suggest.Suggest;
import org.elasticsearch.search.suggest.SuggestBuilder;
import org.elasticsearch.search.suggest.SuggestBuilders;
import org.elasticsearch.search.suggest.SuggestionBuilder;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class ElasticsearchTemplate {

    private SuggestBuilder getSuggestBuilder(MatchQueryDto dto) {

        SuggestionBuilder<?> suggestionBuilder = SuggestBuilders
                .phraseSuggestion(dto.getField())
                .text(dto.getKeyword())
                .maxErrors(5)
                .gramSize(3)
                .realWordErrorLikelihood(0.6f)
                .size(5);

        SuggestBuilder suggestBuilder = new SuggestBuilder().addSuggestion("keyword_suggestion", suggestionBuilder);

        return suggestBuilder;
    }
    public List<Map<String, Object>> findByKeyword(MatchQueryDto dto){

        List<Map<String, Object>> resultList = new ArrayList<>();

        SearchRequest searchRequest = new SearchRequest(dto.getIndex());
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        sourceBuilder.query(
                QueryBuilders.matchQuery(
                        dto.getField(),
                        dto.getKeyword()
                ).fuzziness(Fuzziness.AUTO));

        //sourceBuilder에 suggest 기능 추가하는 부분..
        sourceBuilder.suggest(getSuggestBuilder(dto));
        searchRequest.source(sourceBuilder);


        SearchResponse searchResponse = execute(searchRequest);
        Suggest suggest = searchResponse.getSuggest();
        System.out.println(suggest);

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
