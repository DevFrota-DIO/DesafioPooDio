package br.com.dio.controller;

import br.com.dio.controller.model.Bootcamp;
import br.com.dio.controller.services.ServiceDataBootcamp;

import java.util.List;

public class BootcampController implements IController<Bootcamp>{
    private final ServiceDataBootcamp serviceDataBootcamp;

    public BootcampController() {
        this.serviceDataBootcamp = new ServiceDataBootcamp();
    }

    public void setServiceData(){
    }

    @Override
    public Bootcamp create(String nome, String description, int up){
        serviceDataBootcamp.setBootcamp(nome, description, up);
        return serviceDataBootcamp.getBootcamp();
    }

    @Override
    public void add(Bootcamp bootcamp) {
        serviceDataBootcamp.add(bootcamp);
    }

    @Override
    public Bootcamp getById(int id) {
        return serviceDataBootcamp.getById(id);
    }

    @Override
    public List<Bootcamp> getAll() {
        return serviceDataBootcamp.getAll();
    }

    @Override
    public int update(int id, Bootcamp bootcamp) {
        boolean ok = serviceDataBootcamp.update(id, bootcamp);
        if (ok) return 1;
        return 0;
    }

    @Override
    public int delete(int id) {
        boolean ok = serviceDataBootcamp.delete(id);
        if (ok) return 1;
        return 0;
    }

    @Override
    public void startAutoData() {
        serviceDataBootcamp.setData();
    }

    @Override
    public int sizeMap() {
        return serviceDataBootcamp.sizeMap();
    }
}
