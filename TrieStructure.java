/*
 * A structure for storing Trie Nodes
 * Provides an efficient way of searching for words
 * Methods: TrieStructure, String: isPrefix, int: search
 */
package scrabble;

import java.util.HashMap;

/**
 *
 * @author Milda
 */

//constructor
public class TrieStructure {
    
   private TrieNode root;
    
    public TrieStructure(){
        root = new TrieNode((char)0);
    }
    
    public void add(String w, int val){
        int len = w.length(); //get length of word
        TrieNode current = root; 
        
        //go through each char in the word 
        for(int i = 0; i < len; i++){
            HashMap<Character, TrieNode> children = current.getChildren();
            char c = w.charAt(i);
            
            //check to see if a given char exists as a child
            if(children.containsKey(c)){
                    current = children.get(c); //traverse to it
            }
            else{ //if it doesn't, create it
                TrieNode temp = new TrieNode(c);
                children.put(c, temp);
                current = temp;
            }
        }
        current.setScore(val);
        current.setEnd(true); //set flag for end of the word  
    }
    
    //check to see if a given prefix exists in the dictionary
    public boolean isPrefix(String s){
        
        if(s.equals(""))
            return true; //permutation just started, no prefix was selected
        
        TrieNode t = this.root;
        
        for(int i = 0; i < s.length(); i++){ //traverse down
            TrieNode next = t.getChild(s.charAt(i));
            
            if(next == null) //if there are no children, prefix doesn't exist
                return false;
            
            t = next; //move to next node
        }
        if(t.getChildren() != null || t.isEnd()) //if there are more children or it's the end of the word
            return true;
        else 
            return false;
    }
    
    //searches for a given string and returns its letter score
    public int search(String s){
        TrieNode t = this.root;
        
        for(int i = 0; i < s.length(); i++){
            TrieNode next = t.getChild(s.charAt(i));
            
            if(next == null)
                return 0;
            
            t = next;
        }
        return t.getScore();
    }
    
}
