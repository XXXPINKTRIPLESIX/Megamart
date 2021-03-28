package com.example.megamart.ui.catalog;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.megamart.R;
import com.example.megamart.adapters.CategoryAdapter;
import com.example.megamart.adapters.ProductsAdapter;
import com.example.megamart.business.models.Category;
import com.example.megamart.business.models.Product;
import com.example.megamart.ui.cart.CartViewModel;
import com.example.megamart.ui.home.HomeViewModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class CatalogFragment extends Fragment {
    private HashMap<String, List<Category>> categoryList = new HashMap();
    private List<String> listTitle;
    private CatalogViewModel viewModel;
    private ExpandableListView elvCategory;
    private ExpandableListAdapter expandableListAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        viewModel =
                ViewModelProviders.of(this).get(CatalogViewModel.class);
        View root = inflater.inflate(R.layout.fragment_catalog, container, false);

        elvCategory = root.findViewById(R.id.elvCategories);

        viewModel.getParentCategoryList(100, 1, 0).observe(getViewLifecycleOwner(), categoriesResponse -> {
            HashMap<String, List<Category>> mItems = categoriesResponse;
            categoryList.putAll(mItems);
            listTitle = new ArrayList<String>(categoryList.keySet());
            expandableListAdapter = new CategoryAdapter(getContext(), listTitle, categoryList);
            elvCategory.setAdapter(expandableListAdapter);
            elvCategory.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {

                @Override
                public void onGroupExpand(int groupPosition) {
                    Toast.makeText(getContext(),
                            listTitle.get(groupPosition) + " List Expanded.",
                            Toast.LENGTH_SHORT).show();
                }
            });

            //expandableListAdapter.notifyDataSetChanged();
        });

        return root;
    }
}