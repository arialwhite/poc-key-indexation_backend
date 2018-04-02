package fr.aw;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.config.SchemaAction;
import org.springframework.data.cassandra.core.cql.keyspace.CreateKeyspaceSpecification;
import org.springframework.data.cassandra.core.cql.keyspace.KeyspaceOption;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

import java.util.Collections;
import java.util.List;

/**
 * Created by julian on 01/04/18.
 */
@Configuration
@EnableCassandraRepositories(
        basePackages = "fr.aw.repository"
)
public class CassandraConfig extends AbstractCassandraConfiguration {

    @Value("${CASSANDRA_CONTACTPOINTS:127.0.0.1}")
    private String contactPoints;

    @Value("${CASSANDRA_PORT:9042}")
    private int port;

    @Value("${CASSANDRA_KEYSPACE:kafka_topics}")
    private String keySpace;

    @Value("${cassandra.basepackages}")
    private String basePackages;

    @Override
    protected String getKeyspaceName() {
        return keySpace;
    }

    @Override
    protected String getContactPoints() {
        return contactPoints;
    }

    @Override
    protected int getPort() {
        return port;
    }

    @Override
    public SchemaAction getSchemaAction() {
        return SchemaAction.CREATE_IF_NOT_EXISTS;
    }

    @Override
    public String[] getEntityBasePackages() {
        return new String[] {basePackages};
    }

    @Override
    protected List<CreateKeyspaceSpecification> getKeyspaceCreations() {
        return Collections.singletonList(CreateKeyspaceSpecification.createKeyspace(keySpace)
                .ifNotExists()
                .with(KeyspaceOption.DURABLE_WRITES, true)
                .withSimpleReplication());
    }
}
