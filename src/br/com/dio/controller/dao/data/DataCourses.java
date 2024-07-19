package br.com.dio.controller.dao.data;

import br.com.dio.controller.model.Course;
import java.util.*;

public class DataCourses extends DataDevs{
    private static int sizeMap;
    private static final List<Course> DATA_COURSES = new ArrayList<>();


    static void setDataCourses(Course course) {
        DATA_COURSES.add(course.getId(), course);
    }

    public static List<Course> getDataCourses() {
        return DATA_COURSES;
    }

    public static int getSizeMap() {
        return sizeMap;
    }

    public static void setSizeMap() {
        sizeMap = 0;
        sizeMap = getDataCourses().size();
    }

    public static void addCurso(Course course) {
        setSizeMap();
        DATA_COURSES.add(getSizeMap(), course);
    }

    public static Course getCursoById(int id) {
        return DATA_COURSES.get(id);
    }

    public static List<Course> getAllCursos() {
        return DATA_COURSES;
    }

    public static boolean updateCurso(int id, Course course) {
        if (ifExists(id)) {
            DATA_COURSES.add(id, course);
            return true;
        }
        return false;
    }



    public static boolean deleteCurso(int id) {
        if (ifExists(id)) {
            DATA_COURSES.remove(id);
            return true;
        }
        return false;
    }

    public static int returnSizeMap(){
        setSizeMap();
        return getSizeMap();
    }

    private static boolean ifExists(int id) {
        for (Course activeCourse : DATA_COURSES){
            if (activeCourse.getId() == id){
                return true;
            }
        }
        return false;
    }
}
