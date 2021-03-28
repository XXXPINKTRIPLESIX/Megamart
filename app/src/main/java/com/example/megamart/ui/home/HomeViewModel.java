package com.example.megamart.ui.home;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.megamart.business.models.Product;
import com.example.megamart.business.retrofit2.RetrofitSglt;
import com.example.megamart.business.retrofit2.services.WoocommerceApi;
import com.example.megamart.repository.ProductRepository;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeViewModel extends ViewModel {
    private ProductRepository repository;
    private MutableLiveData<List<Product>> productList = new MutableLiveData<>();

    public HomeViewModel() {
        repository = ProductRepository.getInstance();
    }

    public MutableLiveData<List<Product>> getProductList(int per_page, int page) {
        productList = loadProductList(per_page, page);
        return productList;
    }
    private MutableLiveData<List<Product>> loadProductList(int per_page, int page) {
        return repository.getProductList(per_page, page);
    }
}
