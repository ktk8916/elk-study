package com.study.elk.elasticsearch;

import com.study.elk.dto.MatchQueryDto;
import com.study.elk.dto.SearchResponseDto;
import lombok.RequiredArgsConstructor;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.unit.Fuzziness;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.bucket.terms.Terms;
import org.elasticsearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.suggest.Suggest;
import org.elasticsearch.search.suggest.Suggest.Suggestion;
import org.elasticsearch.search.suggest.Suggest.Suggestion.Entry;
import org.elasticsearch.search.suggest.Suggest.Suggestion.Entry.Option;
import org.elasticsearch.search.suggest.SuggestBuilder;
import org.elasticsearch.search.suggest.SuggestBuilders;
import org.elasticsearch.search.suggest.SuggestionBuilder;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Repository
@RequiredArgsConstructor
public class ElasticsearchTemplate {

    private final ElasticsearchClientConfig elasticsearchClientConfig;
    private SuggestBuilder getSuggestBuilder(MatchQueryDto dto) {

        SuggestionBuilder<?> suggestionBuilder = SuggestBuilders
                .phraseSuggestion(dto.getField())
                .text(dto.getKeyword())
                .maxErrors(20)
                .gramSize(3)
                .realWordErrorLikelihood(0.2f)
                .size(5);

        SuggestBuilder suggestBuilder = new SuggestBuilder().addSuggestion("keyword_suggestion", suggestionBuilder);

        return suggestBuilder;
    }
    public List<String> findPopularKeyword(MatchQueryDto dto) {
        SearchRequest searchRequest = new SearchRequest(dto.getIndex());

        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();

        sourceBuilder.query(
                QueryBuilders.matchQuery(
                        dto.getField(),
                        dto.getKeyword()
                ));

        sourceBuilder.size(0);

        TermsAggregationBuilder aggregationBuilder = AggregationBuilders.terms("top_keywords")
                .field("search_keyword")
                .size(10);

        sourceBuilder.aggregation(aggregationBuilder);
        searchRequest.source(sourceBuilder);

        SearchResponse searchResponse = execute(searchRequest);

        Terms terms = searchResponse.getAggregations().get("top_keywords");
        List<String> resultList = new ArrayList<>();
        for (Terms.Bucket bucket : terms.getBuckets()) {
            String keyword = bucket.getKeyAsString();
            resultList.add(keyword);
        }

        return resultList;
    }
    public SearchResponseDto findByKeyword(MatchQueryDto dto){

        SearchRequest searchRequest = new SearchRequest(dto.getIndex());
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        sourceBuilder.query(
                QueryBuilders.matchQuery(
                        dto.getField(),
                        dto.getKeyword()
                ).fuzziness(Fuzziness.AUTO));

        //sourceBuilder에 suggest 기능 추가하는 부분..
        sourceBuilder.size(200);
        sourceBuilder.suggest(getSuggestBuilder(dto));
        searchRequest.source(sourceBuilder);

        SearchResponse searchResponse = execute(searchRequest);

        SearchHits hits = searchResponse.getHits();

        List<Map<String, Object>> resultList = new ArrayList<>();

        for (SearchHit hit : hits) {
            Map<String, Object> sourceMap = hit.getSourceAsMap();
            resultList.add(sourceMap);
        }

        Suggest suggest = searchResponse.getSuggest();
        //System.out.println(suggest);

        List<String> suggestList = convertSuggestToList(suggest);
        //System.out.println(suggestList);
//        List<String> suggestList = Arrays.asList("1111", "2222", "3333");

        return new SearchResponseDto(resultList, suggestList);
    }

    private SearchResponse execute(SearchRequest searchRequest){

        SearchResponse searchResponse = null;

        try (RestHighLevelClient elasticsearchClient = elasticsearchClientConfig.getElasticsearchClient()){

            searchResponse = elasticsearchClient.search(searchRequest, RequestOptions.DEFAULT);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return searchResponse;
    }

    private List<String> convertSuggestToList(Suggest suggest) {
        List<String> suggestList = new ArrayList<>();

        Suggestion<? extends Entry<? extends Option>> entries = suggest.getSuggestion("keyword_suggestion");

        for (Entry<?> entry : entries) {
            for (Option option : entry) {
                suggestList.add(option.getText().string());
            }
        }

        return suggestList;
    }
}
