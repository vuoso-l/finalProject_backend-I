package com.example.finalProject_backendI.service;

import java.util.Collection;

public interface IBasicCrudService<T> {
    T create(T t);

    T findOne(Integer id);

    Collection<T> findAll();

    T update(T t);

    void delete(Integer id);

}
