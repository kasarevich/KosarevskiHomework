package by.it_academy.task1;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class URLConnector {
    public static String connect(String LINK) {
        InputStream inputStream = null;
        FileOutputStream fileOutputStream = null;
        String nameOfFile = new String("hw12.json");
        try {

            URL url = new URL(LINK);
            HttpURLConnection httpURLConnection =
                    (HttpURLConnection) url.openConnection();
            int responseCode = httpURLConnection.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {
                inputStream = httpURLConnection.getInputStream();
                File file = new File(nameOfFile);
                fileOutputStream = new FileOutputStream(file);

                int byteRead = -1; // к-во полезных байт в буффере. он может не весь заполняться
                byte[] buffer = new byte[2048];
                while ((byteRead = inputStream.read(buffer)) != -1) {
                    fileOutputStream.write(buffer, 0, byteRead);
                }

            } else {
                System.out.println("Данные не найдены, responseCode = " + responseCode);
            }


        } catch (Exception e) {
            System.out.println("Невозможно скачать файл");
        } finally {

            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e) {
                        System.out.println(e.getMessage());
                    }
                }
            }
        }
        return nameOfFile;
    }
}
