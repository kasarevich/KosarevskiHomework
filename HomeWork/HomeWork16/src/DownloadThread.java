import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class DownloadThread extends Thread {
    public static String nameXML = "customers.xml";
    public static String nameJSON = "customers.json";


    @Override
    public void run(){
        synchronized (this){

            System.out.println("Downloading XML");

            try {
                downloadFile("http://kiparo.ru/t/service_station.xml", nameXML);
            } catch (Exception e) {
                e.printStackTrace();
            }

            System.out.println("XML file was downloaded!");

           notify();

            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Downloading JSON");

            try {
                downloadFile("http://kiparo.ru/t/service_station.json", nameJSON);
            } catch (Exception e) {
                e.printStackTrace();
            }

            System.out.println("JSON file was downloaded!");

            notify();

            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Downloading and Parsing finished. Good Luck!");

        }
    }
    public void downloadFile(String link, String nameOfFile) throws Exception{
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
}
