package org.example;

import java.time.LocalDate;

public abstract class Disc implements IDisk {
    private Type type;
    private String name;
    private LocalDate date;
    private int rating;

    public Disc(Type type, String name, LocalDate date, int rating) {
        this.type = type;
        this.name = name;
        this.date = date;
        this.rating = rating;
    }

    public Type getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getRating() {
        return rating;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String toString() {
        return "{" + " Type: " + type + "." +
                " Name: " + name + "." +
                " Date: " + date + "." +
                " Rating: " + rating + "." + " }";
    }
}
