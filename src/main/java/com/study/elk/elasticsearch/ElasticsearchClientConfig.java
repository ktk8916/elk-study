package com.study.elk.elasticsearch;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ElasticsearchClientConfig {

    public RestHighLevelClient getElasticsearchClient(){

        final String HOST_NAME = "localhost";
        final int PORT = 9200;
        final String SCHEMA = "http";

        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(new HttpHost(HOST_NAME, PORT, SCHEMA)));

        return client;
    }
}
