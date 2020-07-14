
package scrabble;

/**
 * Object to return the set of winning criteria--helper object
 * Methods: Winner(String, int, int), String: getWord, int: getLoc,
 * int: getScore, void: setWord(String), void: setLoc(int), void: setScore(int)
 * @author Milda
 */
public class Winner {
    String word;
    int location;
    int score;
    
    public Winner(String s, int l, int sc){
        word = s;
        location = l;
        score = sc;
    }
    
    public String getWord(){
        return word;
    }
    
    public int getLoc(){
        return location;
    }
    
    public int getScore(){
        return score;
    }
    
    public void setWord(String s){
        word = s;
    }
    
    public void setLoc(int l){
        location = l;
    }
    
    public void setScore (int s){
        score = s;
    }
}
