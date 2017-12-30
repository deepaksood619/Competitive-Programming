
/*
A Binary Heap is a Binary Tree with following properties.
1) It’s a complete tree (All levels are completely filled except possibly the last level and the last level has all keys as left as possible). This property of Binary Heap makes them suitable to be stored in an array.

2) A Binary Heap is either Min Heap or Max Heap. In a Min Binary Heap, the key at root must be minimum among all keys present in Binary Heap. The same property must be recursively true for all nodes in Binary Tree. Max Binary Heap is similar to Min Heap.
*/

import java.util.Scanner;
import java.util.Arrays;
import java.util.NoSuchElementException;

class BinaryHeap {

    /** The number of children each node has **/
    private static final int d = 2;
    private int heapSize;
    private int[] heap;

    public BinaryHeap(int size) {
        heapSize = 0;
        heap = new int[size + 1];
        Arrays.fill(heap, -1);
    }

    /** Function to check if heap is empty **/
    public boolean isEmpty( )
    {
        return heapSize == 0;
    }

    /** Check if heap is full **/
    public boolean isFull( )
    {
        return heapSize == heap.length;
    }

    /** Clear heap */
    public void makeEmpty( )
    {
        heapSize = 0;
    }

    /** Function to  get index parent of i **/
    private int parent(int i) 
    {
        return (i - 1)/d;
    }

    /** Function to get index of k th child of i **/
    private int kthChild(int i, int k) 
    {
        return d * i + k;
    }

    /** Function to insert element */
    public void insert(int x)
    {
        if (isFull( ) )
            throw new NoSuchElementException("Overflow Exception");
        /** Percolate up **/
        heap[heapSize++] = x;
        heapifyUp(heapSize - 1);
    }

    public void printHeap()
    {
        System.out.print("\nHeap = ");
        for (int i = 0; i < heapSize; i++)
            System.out.print(heap[i] +" ");
        System.out.println();
    }    

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter size of Binary heap");
        BinaryHeap bh = new BinaryHeap(scan.nextInt());

        char ch;

        do {
            System.out.println("\nBinary Heap Operations\n");
            System.out.println("1. insert ");
            System.out.println("2. delete min");
            System.out.println("3. check full");            
            System.out.println("4. check empty");
            System.out.println("5. clear");

            int choice = scan.nextInt();            
            switch (choice) {
                case 1:
                    try
                {
                    System.out.println("Enter integer element to insert");
                    bh.insert( scan.nextInt() ); 
                }
                catch (Exception e)
                {
                    System.out.println(e.getMessage() );
                }
                break;
                case 2 : 
                try
                {
                    System.out.println("Min Element : "+ bh.deleteMin()); 
                }
                catch (Exception e)
                {
                    System.out.println(e.getMessage() );
                }                 
                break;                                
            case 3 : 
                System.out.println("Full status = "+ bh.isFull());
                break;                                   
            case 4 : 
                System.out.println("Empty status = "+ bh.isEmpty());
                break; 
            case 5 : 
                bh.makeEmpty();
                System.out.println("Heap Cleared\n");
                break;         
            default : 
                System.out.println("Wrong Entry \n ");
                break;
            }
            bh.printHeap(); 
            System.out.println("\nDo you want to continue (Type y or n) \n");
            ch = scan.next().charAt(0);
        } while(ch == 'y' || ch == 'Y');
    }

}