/*
 * Dictionary class. Builds a dictionary by reading words from a file into a
 * Trie structure.
 * Methods: Dictionary(String), boolean: isPrefix(String), int: search(String)
 */
package scrabble;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Milda
 */
public class Dictionary {
    
      Alphabet abc = new Alphabet();
      TrieStructure dict;
    
    public Dictionary (String filePath){
        String temp = "";
        File f = new File (filePath);
        dict = new TrieStructure();
        
        try{
            BufferedReader reader = new BufferedReader(new FileReader(f));
            while((temp = reader.readLine()) != null)
            {
                if(temp.length() > 3 && temp.length() < 8) //add valid starting words
                    dict.add(temp, abc.getScore(temp));
            }
            reader.close();
        }
        catch(IOException e){
            System.out.println("Error reading file. Please check your file and try again");
            System.exit(0);
        }
    }
    
    //calls the Trie structure's isPrefix method
    public boolean isPrefix(String s){
        return dict.isPrefix(s);
    }
    
    //calls the Trie structure's search method
    public int search(String s){
        return dict.search(s);
    }
}
