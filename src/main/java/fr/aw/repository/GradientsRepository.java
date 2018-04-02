package fr.aw.repository;

import fr.aw.model.cassandra.gradients.GradientMessage;
import fr.aw.model.cassandra.gradients.GradientMessageKey;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by julian on 01/04/18.
 */
@Repository
public interface GradientsRepository extends CassandraRepository<GradientMessage, GradientMessageKey> {

    List<GradientMessage> findByKeyKey(final String key);

}