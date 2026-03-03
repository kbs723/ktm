package com.example.ktm.tenant;

import com.example.ktm.enummisc.Types;
import com.example.ktm.opsunitconfig.entity.OpsUnitConfig;
import com.example.ktm.opsunitconfig.repo.OpsUnitDbConfigRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.example.ktm.constants.AppConst.JDBC_DRIVER_CLASS;
import static com.example.ktm.constants.AppConst.REPLICA_NOT_CONFIG;

@Configuration
@RequiredArgsConstructor
// configure data sources -> route them based on the local thread
public class TenantDSConfig {

    private final OpsUnitDbConfigRepository repository;
    private static final Logger log = LoggerFactory.getLogger(TenantDSConfig.class);

    @Bean
    @Primary
    // @Primary, make the entire app use this proxy instead of the real connections configured in yml
    public DataSource tenantDataSource() {

        Map<Object, Object> targetDataSources = new HashMap<>();

        List<OpsUnitConfig> configs = repository.findByActiveTrue();

        for (OpsUnitConfig config : configs) {

            // Primary database
            DataSource primary = DataSourceBuilder.create()
                    .url(config.getPrimaryUrl())
                    .username(config.getPrimaryUsername())
                    .password(config.getPrimaryPassword())
                    .driverClassName(JDBC_DRIVER_CLASS)
                    .build();

            targetDataSources.put(config.getOpsUnitCode() + Types.DataSourceType._PRIMARY, primary);

            // Replica database
            DataSource replica;

            if (config.getReplicaUrl() != null && !config.getReplicaUrl().isBlank()) {

                replica = DataSourceBuilder.create()
                        .url(config.getReplicaUrl())
                        .username(config.getReplicaUsername())
                        .password(config.getReplicaPassword())
                        .driverClassName(JDBC_DRIVER_CLASS)
                        .build();

            } else {
                // fallback
                log.warn(REPLICA_NOT_CONFIG, config.getOpsUnitCode());
                replica = primary;
            }

            targetDataSources.put(config.getOpsUnitCode() + Types.DataSourceType._REPLICA, replica);
        }

        RoutingDataSource routingDataSource = new RoutingDataSource();
        routingDataSource.setTargetDataSources(targetDataSources);
        routingDataSource.setDefaultTargetDataSource(targetDataSources.values().iterator().next());
        routingDataSource.afterPropertiesSet();

        return routingDataSource;
    }
}
