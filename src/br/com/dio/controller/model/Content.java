package br.com.dio.controller.model;

public class Content {

    protected static final double XP_DEFAULT = 10d;
    private int id = 0;
    private String title;
    private String description;

    public Content(String title, String description) {
        setId();
        this.title = title;
        this.description = description;
    }

    public Content() {

    }

    public int getId() {
        return id;
    }

    public void setId() {
        this.id = id++;
    }

    public double calcXp() {
        return 0;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Conteúdo" +
                "\nId= " + id +
                "\nTitulo= " + title +
                "\nDescription= " + description +
                ".";
    }
}
