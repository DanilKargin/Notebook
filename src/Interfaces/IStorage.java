package Interfaces;

import java.time.LocalDate;

public interface IStorage {
    void add(LocalDate localDate, String text);
    void loadData(String data);
    String getAll();
}
