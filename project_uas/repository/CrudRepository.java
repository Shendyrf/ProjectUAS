package com.itenas.project_uas.repository;

import java.util.List;

public interface CrudRepository<T, ID> {
    List<T> findAll();
    ID create(T object);
    ID update(T object);
    T findById(int id);
    ID delete(int id);
}
