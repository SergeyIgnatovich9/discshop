package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Storage implements IStorage {

    private final List<IDisk> allDisks;
    public List<IDisk> testDisks;

    public Storage() {
        allDisks = new ArrayList<>();
    }

    @Override
    public void add(IDisk disk) {
        allDisks.add(disk);
    }

    @Override
    public List<IDisk> getAllDisks() {
        return allDisks;
    }

    @Override
    public IDisk getBy(String name) {
        return allDisks.stream().filter(disk -> disk.getName().equals(name)).findFirst().get();
    }

    @Override
    public List<IDisk> getAllBy(Type type) {
        return allDisks.stream().filter(disk -> disk.getType().equals(type)).collect(Collectors.toList());
    }

    @Override
    public List<IDisk> getAllBy(int rating) {
        return allDisks.stream().filter(disk -> disk.getRating() >= (rating)).collect(Collectors.toList());
    }

    @Override
    public boolean isExistedBy(Type type) {
        return allDisks.stream().anyMatch(disk -> disk.getType().equals(type));
    }

    @Override
    public boolean isExistedBy(String name) {
        return allDisks.stream().anyMatch(disk -> disk.getName().equals(name));
    }

    @Override
    public List<IDisk> getAllBy(String year) throws WrongParameterException {
        List<IDisk> results = allDisks.stream().filter(disk -> disk.getDate().getYear() >= Integer.parseInt(year)).toList();
        if (results.isEmpty()) {
            throw new WrongParameterException();
        }
        return results;
    }
}
