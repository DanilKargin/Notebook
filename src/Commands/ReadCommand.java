package Commands;

import Interfaces.ICommand;
import Interfaces.IStorage;

public class ReadCommand implements ICommand {
    private IStorage storage;

    public ReadCommand(IStorage storage){
        this.storage = storage;
    }
    @Override
    public void doCommand() {
        System.out.println(storage.getAll());
    }
}
