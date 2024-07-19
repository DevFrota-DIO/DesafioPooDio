package br.com.dio.controller.dao.data;

import br.com.dio.controller.model.Content;

import java.util.*;

public class DataContent {
    private static final Map<String, List<Content>> DATA_CONTENT = new HashMap<>();
    private static Map<Integer, String> INDICE = new HashMap<>();
    private static final List<Content> CONTENT_LIST = new ArrayList<>();


    static void generateContent(String name, String description) {
        String title = "Conteudo - ";
        description = "Descrição do Conteúdo: \n" + description;
        for (int i = 0; i < 10; i++) {
            setContentList(i, new Content(title + i + " - " + name, description));

        }
        DATA_CONTENT.put(name, getContentList());
    }

    public static List<Content> getContentList() {
        return CONTENT_LIST;
    }

    public static void setContentList(int id, Content content) {
        CONTENT_LIST.add(id, content);
    }

    public static void addContent(Content content) {
        int index = content.getId();
        boolean ok = false;
        for (int i = 0; i < DATA_CONTENT.size(); i++) {
            for (int j = 0; j < DATA_CONTENT.get(content.getTitle()).size(); j++) {
                if (DATA_CONTENT.get(content.getTitle()).get(j).getTitle().equalsIgnoreCase(content.getTitle())) {
                    DATA_CONTENT.get(content.getTitle()).add(content.getId(),content);
                    ok = true;
                    break;

                }
            }
            if (ok) break;
        }
        if (!ok) {
            INDICE.put(content.getId(), content.getTitle());
            setContentList(content.getId(), content);
            DATA_CONTENT.put(content.getTitle(), getContentList());
        }

    }


    public static List<Content> getContentById(int id) {
                return DATA_CONTENT.get(INDICE.get(id));
    }

    public static Map<String, List<Content>> getAllContents() {
        return DATA_CONTENT;
    }

    public static void updateContent(String name, List<Content> content) {
        DATA_CONTENT.put(name, content);
    }

    public static void deleteContent(int id) {
        DATA_CONTENT.forEach((s, contents) -> {
            DATA_CONTENT.remove(contents.get(id).getTitle());
        });

    }
}
