package com.example.megamart.ui.catalog;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.megamart.AppConstants;
import com.example.megamart.R;
import com.example.megamart.adapters.CategoryRecyclerAdapter;
import com.example.megamart.business.models.Category;

import java.util.ArrayList;
import java.util.List;

import static androidx.navigation.Navigation.findNavController;

public class CatalogFragment extends Fragment implements CategoryRecyclerAdapter.OnCategoryListener {
    private List<Category> categoryList = new ArrayList<>();
    private CatalogViewModel viewModel;
    private RecyclerView rvCatalog;
    private CategoryRecyclerAdapter categoryRecyclerAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        viewModel =
                ViewModelProviders.of(this).get(CatalogViewModel.class);
        View root = inflater.inflate(R.layout.fragment_catalog, container, false);

        rvCatalog = root.findViewById(R.id.rvCatalog);

        GridLayoutManager manager = new GridLayoutManager(getContext(), 2, GridLayoutManager.VERTICAL, false);
        rvCatalog.setLayoutManager(manager);

        RecyclerView.ItemDecoration horizontal = new DividerItemDecoration(getContext(), DividerItemDecoration.HORIZONTAL);
        RecyclerView.ItemDecoration vertical = new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL);
        rvCatalog.addItemDecoration(horizontal);
        rvCatalog.addItemDecoration(vertical);

        viewModel.getCatalogList(100, 1, 0, AppConstants.EXCLUDES_ID).observe(getViewLifecycleOwner(), categoriesResponse -> {
            if (categoryList.size() == 0) {
                List<Category> mItems = categoriesResponse;
                categoryList.addAll(mItems);
            }
            categoryRecyclerAdapter = new CategoryRecyclerAdapter(getContext(), R.layout.category_list_item, categoryList, this);
            rvCatalog.setAdapter(categoryRecyclerAdapter);
        });

        return root;
    }

    @Override
    public void onCategoryClick(int pos) {
        Category category = categoryList.get(pos);
        Bundle bundle = new Bundle();
        bundle.putSerializable("Category", category);
        NavHostFragment.findNavController(this).navigate(R.id.action_nav_catalog_to_nav_category, bundle);

//        if(category.slug.equals("transport")) {
//            NavHostFragment.findNavController(this).navigate(R.id.action_nav_catalog_to_productFragment , bundle);
//        } else {
//
//        }
    }
}