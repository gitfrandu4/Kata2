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
        
        for (int key : data) {
            histogram.put(key, histogram.containsKey(key) ? histogram.get(key) + 1 : 1);
        }
        
        histogram.entrySet().forEach((entry) -> {
            System.out.println(entry.getKey() + " ==> " + entry.getValue());
        }); 
        System.out.println("");
    }    
}