import Commands.ReadCommand;
import Commands.WriteCommand;
import Interfaces.ICommand;
import Interfaces.IStorage;
import Storage.Notebook;

import java.util.Hashtable;

public class Singleton {
    private static Singleton Instance;
    private IStorage storage;
    private Hashtable<String, ICommand> commands;
    private Singleton(){
        storage = new Notebook();
        commands = new Hashtable<>();
        commands.put("#write", new WriteCommand(storage));
        commands.put("#read", new ReadCommand(storage));
    }
    public IStorage getStorage(){
        return storage;
    }
    public ICommand getCommand(String command){
        return commands.get(command);
    }
    public static Singleton getInstance(){
        if(Instance == null)
            Instance = new Singleton();
        return Instance;
    }
}
