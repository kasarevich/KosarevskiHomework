package by.it_academy;

import java.io.IOException;

import static by.it_academy.URLConnecter.connect;

public class Main {
    public static void main(String [] args){
        final String LINK = "http://kiparo.ru/t/test.xml";
        String nameOfFile = new String(connect(LINK));

    }
}
