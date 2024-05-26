package org.example;

import java.time.LocalDate;

public class Film extends Disc implements IDisk {
    public Film(Type type, String name, LocalDate date, int rating) {
        super(type, name, date, rating);
    }
}
