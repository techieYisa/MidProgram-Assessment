package nyc.c4q.midtermasessmentretake;
import android.icu.text.NumberingSystem;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import nyc.c4q.midtermasessmentretake.model.Numbers;

/**
 * Created by c4q on 1/16/18.
 */

public class ListRecyclerFragment extends android.support.v4.app.Fragment {
    View rootView;
    TextView textView;
    RecyclerView numRecyclerView;



    public ListRecyclerFragment() {}
    //required empty constructor

    @Override
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = layoutInflater.inflate(R.layout.fragment_list, container, false);
        textView = (TextView) rootView.findViewById(R.id.fragment_textview);
        Bundle bundle = getActivity().getIntent().getExtras();
        String username = bundle.getString("email");
        textView.setText(username);

        numRecyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_view);

        List<Numbers> numberList = new ArrayList<>();

        for (int i =0 ; i <11; i++){
            numberList.add(new Numbers(i));
        }
        NumberAdapter numberAdapter = new NumberAdapter(numberList);
        LinearLayoutManager linearLayoutManager;
        linearLayoutManager = new LinearLayoutManager(rootView.getContext().getApplicationContext());
        numRecyclerView.setAdapter(numberAdapter);
        numRecyclerView.setLayoutManager(linearLayoutManager);

        return rootView;
    }
}
