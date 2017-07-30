// http://practice.geeksforgeeks.org/problems/permutations-of-a-given-string/0

import java.util.*;

class PermutationsOfAGivenString {
	
	public static Vector<String> vec = new Vector<String>();
	
    public static void print(char str[],int i,int j)
    {
        if(i==j) {
			String temp=new String(str);
			vec.add(temp);
        } else {
			char a=str[i];
			for(int k=i;k<=j;k++) {
				str[i]=str[k];
				str[k]=a;
            
				print(str,i+1,j);
				str[k]=str[i];
				str[i]=a;
			}
        }
    }
	
	public static void main (String[] args) {
		
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		
		while(t-- > 0) {
			
		    String str=sc.next();
		    char arr[]=new char[str.length()];
		    arr = str.toCharArray();

		    print(arr,0,str.length()-1);
			
			for(int i=0;i<vec.size();i++) {
				System.out.print(vec.get(i)+" ");
			}
			System.out.println();
		    Collections.sort(vec);

		    for(int i=0;i<vec.size();i++) {
				System.out.print(vec.get(i)+" ");
			}
			
		    System.out.println("");
		    vec.clear();

		}
	}
}