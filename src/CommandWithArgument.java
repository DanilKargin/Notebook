import Interfaces.ICommand;

public abstract class CommandWithArgument implements ICommand {
    protected String command;
    public boolean checkCommand(String command){
        if(this.command.equals(command)){
            return true;
        }else{
            return false;
        }
    }
    abstract void doCommand(String argument);
}
