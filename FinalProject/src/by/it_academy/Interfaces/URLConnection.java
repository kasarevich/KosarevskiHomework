package by.it_academy.Interfaces;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;

public interface URLConnection {
    public void downloadFile(String link) throws MalformedURLException, IOException, Exception;
}
