package org.example;

import java.time.LocalDate;

public class Program extends Disc implements IDisk {
    public Program(Type type, String name, LocalDate date, int rating) {
        super(type, name, date, rating);
    }
}
