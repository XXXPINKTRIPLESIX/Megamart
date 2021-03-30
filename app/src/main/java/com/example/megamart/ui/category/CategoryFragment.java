package com.example.megamart.ui.category;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.megamart.AppConstants;
import com.example.megamart.R;
import com.example.megamart.adapters.CategoryRecyclerAdapter;
import com.example.megamart.business.models.Category;

import java.util.ArrayList;
import java.util.List;

public class CategoryFragment extends Fragment implements CategoryRecyclerAdapter.OnCategoryListener {
    private List<Category> categoryList = new ArrayList<>();
    private CategoryViewModel viewModel;
    //private RecyclerView rvCategory;
    //private CategoryRecyclerAdapter categoryRecyclerAdapter;
    private Category category;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        viewModel =
                ViewModelProviders.of(this).get(CategoryViewModel.class);
        View root = inflater.inflate(R.layout.fragment_category, container, false);

        //rvCategory = root.findViewById(R.id.rvCategory);

//        GridLayoutManager manager = new GridLayoutManager(getContext(), 2, GridLayoutManager.VERTICAL, false);
//        rvCategory.setLayoutManager(manager);

        viewModel.getCategoryList(100, 1, category.id, AppConstants.CHILD_EXCLUDES_ID).observe(getViewLifecycleOwner(), categoriesResponse -> {
            List<Category> mItems = categoriesResponse;
            categoryList.addAll(mItems);

//            categoryRecyclerAdapter = new CategoryRecyclerAdapter(getContext(), R.layout.category_list_item, categoryList, this);
//            rvCategory.setAdapter(categoryRecyclerAdapter);
         });
        return root;
    }

    public void SetData(Category category){
        this.category = category;
    }

    @Override
    public void onCategoryClick(int pos) {

    }
}




