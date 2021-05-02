package com.example.megamart.repository;

import androidx.lifecycle.MutableLiveData;

import com.example.megamart.business.models.Category;
import com.example.megamart.business.models.Product;
import com.example.megamart.business.retrofit2.RetrofitSglt;
import com.example.megamart.business.retrofit2.services.WoocommerceApi;

import java.util.List;
import java.util.Observable;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoryRepository {
    private static WoocommerceApi myInterface;
    private final MutableLiveData<List<Category>> category = new MutableLiveData<>();
    private final MutableLiveData<List<Category>> subCategory = new MutableLiveData<>();

    private static CategoryRepository categoryRepository;

    public static CategoryRepository getInstance() {
        if (categoryRepository == null) {
            categoryRepository = new CategoryRepository();
        }
        return categoryRepository;
    }

    private CategoryRepository(){
        myInterface = RetrofitSglt.getInstance().getJSONApi();
    }

    public MutableLiveData<List<Category>> getCategoryList(int per_page, int page, int id, String excludes_id) {
        Call<List<Category>> outputData = myInterface.listParentCategories(RetrofitSglt.getAuthToken(), per_page, page, id, excludes_id);
        outputData.enqueue(new Callback<List<Category>>() {
            @Override
            public void onResponse(Call<List<Category>> call, Response<List<Category>> response) {
                if (response.body() != null) {
                    category.postValue(response.body());
                } else {
                    category.postValue(null);
                }
            }

            @Override
            public void onFailure(Call<List<Category>> call, Throwable t) {
                category.postValue(null);
            }
        });
        return category;
    }

    public MutableLiveData<List<Category>> getSubCategory(int per_page, int page, int id, String excludes_id) {
        Call<List<Category>> outputData = myInterface.listParentCategories(RetrofitSglt.getAuthToken(), per_page, page, id, excludes_id);
        outputData.enqueue(new Callback<List<Category>>() {
            @Override
            public void onResponse(Call<List<Category>> call, Response<List<Category>> response) {
                if (response.body() != null) {
                    subCategory.postValue(response.body());
                } else {
                    subCategory.postValue(null);
                }
            }

            @Override
            public void onFailure(Call<List<Category>> call, Throwable t) {
                subCategory.postValue(null);
            }
        });
        return subCategory;
    }
}
