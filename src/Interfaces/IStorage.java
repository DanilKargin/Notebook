package Interfaces;

import java.time.LocalDate;

public interface IStorage {
    void add(LocalDate localDate, String text);
    int count();
    int numberSymbolsInContent();
    LocalDate getMostActiveDay();
    String getAll();
}
