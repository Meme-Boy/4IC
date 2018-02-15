package pizzeriapappiniello;

public class PizzeriaPappiniello {
    
    public static void main(String[] args) {
        for (int i = 1; i < 15; i++) {
            Clienti c=new Clienti ("Cliente "+i);
            c.start();
        }
    }
    
}
