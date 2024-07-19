package br.com.dio.controller;

import br.com.dio.controller.model.Course;
import br.com.dio.controller.services.ServiceDataCurso;
import java.util.List;

public class CourseController implements IController<Course>{
    ServiceDataCurso serviceDataCurso;

    public CourseController() {
        this.serviceDataCurso = new ServiceDataCurso();
    }

    @Override
    public Course create(String name, String description, int up){
        serviceDataCurso.setCourse(name, description, up);
        return serviceDataCurso.getCourse();
    }

    @Override
    public void add(Course course) {
        serviceDataCurso.add(course);
    }

    @Override
    public Course getById(int id) {
        return serviceDataCurso.getById(id);
    }

    @Override
    public List<Course> getAll() {
        return serviceDataCurso.getAll();
    }

    @Override
    public int update(int id, Course course) {
        boolean ok = serviceDataCurso.update(id, course);
        if (ok) return 1;
        return 0;
    }

    @Override
    public int delete(int id) {
        boolean ok = serviceDataCurso.delete(id);
        if (ok)return 1;
        return 0;
    }

    @Override
    public void startAutoData() {

    }

    @Override
    public int sizeMap() {
        return serviceDataCurso.sizeMap();
    }


}
