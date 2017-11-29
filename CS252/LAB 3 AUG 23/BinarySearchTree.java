import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.Iterator;

public class BinarySearchTree
extends Object{
	class Node {
	
		int key;
		String value;
		
		Node leftChild;
		Node rightChild;
		
		Node(int key, String value) {
			this.key = key;
			this.value = value;
		}
	
		public String toString() {
				return "" + key;
		}
	}

	Node root;

	public BinarySearchTree(){
		root=null;
	} 

	public void addNode(int key, String value){
		Node newnode=new Node(key,value);
		if(root==null){
			root=newnode;
			return;
		}
		Node t = root;
		while(true){
			if(key<t.key){
				if(t.leftChild==null){
					t.leftChild=newnode;
					newnode.leftChild=newnode.rightChild=null;
				}
				else
					t=t.leftChild;
			}
			else{
				if(t.rightChild==null){
					t.leftChild=newnode;
					newnode.leftChild=newnode.rightChild=null;
				}
				else
					t=t.rightChild;
			}
		}
	}

	Node findnode(int key){
		Node t = root;
		while(t!=null){
			if(t.key==key)
				return t;
			else if(t.key>key)
				t=t.leftChild;
			else
				t=t.rightChild;
		}
		return null;
	}

	void inOrderTraversal(Node focusNode){
		if(focusNode.leftChild==null && focusNode.rightChild==null){
			System.out.println(focusNode.value);
		}
		else if(focusNode.rightChild==null)
			inOrderTraversal(focusNode.leftChild);
		else if(focusNode.leftChild==null)
			inOrderTraversal(focusNode.rightChild);
		else{
			inOrderTraversal(focusNode.leftChild);
			System.out.println(focusNode.value);
			inOrderTraversal(focusNode.rightChild);
		}
	}

	void reverseInOrderTraversal(Node focusNode){
		if(focusNode.leftChild==null && focusNode.rightChild==null){
			System.out.println(focusNode.value);
		}
		else if(focusNode.rightChild==null)
			reverseInOrderTraversal(focusNode.leftChild);
		else if(focusNode.leftChild==null)
			reverseInOrderTraversal(focusNode.rightChild);
		else{
			reverseInOrderTraversal(focusNode.rightChild);
			System.out.println(focusNode.value);
			reverseInOrderTraversal(focusNode.rightChild);
		}
	}

	void postOrderTraversal(Node focusNode){
		if(focusNode.leftChild==null && focusNode.rightChild==null){
			System.out.println(focusNode.value);
		}
		else if(focusNode.rightChild==null)
			postOrderTraversal(focusNode.leftChild);
		else if(focusNode.leftChild==null)
			postOrderTraversal(focusNode.rightChild);
		else{
			postOrderTraversal(focusNode.leftChild);
			postOrderTraversal(focusNode.rightChild);
			System.out.println(focusNode.value);
		}
	}

	void preOrderTraversal(Node focusNode){
		if(focusNode.leftChild==null && focusNode.rightChild==null){
			System.out.println(focusNode.value);
		}
		else if(focusNode.rightChild==null)
			preOrderTraversal(focusNode.leftChild);
		else if(focusNode.leftChild==null)
			preOrderTraversal(focusNode.rightChild);
		else{
			System.out.println(focusNode.value);
			preOrderTraversal(focusNode.leftChild);
			preOrderTraversal(focusNode.rightChild);
		}
	}


	public static void main (String[] args) throws java.lang.Exception{
		BinarySearchTree tree = new BinarySearchTree();
		tree.addNode(6,"6");
		tree.addNode(1,"1");
		tree.addNode(7,"7");
		tree.addNode(5,"5");
		tree.addNode(2,"2");
		tree.addNode(4,"4");
		tree.inOrderTraversal(tree.root);
		tree.postOrderTraversal(tree.root);
		tree.preOrderTraversal(tree.root);
		tree.reverseInOrderTraversal(tree.root);
	}

}