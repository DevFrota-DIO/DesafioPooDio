package br.com.dio.controller.model;

import java.util.List;

public class Module {
    private int id = 0;
    private String name;
    private String description;
    private List<Content> contentList;

    public Module(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id += id;
    }

    public List<Content> getContentList() {
        return contentList;
    }

    public void setContentList(List<Content> list) {
        this.contentList = list;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
