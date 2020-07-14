
package scrabble;

import java.util.HashMap;

/**
 * Class for initializing the alphabet values
 * @author Milda
 */
public class Alphabet {
    
    HashMap<Character,Integer> alphabet;
    
    public Alphabet(){
    
    alphabet = new HashMap<Character, Integer>();
    alphabet.put('A',1);
    alphabet.put('B',3);
    alphabet.put('C',3);
    alphabet.put('D',2);
    alphabet.put('E',1);
    alphabet.put('F',4);
    alphabet.put('G',2);
    alphabet.put('H',2);
    alphabet.put('I',1);
    alphabet.put('J',8);
    alphabet.put('K',5);
    alphabet.put('L',1);
    alphabet.put('M',3);
    alphabet.put('N',1);
    alphabet.put('O',1);
    alphabet.put('P',3);
    alphabet.put('Q',10);
    alphabet.put('R',1);
    alphabet.put('S',1);
    alphabet.put('T',1);
    alphabet.put('U',1);
    alphabet.put('V',2);
    alphabet.put('W',2);
    alphabet.put('X',8);
    alphabet.put('Y',2);
    alphabet.put('Z',10);
    alphabet.put('_',0);
    }
    
    //returns a word's letter score value
    public int getScore(String s){
        int score = 0;
        
        for(int i = 0; i < s.length(); i++){
            score += alphabet.get(s.charAt(i));
        }
        return score;
    }
    
    //returns the value of a character
    public int getValue (char a){
        return alphabet.get(a);
    }
    
    
}
