import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        while(true){
            System.out.println("Введите комманду:");
            String command = console.nextLine();
            var classCommand = Singleton.getInstance().getCommand(command);
            if(classCommand != null){
                classCommand.doCommand();
            }
            if(command.equals("#exit")){
                break;
            }
        }
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                Singleton.getInstance().getStorage().saveData();
            }
        });
    }
}