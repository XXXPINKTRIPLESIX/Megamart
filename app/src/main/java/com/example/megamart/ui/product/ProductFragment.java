package com.example.megamart.ui.product;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.megamart.R;
import com.example.megamart.adapters.ProductsRecyclerAdapter;
import com.example.megamart.business.models.Product;
import com.example.megamart.ui.home.HomeViewModel;

import java.util.ArrayList;
import java.util.List;

public class ProductFragment extends Fragment /*implements ProductsAdapter.OnItemClickListener*/ {
    private List<Product> productsList = new ArrayList<>();
    private RecyclerView rvProducts;
    private ProductsRecyclerAdapter productAdapter;
    private ProductViewModel viewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        viewModel = ViewModelProviders.of(this).get(ProductViewModel.class);
        View root = inflater.inflate(R.layout.fragment_product, container, false);

        rvProducts = root.findViewById(R.id.rvProducts);

        GridLayoutManager manager = new GridLayoutManager(getContext(), 2, GridLayoutManager.VERTICAL, false);
        rvProducts.setLayoutManager(manager);

        productAdapter = new ProductsRecyclerAdapter(getContext(), R.layout.product_list_item, productsList);
        rvProducts.setAdapter(productAdapter);

        viewModel.getProductList(50, 1).observe(getViewLifecycleOwner(), productResponse -> {
            List<Product> mItems = productResponse;
            productsList.addAll(mItems);
            productAdapter.notifyDataSetChanged();
        });

        return root;
    }
}
