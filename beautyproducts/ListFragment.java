package com.example.beautyproducts;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

public class ListFragment extends Fragment {
    //variables
    private ListViewModel mViewModel;
    private ListView lv;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //sets and inflates the list view on list fragment layout
        View view = inflater.inflate(R.layout.fragment_list,
                container, false);
        lv = view.findViewById(R.id.beautyProducts);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //calls the ViewModel class to observe the activity
        mViewModel = ViewModelProviders.of(getActivity()).get(ListViewModel.class);
        //set the array adapter for the list view
        lv.setAdapter(new ArrayAdapter<String>(this.getActivity(),
                R.layout.lv_custom_layout, mViewModel.getProductList())


        );
        //sets a click listener on listview items, gets the string of the item clicked and sends it to the ViewModel
        lv.setOnItemClickListener((adapter, itemView, pos, id) -> {
            TextView tv = (TextView)itemView;
            Toast.makeText(this.getContext(), tv.getText().toString()+" Selected", Toast.LENGTH_SHORT).show();
            mViewModel.selectProduct(tv.getText().toString());

        });
    }
}
