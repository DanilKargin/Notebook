package Storage;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class RecordHashtable extends Hashtable<LocalDate, List<String>> {
    private int size = 0;
    public synchronized List<String> put(LocalDate k, String v) {
        size++;
        if(super.containsKey(k)){
            var list = super.get(k);
            list.add(v);
            return super.put(k, list);
        }else{
            List<String> list = new ArrayList<>();
            list.add(v);
            return super.put(k, list);
        }
    }
    public synchronized List<String> remove(LocalDate k, String v) {
        var list = super.get(k);
        if(list.remove(v)){
            size--;
        }
        return super.put(k, list);
    }
    @Override
    public synchronized void clear(){
        size = 0;
        super.clear();
    }
    @Override
    public synchronized int size(){
        return size;
    }
}
