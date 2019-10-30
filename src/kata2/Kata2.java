package kata2;

import java.util.Map;

/**
 *
 * @author Francisco J.
 * @version 5
 */

public class Kata2 {

    public static void main(String[] args) {
        String [] data = {"Rosa", "Pepe", "María", "Pepe", "Pepe", "Rosa"};
        Histogram histo = new Histogram(data);
        
        Map<String, Integer> histogr = histo.getHistogram();
        
        histogr.entrySet().forEach((entry) -> {
            System.out.println(entry.getKey() + " ==> " + entry.getValue());
        }); 
    }    
}