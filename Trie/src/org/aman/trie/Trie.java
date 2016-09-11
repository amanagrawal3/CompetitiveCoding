package org.aman.trie;

import java.util.HashMap;

public class Trie {
	
	private Character c;
	private HashMap<Character,Trie> children;
	private boolean isLeaf;
	
	Trie(){
		
	}
	
	Trie(char c){
		this.c=c;
		children =new HashMap<Character,Trie>();
		isLeaf=false;
	}
	
	public Character getChar(){
		return c;
	}
	
	public void setChar(Character c){
		this.c=c;
	}
	
	public boolean isLeaf(){
		return isLeaf;
	}
	
	public void setLeaf(Boolean b){
		isLeaf=b;
	}
	
	public HashMap<Character,Trie> getChildren(){
		return children;
	}
	
	public void setChildren(HashMap<Character,Trie> children){
		this.children=children;
	}
	
	
	
	

}
