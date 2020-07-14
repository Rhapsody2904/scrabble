/*
 * Node class for a Trie data structure
 * Holds one character, a flag on whether it's the end of the word, a score value
 * for the word and a HashMap for children. Each node has 26 children - one for 
 * each letter of the alphabet.
 * Methods: TrieNode(char), void: setScore(int), int: getScore(), char: getLetter
 * boolean: isEnd, void: setEnd(boolean)
 */
package scrabble;

import java.util.HashMap;

/**
 *
 * @author Milda
 */
public class TrieNode {
    
    private char letter;
    private boolean isEnd;
    private HashMap <Character, TrieNode> children;
    private int score;
    
    public TrieNode(char a){
        letter = a;
        isEnd = false;
        children = new HashMap<>();
        score = 0;
    }
    
    public void setScore(int s){
        this.score = s;
    }
    
    public int getScore(){
        return this.score;
    }
    
    public char getLetter(){
        return this.letter;
    }
    
    public boolean isEnd(){
        return this.isEnd;
    }
    
    public void setEnd(boolean end){
        isEnd = end;
    }
    
    public HashMap <Character, TrieNode> getChildren(){
        return this.children;
    }
    
    public TrieNode getChild(char a){
        if(this.children.containsKey(a))
            return this.children.get(a);
        return null;
    }
}
