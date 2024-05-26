package org.example;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, ParseException {

        IStorage storage = new Storage();
        fillStorage(storage);
        List<IDisk> films = storage.getAllBy(Type.Film);
        for (IDisk film : films) {
            System.out.println(film);
        }
        FileReader reader = new FileReader("src/main/resources/disk.json");
        JSONParser parser = new JSONParser();
        JSONObject jsonObject = (JSONObject) parser.parse(reader);
        String diskData = (String) jsonObject.get("type");
        System.out.println(diskData);
    }

    private static void fillStorage(IStorage storage) {
        storage.add(new Film(Type.Film, "The Gentleman",
                LocalDate.of(2001, 5, 5), 9));
        storage.add(new Film(Type.Film, "The Gentleman1",
                LocalDate.of(2002, 5, 5), 9));
        storage.add(new Film(Type.Film, "The Gentleman3",
                LocalDate.of(2003, 5, 5), 9));
        storage.add(new Film(Type.Film, "The Gentleman4",
                LocalDate.of(2004, 5, 5), 9));
        storage.add(new Film(Type.Film, "The Gentleman",
                LocalDate.of(2005, 5, 5), 9));
        storage.add(new Music(Type.Music, "System of a down",
                LocalDate.of(1990, 5, 5), 8));
        storage.add(new Music(Type.Music, "System of a down1",
                LocalDate.of(1991, 5, 5), 8));
        storage.add(new Music(Type.Music, "System of a down2",
                LocalDate.of(1992, 5, 5), 8));
        storage.add(new Music(Type.Music, "System of a down3",
                LocalDate.of(1993, 5, 5), 8));
        storage.add(new Music(Type.Music, "System of a down4",
                LocalDate.of(1994, 5, 5), 8));
        storage.add(new Program(Type.Program, "Office",
                LocalDate.of(2010, 5, 5), 7));
        storage.add(new Program(Type.Program, "Office1",
                LocalDate.of(2011, 5, 5), 7));
        storage.add(new Program(Type.Program, "Office2",
                LocalDate.of(2012, 5, 5), 7));
        storage.add(new Program(Type.Program, "Office3",
                LocalDate.of(2013, 5, 5), 7));
        storage.add(new Program(Type.Program, "Office4",
                LocalDate.of(2010, 5, 5), 7));
        storage.add(new Game(Type.Game, "Mafia",
                LocalDate.of(2020, 5, 5), 6));
        storage.add(new Game(Type.Game, "Mafia1",
                LocalDate.of(2021, 5, 5), 6));
        storage.add(new Game(Type.Game, "Mafia2",
                LocalDate.of(2022, 5, 5), 6));
        storage.add(new Game(Type.Game, "Mafia3",
                LocalDate.of(2023, 5, 5), 6));
        storage.add(new Game(Type.Game, "Mafia4",
                LocalDate.of(2024, 5, 5), 6));
    }
}