package SaveSystem;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileSaveSystem {
    private final static String PATH = "data.txt";
    public static void saveData(String data) {
        FileOutputStream outputStream = null;
        try{
            File myFile = new File(PATH);
            outputStream = new FileOutputStream(myFile);
            byte[] buffer = data.getBytes();
            outputStream.write(buffer);
            outputStream.close();
        }catch (IOException e){
            System.out.println("Ошибка сохранения: " + e.getMessage());
        }finally {

        }
    }

    public static String loadData() {
        FileInputStream inputStream = null;
        try{
            File myFile = new File(PATH);
            inputStream = new FileInputStream(myFile);
            byte[] buffer = new byte[1024];
            int bytesRead;
            StringBuilder result = new StringBuilder();
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                result.append(new String(buffer, 0, bytesRead));
            }
            inputStream.close();
            return result.toString();
        }catch(IOException e){
            System.out.println("Ошибка загрузки: " + e.getMessage());
            return "";
        }finally {

        }
    }
}
