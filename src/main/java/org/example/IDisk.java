package org.example;

import java.time.LocalDate;

public interface IDisk {

    Type getType();

    String getName();

    LocalDate getDate();

    int getRating();

}
