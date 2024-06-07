package Storage;

import Interfaces.IStorage;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class Notebook implements IStorage {
    private RecordHashtable records;

    public Notebook(){
        records = new RecordHashtable();
    }
    public void add(LocalDate localDate, String text){
        if(localDate != null && !text.isEmpty()){
            records.put(localDate, text);
        }
    }
    public int count(){
        return records.size();
    }
    public int numberSymbolsInContent(){
        int count = 0;
        for(Map.Entry<LocalDate, List<String>> entry : records.entrySet()){
            for(var item : entry.getValue()){
                count += item.length();
            }
        }
        return count;
    }

    public LocalDate getMostActiveDay(){
        LocalDate date = null;
        int maxInt = 0;
        for(Map.Entry<LocalDate, List<String>> entry : records.entrySet()){
            if(entry.getValue().size() > maxInt){
                maxInt = entry.getValue().size();
                date = entry.getKey();
            }
        }
        return date;
    }

    public String getAll(){
        StringBuilder result = new StringBuilder();
        for(Map.Entry<LocalDate, List<String>> entry : records.entrySet()){
            for(var item : entry.getValue()){
                result.append(entry.getKey());
                result.append(item);
                result.append('\n');
            }
        }
        return result.toString();
    }
}
