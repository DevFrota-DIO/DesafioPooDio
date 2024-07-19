package br.com.dio.controller.dao.dao;

import br.com.dio.controller.dao.IDao;
import br.com.dio.controller.dao.data.DataBootcamp;
import br.com.dio.controller.model.Course;
import java.util.List;
import static br.com.dio.controller.dao.data.DataCourses.*;

public class DaoCursos implements IDao<Course> {
    private final DataBootcamp dataBootcamp = new DataBootcamp();

    @Override
    public void add(Course course) {
        addCurso(course);
    }

    @Override
    public Course getById(int id) {
        return getCursoById(id);
    }

    @Override
    public List<Course> getAll() {
        return getAllCursos();
    }

    @Override
    public boolean update(int id, Course course) {
        return updateCurso(id, course);
    }

    @Override
    public boolean delete(int id) {
        return deleteCurso(id);
    }

    @Override
    public void startAutoData() {

    }

    @Override
    public int sizeMap() {
        return returnSizeMap();
    }
}
