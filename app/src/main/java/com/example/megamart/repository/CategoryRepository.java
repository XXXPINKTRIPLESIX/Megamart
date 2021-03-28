package com.example.megamart.repository;

import androidx.lifecycle.MutableLiveData;

import com.example.megamart.business.models.Category;
import com.example.megamart.business.models.Product;
import com.example.megamart.business.retrofit2.RetrofitSglt;
import com.example.megamart.business.retrofit2.services.WoocommerceApi;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoryRepository {
    private static WoocommerceApi myInterface;
    private final MutableLiveData<HashMap<String, List<Category>>> data = new MutableLiveData<>();

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

//    public MutableLiveData<List<Category>> getCategoryList(int per_page, int page) {
//        Call<List<Category>> outputData = myInterface.listCategories(RetrofitSglt.getAuthToken(), per_page, page);
//        outputData.enqueue(new Callback<List<Category>>() {
//            @Override
//            public void onResponse(Call<List<Category>> call, Response<List<Category>> response) {
//                if (response.body() != null) {
//                    data.setValue(response.body());
//                    int a = 0;
//                } else {
//                    data.postValue(null);
//                }
//            }
//
//            @Override
//            public void onFailure(Call<List<Category>> call, Throwable t) {
//                data.postValue(null);
//            }
//        });
//        return data;
//    }

    public MutableLiveData<HashMap<String, List<Category>>> getParentCategoryList(int per_page, int page, int parent_id) {
        Call<List<Category>> outputData = myInterface.listParentCategories(RetrofitSglt.getAuthToken(), per_page, page, parent_id);
        outputData.enqueue(new Callback<List<Category>>() {
            @Override
            public void onResponse(Call<List<Category>> call, Response<List<Category>> response) {
                if (response.body() != null) {

                    HashMap<String, List<Category>> stringListHashMap = new HashMap<>();

                    for (Category c : response.body()) {
                        Call<List<Category>> outputData = myInterface.listCategories(RetrofitSglt.getAuthToken(), per_page, page, c.id);
                        outputData.enqueue(new Callback<List<Category>>() {
                            @Override
                            public void onResponse(Call<List<Category>> call, Response<List<Category>> response) {
                                if (response.body() != null) {
                                    if(c.name != "Автомобили"){
                                        stringListHashMap.put(c.name, response.body());
                                        int a = 0;
                                    }
                                    else
                                        return;
                                }
                                else {
                                    data.postValue(null);
                                }

                                data.postValue(stringListHashMap);
                            }

                            @Override
                            public void onFailure(Call<List<Category>> call, Throwable t) {
                                data.postValue(null);
                            }
                        });

                    }

                    data.setValue(stringListHashMap);
                    int a = 0;

                } else {
                    data.postValue(null);
                }
            }

            @Override
            public void onFailure(Call<List<Category>> call, Throwable t) {
                data.postValue(null);
            }
        });
        int b = 0;
        return data;
    }
}
