import com.google.gson.Gson;
import entity.Station;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.MalformedInputException;
import java.text.ParseException;

public class App {
    final static String NameOfFile = "test.json";
    final static String LINK = "http://kiparo.ru/t/service_station.json";
    public static void main(String[] args) {
        try {
            downloadFile();
            Station station = parse();
            System.out.println(station.toString());
        }catch (MalformedInputException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }catch (SAXException e){
            e.printStackTrace();
        } catch (ParseException e){
            e.printStackTrace();
        }catch (ParserConfigurationException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public static Station parse() throws ParserConfigurationException, IOException, SAXException, ParseException{
        Gson gson = new Gson();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(NameOfFile));
        Station station = gson.fromJson(bufferedReader, Station.class);


        return station;
    }



    public static void downloadFile() throws MalformedInputException, IOException, Exception{
        URL url = new URL(LINK);
        HttpURLConnection httpURLConnection =
                (HttpURLConnection) url.openConnection();
        int responseCode = httpURLConnection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK){
            InputStream inputStream = httpURLConnection.getInputStream();
            File file = new File(NameOfFile);
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

