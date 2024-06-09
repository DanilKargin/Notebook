package Commands;

import Interfaces.ICommand;
import Interfaces.IStorage;
import Storage.AdvancedNotebook;

public class StatisticCommand implements ICommand {
    private IStorage storage;

    public StatisticCommand(IStorage storage){
        this.storage = storage;
    }
    @Override
    public void doCommand() {
        try{
            System.out.println("Количество записей: " + ((AdvancedNotebook) storage).count());
            System.out.println("Количество символов в контенте: " + ((AdvancedNotebook) storage).numberSymbolsInContent());
            System.out.println("Самый активный день по записям: " + ((AdvancedNotebook) storage).getMostActiveDay());
        }catch(Exception e){
            System.out.println("Ошибка воспроизведения статистики: " + e.getMessage());
        }
    }
}
