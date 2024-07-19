package br.com.dio.controller.dao;

import java.util.List;
public interface IDao <T> {

        void add(T item);
        T getById(int id);
        List<T> getAll();
        boolean update(int id, T item);
        boolean delete(int id);
        void startAutoData();
        int sizeMap();

}
