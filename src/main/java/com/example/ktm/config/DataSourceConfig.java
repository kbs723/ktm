package com.example.ktm.config;

import com.example.ktm.enummisc.Types;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
// configure data sources -> route them based on the local thread
public class DataSourceConfig {

    @Bean
    @ConfigurationProperties("spring.datasource.primary")
    public DataSource primaryDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    @ConfigurationProperties("spring.datasource.replica")
    public DataSource replicaDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    @Primary
    // @Primary, make the entire app use this proxy instead of the real connections configured in yml
    public DataSource routingDataSource(@Qualifier("primaryDataSource") DataSource primaryDataSource,
                                        @Qualifier("replicaDataSource") DataSource replicaDataSource) {

        RoutingDataSource rds = new RoutingDataSource();

        Map<Object, Object> ds = new HashMap<>();
        ds.put(Types.DataSourceType.PRIMARY, primaryDataSource);
        ds.put(Types.DataSourceType.REPLICA, replicaDataSource);

        rds.setTargetDataSources(ds);
        rds.setDefaultTargetDataSource(primaryDataSource);

        return rds;
    }
}