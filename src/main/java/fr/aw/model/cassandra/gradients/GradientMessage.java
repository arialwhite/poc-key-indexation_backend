package fr.aw.model.cassandra.gradients;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

/**
 * A gradient message stored in Cassandra
 * Created by julian on 01/04/18.
 */
@Table("small_topic")
public class GradientMessage {

    @PrimaryKey
    private GradientMessageKey key;

    @Column("value")
    private String value;

    public GradientMessage(GradientMessageKey key, String value) {
        this.key = key;
        this.value = value;
    }

    public GradientMessageKey getKey() {
        return key;
    }

    public void setKey(GradientMessageKey key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
