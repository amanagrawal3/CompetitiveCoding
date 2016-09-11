package org.aman.tree;

public class Node<T> {
	T data;
	Node<T> left;
	Node<T> right;
	Node(T data){
		this.data=data;
		left=right=null;
	}

	public T getData(){
		return data;
	}

	public void setData(T data){
		this.data=data;
	}

	public void setLeft(Node<T> left){
		this.left=left;
	}

	public Node<T> getLeft(){
		return left;
	}

	public void setRight(Node<T> right){
		this.right=right;
	}

	public Node<T> getRight(){
		return right;
	}

}



class Tree<T extends Comparable<T>>{
	private Node<T> root;
	private int size;
	Tree(){
		root=null;
	}

	
	public Node<T> getRoot(){
		return root;
	}
	
	public void setRoot(Node<T> root){
		this.root=root;
	}
	public void insert(T data){
		if (data==null)
			throw new IllegalArgumentException();

		Node<T> newNode=new Node<T>(data);
		size++;
		if (root==null)
			root=newNode;
		else{
			Node<T> curr=root;

			while(true){
				if(newNode.getData().compareTo(curr.getData())>0){

					if(curr.getRight()==null){
						curr.setRight(newNode);
						return;
					}
					curr=curr.getRight();
				}

				else if (newNode.getData().compareTo(curr.getData())<0){
					if(curr.getLeft()==null){
						curr.setLeft(newNode);
						return;
					}
					curr=curr.getLeft();
				}

				else
					return;
			}
		}
	}

	public void inOrder(){
		inOrder(root);
	}

	private void inOrder(Node<T> curr){
		if(curr==null)
			return;
		if(curr!=null){
			inOrder(curr.getLeft());
			System.out.print(curr.getData()+" ");
			inOrder(curr.getRight());
		}
	}
	
	public void reverseinorder(){
		System.out.println();
		reverseInorder(root);
	}

	
	private void reverseInorder(Node<T> curr){
		if(curr==null)
			return;
		if(curr!=null){
			reverseInorder(curr.getRight());
			System.out.print(curr.getData()+" ");
			reverseInorder(curr.getLeft());
		}	
	}

	public int compareTo(T obj) {
		// TODO Auto-generated method stub
		return this.compareTo(obj);
	}

	public int getSize(){
		return size;
	}
	public boolean isEmpty(){
		return root==null;
	}

	public boolean find(T data){
		//boolean result=false;

		Node<T> curr=root;
		while(true){
			if(data.compareTo(curr.getData())>0){
				//System.out.println("Right"+data +":" +curr.getData());
				if(curr.getRight()==null){
					return false;
				}
				curr=curr.getRight();
			}

			else if (data.compareTo(curr.getData())<0){
				//System.out.println("Left"+data +":" +curr.getData());
				if(curr.getLeft()==null){
					return false;
				}
				curr=curr.getLeft();
			}

			else{
				return true;
			}
		}
	}

	
	//http://algorithms.tutorialhorizon.com/binary-search-tree-complete-implementation/

	public void delete(T data){
		if(root==null){
			System.out.println("No elements to delete");
			return;
		}	

		Node<T> curr=root;
		Node<T>  parent=root;
		boolean isLeftChild=false;
		while(true){
			parent=curr;
			if(data.compareTo(curr.getData())>0){
				//System.out.println("Right"+data +":" +curr.getData());
				if(curr.getRight()==null){
					System.out.println("No item to delete");
					return;
				}
				isLeftChild=false;
				curr=curr.getRight();
			}

			else if (data.compareTo(curr.getData())<0){
				//System.out.println("Left"+data +":" +curr.getData());
				if(curr.getLeft()==null){
					System.out.println("No item to delete");
					return;
				}
				isLeftChild=true;
				curr=curr.getLeft();
			}

			else
				break;
		}

		if(curr.getLeft()==null && curr.getRight()==null){

			if (curr==root)
				root=null;

			if(isLeftChild)
				parent.setLeft(null);
			else
				parent.setRight(null);

		}

		else if (curr.getRight()==null){
			if(curr==root)
				root=curr.getLeft();

			else if(isLeftChild)
				parent.setLeft(curr.getLeft());
			else
				parent.setRight(curr.getLeft());
		}

		else if (curr.getLeft()==null){
			
			if(curr==root)
				root=curr.getRight();

			else if(isLeftChild)
				parent.setLeft(curr.getLeft());
			else
				parent.setRight(curr.getLeft());
		}	

	}	
}
