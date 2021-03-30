package com.example.megamart.ui.home;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.megamart.AppConstants;
import com.example.megamart.R;
import com.example.megamart.adapters.CategoryHomeRecyclerAdapter;
import com.example.megamart.adapters.ProductsRecyclerAdapter;
import com.example.megamart.business.models.Category;
import com.example.megamart.business.models.Product;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment /*implements ProductsAdapter.OnItemClickListener*/ {
    private List<Product> productsList = new ArrayList<>();
    private List<Category> categoryList = new ArrayList<>();
    private RecyclerView rvHomeProducts;
    private RecyclerView rvHomeCategories;
    private ProductsRecyclerAdapter productAdapter;
    private CategoryHomeRecyclerAdapter categoryAdapter;
    private HomeViewModel viewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        viewModel = ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        rvHomeProducts = root.findViewById(R.id.rvHomeProducts);
        rvHomeCategories = root.findViewById(R.id.rvHomeCategories);

        GridLayoutManager productGridManager = new GridLayoutManager(getContext(), 1, GridLayoutManager.HORIZONTAL, false);
        rvHomeProducts.setLayoutManager(productGridManager);

        // RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(getContext(), DividerItemDecoration.HORIZONTAL);
//        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(getContext(), DividerItemDecoration.HORIZONTAL);
//        Drawable dividerDrawable = getResources().getDrawable(R.drawable.home_products_divider);
//        itemDecoration.se .setDrawable(dividerDrawable);
//        rvHomeProducts.addItemDecoration(itemDecoration);

        GridLayoutManager categoryGridManager = new GridLayoutManager(getContext(), 1, GridLayoutManager.HORIZONTAL, false);
        rvHomeCategories.setLayoutManager(categoryGridManager);

        categoryAdapter = new CategoryHomeRecyclerAdapter(getContext(), R.layout.category_home_list_item, categoryList);
        productAdapter = new ProductsRecyclerAdapter(getContext(), R.layout.product_list_item, productsList);

        rvHomeProducts.setAdapter(productAdapter);
        rvHomeCategories.setAdapter(categoryAdapter);

        viewModel.getCatalogList(100, 1, 0, AppConstants.EXCLUDES_ID).observe(getViewLifecycleOwner(), categoryResponse -> {
            if(categoryList.size() == 0) {
                List<Category> mItems = categoryResponse;
                categoryList.addAll(mItems);
            }
            categoryAdapter.notifyDataSetChanged();
        });

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
