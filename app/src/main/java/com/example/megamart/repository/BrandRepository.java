package com.example.megamart.repository;

import androidx.lifecycle.MutableLiveData;

import com.example.megamart.business.models.Brand;
import com.example.megamart.business.models.Category;
import com.example.megamart.business.retrofit2.RetrofitSglt;
import com.example.megamart.business.retrofit2.services.WoocommerceApi;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

//public class BrandRepository {
//    private static WoocommerceApi myInterface;
//    private final MutableLiveData<List<Brand>> data = new MutableLiveData<>();
//
//    private static BrandRepository brandRepository;
//
//    public static BrandRepository getInstance() {
//        if (brandRepository == null) {
//            brandRepository = new BrandRepository();
//        }
//        return brandRepository;
//    }
//
//    private BrandRepository(){
//        myInterface = RetrofitSglt.getInstance().getJSONApi();
//    }
//
//    public MutableLiveData<List<Brand>> getBrandList(int per_page, int page, int id, String excludes_id) {
//        Call<List<Brand>> outputData = myInterface.listParentCategories(RetrofitSglt.getAuthToken(), per_page, page, id, excludes_id);
//        outputData.enqueue(new Callback<List<Brand>>() {
//            @Override
//            public void onResponse(Call<List<Brand>> call, Response<List<Brand>> response) {
//                if (response.body() != null) {
//                    data.postValue(response.body());
//                } else {
//                    data.postValue(null);
//                }
//            }
//
//            @Override
//            public void onFailure(Call<List<Brand>> call, Throwable t) {
//                data.postValue(null);
//            }
//        });
//        return data;
//    }
//}
