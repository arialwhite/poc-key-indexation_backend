package fr.aw.model.cassandra.gradients;

import static org.springframework.data.cassandra.core.cql.PrimaryKeyType.PARTITIONED;

import org.springframework.data.cassandra.core.mapping.PrimaryKeyClass;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;

import java.io.Serializable;

/**
 * Created by julian on 01/04/18.
 */
@PrimaryKeyClass
public class GradientMessageKey implements Serializable {

    @PrimaryKeyColumn(name = "key", type = PARTITIONED)
    private String key;

    @PrimaryKeyColumn(name = "partition", type = PARTITIONED)
    private Integer partition;

    @PrimaryKeyColumn(name = "offset", type = PARTITIONED)
    private Double offset;

    public GradientMessageKey(String key, Double offset, Integer partition) {
        this.key = key;
        this.offset = offset;
        this.partition = partition;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Double getOffset() {
        return offset;
    }

    public void setOffset(Double offset) {
        this.offset = offset;
    }

    public Integer getPartition() {
        return partition;
    }

    public void setPartition(Integer partition) {
        this.partition = partition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GradientMessageKey)) return false;

        GradientMessageKey that = (GradientMessageKey) o;

        if (key != null ? !key.equals(that.key) : that.key != null) return false;
        if (offset != null ? !offset.equals(that.offset) : that.offset != null) return false;
        return partition != null ? partition.equals(that.partition) : that.partition == null;
    }

    @Override
    public int hashCode() {
        int result = key != null ? key.hashCode() : 0;
        result = 31 * result + (offset != null ? offset.hashCode() : 0);
        result = 31 * result + (partition != null ? partition.hashCode() : 0);
        return result;
    }
}
