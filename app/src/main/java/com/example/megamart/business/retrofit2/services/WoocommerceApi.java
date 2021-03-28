package com.example.megamart.business.retrofit2.services;

import com.example.megamart.business.models.Category;
import com.example.megamart.business.models.Product;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface WoocommerceApi {
    @GET("/wp-json/wc/v3/products")
    Call<List<Product>> listProducts(@Header("Authorization") String auth, @Query("per_page") int per_page, @Query("page") int page);
    @GET("/wp-json/wc/v3/products/categories")
    Call<List<Category>> listCategories(@Header("Authorization") String auth, @Query("per_page") int per_page, @Query("page") int page, @Query("parent") int parent_id);
    @GET("/wp-json/wc/v3/products/categories")
    Call<List<Category>> listParentCategories(@Header("Authorization") String auth, @Query("per_page") int per_page, @Query("page") int page, @Query("parent") int parent_id);
}
