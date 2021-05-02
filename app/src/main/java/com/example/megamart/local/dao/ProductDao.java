package com.example.megamart.local.dao;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.megamart.business.models.Product;

import java.util.List;

public interface ProductDao {
    @Query("SELECT * FROM product")
    List<Product> getAll();

    @Insert
    void insertAll(Product... products);

    @Delete
    void delete(Product product);
}
