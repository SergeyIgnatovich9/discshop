package org.example;

import java.util.List;

public interface IStorage {
    public void add(IDisk disc);

    public List<IDisk> getAllDisks();

    public IDisk getBy(String name);

    public List<IDisk> getAllBy(Type type);

    public List<IDisk> getAllBy(int rating);

    public boolean isExistedBy(Type type);

    public boolean isExistedBy(String name);

    abstract List<IDisk> getAllBy(String year) throws WrongParameterException;

}
