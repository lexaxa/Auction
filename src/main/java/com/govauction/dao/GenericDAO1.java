package com.govauction.dao;

import java.util.List;

/**
 * ДАО для работы с лотами - Добавить, Получить список
 */
public interface GenericDAO1<T>{
    public void create(T entity);
    public void edit (T entity);
    public T getById(Long id);
    public void delete(T entity);
    public List<T> find(Filter filter);
    public List<T> getAll();
}
