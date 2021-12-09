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

    private ListViewModel mViewModel;
    private ListView lv;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_list,
                container, false);
        lv = view.findViewById(R.id.beautyProducts);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(getActivity()).get(ListViewModel.class);
        // TODO: Use the ViewModel
        lv.setAdapter(new ArrayAdapter<String>(this.getActivity(),
                android.R.layout.simple_list_item_1, mViewModel.getProductList()));

        lv.setOnItemClickListener((adapter, itemView, pos, id) -> {
            TextView tv = (TextView)itemView;
            Toast.makeText(this.getContext(), tv.getText().toString()+" Selected", Toast.LENGTH_SHORT).show();
            mViewModel.selectProduct(tv.getText().toString());

        });
    }
}
