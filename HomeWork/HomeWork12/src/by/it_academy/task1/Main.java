package by.it_academy.task1;

import by.it_academy.task1.Entity.Root;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import static by.it_academy.task1.URLConnector.connect;

public class Main {

    public static final String LINK = "http://kiparo.ru/t/test.json";

    public static void main(String[] args) throws IOException {
        File file = new File(URLConnector.connect(LINK));
        ObjectMapper mapper = new ObjectMapper();
        Root root = mapper.readValue(file, Root.class);
        System.out.println(root.toString());
    }

}
