package com.example.ktm.config;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

// Every time a DB connection is needed, it calls determineCurrentLookupKey() and uses that key to pick the real DataSource
public class RoutingDataSource extends AbstractRoutingDataSource {

    @Override
    // returns PRIMARY or REPLICA
    protected Object determineCurrentLookupKey() {
        return DataSourceContextHolder.get();
    }
}
