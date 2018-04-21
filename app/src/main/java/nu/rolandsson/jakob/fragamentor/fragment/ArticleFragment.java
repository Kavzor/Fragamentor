package nu.rolandsson.jakob.fragamentor.fragment;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import nu.rolandsson.jakob.fragamentor.R;
import nu.rolandsson.jakob.fragamentor.model.Article;
import nu.rolandsson.jakob.fragamentor.model.Text;

/**
 * Created by Martin on 2018-04-19.
 */

public abstract class ArticleFragment extends Fragment {

    public static final String ARG_TEXT = "position";
    private Text mCurrentText = null;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup,
                             Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            mCurrentText = (Text) savedInstanceState.getSerializable(ARG_TEXT);
        }

        return inflater.inflate(R.layout.article_view, viewGroup, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView textView = (TextView) view;
        Resources resources = getResources();

        textView.setTextColor(resources.getColor(R.color.text));
        textView.setBackgroundColor(resources.getColor(R.color.article_bg));
    }

    @Override
    public void onStart() {
        super.onStart();

        Bundle bundle = getArguments();
        if (bundle != null) {
            updateArticleView((Text) bundle.getSerializable(ARG_TEXT));
        } else if (mCurrentText != null) {
            updateArticleView(mCurrentText);
        }
    }

    public void updateArticleView(Text text) {
        mCurrentText = text;
        setText(text);
    }

    protected void setText(Text text) {
        setText(text.getText());
    }

    protected void setText(String string) {
        TextView textView = (TextView) getView();
        textView.setText(string);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable(ARG_TEXT, mCurrentText);
    }

    public static void updateArticles(Article article, ArticleFragment... articleFragments) {
        for (ArticleFragment articleFragment : articleFragments) {
            articleFragment.updateArticleView(article);
        }
    }
}