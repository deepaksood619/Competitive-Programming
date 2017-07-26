// http://www.geeksforgeeks.org/detect-loop-in-a-linked-list/
// http://practice.geeksforgeeks.org/problems/detect-loop-in-linked-list/1

/*
	Naive Solution - Have a visited flag with each node, if the node is already visited then there is a loop-in-a-linked-list/
					The above solution requires the data structure to be changed and have a flag with each node.
	
	Naive Solution 2 - Traverse the linked list and keep on saving the node addresses in hash table, if any node points to the
						previously stored hash then there is a loop, if null is reached then there is no loop
						
	Time Complexity - O(N)
	Space Complexity - O(N)
						
	Optimized Solution - Floyd Tortoise and Hare
						This is the fastest method. Traverse linked list using two pointers.  Move one pointer by one and other pointer by two.  If these pointers meet at some node then there is a loop.  If pointers do not meet then linked list doesn’t have loop.
						
	Time Complexity - O(N)
	Space Complexity - O(1)
	
	Starting Node - https://stackoverflow.com/questions/2936213/explain-how-finding-cycle-start-node-in-cycle-linked-list-work
	When the tortoise and hare meet, we have found the smallest i (the number of steps taken by the tortoise) such that Xi = X2i. Let mu represent the number of steps to get from X0 to the start of the cycle, and let lambda represent the length of the cycle. Then i = mu + alambda, and 2i = mu + blambda, where a and b are integers denoting how many times the tortoise and hare went around the cycle. Subtracting the first equation from the second gives i = (b-a)*lambda, so i is an integer multiple of lambda. Therefore, Xi + mu = Xmu. Xi represents the meeting point of the tortoise and hare. If you move the tortoise back to the starting node X0, and let the tortoise and hare continue at the same speed, after mu additional steps the tortoise will have reached Xmu, and the hare will have reached Xi + mu = Xmu, so the second meeting point denotes the start of the cycle.
*/

class FloydTortoiseAndHare {
	public static void main(String[] args) {
		LinkedList linkedList = new LinkedList();
		
		linkedList.push(5);
		linkedList.push(3);
		linkedList.push(8);
		linkedList.push(4);
		
		linkedList.print();
		
		linkedList.head.next.next.next.next = linkedList.head.next;
		
		String out = linkedList.findLoop() ? "Loop found" : "Loop not found";
		System.out.println(out);
		
		linkedList.findStartingNode();
	}
}

class LinkedList {
	Node head;
	
	class Node {
		int data;
		Node next;
		
		Node(int d) {
			this.data = d;
			next = null;
		}
	}
	
	// add node at the end of the list
	public void push(int newData) {
		Node node = new Node(newData);
		if(head == null) {
			head = node;
		} else {
			Node current = head;
			while(current.next != null) {
				current = current.next;
			}
			current.next = node;
		}
	}
	
	public void findStartingNode() {
		Node slow_p = head, fast_p = head;
		
		while(slow_p != null && fast_p != null && fast_p.next != null) {
			System.out.print(" slow - " + slow_p.data + " fast - " + fast_p.data);
			
			slow_p = slow_p.next;
			fast_p = fast_p.next.next;
			
			if(slow_p == fast_p) {
				System.out.println();
				System.out.println("join - " + slow_p.data);
				break;
			}
		}
		System.out.println("----------");
		slow_p = head;
		while(slow_p != null && fast_p != null && fast_p.next != null) {
			System.out.print(" slow - " + slow_p.data + " fast - " + fast_p.data);
			slow_p = slow_p.next;
			fast_p = fast_p.next;
			if(slow_p == fast_p) {
				
				System.out.println();
				System.out.println("first node - " + slow_p.data);
				break;
			}
		}
	}
	
	public boolean findLoop() {
		Node slow_p = head, fast_p = head;
		
		while(slow_p != null && fast_p != null && fast_p.next != null) {
			System.out.print(" slow - " + slow_p.data + " fast - " + fast_p.data);
			
			slow_p = slow_p.next;
			fast_p = fast_p.next.next;
			
			if(slow_p == fast_p) {
				System.out.println();
				System.out.println("join - " + slow_p.data);
				return true;
			}
		}
		
		return false;
	}
	
	public void print() {
		Node current = head;
		while(current != null) {
			System.out.print(current.data + " ");
			current = current.next;
		}
		System.out.println();
	}
}