package Storage;

import Interfaces.IStorage;
import SaveSystem.FileSaveSystem;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class Notebook implements IStorage {
    protected RecordHashtable records;

    public Notebook(){
        records = new RecordHashtable();
        loadData(FileSaveSystem.loadData());
    }

    public boolean add(LocalDate localDate, String text){
        if(localDate != null && !text.isEmpty()){
            records.put(localDate, text);
            return true;
        }else
            return false;
    }
    public void loadData(String string){
            String[] stringArray = string.split(";");
            for (String item : stringArray) {
                String[] itemStringArray = item.split(" ", 2);
                if (itemStringArray.length == 2)
                    add(LocalDate.parse(itemStringArray[0]), itemStringArray[1]);
            }
    }

    public void saveData() {
        FileSaveSystem.saveData(getAll());
    }

    public String getAll(){
        StringBuilder result = new StringBuilder();
        for(Map.Entry<LocalDate, List<String>> entry : records.entrySet()){
            for(var item : entry.getValue()){
                result.append(entry.getKey());
                result.append(" ");
                result.append(item);
                result.append(";");
                result.append("\n");
            }
        }
        return result.toString();
    }
}
