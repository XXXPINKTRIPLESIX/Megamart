package com.example.megamart.ui.product;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.megamart.business.models.Product;
import com.example.megamart.repository.ProductRepository;

import java.util.List;

public class ProductViewModel extends ViewModel {
    private ProductRepository repository;
    private MutableLiveData<List<Product>> productList = new MutableLiveData<>();

    public ProductViewModel() {
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
