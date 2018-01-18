import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class DownloadThread extends Thread {
    public static String nameXML = "customers.xml";
    public static String nameJSON = "customers.json";


    @Override
    public void run(){

            System.out.println("Downloading XML");

            try {
                downloadFile("http://kiparo.ru/t/service_station.xml", nameXML);    // скачиваем XML
            } catch (Exception e) {
                e.printStackTrace();
            }

            System.out.println("XML file was downloaded!");
            ParsingThread.changeReady();                        // меняем флаг готовности на true
            synchronized (this) {
                this.notifyAll();                               // будим парсер
            }
            synchronized (this) {
                try {                                           // сами ожидаем, пока парсер распарсит XML
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println("Downloading JSON");             // нас разбудили, качаем JSON

            try {
                downloadFile("http://kiparo.ru/t/service_station.json", nameJSON);
            } catch (Exception e) {
                e.printStackTrace();
            }

            System.out.println("JSON file was downloaded!");
            ParsingThread.changeReady();                       // устанавливаем флаг готовности в true
            synchronized (this) {
                this.notifyAll();                              // будим парсер
            }
            synchronized (this) {
                try {
                    this.wait();                               // сами ожидаем, пока он распарсит
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Downloading and Parsing finished. Good Luck!"); // нас разбудили, сообщаем о том, что все прошло успешно, поток завершается

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
