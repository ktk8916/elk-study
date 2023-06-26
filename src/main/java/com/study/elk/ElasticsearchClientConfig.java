package com.study.elk;

import co.elastic.clients.json.jackson.JacksonJsonpMapper;
import co.elastic.clients.transport.ElasticsearchTransport;
import co.elastic.clients.transport.rest_client.RestClientTransport;
import org.apache.http.HttpHost;
import org.elasticsearch.client.ElasticsearchClient;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;

public class ElasticsearchClientConfig {

    public static RestHighLevelClient getElasticsearchClient(){

        final String HOST_NAME = "localhost";
        final int PORT = 9200;
        final String SCHEMA = "http";

        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(new HttpHost(HOST_NAME, PORT, SCHEMA)));

        return client;
    }
}
