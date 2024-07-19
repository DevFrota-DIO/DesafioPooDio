package br.com.dio.controller.services;

import br.com.dio.controller.dao.IDao;
import br.com.dio.controller.dao.dao.DaoBootcamp;
import br.com.dio.controller.model.Bootcamp;

import java.util.List;

public class ServiceDataBootcamp {
    private Bootcamp bootcamp;
    private final IDao<Bootcamp> daoBootcamp = new DaoBootcamp();


    public void setData(){
        daoBootcamp.startAutoData();
    }

    public void add(Bootcamp bootcamp) {
        daoBootcamp.add(bootcamp);
    }

    public Bootcamp getById(int id) {
        return daoBootcamp.getById(id);
    }

    public List<Bootcamp> getAll() {
        return daoBootcamp.getAll();
    }

    public boolean update(int id, Bootcamp bootcamp) {
        return daoBootcamp.update(id, bootcamp);
    }

    public boolean delete(int id) {
        return daoBootcamp.delete(id);
    }

    public Bootcamp getBootcamp() {
        return bootcamp;
    }

    public void setBootcamp(String name, String description, int up) {
        this.bootcamp = new Bootcamp(name, description);
    }

    public int sizeMap() {
        return daoBootcamp.sizeMap();
    }
}
