package org.aman.tree;

public class TreeOperations1<T> {
	//find Kth smallest in BST
	private static boolean found=false;
	private static  int present=0;
	public void kthSmallest(Tree<?> t,int k){
		if (t.getRoot()==null || k==0||k>t.getSize()){
			System.out.println("Invalid input");
			return;
		}
		System.out.println();
		kthSmallestUtil2(t.getRoot(),k,present);
		System.out.println();
		//kthSmallestUtil(t.getRoot(),k);
		
		
	}


	private void kthSmallestUtil(Node<?> curr,int k){

		int size=sizeLeftSubTree(curr.getLeft());


		if (size==k-1)
			System.out.println("Kth largest element is: "+curr.getData());

		else if (size>k-1){
			kthSmallestUtil(curr.getLeft(),k);
		}
		else{
			kthSmallestUtil(curr.getRight(),k-size-1);
		}

		//	kthSmallestUtil(t.getRoot(),k);
	}


	public int sizeLeftSubTree(Node<?> root){
		if(root==null)
			return 0;

		return 1+ sizeLeftSubTree(root.getLeft())+sizeLeftSubTree(root.getRight());
	}


	public  void kthSmallestUtil2(Node<?> curr,int k,int present){
		if(curr==null)
			return ;
		if (!found)
		kthSmallestUtil2(curr.getLeft(),k,present);
		present++;
		System.out.println("Present is"+present);
		System.out.print(curr.getData()+" ");
		if (present==k){
			System.out.println("Kth largest element is: "+curr.getData());
			found=true;
			}
		if(!found)
		kthSmallestUtil2(curr.getRight(),k,present);
		
	}

}
