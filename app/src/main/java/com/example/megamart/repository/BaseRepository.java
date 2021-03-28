package com.example.megamart.repository;

import java.util.List;

public interface BaseRepository<T> {
    void Create(T obj);
    void Delete(int id);
    void Update(T obj);
    T Read(int id);
    List<T> ReadAll();
}
