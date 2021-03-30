package com.example.megamart.ui.category;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.megamart.business.models.Category;
import com.example.megamart.business.models.Product;
import com.example.megamart.repository.CategoryRepository;
import com.example.megamart.repository.ProductRepository;

import java.util.List;

public class CategoryViewModel extends ViewModel {
    private CategoryRepository repository;
    private MutableLiveData<List<Category>> categoryList = new MutableLiveData<>();

    public CategoryViewModel() {
        repository = CategoryRepository.getInstance();
    }

    public MutableLiveData<List<Category>> getCategoryList(int per_page, int page, int id, String excludes_id) {
        categoryList = loadCategoryList(per_page, page, id, excludes_id);
        return categoryList;
    }

    private MutableLiveData<List<Category>> loadCategoryList(int per_page, int page, int id, String excludes_id) {
        return repository.getCategoryList(per_page, page, id, excludes_id);
    }
}
