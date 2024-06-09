package Commands;

import Interfaces.ICommand;
import Interfaces.IStorage;
import Storage.AdvancedNotebook;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class FindCommand implements ICommand {
    private IStorage storage;

    public FindCommand(IStorage storage){
        this.storage = storage;
    }
    @Override
    public void doCommand() {
        try {
            Scanner console = new Scanner(System.in);
            System.out.print("Введите дату(YYYY-mm-DD): ");
            LocalDate date = LocalDate.parse(console.nextLine());
            String records = ((AdvancedNotebook) storage).getRecordsByDate(date);
            if(records.isEmpty()){
               System.out.printf("Записей по дате %d не обнаружено", date);
            }else{
                System.out.println(records);
            }
        }catch(DateTimeParseException e){
            System.out.println(e.getMessage());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
