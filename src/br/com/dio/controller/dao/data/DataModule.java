package br.com.dio.controller.dao.data;

import br.com.dio.controller.model.Module;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

import static br.com.dio.controller.dao.data.DataContent.generateContent;
import static br.com.dio.controller.dao.data.DataContent.getContentList;

public class DataModule {
    private static int sizeMap;
    private static Map<String, List<Module>> DATA_MODULE =  new HashMap<>();
    private static final ArrayList<String> INDICE = new ArrayList<>();
    private static final List<Module> NEW_MODULE_LIST = new ArrayList<>();


    static void generateModules(String name, String description) {
        generateContent(name, description);
            Module module = new Module(name, description );
            module.setContentList(getContentList());
            setNewModuleList(module);

    }

    public static Map<String, List<Module>> getDataModule() {
        return DATA_MODULE;
    }

    public static void setDataModule(String name, List<Module> dataModule) {
        DATA_MODULE.put(name, dataModule);
    }

    public static List<Module> getNewModuleList() {
        return NEW_MODULE_LIST;
    }

    public static void setNewModuleList(Module module) {
        NEW_MODULE_LIST.add(module);
        setDataModule(module.getName(), getNewModuleList());
    }

    public static int getSizeMap() {
        return sizeMap;
    }

    public static void setSizeMap() {
        DataModule.sizeMap = getContentList().size();
    }

    public static void addModule(Module module) {
        setSizeMap();
        module.setId(getSizeMap());
        AtomicBoolean ok = new AtomicBoolean(true);
        DATA_MODULE.forEach((s, modules) -> {
            if (s.equals(module.getName())){
                ok.set(false);
                System.out.println("Objeto já existente");
                System.out.println("Atualize ou crie um novo.");
            }
        });

        if (ok.get()) {
            INDICE.add(module.getId(), module.getName());
            setNewModuleList(module);
        }

    }


    public static Module getModuleById(int id) {
                    return DATA_MODULE.get(INDICE.get(id)).get(id);

    }

    public static ArrayList<String> getAllModules() {
        return INDICE;
    }

    public static void updateModule(int id, Module module) {
        setNewModuleList(module);
        DATA_MODULE.put(module.getName(), getNewModuleList());
    }

    public static void deleteModule(int id) {
        DATA_MODULE.remove(id);
    }
}
