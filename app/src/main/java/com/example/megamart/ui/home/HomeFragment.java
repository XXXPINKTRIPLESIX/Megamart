package com.example.megamart.ui.home;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.megamart.AppConstants;
import com.example.megamart.R;
import com.example.megamart.adapters.CategoryHomeRecyclerAdapter;
import com.example.megamart.adapters.ProductsRecyclerAdapter;
import com.example.megamart.business.models.Category;
import com.example.megamart.business.models.Product;
import com.example.megamart.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment implements CategoryHomeRecyclerAdapter.OnHomeCategoryListener, ProductsRecyclerAdapter.OnProductListener {
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

        categoryAdapter = new CategoryHomeRecyclerAdapter(getContext(), R.layout.category_home_list_item, categoryList, this);
        productAdapter = new ProductsRecyclerAdapter(getContext(), R.layout.product_list_item, productsList, this);

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

    @Override
    public void onCategoryClick(int pos) {
        Category category = categoryList.get(pos);
        Bundle bundle = new Bundle();
        bundle.putSerializable("Category", category);
        NavHostFragment.findNavController(this).navigate(R.id.action_nav_home_to_nav_category, bundle);
    }

    @Override
    public void onProductClick(int pos) {
        Product product = productsList.get(pos);
        Bundle bundle = new Bundle();
        bundle.putSerializable("Product", product);
        NavHostFragment.findNavController(this).navigate(R.id.action_nav_home_to_productDetailFragment , bundle);
    }
}
