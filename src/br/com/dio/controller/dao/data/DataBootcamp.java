package br.com.dio.controller.dao.data;

import br.com.dio.controller.model.Bootcamp;
import br.com.dio.controller.model.Course;
import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

import static br.com.dio.controller.dao.data.DataModule.generateModules;
import static br.com.dio.controller.dao.data.DataModule.getNewModuleList;

public class DataBootcamp extends DataCourses {
    private static final Map<Integer, Bootcamp> DATA_BOOTCAMP = new HashMap<>();
    private static int sizeMap;

    private static void createAutoData() {

        List<String> courseName = Arrays.asList("Java Development", "Web Development", "Python Programming",
                "Data Science Fundamentals", "Mobile App Development", "Machine Learning Mastery",
                "Cybersecurity Essentials", "Cloud Computing Basics", "Blockchain Fundamentals", "DevOps Essentials");

        List<String> descricoes = Arrays.asList(
                "Aprenda a desenvolver aplicativos Java",
                "Curso completo de desenvolvimento web",
                "Aprenda Python do básico ao avançado",
                "Introdução aos fundamentos de ciência de dados",
                "Desenvolvimento de aplicativos móveis para iOS e Android",
                "Domine técnicas de aprendizado de máquina",
                "Curso essencial de segurança cibernética",
                "Fundamentos de computação em nuvem",
                "Introdução aos fundamentos da tecnologia blockchain",
                "Princípios essenciais de DevOps e automação");

        System.out.println("Criando lista de cursos");
        generateDevs();
        for (int i = 0; i < courseName.size(); i++) {
            String nome = courseName.get(i);
            String uname = extractName(nome);
            String description = descricoes.get(i);
            generateModules(uname, description);
            Course course = new Course(uname, description, getNewModuleList());
            course.setId(i);
            setDataCourses(course);
            Bootcamp bootcamp = new Bootcamp(nome, description);
            bootcamp.setDevsInscritos(getDataDevs());
            bootcamp.setCourses(getDataCourses());
            addBootcamp(bootcamp);
        }

    }


    private static String extractName(String nome) {
        String[] newnome = nome.split(",");
        for (int i = 0; i < newnome.length; i++) {
            if(Objects.equals(newnome[i], "")){
                nome = nome.substring(0 , i);
            }
        }
        return nome;

    }


    public static int getSizeMap() {
        return sizeMap;
    }

    public static void setSizeMap() {
        sizeMap = getDataBootcamp().size();
    }

    public static void startAutoDataBootcamp(){
        createAutoData();
    }

    public static Map<Integer, Bootcamp> getDataBootcamp() {
        return DATA_BOOTCAMP;
    }

    private static List<Bootcamp> createList(){
        return new ArrayList<>(DATA_BOOTCAMP.values());
    }

    public static void addBootcamp(Bootcamp bootcamp) {
        setSizeMap();
        bootcamp.setId(getSizeMap());
        DATA_BOOTCAMP.put(bootcamp.getId(), bootcamp);
    }

    public static Bootcamp getBootcampById(int id) {
        return DATA_BOOTCAMP.get(id);
    }

    public static List<Bootcamp> getAllBootcamps() {
        return new ArrayList<>(DATA_BOOTCAMP.values());
    }

    public static boolean updateBootcamp(int id, Bootcamp bootcamp) {
        if (ifExists(id)) {
            DATA_BOOTCAMP.replace(id, bootcamp);
            return true;
        }

        return false;
    }

    public static boolean deleteBootcamp(int id) {
        if (ifExists(id)) {
            DATA_BOOTCAMP.remove(id);
            return true;
        }
        return false;
    }

    public static int returnSizeMap() {
        setSizeMap();
        return getSizeMap();
    }

    private static boolean ifExists(int id) {
        AtomicBoolean b = new AtomicBoolean(false);
        DATA_BOOTCAMP.forEach((oldId, bootcamp) -> {
            if (oldId == id) {
                b.set(true);
            }
        });
        return b.get();
    }
}




