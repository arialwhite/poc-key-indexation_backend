package fr.aw.model.kafka.gradients;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by julian on 01/04/18.
 */
public class Gradients {

    private String color = "";
    private List<String> styles = new ArrayList<>();

    public Gradients() {
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public List<String> getStyles() {
        return styles;
    }

    public void setStyles(List<String> styles) {
        this.styles = styles;
    }
}
