package Commands;

import Interfaces.ICommand;
import Interfaces.IStorage;

import java.time.LocalDate;
import java.util.Scanner;

public class WriteCommand implements ICommand {
    private IStorage storage;
    public WriteCommand(IStorage storage){
        this.storage = storage;
    }
    @Override
    public void doCommand(){
        Scanner console = new Scanner(System.in);
        System.out.print("Введите ваши планы на сегодня: ");
        String argument = console.nextLine();
        if(!storage.add(LocalDate.now(), argument))
            System.out.println("Ошибка записи!");
    }
}
