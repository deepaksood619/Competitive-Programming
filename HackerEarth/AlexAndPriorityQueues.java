// https://www.hackerearth.com/challenge/hiring/bima-java-hiring-challenge/problems/59441819ed5b46ea86c207f7dfcf6322/

/*

*/


import java.util.*;

class TestClass {
    public static void main(String args[] ) throws Exception {
        Scanner in = new Scanner(System.in);
        
        LinkedHashMap<Integer, Integer> priorityMap = new LinkedHashMap<>();
        
        int Q = in.nextInt();
		
		LinkedList ll = new LinkedList();
        
        while(Q-- > 0) {
            int type = in.nextInt();
            
            switch(type) {
                case 1:
                    int t = in.nextInt();
                    int p = in.nextInt();
                    priorityMap.put(t, p);
                    break;
                    
                case 2:
                    int removeT = in.nextInt();
                    priorityMap.remove(removeT);
                    break;
                    
                case 3:
                    int min = Integer.MAX_VALUE;
                    int max = 0;
                    for(Map.Entry m : priorityMap.entrySet()){
                        if((int)m.getValue() < min) {
                            min = (int) m.getValue();
                        }
                        if((int)m.getValue() > max) {
                            max = (int) m.getValue();
                        }
                    }
					System.out.println(min + " " + max);
                    break;
                    
                case 4:
					int maxKey = 0;
					int maxVal = 0;
					for(Map.Entry m1: priorityMap.entrySet()) {
						if((int)m1.getKey() > maxKey) {
							maxKey = (int)m1.getKey();
							maxVal = (int)m1.getValue();
						}
					}
					System.out.println(maxVal);
                    break;
                    
                default:
                    System.out.println("Wrong input");
            }
        }
    }
}

/*
class LinkedList {
	
	Node head;
	Node last;
	
	class Node {
		int key;
		int val;
		Node next;
		
		Node(int key, int val) {
			this.key = key;
			this.val = val;
			this.next = null;
		}
	}
	
	LinkedList {
		head = null;
		last = null;
	}
	
	void insert(int key, int val) {
		Node node = new Node(key, val);
		
		if(head == null) {
			head = node;
			return;
		}
		
		Node current = head;
		
		while(current.next != null && ) {
			
		}
		current.next = node;
		
		while(current.next != null) {
			last = node;
		}
	}
}
*/