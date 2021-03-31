package com.example.megamart.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.megamart.R;
import com.example.megamart.business.models.Product;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ProductsRecyclerAdapter extends RecyclerView.Adapter<ProductsRecyclerAdapter.ViewHolder> {

    private List<Product> products;
    private LayoutInflater inflater;
    private int layout;
    private OnProductListener mOnProductListener;

    public ProductsRecyclerAdapter(@NonNull Context context, int resource, @NonNull List<Product> products, OnProductListener onProductListener) {
        this.products = products;
        this.layout = resource;
        this.inflater = LayoutInflater.from(context);
        this.mOnProductListener = onProductListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(this.layout, parent, false);
        return new ProductsRecyclerAdapter.ViewHolder(view, mOnProductListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Product product = products.get(position);
        holder.productName.setText(product.getName());
        holder.productPrice.setText(product.getPrice());
        try{
            Picasso.get().load(product.images.get(0).src).into(holder.productImage);
        }
        catch (Exception e){
            holder.productImage.setImageResource(com.example.megamart.R.drawable.no_image_available);
        }
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        final LinearLayout clRoot;
        final TextView productName;
        final TextView productPrice;
        final FloatingActionButton productAddCart;
        final ImageView productImage;
        final OnProductListener onProductListener;

        public ViewHolder(@NonNull View view, OnProductListener onProductListener) {
            super(view);
            clRoot = view.findViewById(R.id.clRoot);
            productName = view.findViewById(R.id.productName);
            productPrice = view.findViewById(R.id.productPrice);
            productAddCart = view.findViewById(R.id.productAddCart);
            productImage = view.findViewById(R.id.productImage);

            this.onProductListener = onProductListener;

            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) { onProductListener.onProductClick(getAdapterPosition()); }
    }

    public interface OnProductListener {
        void onProductClick(int pos);
    }

}
