import java.util.Hashtable;
import java.util.Map;

class HashTable {

    public static void main(String[] args) {
        System.out.println("Hello World");
        
        Hashtable<Integer, String> hm = new Hashtable<Integer, String>();

        hm.put(100, "Deepak");
        hm.put(102, "Asha");
        hm.put(101, "Manoj");
        hm.put(103, "Anchal");

        for (Map.Entry m : hm.entrySet()) {
            System.out.println(m.getKey() + " " + m.getValue());
        }
    }
}