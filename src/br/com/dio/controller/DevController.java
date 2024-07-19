package br.com.dio.controller;

import br.com.dio.controller.model.Dev;
import br.com.dio.controller.services.ServiceDataDev;
import java.util.List;

public class DevController implements IController<Dev>{
    ServiceDataDev serviceDataDev;

    public DevController() {
        this.serviceDataDev = new ServiceDataDev();
    }

    @Override
    public Dev create(String nome, String email, int up){
        serviceDataDev.setDev(nome, email, up);
        return serviceDataDev.getDev();
    }

    @Override
    public void add(Dev dev) {
        serviceDataDev.addDev(dev);
    }

    @Override
    public Dev getById(int id) {
        return serviceDataDev.getById(id);
    }

    @Override
    public List<Dev> getAll() {
        return serviceDataDev.getAll();
    }

    @Override
    public int update(int id, Dev dev) {
        boolean ok = serviceDataDev.update(id, dev);
        if (ok)return 1;
        return 0;
    }

    @Override
    public int delete(int id) {
        boolean ok = serviceDataDev.delete(id);
        if (ok)return 1;
        return 0;
    }

    @Override
    public void startAutoData() {

    }

    @Override
    public int sizeMap() {
        return serviceDataDev.sizeMap();
    }

}
