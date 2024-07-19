package br.com.dio.controller.model;

import java.util.*;

public class Dev {
    private int id = 0;
    private String name;
    private String email;
    private List<Course> cursosInscritos = new ArrayList<>();
    private List<Course> cursosConcluidos = new ArrayList<>();

    public Dev(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public List<Course> getCursosInscritos() {
        return this.cursosInscritos;
    }

    public void setCursosInscritos(List<Course> cursosInscritos) {
        this.cursosInscritos = cursosInscritos;
    }

    public List<Course> getCursosConcluidos() {
        return this.cursosConcluidos;
    }

    public void setCursosConcluidos(List<Course> cursosConcluidos) {
        this.cursosConcluidos = cursosConcluidos;
    }

    public String getEmail() {
        return this.email;
    }

    public int getId() {
        return this.id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setId(int increment) {
        this.id += increment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dev dev = (Dev) o;
        return Objects.equals(name, dev.name) && Objects.equals(email, dev.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email);
    }

    @Override
    public String toString() {
        return "Dev " + getName() +
                "\nId= " + getId() +
                "\nE-mail= " + getEmail() + '\'' +
                "\nCursos Inscritos=" + getCursosInscritos() +
                "\nCursos Concluidos=" + getCursosConcluidos() +
                ".";
    }
}
