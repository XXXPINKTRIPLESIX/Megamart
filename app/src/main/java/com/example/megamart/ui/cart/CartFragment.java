package com.example.megamart.ui.cart;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.example.megamart.R;
import com.example.megamart.adapters.CartListViewAdapter;
import com.example.megamart.adapters.CategoryListViewAdapter;
import com.example.megamart.business.models.Product;
import com.example.megamart.ui.home.HomeViewModel;

import java.util.ArrayList;
import java.util.List;

public class CartFragment extends Fragment {

    private CartViewModel cartViewModel;
    private ArrayList<Product> listProduct = new ArrayList<>();
    private CartListViewAdapter adapter;
    private ListView lvOrders;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        cartViewModel =
                ViewModelProviders.of(this).get(CartViewModel.class);
        View root = inflater.inflate(R.layout.fragment_cart, container, false);

        lvOrders = root.findViewById(R.id.lvOrders);

        try {
            listProduct.add((Product) getArguments().getSerializable("Product"));

            adapter = new CartListViewAdapter(getContext(), listProduct);
            lvOrders.setAdapter(adapter);

            adapter.notifyDataSetChanged();
        }catch (NullPointerException ex){
            TextView textView = new TextView(getContext());
            textView.setWidth(400);
            textView.setHeight(100);
            textView.setText("Пока ничего нет.");
            lvOrders.setEmptyView(textView);
        }
        return root;
    }
}