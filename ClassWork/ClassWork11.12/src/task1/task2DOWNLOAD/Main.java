package task1.task2DOWNLOAD;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import task1.task2DOWNLOAD.Entity.DateGsonConverter;
import task1.task2DOWNLOAD.Entity.People;
import task1.task2DOWNLOAD.Entity.Root;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    private static final String LINK = "http://kiparo.ru/t/test.json";
    public static void main(String [] args){

        InputStream inputStream = null;
        FileOutputStream fileOutputStream = null;

        try{

            URL url = new URL(LINK);
            HttpURLConnection httpURLConnection =
                    (HttpURLConnection)url.openConnection();
            int responseCode = httpURLConnection.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {
                inputStream = httpURLConnection.getInputStream();
                File file = new File("test.json");
                fileOutputStream = new FileOutputStream(file);

                int byteRead = -1; // к-во полезных байт в буффере. он может не весь заполняться
                byte[] buffer = new byte[2048];
                while ((byteRead = inputStream.read(buffer))!=-1){
                    fileOutputStream.write(buffer, 0, byteRead);
                }
                //parseXml();
                //parseJson();
                parseGson();

            }else{
                System.out.println("Данные не найдены, responseCode = " + responseCode);
            }


        }catch (Exception e){
            System.out.println("Невозможно скачать файл");
        }finally {
            if(inputStream != null){
                try{
                inputStream.close();
                }catch (IOException e){
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
    }

    public static void parseXml(){

        Document dom; // w3c
        try{
            //Открываем хml
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = dbf.newDocumentBuilder();
            dom = builder.parse("test.xml");

        }catch (Exception e){
            System.out.println("Невозможно открыть документ" + e.toString());
            return;
    }
        // Наш объект, который мы заполним данными из xml
        Root root = new Root();
        // Parsing xml
        // Получаем первый, главный элемент из файла

        Element rootElement = dom.getDocumentElement();//w3c
        System.out.println("root tag.name = " + rootElement.getTagName());

        // Получаем элемент по названию, в данном случае вытягиваем tag name
        NodeList nameNodeList = rootElement.getElementsByTagName("name");

        //Так как в тэге может быть много других тэгов, мы изначально получаем массив
        // Так как мы знаем, что нет содержимого в пame, берем первый элемент

        Node nameNode = nameNodeList.item(0);
        System.out.println("name tag.name = " + nameNode.getNodeName());

        String nameFile = nameNode.getTextContent();

        System.out.println("content tag.name = " + nameNode.getTextContent());

        //Заполняем наш объект root
        root.setName(nameFile);


        // Parsing people

        // Получаем элемент по названию, в данном случае вытягиваем tag people
        NodeList people = rootElement.getElementsByTagName("people");
        Node peopleNode = people.item(0);

        // Получаем из тега все содержимое, т.е. массив элементов element
        // Один элемент из elementsNodeList - это один тег элемент
        NodeList elementsNodeList = peopleNode.getChildNodes();

        List<People> peoples = new ArrayList<>();
        for (int i = 0; i< elementsNodeList.getLength(); i++){
            // снова получаем нод
            Node node = elementsNodeList.item(i);
            if(node.getNodeType() != Node.ELEMENT_NODE){
                continue;
            }
           Element element = (Element)node;
            //вытягиваем остальные поля.

            String name = element.getElementsByTagName("name").item(0).getTextContent();
            System.out.println(name);
            String surname = element.getElementsByTagName("surname").item(0).getTextContent();
            System.out.println(surname);
            int id = Integer.parseInt(element.getElementsByTagName("id").item(0).getTextContent());
            System.out.println(id);
            int age = Integer.parseInt(element.getElementsByTagName("age").item(0).getTextContent());
            System.out.println(age);
            boolean isDegree = Boolean.valueOf(element.getElementsByTagName("isDegree").item(0).getTextContent());
            System.out.println(isDegree);

            // Создаем объект, аполняем поля

            People people1 = new People();
            people1.setName(name);
            people1.setSurname(surname);
            people1.setId(id);
            people1.setAge(age);
            people1.setDegree(isDegree);

            peoples.add(people1);
        }
            root.setPeople(peoples);
        // Вывод на экран всего объекта
        System.out.println("+++++++++++++++++++++++++++++++++");
        System.out.println("root = " + root.toString());
    }






    public static void parseJson(){

       JSONParser parser = new JSONParser();
       FileReader fileReader = null;
       try{
           Root rootModel = new Root();

           fileReader = new FileReader("test.json");
           JSONObject root = (JSONObject)parser.parse(fileReader);
           String name = (String)root.get("name");
           System.out.println("name = " + name);

           JSONArray peoples = (JSONArray)root.get("people");
           List<People> peoplelist = new ArrayList<>();


           for (Object element: peoples){
               People peopleModel = new People();
               JSONObject people = (JSONObject)element;

               long id = (Long) people.get("id");
               System.out.println("id = "+id);
               peopleModel.setId((int)id);

               String nameOfP = (String)people.get("name");
               System.out.println("nameOfP = " + nameOfP);
               peopleModel.setName(nameOfP);

               String surname = (String)people.get("surname");
               System.out.println("surname = " + surname);
               peopleModel.setSurname(surname);

               long age = (Long) people.get("age");
               System.out.println("age = "+age);
               peopleModel.setAge((int)age);

               boolean isDegree = (boolean) people.get("isDegree");
               System.out.println("isDegree = "+isDegree);
               peopleModel.setDegree(isDegree);

               peoplelist.add(peopleModel);

               System.out.println("______________");
           }

           rootModel.setPeople(peoplelist);
           System.out.println(rootModel.toString());

       }catch (Exception e){
           System.out.println(e.toString());
       }
       finally {
           if(fileReader!= null){
               try{
                   fileReader.close();
               }catch (Exception e){
                   System.out.println(e.getMessage());
               }
           }
       }
    }




    private static void parseGson(){

        try{

            BufferedReader bufferedReader =
            new BufferedReader(new FileReader("test.json"));

            GsonBuilder builder = new GsonBuilder().registerTypeAdapter(Date.class, new DateGsonConverter());
            Gson gson = builder.create(); // -  для парсинга своих дат добавятся эти 2 строки

            Root root = gson.fromJson(bufferedReader, Root.class);
            System.out.println(root.toString());





// см Гендер и класс Пипл(Здесь енам не реализован, но там заккоментировано как переопределить переменные, кот. не совпадают)
        }catch (Exception e ){
            System.out.println(e.getMessage());
        }



    }
}
