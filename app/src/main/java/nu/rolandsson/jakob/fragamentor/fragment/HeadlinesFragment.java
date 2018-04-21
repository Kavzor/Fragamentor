package nu.rolandsson.jakob.fragamentor.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Martin on 2018-04-17.
 */

public class HeadlinesFragment extends ListFragment {

    public interface OnHeadlineSelectedListener {
        void select(String text);
    }

    private OnHeadlineSelectedListener mHeadlineSelectedCallBack;

    public void setHeadlineSelectAction(OnHeadlineSelectedListener listener) {
        mHeadlineSelectedCallBack = listener;
    }

    public void setHeadlines(List<String> headlines) {
        setListAdapter(new ArrayAdapter<>(getActivity(),
                android.R.layout.simple_list_item_single_choice, headlines));
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
    }

    @Override
    public void onListItemClick(ListView listView, View view, int position, long id) {
        TextView listItemView = (TextView) view;
        String headline = listItemView.getText().toString();

        mHeadlineSelectedCallBack.select(headline);
        listView.setItemChecked(position, true);
    }
}
