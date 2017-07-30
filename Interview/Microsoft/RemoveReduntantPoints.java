// 0,20 -> 10,20 -> 10,15 -> 10,10 -> 20,10 -> 20,0 -> 25,0 -> 30,0

/*
Test cases -
8
0 20 10 20 10 15 10 10 20 10 20 0 25 0 30 0

Num of nodes - 6
Solution - 0,20 -> 10,20 -> 10,10 -> 20,10 -> 20,0 -> 30,0

Horizontal test case -
4
20 10 25 10 30 10 35 10
*/

import java.util.Scanner;

class RemoveReduntantPoints {
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("Enter number of nodes - ");
		int numOfNodes = in.nextInt();
		
		LinkedList linkedList = new LinkedList();
		
		while(numOfNodes-- > 0) {
			int X = in.nextInt();
			int Y = in.nextInt();
			
			Node node = new Node(X, Y);
			linkedList.add(node);
		}
		
		linkedList.print();
		
		linkedList.removeRedundants();
		
		linkedList.print();
		
	}
	
}

class LinkedList {
	
	Node head;
	
	LinkedList() {
		head = null;
	}
	
	public void add(Node node) {
		if(head == null) {
			head = node;
			return;
		}
		
		Node current = head;
		
		while(current.next != null) {
			current = current.next;
		}
		
		current.next = node;
	}
	
	public void removeRedundants() {
		if(head == null) {
			return;
		}
		
		Node current = head;
		Node next = current.next;
		int count = 0;
		
		while(next.next != null && current.Y == next.Y) {
			count++;
			next = next.next;
		}
		
		if(count > 1) {
			current.next = next;
		}
		
	}
	
	public void print() {
		Node current = head;
		
		while(current != null) {
			System.out.print(" -> " + current.X + "," + current.Y);
			current = current.next;
		}
		System.out.println();
	}	
}

class Node {
	int X;
	int Y;
	Node next;
	
	Node(int X, int Y) {
		this.X = X;
		this.Y = Y;
		next = null;
	}
	
}