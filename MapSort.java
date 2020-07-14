/*
 * Helper class to sort the contents of a map and pick out the top 5 entries
 * based on value. One of the most inefficient parts of this program, but I was drawing a
 * blank on how to grab the last values from a map.
 * Methods: String[]: sort(Map<String, Integer>
 */
package scrabble;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 
 * @author Milda
 */
public class MapSort {
    
    public String[] sort(Map<String, Integer> map){
 
        List<Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(Entry.comparingByValue());
        int size = list.size();
        
        String[] result = new String[5];
        if(size >= 5){
            Entry<String,Integer> e1 = list.get(list.size()-1);
            Entry<String,Integer> e2 = list.get(list.size()-2);
            Entry<String,Integer> e3 = list.get(list.size()-3);
            Entry<String,Integer> e4 = list.get(list.size()-4);
            Entry<String,Integer> e5 = list.get(list.size()-5);
            
            result[0] = e1.getKey();
            result[1] = e2.getKey();
            result[2] = e3.getKey();
            result[3] = e4.getKey();
            result[4] = e5.getKey();
        }
        else{
            int j = 0;
            for(Entry<String,Integer> e: list){
                result[j] = e.getKey();
                j++;
            }
                
        }   
        
        return result;
    }    
}       


