package task1;

import java.util.*;

public class Main {
    public static void main(String []args){
        Set<Student> testSet = new HashSet<>();
        testSet.add(new Student("AAA", 19));
        testSet.add(new Student("BBB", 35));
        testSet.add(new Student("AAA", 19));

        for(Student test: testSet){
            System.out.println("value = " + test);
        }



        Map<String, String> testMap = new HashMap<>();
        testMap.put("RU", "RU VALUE");
        testMap.put("BY", "BY VALUE");
        testMap.put("EN", "EN VALUE");
        testMap.put("FR", "FR VALUE");
        testMap.put("IN", "IN VALUE");
        System.out.println("VALUE = " + testMap.get("RU"));


    }
}
