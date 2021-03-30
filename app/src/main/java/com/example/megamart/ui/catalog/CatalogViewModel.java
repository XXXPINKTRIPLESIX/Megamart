package com.example.megamart.ui.catalog;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.megamart.business.models.Category;
import com.example.megamart.repository.CategoryRepository;

import java.util.List;

public class CatalogViewModel extends ViewModel {
    private CategoryRepository repository;
    private MutableLiveData<List<Category>> catalogList = new MutableLiveData<>();

    public CatalogViewModel() {
        repository = CategoryRepository.getInstance();
    }

    public MutableLiveData<List<Category>> getCatalogList(int per_page, int page, int id, String excludes_id) {
        catalogList = loadCatalogList(per_page, page, id, excludes_id);
        return catalogList;
    }

    private MutableLiveData<List<Category>> loadCatalogList(int per_page, int page, int id, String excludes_id) {
        return repository.getCategoryList(per_page, page, id, excludes_id);
    }
}