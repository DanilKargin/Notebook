import java.time.LocalDate;

public class Record {
    private LocalDate createDate;
    private String recordText;

    public Record(LocalDate createDate, String recordText){
        this.createDate = createDate;
        this.recordText = recordText;
    }
    public LocalDate getCreateDate(){
        return createDate;
    }
    public String getRecordText(){
        return recordText;
    }
    @Override
    public String toString(){
        return createDate + " | " + recordText;
    }
}
