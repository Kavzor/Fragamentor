package nu.rolandsson.jakob.fragamentor.fragment;

import nu.rolandsson.jakob.fragamentor.model.Article;
import nu.rolandsson.jakob.fragamentor.model.Text;

/**
 * Created by Martin on 2018-04-19.
 */

public class TranslationFragment extends ArticleFragment {

    @Override
    protected  void setText(Text text) {
        Article article = (Article) text;
        setText(article.getTranslation());
    }
}
