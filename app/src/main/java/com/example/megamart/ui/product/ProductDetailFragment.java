package com.example.megamart.ui.product;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.megamart.R;
import com.example.megamart.business.models.Product;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.squareup.picasso.Picasso;

import java.util.PrimitiveIterator;

public class ProductDetailFragment extends Fragment {

    private Product product;
    private TextView productName, productDesc, productPrice;
    private ImageView productImage;
    private FloatingActionButton addCart;

    public ProductDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            product = (Product) getArguments().getSerializable("Product");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_product_detail, container, false);

        productName = root.findViewById(R.id.tvProductDetailName);
        productDesc = root.findViewById(R.id.tvProductDetailDesc);
        productPrice = root.findViewById(R.id.tvProductDetailPrice);
        productImage = root.findViewById(R.id.productDetailImage);
        addCart = root.findViewById(R.id.flbProductDetailCart);


        try{
            Picasso.get().load(product.images.get(0).src).into(productImage);
        }
        catch (Exception e){
            productImage.setImageResource(com.example.megamart.R.drawable.no_image_available);
        }

        productName.setText(product.getName());
        productDesc.setText(product.getDescription());
        productPrice.setText(product.getPrice());

        return root;
    }
}