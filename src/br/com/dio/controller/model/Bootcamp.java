package br.com.dio.controller.model;

import java.time.LocalDate;
import java.util.*;

public class Bootcamp {
    private int id = 0;
    private String name;
    private final String description;
    private List<Course> courses;
    private final LocalDate dataInicial = LocalDate.now();
    private final LocalDate dataFinal = dataInicial.plusDays(45);
    private List<Dev> devsInscritos = new ArrayList<>();

    public Bootcamp(String name, String description) {
        this.name = name;
        this.description = description;
        this.courses = new ArrayList<>();
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getDataInicial() {
        return dataInicial;
    }

    public LocalDate getDataFinal() {
        return dataFinal;
    }

    public List<Dev> getDevsInscritos() {
        return devsInscritos;
    }

    public void setDevsInscritos(List<Dev> devsInscritos) {
        this.devsInscritos = devsInscritos;
    }

    public List<Course> getCurso() {
        return courses;
    }

    public int getId() {
        return id;
    }

    public void setId(int increment) {
        this.id += increment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    @Override
    public int hashCode() {
        return Objects.hash(getCurso(), dataInicial, dataFinal);
    }



    @Override
    public String toString() {
        return "Bootcamp " + name +
                "\nid= " + getId() + "  - criado pelo sistema." +
                "\nDescrição= " + description +
                "\nData Inicial= " + dataInicial +
                "\nData Término= " + dataFinal +
                "\nQD de Devs Inscritos= " + devsInscritos.size() +
                ".";
    }
}
