package com.example.megamart.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.megamart.R;
import com.example.megamart.business.models.Product;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class CartListViewAdapter extends ArrayAdapter<Product> {
    private Context mContext;
    private List<Product> orderList;

    public CartListViewAdapter(@NonNull Context context, @SuppressLint("SupportAnnotationUsage") @LayoutRes ArrayList<Product> list) {
        super(context, 0 , list);
        mContext = context;
        orderList = list;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItem = convertView;
        if(listItem == null)
            listItem = LayoutInflater.from(mContext).inflate(R.layout.product_list_list_item,parent,false);

        TextView name = listItem.findViewById(R.id.tvNameOrder);
        ImageView image = listItem.findViewById(R.id.ordetItemImage);
        TextView price = listItem.findViewById(R.id.tvOrderPrice);

        Product currentProduct = orderList.get(position);

        try{
            Picasso.get().load(currentProduct.images.get(0).src).into(image);
        }
        catch (Exception e){
            image.setImageResource(com.example.megamart.R.drawable.no_image_available);
        }


        name.setText(currentProduct.getName());
        price.setText(currentProduct.getPrice());

        return listItem;
    }
}
