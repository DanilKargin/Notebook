package Storage;

import Interfaces.IStorage;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class Notebook implements IStorage {
    protected RecordHashtable records;

    public Notebook(){
        records = new RecordHashtable();
    }
    public void add(LocalDate localDate, String text){
        if(localDate != null && !text.isEmpty()){
            records.put(localDate, text);
        }
    }
    public void loadData(String string){
        String[] stringArray = string.split("\n");
        for(String item : stringArray){
            String[] itemStringArray = item.split(" ");
            if(itemStringArray.length == 2)
                add(LocalDate.parse(itemStringArray[0]), itemStringArray[1]);
        }
    }
    public String getAll(){
        StringBuilder result = new StringBuilder();
        for(Map.Entry<LocalDate, List<String>> entry : records.entrySet()){
            for(var item : entry.getValue()){
                result.append(entry.getKey());
                result.append(" ");
                result.append(item);
                result.append('\n');
            }
        }
        return result.toString();
    }
}
