/*
	All the basic operations will be performed
	1. insertion
	2. print Linked List
*/

class LinkedListOperations {
	
	Node head;
	
	static class Node {
		int data;
		Node next;
		
		Node(int data) {
			this.data = data;
			this.next = null;
		}
	}
	
	void insert(int data) {
		Node node = new Node(data);
		if(head == null) {
			head = node;
		} else {
			Node endNode = head;
			while(endNode.next != null) {
				endNode = endNode.next;
			}
			endNode.next = node;
		}
	}
	
	void insertFront(int data) {
		Node node = new Node(data);
		node.next = head;
		head = node;
	}
	
	void insertAt(int data, int index) {
		Node current = head;
		if(current != null) {
			Node node = new Node(data);
			System.out.println("insert At");
			int count = 0;
			while(current != null) {
				if (++count == index) {
					System.out.println("count - " + count);
					node.next = current.next;
					current.next = node;
				} else {
					current = current.next;
				}
			}
		} else {
			insert(data);
		}
	}
	
	void deleteFirst() {
		Node current = head;
		if(current != null) {
			head = current.next;
		} else {
			System.out.println("No items to delete");
		}
	}
	
	void deleteLast() {
		Node current = head;
		Node temp = current;
		if(current == null) {
			System.out.println("No items to delete");
			return;
		}
		
		while(current.next != null) {
			temp = current;
			current = current.next;
		}
		
		temp.next = null;
	}
	
	void deleteAt(int index) {
		Node current = head;
		Node temp = head;
		if(current == null) {
			System.out.println("No items to delete");
			return;
		}
		
		int count = 0;
		while(current != null) {
			if(++count == index) {
				System.out.println("count " + count);
				temp.next = current.next;
			} else {
				temp = current;
				current = current.next;
			}
		}
	}
	
	void printList() {
		Node current = head;
		while(current != null) {
			System.out.print(current.data + " ");
			current = current.next;
		}
		System.out.println();
	}
	
	void printLength() {
		int count = 0;
		Node current = head;
		while(current != null) {
			count ++;
			current = current.next;
		}
		System.out.println(count);
	}
	
	void reverseList() {
		Node prev = null;
		Node current = head;
		Node next = null;
		while(current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		head = prev;
	}
	
	public static void main(String[] args) {
		LinkedListOperations ll = new LinkedListOperations();
		ll.insert(2);
		ll.insert(4);
		ll.insert(5);
		ll.insert(6);
		ll.insertFront(1);
		ll.insertAt(3, 3-1);
		
		ll.printList();
		
		ll.printLength();
		
		ll.deleteLast();
		ll.deleteFirst();
		ll.deleteAt(2);
		
		ll.printList();
		
		ll.reverseList();
		ll.printList();
	}
}