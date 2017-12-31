
package main1;

import java.util.concurrent.Semaphore;

/**
 *
 * @author federico.scaggiante
 */
class Controllore extends Thread{

    private Semaphore semaforo;
    private int posti;

    Controllore(Semaphore s, int p){
        this.semaforo = s;
        this.posti = p;
    }

    @Override
    public void run(){
        System.out.println("I passeggeri sono :");
        int i;
        for(i = 0; i<posti-semaforo.availablePermits()-1; i++)
            System.out.print("Passeggero"+(i+1)+", ");
        System.out.print("Passeggero"+(i+1)+"\n");
    }

}