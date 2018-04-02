package fr.aw.model.kafka.gradients;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by julian on 01/04/18.
 */
public class GradientData {

    private List<Gradients> gradients = new ArrayList<>();

    public GradientData() {
    }

    public List<Gradients> getGradients() {
        return gradients;
    }

    public void setGradients(List<Gradients> gradients) {
        this.gradients = gradients;
    }
}
