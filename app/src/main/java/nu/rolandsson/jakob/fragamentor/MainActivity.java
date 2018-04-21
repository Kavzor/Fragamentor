package nu.rolandsson.jakob.fragamentor;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import nu.rolandsson.jakob.fragamentor.fragment.ArticleFragment;
import nu.rolandsson.jakob.fragamentor.fragment.PlainFragment;
import nu.rolandsson.jakob.fragamentor.fragment.HeadlinesFragment;
import nu.rolandsson.jakob.fragamentor.fragment.TranslationFragment;
import nu.rolandsson.jakob.fragamentor.model.Article;

public class MainActivity extends FragmentActivity {

    private Map<String, Article> articles = new HashMap<String, Article>() {{
        put("Article one",
                new Article("En lång sträng som ska fejka en artikel...",
                        "A long string illustrating an article"));
        put("Article two",
                new Article("... och en lång string för artikel 2",
                        "... and a longer string for article 2"));
    }};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        HeadlinesFragment headlinesFragment = (HeadlinesFragment) getSupportFragmentManager().
                findFragmentById(R.id.headlines_fragment);

        headlinesFragment.setHeadlines(new ArrayList<>(articles.keySet()));
        headlinesFragment.setHeadlineSelectAction(this::onHeadlineSelected);
    }

    private void onHeadlineSelected(String headline) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        Article article = articles.get(headline);

        PlainFragment plainFragment = (PlainFragment)
                fragmentManager.findFragmentById(R.id.plain_fragment);
        TranslationFragment translationFragment = (TranslationFragment)
                fragmentManager.findFragmentById(R.id.translation_fragment);

        ArticleFragment.updateArticles(article, plainFragment, translationFragment);
    }
}
