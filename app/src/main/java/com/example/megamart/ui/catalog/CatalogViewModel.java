package com.example.megamart.ui.catalog;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.megamart.business.models.Category;
import com.example.megamart.business.models.Product;
import com.example.megamart.repository.CategoryRepository;
import com.example.megamart.repository.ProductRepository;

import java.util.HashMap;
import java.util.List;

public class CatalogViewModel extends ViewModel {
    private CategoryRepository repository;
    private MutableLiveData<HashMap<String, List<Category>>> parentCategoryList = new MutableLiveData<>();

    public CatalogViewModel() {
        repository = CategoryRepository.getInstance();
    }

//    public MutableLiveData<List<Category>> getCategoryList(int per_page, int page) {
//        categoryList = loadCategoryList(per_page, page);
//        return categoryList;
//    }
//
//    private MutableLiveData<List<Category>> loadCategoryList(int per_page, int page) {
//        return repository.getCategoryList(per_page, page);
//    }

        public MutableLiveData<HashMap<String, List<Category>>> getParentCategoryList(int per_page, int page, int id) {
        parentCategoryList = loadParentCategoryList(per_page, page, id);
        return parentCategoryList;
    }

    private MutableLiveData<HashMap<String, List<Category>>> loadParentCategoryList(int per_page, int page, int id) {
        return repository.getParentCategoryList(per_page, page, id);
    }
}