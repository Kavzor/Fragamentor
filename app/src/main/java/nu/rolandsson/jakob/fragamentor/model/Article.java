package nu.rolandsson.jakob.fragamentor.model;

/**
 * Created by Martin on 2018-04-19.
 */

public class Article extends Text {
    private String translation;

    public Article(String text, String translation) {
        super(text);
        this.translation = translation;
    }

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }
}
