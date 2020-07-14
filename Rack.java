/*
 * Clas for the Rack object.
 * Reads a data file with multiple racks and creates and ArrayList
 * Methods: Rack(String), ArrayList<String>: getRacks
 */
package scrabble;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Milda
 */
public class Rack {
    ArrayList<String> racks;
    
    public Rack (String filePath){
        String temp = "";
        File f = new File (filePath);
        racks = new ArrayList<String>();
        
        try{
            BufferedReader reader = new BufferedReader(new FileReader(f));
            while((temp = reader.readLine()) != null)
            {
                racks.add(temp);
            }
            reader.close();
        }
        catch(IOException e){
            System.out.println("Error reading file. Please check your file and try again");
            System.exit(0);
        }
    }
    
    //returns the array list of racks
    public ArrayList<String> getRacks(){
        return this.racks;
    }
    
}
