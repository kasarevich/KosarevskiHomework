import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class App {
    public static void main(String [] arg){
        int [] arr = {1,5,5,8,1,9,8,9};


        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i<arr.length; i++){
            int counter = 0;
            int buf = arr[i];
            for(int j = i+1; j < arr.length; j++){
                    if(buf == arr[j]){
                        counter++;
                }
                map.put(arr[i], counter);
                }System.out.println(counter + " " + buf);
            }
        for (Map.Entry<Integer, Integer> entry: map.entrySet())
            System.out.println(entry.getValue() + " - pyfxtybt " + entry.getKey() );
        }

        public static void bitOperation(int[] arr){
        int rezult = 0;
        for(int i = 0; i < arr.length; i++){
            rezult = rezult ^ arr[i];
        }
        System.out.println(rezult);
        }
    }

