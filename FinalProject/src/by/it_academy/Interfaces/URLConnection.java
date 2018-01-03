package by.it_academy.interfaces;

import java.io.IOException;
import java.net.MalformedURLException;

public interface URLConnection {
    public void downloadFile(String link) throws MalformedURLException, IOException, Exception;
}
