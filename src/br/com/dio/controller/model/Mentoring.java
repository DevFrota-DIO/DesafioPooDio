package br.com.dio.controller.model;

import java.time.LocalDate;

public class Mentoring extends Content {
    private String name;
    private String description;
    private Mentor mentor;
    private LocalDate date;

    @Override
    public double calcXp() {
        return XP_DEFAULT + 20d;
    }

    public Mentoring() {
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Mentor getMentor() {
        return mentor;
    }

    public void setMentor(Mentor mentor) {
        this.mentor = mentor;
    }

    @Override
    public String toString() {
        return "Mentoria{" +
                "titulo='" + getTitle() + '\'' +
                ", descricao='" + getDescription() + '\'' +
                ", data=" + date +
                '}';
    }
}
