package br.com.dio.controller.dao.data;

import br.com.dio.controller.model.Mentor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataMentor {
        private static final ArrayList<String> INDICE = new ArrayList<>();
        private static final List<Mentor> DATA_MENTOR = new ArrayList<>();

        static void generateMentors() {
                List<String> names = Arrays.asList(
                        "Cláudio Sampaio",
                        "William Nunes",
                        "Telma Louise",
                        "Andréia Tavares",
                        "Nilton Seixas",
                        "Helena de Tróia",
                        "Wilson Gadelha",
                        "Abraão Amorin",
                        "Teuto Soares",
                        "Levington Gomes");
                for (int i = 0; i < names.size(); i++) {
                        setDataMentor(new Mentor(names.get(i), names.get(i)+"@gmail.com"));

                }

        }

        public static List<Mentor> getDataMentor() {
                return DATA_MENTOR;
        }

        public static void setDataMentor(Mentor mentor) {
                DataMentor.DATA_MENTOR.add(mentor);
        }


        public static void addMentor(Mentor mentor) {
                int index = mentor.getId();
                boolean ok = true;
                for (int i = 0; i < DATA_MENTOR.size(); i++) {
                                if (DATA_MENTOR.get(i).getName().equals(mentor.getName())) {
                                        ok = false;
                                        break;
                                }

                }
                if (ok) {
                        INDICE.add(mentor.getName());
                        setDataMentor(mentor);
                }

        }


        public static Mentor getMentorById(int id) {
                return DATA_MENTOR.get(id);
        }

        public static List<Mentor> getAllMentors() {
                return DATA_MENTOR;
        }

        public static void updateMentor(int id, Mentor mentor) {
                DATA_MENTOR.set(id, mentor);
        }

        public static void deleteMentor(int id) {
                DATA_MENTOR.remove(id);
        }
}
