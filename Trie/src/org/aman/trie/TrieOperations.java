package org.aman.trie;

interface TrieActions{
	public void insert(String word);
	public boolean search (String word);
	public void delete(String word);
	
	//recursive operations
	public void insertRecursive(String word);
	public void searchRecursive(String word);
	
}

public class TrieOperations implements TrieActions {

	private Trie root;
	
	TrieOperations(){
		root =new Trie();
	}
		
	@Override
	public void insert(String word) {
		Trie current =root;
		for (int i=0;i<word.length();i++){
			Character ch =word.charAt(i);
			Trie node =current.getChildren().get(ch);
			if (node==null){
				node =new Trie(ch);
				current.getChildren().put(ch, node);	
			}
			current=node;
		}
		current.setLeaf(true);
	}

	@Override
	public boolean search(String word) {
		Trie current =root;
		for (int i=0;i<word.length();i++){
			Character ch =word.charAt(i);
			Trie node=current.getChildren().get(ch);
			if (node==null)
				return false;
			
			current=node;
		}
		return current.isLeaf();	
	}

	@Override
	public void delete(String word) {
		
		
	}

	@Override
	public void insertRecursive(String word) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void searchRecursive(String word) {
		// TODO Auto-generated method stub
		
	}

}
