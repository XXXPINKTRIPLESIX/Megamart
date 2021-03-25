package com.example.megamart.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.megamart.R;
import com.example.megamart.business.models.Product;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class ProductsAdapter extends RecyclerView.Adapter<ProductsAdapter.ViewHolder> {

    private List<Product> products;
    private LayoutInflater inflater;
    private int layout;
    private AdapterView.OnItemClickListener itemClickListener;

    public ProductsAdapter(@NonNull Context context, int resource, @NonNull List<Product> products) {
        this.products = products;
        this.layout = resource;
        this.inflater = LayoutInflater.from(context);

        if (context instanceof AdapterView.OnItemClickListener) {
            itemClickListener = (AdapterView.OnItemClickListener) context;
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(this.layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Product product = products.get(position);
        holder.productName.setText(product.getName());
        holder.productPrice.setText(product.getRegularPrice());
        //holder.productImage.setImage

    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public interface OnItemClickListener {
        void onItemClick(Product product, int pos);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final LinearLayout clRoot;
        final TextView productName;
        final TextView productPrice;
        final FloatingActionButton productAddCart;
        final ImageView productImage;

        public ViewHolder(@NonNull View view) {
            super(view);
            clRoot = view.findViewById(R.id.clRoot);
            productName = view.findViewById(R.id.productName);
            productPrice = view.findViewById(R.id.productPrice);
            productAddCart = view.findViewById(R.id.productAddCart);
            productImage = view.findViewById(R.id.productImage);
        }
    }
}
