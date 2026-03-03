package com.example.ktm.tenant;

import com.example.ktm.enummisc.Types;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.transaction.support.TransactionSynchronizationManager;

// Every time a DB connection is needed, it calls determineCurrentLookupKey() and uses that key to pick the real DataSource
public class RoutingDataSource extends AbstractRoutingDataSource {

    @Override
    // returns PRIMARY or REPLICA
    protected Object determineCurrentLookupKey() {

        String tenant = TenantContext.get();
        boolean readOnly = TransactionSynchronizationManager.isCurrentTransactionReadOnly();

        if (tenant == null) {
            return null;
        }

        return tenant + (readOnly ? Types.DataSourceType._REPLICA : Types.DataSourceType._PRIMARY);
    }
}
