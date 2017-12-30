class ABC
    { 
        public int i = 0;

        public ABC(String text) {
            i = 1; 
        } 
    } 

    class XYZ extends ABC {

        public XYZ(String text) {
            // super(text);
            i = 2;
        }

        public static void main(String args[])
        {
            XYZ sub = new XYZ("Hi"); 
            System.out.println(sub.i);
        } 
    }