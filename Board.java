/*
 * Board object. Creates a board and handles the scoring.
 * Methods: Board(); int[] getBoard--returns an array of size 13--the maximum available space for first play
 * Winner: findSpot(String[], String); Pair<Integer,Integer>: place(String, String); String: getBlanks (String, String)
 */
package scrabble;

import javafx.util.Pair;

/**
 *
 * @author Milda
 */
public class Board {
    
    int[] board = new int[13];
    Alphabet abc = new Alphabet();
    
    //constructor
    public Board(){
        
       for(int i = 0; i < 13; i++){
           if(i==2 || i==10)
               board[i] = 2;
           else
               board[i] = 1;
       }
    }
    
    //returns the board object
    public int[] getBoard(){
        return this.board;
    }
    
    //main search method. Calls helper methods for scoring and optimal placement
    public Winner findSpot(String[] top5, String hand){

        String blanks = "";
        
        Pair<Integer, Integer> play;
        int loc, value;
        int max = 0;
        int bestLoc = 0;
        String bestWord = "***";
        
        //find the highest placing word out of the top 5
        for(String w: top5){
            if(w != null){
                if(!hand.isEmpty())
                    blanks = getBlanks(w, hand);
                play = place(w, blanks);
                loc = play.getKey();
                value = play.getValue();

                if(value > max){
                    bestWord = w;
                    max = value;
                    bestLoc = loc;       
                }
            }
            else
                break;
        }
        Winner win = new Winner(bestWord, bestLoc, max);
        return win;
    }
    
    //Does the math to figure out where the word should go on the board
    public Pair<Integer, Integer> place(String s, String b){
       
        int len = s.length()-1;
        int score = 0;
        int maxScore = 0;
        int index = 0;
        int i,j;
        String blanks;
        
        //space 6 is the anchor, so the loop can't go beyond that
        for(i = 6 - len; i <= 6; i++){
            blanks = b;
            for(j = 0; j < s.length(); j++){
                char a = s.charAt(j);
                int loc = blanks.indexOf(a);
                if(loc >= 0){
                    blanks = blanks.replace(a,'*');
                }
                else
                   score += board[j+i] * abc.getValue(s.charAt(j)); //multiply to make sure to get the bonus tile score
            }
            if(score > maxScore){
                maxScore = score; //acount for double word
                index = j+i - s.length(); //get start location
            }    
                    score = 0;   
        }
        //apply BINGO and/or double-word bonuses
        if(s.length() == 7)
            maxScore = (maxScore + 50) * 2;
        else
            maxScore = maxScore*2;
 
        Pair <Integer, Integer> winner = new Pair <Integer, Integer>(index, maxScore);
        return winner;
    }
    
    //helper method to figure out what letters were the blanks used as
    //does string manipulation and returns 1 or 2 values, depending on the number of blanks
    //not the mos efficient approach, but it does the trick
    private String getBlanks(String s1, String s2){
        
        String trim = s2.replace("_", "");
        String blanks = "";
        
        char[] word = s1.toCharArray();
        char[] hand = trim.toCharArray();
        
        for(int i = 0; i < word.length; i++){
            for(int j = 0; j < hand.length; j++){
                if(word[i]==hand[j]){
                    word[i] = '*';
                    hand[j] = '*';
                }
            }
        }
        
        for(int i = 0; i < word.length; i++){
            if(word[i] != '*')
                blanks += word[i];
        }
        
        return blanks;
    }
    
}
