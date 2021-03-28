package com.example.megamart.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.megamart.R;
import com.example.megamart.adapters.ProductsAdapter;
import com.example.megamart.business.models.Product;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment /*implements ProductsAdapter.OnItemClickListener*/ {
    private List<Product> productsList = new ArrayList<>();
    private RecyclerView rvProducts;
    private ProductsAdapter productAdapter;
    private HomeViewModel viewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        viewModel = ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        rvProducts = root.findViewById(R.id.rvProducts);

        GridLayoutManager manager = new GridLayoutManager(getContext(), 2, GridLayoutManager.VERTICAL, false);
        rvProducts.setLayoutManager(manager);

        productAdapter = new ProductsAdapter(getContext(), R.layout.product_list_item, productsList);
        rvProducts.setAdapter(productAdapter);

        viewModel.getProductList(50, 1).observe(getViewLifecycleOwner(), productResponse -> {
            List<Product> mItems = productResponse;
            productsList.addAll(mItems);
            productAdapter.notifyDataSetChanged();
        });

        return root;
    }

//    @Override
//    public void onItemClick(Product task, int pos) {
//        FragmentManager fm = getFragmentManager();
//        FragmentTransaction ft = fm.beginTransaction();
//        FragmentGreen llf = new FragmentGreen();
//        ft.replace(R.id.listFragment, llf);
//        ft.commit();
//    }
}
