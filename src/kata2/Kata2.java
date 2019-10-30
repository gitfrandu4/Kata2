package kata2;

import java.util.Map;

/**
 *
 * @author Francisco J.
 * @version 3
 */

public class Kata2 {

    public static void main(String[] args) {
        int data [] = {23, 58, 7, 1, 32, 1, 21, 3, 4, 4, 4, 8, 7, 6, 3, 4};
        Histogram histo = new Histogram(data);
        
        Map<Integer, Integer> histogr = histo.getHistogram();
        
        histogr.entrySet().forEach((entry) -> {
            System.out.println(entry.getKey() + " ==> " + entry.getValue());
        }); 
    }    
}