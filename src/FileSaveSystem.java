import Interfaces.ISaveSystem;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileSaveSystem implements ISaveSystem {

    @Override
    public void SaveData(String data) {
        try {
            File myFile = new File("data.txt");
            FileOutputStream outputStream = new FileOutputStream(myFile);
            byte[] buffer = data.getBytes();
            outputStream.write(buffer);
            outputStream.close();
        }catch (IOException e){
            System.out.println("Ошибка сохранения: " + e.getMessage());
        }
    }

    @Override
    public String LoadData() {
        try {
            File myFile = new File("data.txt");
            FileInputStream inputStream = new FileInputStream(myFile);
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
        }
    }
}
