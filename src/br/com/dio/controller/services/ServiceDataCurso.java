package br.com.dio.controller.services;

import br.com.dio.controller.dao.IDao;
import br.com.dio.controller.dao.dao.DaoCursos;
import br.com.dio.controller.model.Content;
import br.com.dio.controller.model.Course;
import java.util.List;

public class ServiceDataCurso {
    private Course course;
    Content atualContent;
    private final IDao<Course> daoCurso = new DaoCursos();


    public Content getAtualConteudo() {
        return atualContent;
    }

    public void setAtualConteudo(int index) {
        //this.atualConteudo = this.moduloList.get(index).getConteudo();
    }


    public String getConteudoTitulo(int index) {
        setAtualConteudo(index);
        return getAtualConteudo().getTitle();
    }

    public void setConteudoTitulo(int index, String titulo) {
        setAtualConteudo(index);
        getAtualConteudo().setTitle(titulo);
    }

    public String getConteudoDescricao(int index) {
        setAtualConteudo(index);
        return getAtualConteudo().getDescription();
    }

    public void setConteudoDescricao(int index, String descricao) {
        setAtualConteudo(index);
        getAtualConteudo().setDescription(descricao);
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(String name, String description, int up) {
        this.course = new Course(name, description);
        this.course.setId(sizeMap() - up);
    }

    public void add(Course course) {
        daoCurso.add(course);
    }

    public Course getById(int id) {
        return daoCurso.getById(id);
    }

    public List<Course> getAll() {
        return daoCurso.getAll();
    }

    public boolean update(int id, Course course) {
        return daoCurso.update(id, course);
    }

    public boolean delete(int id) {
        return daoCurso.delete(id);
    }

    public int sizeMap() {
        return daoCurso.sizeMap();
    }
}
