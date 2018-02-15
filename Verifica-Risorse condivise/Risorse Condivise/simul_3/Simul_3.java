package simul_3;

import static simul_3.Risorsa.s;

public class Simul_3 {
    
    public static void main(String[] args) {
        System.out.println("Risorse disponibili di entrambi i thread assieme adesso: " + s.availablePermits());
        Task t2 = new Task("B", 1, 2);
        Task t1 = new Task("A", 2, 1);
        
        t1.start();
        t2.start();    
    }
    
}
