package com.example.beautyproducts;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

public class DetailFragment extends Fragment {

    private ListViewModel mViewModel;
    private TextView tname, tprice, tdescrip;
    public  TextView name_tv, price_tv;
    private ImageView pimage;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = ViewModelProviders.of(getActivity()).get(ListViewModel.class);

        mViewModel.getSelectedProduct().observe(this, item -> {
            displayDetails(mViewModel.getProductDetails(item));
        });
    }
    public void displayDetails(Product product){
        tname.setText(product.getName());
        tprice.setText(String.format("%.2f", product.getPrice())+"€");
        tdescrip.setText(product.getDescrip());
        pimage.setImageResource(product.getImage());

        name_tv.setVisibility(View.VISIBLE);
        price_tv.setVisibility(View.VISIBLE);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail,
                container, false);

        name_tv = view.findViewById(R.id.name_tv);
        price_tv = view.findViewById(R.id.price_tv);
        pimage = view.findViewById(R.id.productimage);
        tname = view.findViewById(R.id.productName);
        tprice = view.findViewById(R.id.productPrice);
        tdescrip = view.findViewById(R.id.productDescription);

        return view;
    }
}
