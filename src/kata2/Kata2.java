package kata2;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Francisco J.
 * @version 1
 */

public class Kata2 {

    public static void main(String[] args) {
        int data [] = {23, 58, 7, 1, 32, 1, 21, 3, 4, 4, 4, 8, 7, 6, 3, 4};
        HashMap<Integer, Integer> histogram = new HashMap<Integer, Integer>();
        
        for (int i = 0; i < data.length; i++) {
            if(histogram.containsKey(data[i])){
                histogram.put(data[i], histogram.get(data[i])+1);
            } else {
                histogram.put(data[i], 1);
            }
        }
        
        histogram.entrySet().forEach((entry) -> {
            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
        }); 
        System.out.println("");
    }    
}