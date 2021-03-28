package com.example.megamart.repository;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;

import com.example.megamart.business.models.Product;
import com.example.megamart.business.retrofit2.RetrofitSglt;
import com.example.megamart.business.retrofit2.services.WoocommerceApi;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductRepository {
    private static WoocommerceApi myInterface;
    private final MutableLiveData<List<Product>> data = new MutableLiveData<>();

    private static ProductRepository productRepository;

    public static ProductRepository getInstance() {
        if (productRepository == null) {
            productRepository = new ProductRepository();
        }
        return productRepository;
    }

    private ProductRepository(){
        myInterface = RetrofitSglt.getInstance().getJSONApi();
    }

    public MutableLiveData<List<Product>> getProductList(int per_page, int page) {
        Call<List<Product>> outputData = myInterface.listProducts(RetrofitSglt.getAuthToken(), per_page, page);
        outputData.enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                if (response.body() != null) {
                    data.setValue(response.body());
                } else {
                    data.postValue(null);
                }
            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {
                data.postValue(null);
            }
        });
        return data;
    }
}
