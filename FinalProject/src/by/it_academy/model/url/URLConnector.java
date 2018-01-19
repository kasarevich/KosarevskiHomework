package by.it_academy.model.url;

import by.it_academy.controller.interfaces.URLConnection;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.MalformedInputException;

public class URLConnector implements URLConnection{ // до вызова, после того, как определились, джисон или хмл, делаем сет.нэймоффайл
    private String nameOfFile;

    public URLConnector(String nameOfFile) {
        this.nameOfFile = nameOfFile;
    }

    @Override
    public void downloadFile(String link) throws MalformedInputException, IOException, Exception{
        URL url = new URL(link);
        HttpURLConnection httpURLConnection =
                (HttpURLConnection) url.openConnection();
        int responseCode = httpURLConnection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK){
            InputStream inputStream = httpURLConnection.getInputStream();
            File file = new File(nameOfFile);
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            int byteRead = -1;
            byte[] buffer = new byte[2048];
            while ((byteRead = inputStream.read(buffer)) != -1){
                fileOutputStream.write(buffer, 0, byteRead);
            }
        }else {
            throw new Exception("Данные не найдены, response code = " + responseCode);
        }

    }

    public String getNameOfFile() {
        return nameOfFile;
    }
}
