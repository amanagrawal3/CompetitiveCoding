package org.aman.tree;

public class TreeMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Tree<Integer> b=new Tree<Integer>();
		b.insert(3);b.insert(8);
		b.insert(1);b.insert(4);b.insert(6);b.insert(2);b.insert(10);b.insert(9);
		b.insert(20);b.insert(25);b.insert(15);b.insert(16);
		
		b.inOrder();
		System.out.println();
		System.out.println(b.find(18));
		
		Tree<Integer> b2=new Tree<Integer>();
		TreeOperations t1=new TreeOperations();
		b2.insert(50);b2.insert(30);b2.insert(20);
		b2.insert(40);b2.insert(70);b2.insert(60);b2.insert(80);
		b2.inOrder();
	//	b2.reverseinorder();
		//t1.addGreaterValueNode(b2);
		System.out.println();
		b2.inOrder();
		System.out.println();
		//t1.mirror(b2);
		
		t1.postOrder(b);
		t1.preOrder(b);
		
		TreeOperations1 t2=new TreeOperations1();
		t2.kthSmallest(b2, 4);
	}

}
