// https://www.hackerearth.com/practice/algorithms/sorting/bubble-sort/practice-problems/algorithm/the-best-player-1/

/*
3 2
surbhi 3
surpanakha 3
shreya 5

Output-
shreya
surbhi
*/

import java.util.*;

class TheBestPlayer {
    public static void main(String args[] ) throws Exception {
       Scanner in = new Scanner(System.in);
       
       String l1 = in.nextLine();
       String[] larr = l1.split(" ");
       int N = Integer.parseInt(larr[0]);
       int T = Integer.parseInt(larr[1]);
       
       ArrayList<Fans> fansArr = new ArrayList<>(N);
       
       while(N-- > 0) {
           String val = in.nextLine();
           String[] varArr = val.split(" ");
           fansArr.add(new Fans(varArr[0], Integer.parseInt(varArr[1])));
       }
       
       Collections.sort(fansArr, new Comparator<Fans>() {
          @Override
          public int compare(Fans a, Fans b) {
              int i = Integer.compare(b.quotient, a.quotient);
              if(i == 0) {
                  int j = a.name.compareTo(b.name);
                  return j;
              }
              return i;
          }
       });
       
       for(int k = 0; k < T; k++) {
           System.out.println(fansArr.get(k).name);
       }

       in.close();
       
    }
}

class Fans {
    String name;
    int quotient;
    
    Fans(String name, int quotient) {
        this.name = name;
        this.quotient = quotient;
    }
}