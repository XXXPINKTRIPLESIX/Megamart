package com.example.megamart.ui.home;

import androidx.lifecycle.ViewModel;

import com.example.megamart.business.models.Product;
import com.example.megamart.business.retrofit2.RetrofitSglt;
import com.example.megamart.business.retrofit2.services.WoocommerceApi;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeViewModel extends ViewModel {

    //private MutableLiveData<String> mText;

    public HomeViewModel() {
        RetrofitSglt.getInstance().getJSONApi().listProducts(RetrofitSglt.getAuthToken()).enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                if (response.body() != null) {
                    int i = 0;
                } else {
                    int a = 5;
                }
            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {
                int b = 0;
            }
        });
    }

//    public LiveData<String> getText() {
//        return mText;
}
