package com.ds.basic;

public class BasicBinaryTree<X extends Comparable<X>> {

	private Node root;
	private int size;

	public BasicBinaryTree() {
		this.root = null;
	}
	
	
	public int size() {
		return size;
	}
	
	public void add(X item) {
		Node node  = new Node(item);
		
		// if this is the first item in the tree, set it as root
		if(root == null) {
			this.root = node;
			System.out.println("The root: "+ node.getItem());
			this.size++;
		}
		else {
			insert(this.root, node);
		}
	}
	
	private void insert(Node parent, Node child) {
		//if the child is less than the parent, it goes on the left
		if(child.getItem().compareTo(parent.getItem()) < 0) {
			
			// if the left node is null, we've found out spot
			if(parent.getLeft() == null) {
				parent.setLeft(child);
				child.setParent(parent);
				this.size++;
			}
			// otherwise we need to call insert again and test for left or right recursion
			else {
				insert(parent.getLeft(), child);
			}
			
		}
		//if the child is greater than the parent, it goes on the right
		else if(child.getItem().compareTo(parent.getItem()) > 0) {
			
			// if the right node is null, we've found out spot
			if(parent.getRight() == null) {
				parent.setRight(child);
				child.setParent(parent);
				this.size++;
			}
			// otherwise we need to call insert again and test for left or right recursion
			else {
				insert(parent.getRight(), child);
			}
			
		}
		
		// if the parent and child happen to be equal, we don't do anything
		// data in a binary tree is aasumed to be unique and the value already exists in a tree
	}
	
	public boolean contains(X item) {

		Node currentNode = getNode(item);
		if (currentNode == null) {
			// we didn't find it
			return false;
		} else {
			return true;
		}
	}
	
	private Node getNode(X item) {
		Node currentNode = this.root;

		while (currentNode != null) {
			int val = item.compareTo(currentNode.getItem());

			// see if the node is match
			if (val == 0) {
				return currentNode;
			}

			// if the val is less than 0, we go to the left side of the tree
			else if (val < 0) {
				currentNode = currentNode.getLeft();
			}

			// if the val is greater than 0, we go to the right side of the tree
			else {
				currentNode = currentNode.getRight();
			}
		}
		return null;
	}
	
	
	public boolean delete(X item) {
		boolean deleted = false;
		
		// make sure the root isn't null meaning the tree is empty
		if(this.root == null) {
			return false;
		}
		
		// find the node to delete
		Node currentNode = getNode(item);
		
		if(currentNode != null) {
			// if the node to delete doesn't have any children , just delete it
			if(currentNode.getLeft() == null && currentNode.getRight() == null) {
				unlink(currentNode, null);
				deleted = true;
			}
			
			// if the node to delete only has a right child, remove it in the hierarchy,
			// re-attach the right child of the current node to the parent of the current node  
			else if(currentNode.getLeft() == null && currentNode.getRight() != null) {
				unlink(currentNode, currentNode.getRight());
				deleted = true;
			}
			
			// if the node to delete only has a left child, remove it in the hierarchy,
			// re-attach the left child of the current node to the parent of the current node  
			else if(currentNode.getLeft() != null && currentNode.getRight() == null) {
				unlink(currentNode, currentNode.getLeft());
				deleted = true;
			}
			
			// the node has both children, do a node swap to delete
			else {
				// first find the left child, then swap out the right most leaf node on the left side child 
				Node child = currentNode.getLeft();
				
				while(child.getRight() != null && child.getLeft() != null) {
					child = child.getRight();
				}
				
				// we have the right most leaf node. We can replace the current node with this node
				child.getParent().setRight(null); // remove the leaf node from it's current position
				
				child.setLeft(currentNode.getLeft());
				child.setRight(currentNode.getRight());
				
				unlink(currentNode, child);
				deleted = true;
			}
		}
		
		if(deleted) {
			this.size--;
		}
		
		return deleted;
	}
	
	private void unlink(Node currentNode, Node newNode) {
		// if this is the root node, we replace that a little differently
		if(currentNode == this.root) {
			newNode.setLeft(currentNode.getLeft());
			newNode.setRight(currentNode.getRight());
			this.root = newNode;
		}
		else if(currentNode.getParent().getRight() == currentNode) {
			currentNode.getParent().setRight(newNode);
		}
		else {
			currentNode.getParent().setLeft(newNode);
		}
	}
	

	private class Node {
		private Node left;
		private Node right;
		private Node parent;

		private X item;

		public Node(X item) {
			this.item = item;
			this.left = null;
			this.right = null;
			this.parent = null;
		}

		public Node getLeft() {
			return left;
		}

		public void setLeft(Node left) {
			this.left = left;
		}

		public Node getRight() {
			return right;
		}

		public void setRight(Node right) {
			this.right = right;
		}

		public Node getParent() {
			return parent;
		}

		public void setParent(Node parent) {
			this.parent = parent;
		}

		public X getItem() {
			return item;
		}

		public void setItem(X item) {
			this.item = item;
		}

	}
}
