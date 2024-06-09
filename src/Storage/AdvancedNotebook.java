package Storage;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class AdvancedNotebook extends Notebook{
    public AdvancedNotebook(){
        super();
    }
    public int count(){
        return super.records.size();
    }
    public int numberSymbolsInContent(){
        int count = 0;
        for(Map.Entry<LocalDate, List<String>> entry : super.records.entrySet()){
            for(var item : entry.getValue()){
                count += item.length();
            }
        }
        return count;
    }

    public LocalDate getMostActiveDay(){
        LocalDate date = null;
        int maxInt = 0;
        for(Map.Entry<LocalDate, List<String>> entry : super.records.entrySet()){
            if(entry.getValue().size() > maxInt){
                maxInt = entry.getValue().size();
                date = entry.getKey();
            }
        }
        return date;
    }
    public String getRecordsByDate(LocalDate date){
        List<String> records = super.records.get(date);
        StringBuilder sb = new StringBuilder();
        for(var item : records){
            sb.append(item);
            sb.append('\n');
        }
        return sb.toString();
    }
}
