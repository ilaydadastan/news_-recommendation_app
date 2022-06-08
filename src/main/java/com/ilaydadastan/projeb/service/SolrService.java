package com.ilaydadastan.projeb.service;

import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.springframework.stereotype.Service;

@Service
public class SolrService {
    public HttpSolrClient getConnection(){
        final String solrUrl = "http://localhost:8983/solr";
        return new HttpSolrClient.Builder(solrUrl)
                .withConnectionTimeout(10000)
                .withSocketTimeout(60000)
                .build();

    }
}
