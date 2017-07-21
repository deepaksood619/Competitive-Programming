// http://www.geeksforgeeks.org/linked-list-set-1-introduction/

class LinkedList {
	
	Node head;
	
	static class Node {
		int data;
		Node next;
		
		Node(int d) {
			data = d;
			next = null;
		}
	}
	
	void printList() {
		Node link = head;
		while(link != null) {
			System.out.print(link.data + " ");
			link = link.next;
		}
	}
	
	public static void main(String[] args) {
		System.out.println("Linked List");
		
		LinkedList linkedList = new LinkedList();
		
		linkedList.head = new Node(4);
		Node second = new Node(3);
		Node third = new Node(1);
		
		linkedList.head.next = second;
		second.next = third;
		
		linkedList.printList();
	}
}