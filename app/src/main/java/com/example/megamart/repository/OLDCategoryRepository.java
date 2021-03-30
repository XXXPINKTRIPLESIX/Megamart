//package com.example.megamart.repository;
//
//import androidx.lifecycle.MutableLiveData;
//
//import com.example.megamart.business.models.Category;
//import com.example.megamart.business.retrofit2.RetrofitSglt;
//import com.example.megamart.business.retrofit2.services.WoocommerceApi;
//
//import java.util.HashMap;
//import java.util.List;
//
//import retrofit2.Call;
//import retrofit2.Callback;
//import retrofit2.Response;
//
//public class OLDCategoryRepository {
//    private static WoocommerceApi myInterface;
//    private final MutableLiveData<HashMap<Category, List<Category>>> data = new MutableLiveData<>();
//
//    private static OLDCategoryRepository OLDCategoryRepository;
//
//    public static OLDCategoryRepository getInstance() {
//        if (OLDCategoryRepository == null) {
//            OLDCategoryRepository = new OLDCategoryRepository();
//        }
//        return OLDCategoryRepository;
//    }
//
//    private OLDCategoryRepository() {
//        myInterface = RetrofitSglt.getInstance().getJSONApi();
//    }
//
//
//    public MutableLiveData<HashMap<Category, List<Category>>> getParentCategoryList(int per_page, int page, int parent_id, String excludes_id) {
//        Call<List<Category>> outputData = myInterface.listParentCategories(RetrofitSglt.getAuthToken(), per_page, page, parent_id, excludes_id);
//        outputData.enqueue(new Callback<List<Category>>() {
//            @Override
//            public void onResponse(Call<List<Category>> call, Response<List<Category>> response) {
//                if (response.body() != null) {
//
//                    HashMap<Category, List<Category>> stringListHashMap = new HashMap<>();
//
//                    for (Category c : response.body()) {
//                        Call<List<Category>> outputData = myInterface.listCategories(RetrofitSglt.getAuthToken(), per_page, page, c.id);
//                        outputData.enqueue(new Callback<List<Category>>() {
//                            @Override
//                            public void onResponse(Call<List<Category>> call, Response<List<Category>> response) {
//                                if (response.body() != null) {
//                                    stringListHashMap.put(c, response.body());
//                                } else {
//                                    data.postValue(null);
//                                }
//
//                                data.postValue(stringListHashMap);
//                            }
//
//                            @Override
//                            public void onFailure(Call<List<Category>> call, Throwable t) {
//                                data.postValue(null);
//                            }
//                        });
//                    }
//
//                    data.setValue(stringListHashMap);
//
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
//
//        return data;
//    }
//}
