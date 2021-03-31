package com.example.megamart.ui.category;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.solver.PriorityGoalRow;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.megamart.AppConstants;
import com.example.megamart.R;
import com.example.megamart.adapters.CategoryListViewAdapter;
import com.example.megamart.adapters.CategoryRecyclerAdapter;
import com.example.megamart.adapters.ProductsRecyclerAdapter;
import com.example.megamart.business.models.Category;
import com.example.megamart.business.models.Product;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class SubCategoryFragment extends Fragment implements ProductsRecyclerAdapter.OnProductListener {
    private ArrayList<Category> categoryList = new ArrayList<>();
    private List<Product> productList = new ArrayList<>();

    private SubCategoryViewModel viewModel;

    private ListView lvCategories;
    private RecyclerView rvProducts;

    private CategoryListViewAdapter categoryListViewAdapter;
    private ProductsRecyclerAdapter productsRecyclerAdapter;

    Category category;

    private ImageView image;
    private TextView categoryName;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        viewModel =
                ViewModelProviders.of(this).get(SubCategoryViewModel.class);
        View root = inflater.inflate(R.layout.sub_fragment_category, container, false);

        try {
            category = (Category) getArguments().getSerializable("Category");
        }catch (NullPointerException nullPointerException){
            Toast toast =Toast.makeText(getContext(),"NullPointerException",Toast.LENGTH_SHORT);
            toast.setMargin(50,50);
            toast.show();
        }

        image = root.findViewById(R.id.mainCategoryImage);
        try{
            Picasso.get().load(category.image.src).into(image);
        }
        catch (Exception e){
            image.setImageResource(com.example.megamart.R.drawable.no_image_available);
        }
        categoryName = root.findViewById(R.id.tvMainCategoryName);
        categoryName.setText(category.name);

        lvCategories = root.findViewById(R.id.lvSubCategories);
        rvProducts = root.findViewById(R.id.rvCategoryProduct);

        categoryListViewAdapter = new CategoryListViewAdapter(getContext(), categoryList);
        lvCategories.setAdapter(categoryListViewAdapter);

        productsRecyclerAdapter = new ProductsRecyclerAdapter(getContext(), R.layout.product_list_item, productList, this);
        rvProducts.setAdapter(productsRecyclerAdapter);

        GridLayoutManager categoryGridManager = new GridLayoutManager(getContext(), 3, GridLayoutManager.VERTICAL, false);
        rvProducts.setLayoutManager(categoryGridManager);

        viewModel.getCategoryList(100, 1, category.id, AppConstants.CHILD_EXCLUDES_ID).observe(getViewLifecycleOwner(), categoriesResponse -> {
            categoryList.clear();
            //List<Category> mItems = categoriesResponse;
            categoryList.addAll(categoriesResponse);
            categoryListViewAdapter.notifyDataSetChanged();
         });

        viewModel.getProductList(100, 1, category.id).observe(getViewLifecycleOwner(), productsResponse -> {
            productList.clear();
            //List<Product> mItems = productsResponse;
            productList.addAll(productsResponse);
            productsRecyclerAdapter.notifyDataSetChanged();
        });

        return root;
    }

    @Override
    public void onProductClick(int pos) {
        Product product = productList.get(pos);
        Bundle bundle = new Bundle();
        bundle.putSerializable("Product", product);
        NavHostFragment.findNavController(this).navigate(R.id.action_nav_category_to_productDetailFragment , bundle);
    }
}




