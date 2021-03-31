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
import com.example.megamart.business.models.Category;
import com.example.megamart.business.models.Product;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CategoryHomeRecyclerAdapter extends RecyclerView.Adapter<CategoryHomeRecyclerAdapter.ViewHolder> {

    private List<Category> categories;
    private LayoutInflater inflater;
    private int layout;

    private CategoryHomeRecyclerAdapter.OnHomeCategoryListener mOnHomeCategoryListener;

    public CategoryHomeRecyclerAdapter(@NonNull Context context, int resource, @NonNull List<Category> categories, OnHomeCategoryListener onHomeCategoryListener) {
        this.categories = categories;
        this.layout = resource;
        this.inflater = LayoutInflater.from(context);
        this.mOnHomeCategoryListener = onHomeCategoryListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(this.layout, parent, false);
        return new ViewHolder(view, mOnHomeCategoryListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Category category = categories.get(position);
        holder.categoryName.setText(category.getName());
        try{
            Picasso.get().load(category.image.src).into(holder.categoryImage);
        }
        catch (Exception e){
            holder.categoryImage.setImageResource(com.example.megamart.R.drawable.no_image_available);
        }
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        final LinearLayout categoryHomeRoot;
        final TextView categoryName;
        final ImageView categoryImage;
        final OnHomeCategoryListener onHomeCategoryListener;


        public ViewHolder(@NonNull View view, OnHomeCategoryListener onHomeCategoryListener) {
            super(view);
            categoryHomeRoot = view.findViewById(R.id.categoryHomeRoot);
            categoryName = view.findViewById(R.id.tvCategoryHomeName);
            categoryImage = view.findViewById(R.id.categoryHomeImageView);
            this.onHomeCategoryListener = onHomeCategoryListener;

            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) { onHomeCategoryListener.onCategoryClick(getAdapterPosition()); }
    }

    public interface OnHomeCategoryListener {
        void onCategoryClick(int pos);
    }
}
