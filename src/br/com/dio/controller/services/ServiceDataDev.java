package br.com.dio.controller.services;

import br.com.dio.controller.dao.IDao;
import br.com.dio.controller.dao.dao.DaoDevs;
import br.com.dio.controller.model.Course;
import br.com.dio.controller.model.Dev;

import java.util.List;
import java.util.Optional;

public class ServiceDataDev {
    private Dev dev;
    private final IDao<Dev> daoDev = new DaoDevs();

    public ServiceDataDev() {
    }

    public void progredir() {
        Optional<Course> curso = this.dev.getCursosInscritos().stream().findFirst();
        if(curso.isPresent()) {
            this.dev.getCursosConcluidos().add(curso.get());
            this.dev.getCursosInscritos().remove(curso.get());
        } else {
            System.err.println("Você não está matriculado em nenhum conteúdo!");
        }
    }

    public double calcularTotalXp() {
        return this.dev.getCursosConcluidos()
                .stream()
                .mapToDouble(Course::calcularXp)
                .sum();
    }

    public Dev getDev() {
        return dev;
    }

    public void setDev(String nome, String email, int up) {
        this.dev = new Dev(nome, email);
    }

    public void addDev(Dev dev) {
        daoDev.add(dev);
    }

    public Dev getById(int id) {
        return daoDev.getById(id);
    }

    public List<Dev> getAll() {
        return daoDev.getAll();
    }

    public boolean update(int id, Dev dev) {
        return daoDev.update(id, dev);
    }

    public boolean delete(int id) {
        return daoDev.delete(id);
    }


    public int sizeMap() {
        return daoDev.sizeMap();
    }
}
