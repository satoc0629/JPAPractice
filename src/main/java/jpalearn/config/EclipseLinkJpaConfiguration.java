package jpalearn.config;

import org.eclipse.persistence.config.PersistenceUnitProperties;
import org.eclipse.persistence.config.ProfilerType;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.autoconfigure.orm.jpa.JpaBaseConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.vendor.AbstractJpaVendorAdapter;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.EclipseLinkJpaVendorAdapter;
import org.springframework.transaction.jta.JtaTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableJpaRepositories("jpalearn.repository")
public class EclipseLinkJpaConfiguration extends JpaBaseConfiguration {

    protected EclipseLinkJpaConfiguration(DataSource dataSource, JpaProperties properties, ObjectProvider<JtaTransactionManager> jtaTransactionManager) {
        super(dataSource, properties, jtaTransactionManager);
    }

    @Override
    protected String[] getPackagesToScan() {
        return new String[]{"jpalearn.entity"};
    }

    @Override
    protected AbstractJpaVendorAdapter createJpaVendorAdapter() {
        return new EclipseLinkJpaVendorAdapter();
    }

    @Override
    protected Map<String, Object> getVendorProperties() {
        HashMap<String, Object> jpaProperties = new HashMap<>();
        jpaProperties.put("eclipselink.ddl-generation", "none");
        jpaProperties.put("eclipselink.session.customizer", CamelCaseSessionCustomizer.class.getName());
        jpaProperties.put("eclipselink.temporal.mutable", "true");
        jpaProperties.put("eclipselink.cache.shared.default", "false");
        jpaProperties.put("eclipselink.query-results-cache", "false");
        jpaProperties.put("eclipselink.target-database", "PostgreSQL");
        jpaProperties.put(PersistenceUnitProperties.WEAVING, "true");

        jpaProperties.put("eclipselink.logging.level.sql", "FINE");
        jpaProperties.put(PersistenceUnitProperties.LOGGING_PARAMETERS, "true");
        jpaProperties.put(PersistenceUnitProperties.PROFILER, ProfilerType.PerformanceMonitor);

        return jpaProperties;
    }

    @Bean
    public JpaVendorAdapter jpaVendorAdapter() {
        EclipseLinkJpaVendorAdapter vendorAdapter = new EclipseLinkJpaVendorAdapter();
        vendorAdapter.setDatabase(Database.POSTGRESQL);
        return vendorAdapter;
    }
}