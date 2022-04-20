package com.example.finalProject_backendI.service;

import java.util.Collection;

public interface IBasicCrudService<T> {
    public T create(T t);

    public T findOne(Integer id);

    public Collection<T> findAll();

    public T update(T t);

    public void delete(Integer id);

}
