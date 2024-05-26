package org.example;

import java.time.LocalDate;

public class Music extends Disc implements IDisk {
    public Music(Type type, String name, LocalDate date, int rating) {
        super(type, name, date, rating);
    }
}
