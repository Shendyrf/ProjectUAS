package com.itenas.project_uas.repository;

public interface AkunRepository<T, ID> {
    T login(String username, String password);
}
