package org.example;

import java.time.LocalDate;

public class Game extends Disc implements IDisk {
    public Game(Type type, String name, LocalDate date, int rating) {
        super(type, name, date, rating);
    }
}
