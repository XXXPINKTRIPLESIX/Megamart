package com.example.megamart.business.retrofit2.services;

import com.example.megamart.business.models.Product;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface WoocommerceApi {
    @GET("/wp-json/wc/v3/products")
    Call<List<Product>> listProducts(@Header("Authorization") String auth);
}
