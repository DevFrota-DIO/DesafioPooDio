package br.com.dio.controller.dao.data;

import br.com.dio.controller.model.Course;
import br.com.dio.controller.model.Dev;
import java.util.*;

public class DataDevs {
    private static int sizeMap;
    private static final List<Dev> DATA_DEVS = new ArrayList<>();

    static void generateDevs() {
        List<String> nomes = Arrays.asList("Dev1", "Dev2", "Dev3", "Dev4", "Dev5");
        List<String> emails = Arrays.asList("dev1@example.com", "dev2@example.com", "dev3@example.com", "dev4@example.com", "dev5@example.com");

        for (int i = 0; i < nomes.size(); i++) {
            Dev dev = new Dev(nomes.get(i), emails.get(i));
            dev.setId(i);
            DATA_DEVS.add(i,dev);
        }
    }

    public static List<Dev> getDataDevs() {
        return DATA_DEVS;
    }

    public static int getSizeMap() {
        return sizeMap;
    }

    public static void setSizeMap() {
        DataDevs.sizeMap = getDataDevs().size();
    }

    public static void addDev(Dev dev) {
        setSizeMap();
        dev.setId(getSizeMap());
        DATA_DEVS.add(dev.getId(), dev);
    }

    public static Dev getDevById(int id) {
        return DATA_DEVS.get(id);
    }

    public static List<Dev> getAllDevs() {
        return DATA_DEVS;
    }

    public static boolean updateDev(int id, Dev dev) {
        if (ifExists(id)) {
            DATA_DEVS.add(id, dev);
            return true;
        }
        return false;
    }

    public static boolean deleteDev(int id) {
        if (ifExists(id)) {
            DATA_DEVS.remove(id);
            return true;
        }
        return false;
    }

    public static int returnSizeMap(){
        setSizeMap();
        return getSizeMap();
    }

    private static boolean ifExists(int id) {
        for (Dev dev : DATA_DEVS){
            if (dev.getId() == id){
                return true;
            }
        }
        return false;
    }
}
