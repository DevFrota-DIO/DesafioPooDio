package br.com.dio.controller.model;


import java.util.ArrayList;
import java.util.List;

public class Course {
    private int id = 0;
    private String name;
    private String description;
    List<Module> moduleList;
    private int workload;


    public Course(String name, String description, List<Module> modules) {
        this.description = description;
        this.name = name;
        this.moduleList = modules;
        setWorkload(3);
    }

    public Course(String name, String description) {
        this.description = description;
        this.name = name;
        this.moduleList = new ArrayList<>();
        setWorkload(3);
    }

    public void setId(int increment) {
        this.id += increment;
    }

    public int getId() {
        return this.id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double calcularXp() {
        return Content.XP_DEFAULT * workload;
    }

    public int getWorkload() {
        return this.workload;
    }

    public void setWorkload(int index) {
        int[] ArrayWorkload = {30, 60, 120, 240, 360} ;
        this.workload = ArrayWorkload[index];
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Module> getModuloList() {
        return moduleList;
    }

    public void setModuloList(List<Module> moduleList) {
        this.moduleList = moduleList;
    }

    public String sanitize(Course course) {
        if (course.getName() == null){
            return "Não há cursos cadastrados";
        }
        return course.getName();
    }

    @Override
    public String toString() {
        return "Curso - " + getName() +
                "\nId = " + getId() +
                "\nCargaHoraria = " + getWorkload() +
                ".";
    }

}
