package com.itenas.project_uas.repository;

//import java.util.List;

public interface KasirRepository<T, ID> {
    T login(String username, String password);
    ID register (T object);
}
