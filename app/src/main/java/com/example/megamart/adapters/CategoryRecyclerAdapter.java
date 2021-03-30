package com.example.megamart.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.megamart.R;
import com.example.megamart.business.models.Category;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CategoryRecyclerAdapter extends RecyclerView.Adapter<CategoryRecyclerAdapter.ViewHolder> {

    private List<Category> categories;
    private LayoutInflater inflater;
    private int layout;

    private OnCategoryListener mOnCategoryListener;

    public CategoryRecyclerAdapter(@NonNull Context context, int resource, @NonNull List<Category> category, OnCategoryListener onCategoryListener) {
        this.categories = category;
        this.layout = resource;
        this.inflater = LayoutInflater.from(context);
        this.mOnCategoryListener = onCategoryListener;
    }

    @NonNull
    @Override
    public CategoryRecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(this.layout, parent, false);
        return new CategoryRecyclerAdapter.ViewHolder(view, mOnCategoryListener);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryRecyclerAdapter.ViewHolder holder, int position) {
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
        final LinearLayout root;
        final TextView categoryName;
        final ImageView categoryImage;
        OnCategoryListener onCategoryListener;

        public ViewHolder(@NonNull View view, OnCategoryListener onCategoryListener) {
            super(view);
            root = view.findViewById(R.id.categoryRoot);
            categoryName = view.findViewById(R.id.tvCategoryName);
            categoryImage = view.findViewById(R.id.categoryImage);
            this.onCategoryListener = onCategoryListener;

            view.setOnClickListener(this);
        }


        @Override
        public void onClick(View v) {
            onCategoryListener.onCategoryClick(getAdapterPosition());
        }
    }
    public interface OnCategoryListener {
        void onCategoryClick(int pos);
    }
}
