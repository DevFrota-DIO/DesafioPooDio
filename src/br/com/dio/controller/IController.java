package br.com.dio.controller;

import java.util.List;

public interface IController <Object>{

    Object create(String nome, String description, int up);

    void add(Object object);

    Object getById(int id);

    List<Object> getAll();

    int update(int id, Object object);

    int delete(int id);

    void startAutoData();

    int sizeMap();
}
