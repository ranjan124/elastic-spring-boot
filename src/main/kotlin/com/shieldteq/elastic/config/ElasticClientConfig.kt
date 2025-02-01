//package com.shieldteq.elastic.config
//
//import org.springframework.context.annotation.Configuration
//import org.springframework.data.elasticsearch.client.ClientConfiguration
//import org.springframework.data.elasticsearch.client.elc.ElasticsearchConfiguration
//import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories
//
//@EnableElasticsearchRepositories(
//    basePackages = ["com.shieldteq.elastic.repository", "org.springframework.data.elasticsearch.repository"]
//)
//@Configuration
//class ElasticClientConfig : ElasticsearchConfiguration() {
//    override fun clientConfiguration(): ClientConfiguration {
//        return ClientConfiguration.builder()
//            .connectedTo("localhost:9200")
//            .usingSsl()
//            .withBasicAuth("elastic", "secret123")
//            .build()
//    }
//}