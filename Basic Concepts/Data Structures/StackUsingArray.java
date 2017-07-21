// http://www.geeksforgeeks.org/stack-data-structure-introduction-program/

class StackUsingArray {
	
	int size;
	int top;
	int[] stackArr;
	
	StackUsingArray(int size) {
		this.size = size;
		top = -1;
		stackArr = new int[size];
	}
	
	boolean isEmpty() {
		return (top < 0);
	}
	
	boolean push(int num) {
		if(top >= size) {
			System.out.println("Stack Overflow");
			return false;
		} else {
			stackArr[++top] = num;
			return true;
		}
	}
	
	int pop () {
		if(top < 0) {
			System.out.println("Stack Underflow");
			return 0;
		} else {
			int x = stackArr[top--];
			return x;
		}
	}
	
	void printStack() {
		if(top < 0) {
			System.out.println("Stack Underflow");
			return;
		} else {
			for(int i = 0; i <= top; i++) {
				System.out.print(stackArr[i] + " ");
			}
		}
	}	
	
	public static void main(String[] args) {
		StackUsingArray stack = new StackUsingArray(10);
		stack.push(10);
		stack.push(15);
		stack.push(20);
		stack.push(30);
		
		System.out.println("popped - " + stack.pop());
		stack.push(40);
		
		stack.printStack();
	}
}