package org.aman.tree;
import java.util.Deque;
import java.util.LinkedList;

public class TreeOperations<T> {

	/** http://www.geeksforgeeks.org/add-greater-values-every-node-given-bst/
	 * http://www.geeksforgeeks.org/transform-bst-sum-tree/
	 * O(n)-reverse InOrder
	 */

	public void addGreaterValueNode(Tree<Integer>  t){
		int sum=0;
		Node<Integer> root=t.getRoot();
		addGreaterValueNodeUtil(root,sum);
	}

	@SuppressWarnings("hiding")
	public<T extends Number > void	addGreaterValueNodeUtil(Node<Integer> root,int sum){
		if(root==null)
			return;

		addGreaterValueNodeUtil(root.getRight(),sum);
		sum=sum+root.getData();
		root.setData(sum);
		addGreaterValueNodeUtil(root.getLeft(),sum);

	}


	/*-------------------------------PRE ORDER TRAVERSAL(Root,Left,Right)-------------------------------------------------------------------------------------------
	 * 	
	 */

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void preOrder(Tree t){
		System.out.println();
		preOrder(t.getRoot());
		System.out.println();
		preOrderIterative(t.getRoot());
		//System.out.println();
		//postOrder1Stack(t.getRoot());
	}

	private void preOrder(Node<T> root){

		if (root==null)
			return;

		System.out.print(root.getData()+" ");
		preOrder(root.getLeft());
		preOrder(root.getRight());

	}

	private void preOrderIterative(Node<T> root){
		Deque<Node<T>> stack=new LinkedList<Node<T>>();
		stack.addFirst(root);
		while (!stack.isEmpty())
		{
			root=stack.pollFirst();
			System.out.print(root.getData()+" ");
	
			if (root.getRight()!=null){
				stack.addFirst(root.getRight());
			}
			if (root.getLeft()!=null){
				stack.addFirst(root.getLeft());
			}

		
		}
	}



	/*-------------------------------POST ORDER TRAVERSAL(Left,Right,Root)-------------------------------------------------------------------------------------------
	 * 	
	 */

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void postOrder(Tree t){
		System.out.println();
		postOrder(t.getRoot());
		System.out.println();
		postOrderIterative(t.getRoot());
		System.out.println();
		postOrder1Stack(t.getRoot());
	}

	//Recursive solution of postOrder
	private void postOrder(Node<T> root){

		if (root==null)
			return;

		postOrder(root.getLeft());
		postOrder(root.getRight());
		System.out.print(root.getData()+" ");

	}

	//Using Two stacks...1 stack for remembering parent ..Other for iterating left and right node
	private void postOrderIterative(Node<T> root){
		if(root==null)
			return;

		Deque<Node<T>> stack1=new LinkedList<Node<T>>();
		Deque<Node<T>> stack2=new LinkedList<Node<T>>();

		stack1.addFirst(root);

		while(!stack1.isEmpty()){
			root=stack1.pollFirst();

			if (root.getLeft()!=null)
				stack1.addFirst(root.getLeft());
			if (root.getRight()!=null)
				stack1.addFirst(root.getRight());

			stack2.addFirst(root);
		}

		while (!stack2.isEmpty()){
			System.out.print(stack2.pollFirst().getData()+" ");
		}

	}

	//Using one stack
	private void postOrder1Stack(Node<T> root){
		Node <T> curr=root;
		Deque<Node<T>> stack=new LinkedList<Node<T>>();
		while(curr!=null || !stack.isEmpty()){
			if (curr !=null){
				stack.addFirst(curr);
				curr=curr.getLeft();
			}

			else
			{
				Node<T> temp=stack.peek().getRight();
				if(temp==null){
					temp=stack.poll();
					System.out.print(temp.getData()+" ");
					while(!stack.isEmpty() && temp==stack.peek().getRight())
					{
						temp=stack.poll();
						System.out.print(temp.getData()+" ");
					}
				}
				else
					curr=temp;
			}
		}
	}

	
	
	/*-------------------------------LEVEL ORDER TRAVERSAL(BFS of a tree)-------------------------------------------------------------------------------------------
	 * 	
	 */

	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void levelOrder(Tree t){
		Node<T> root=t.getRoot();
		Deque<Node<T>> queue=new LinkedList<Node<T>>();
		queue.add(root);
		
		while (!queue.isEmpty()){
			Node<T> temp =queue.poll();
			System.out.print(temp.getData()+" ");
			if(temp.getLeft()!=null)
				queue.add(temp.getLeft());
			if(temp.getRight()!=null)
				queue.add(temp.getRight());
		}
	}

	
	
	/**--------------------------------------------------------------------------------------------------------------------------------------------------
	 * 
	 */
	
	
	/**-------------------------------------------------------------------------------------------------------------------------------------------
	 * 
	 * @param T
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void mirror(Tree T){
		mirror(T.getRoot());

		T.inOrder();
	}

	private void mirror(Node<T> root){

		if (root==null)
			return;

		mirror(root.getLeft());
		mirror(root.getRight());

		Node<T> temp=root.getLeft();
		root.setLeft(root.getRight());
		root.setRight(temp);
	}



}
