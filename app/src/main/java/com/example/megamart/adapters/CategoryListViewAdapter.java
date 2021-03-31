package com.example.megamart.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.megamart.R;
import com.example.megamart.business.models.Category;

import java.util.ArrayList;
import java.util.List;

public class CategoryListViewAdapter extends ArrayAdapter<Category> {

    private Context mContext;
    private List<Category> categoriesList;

    public CategoryListViewAdapter(@NonNull Context context, @SuppressLint("SupportAnnotationUsage") @LayoutRes ArrayList<Category> list) {
        super(context, 0 , list);
        mContext = context;
        categoriesList = list;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItem = convertView;
        if(listItem == null)
            listItem = LayoutInflater.from(mContext).inflate(R.layout.category_list_list_item,parent,false);

        Category currentCategory = categoriesList.get(position);

//        ImageView image = (ImageView)listItem.findViewById(R.id.imageView_poster);
//        image.setImageResource(currentMovie.getmImageDrawable());

        TextView name = listItem.findViewById(R.id.subCategoryName);
        name.setText(currentCategory.getName());

//        TextView release = (TextView) listItem.findViewById(R.id.textView_release);
//        release.setText(currentMovie.getmRelease());

        return listItem;
    }
}
