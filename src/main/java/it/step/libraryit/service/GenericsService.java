package it.step.libraryit.service;

import java.util.List;

public interface GenericsService<T> {

    T findById(Long id);

    List<T> findAll(String keyword);

    T save(T t);

    void deleteById(Long id);

}