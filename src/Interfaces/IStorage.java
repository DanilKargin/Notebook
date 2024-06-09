package Interfaces;

import java.time.LocalDate;

public interface IStorage {
    boolean add(LocalDate localDate, String text);
    void loadData(String data);
    void saveData();
    String getAll();
}
