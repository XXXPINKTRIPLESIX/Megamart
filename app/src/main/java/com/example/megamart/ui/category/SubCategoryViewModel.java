package com.example.megamart.ui.category;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.megamart.business.models.Category;
import com.example.megamart.business.models.Product;
import com.example.megamart.repository.CategoryRepository;
import com.example.megamart.repository.ProductRepository;

import java.util.List;

public class SubCategoryViewModel extends ViewModel {
    private CategoryRepository categoryRepository;
    private ProductRepository productRepository;
    private MutableLiveData<List<Category>> categoryList = new MutableLiveData<>();
    private MutableLiveData<List<Product>> productList = new MutableLiveData<>();

    public SubCategoryViewModel() {
        categoryRepository = CategoryRepository.getInstance();
        productRepository = ProductRepository.getInstance();
    }

    public MutableLiveData<List<Category>> getCategoryList(int per_page, int page, int id, String excludes_id) {
        categoryList = loadCategoryList(per_page, page, id, excludes_id);
        return categoryList;
    }

    private MutableLiveData<List<Category>> loadCategoryList(int per_page, int page, int id, String excludes_id) {
        return categoryRepository.getSubCategory(per_page, page, id, excludes_id);
    }

    public MutableLiveData<List<Product>> getProductList(int per_page, int page, int id) {
        productList = loadProductList(per_page, page, id);
        return productList;
    }

    private MutableLiveData<List<Product>> loadProductList(int per_page, int page, int id) {
        return productRepository.getProductCategoriesList(per_page, page, id);
    }
}
