package com.example.megamart.ui.home;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.megamart.business.models.Category;
import com.example.megamart.business.models.Product;
import com.example.megamart.business.retrofit2.RetrofitSglt;
import com.example.megamart.business.retrofit2.services.WoocommerceApi;
import com.example.megamart.repository.CategoryRepository;
import com.example.megamart.repository.ProductRepository;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeViewModel extends ViewModel {
    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;
    private MutableLiveData<List<Category>> catalogList = new MutableLiveData<>();
    private MutableLiveData<List<Product>> productList = new MutableLiveData<>();

    public HomeViewModel() {
        productRepository = ProductRepository.getInstance();
        categoryRepository = CategoryRepository.getInstance();
    }

    public MutableLiveData<List<Product>> getProductList(int per_page, int page) {
        productList = loadProductList(per_page, page);
        return productList;
    }
    private MutableLiveData<List<Product>> loadProductList(int per_page, int page) {
        return productRepository.getProductHomeList(per_page, page);
    }

    public MutableLiveData<List<Category>> getCatalogList(int per_page, int page, int id, String excludes_id) {
        catalogList = loadCatalogList(per_page, page, id, excludes_id);
        return catalogList;
    }

    private MutableLiveData<List<Category>> loadCatalogList(int per_page, int page, int id, String excludes_id) {
        return categoryRepository.getCategoryList(per_page, page, id, excludes_id);
    }
}
