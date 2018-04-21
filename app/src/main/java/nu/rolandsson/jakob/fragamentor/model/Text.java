package nu.rolandsson.jakob.fragamentor.model;

import java.io.Serializable;

/**
 * Created by Martin on 2018-04-19.
 */

public abstract class Text implements Serializable {
    private String text;

    public Text(String text) {
        this.text = text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
