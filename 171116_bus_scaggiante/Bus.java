
package main1;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author federico.scaggiante
 */
public class Bus extends Thread{

    private Random nRandom = new Random();
    private Semaphore semaphore;
    private int maxPasseggeri;
    private int nFermate = 6;
    private int fermataControllore;
    private int tempoFermata = 10;

    Bus(int maxPasseggeri){
        this.maxPasseggeri = maxPasseggeri;
        semaphore = new Semaphore(maxPasseggeri);
    }

    @Override
    public void run(){
        fermataControllore = nRandom.nextInt(nFermate);
        for(int i=0; i<nFermate; i++){

            System.out.println("Fermata numero "+(i+1)+" di "+nFermate);

            int randomPass = nRandom.nextInt(maxPasseggeri);
            for(int j=0; j<randomPass; j++){
                if(semaphore.availablePermits() < maxPasseggeri) {
                    System.out.println("Sceso passeggero numero " + (maxPasseggeri - semaphore.availablePermits()));
                    semaphore.release();
                }
            }

            if(i+1 < nFermate){
                randomPass = nRandom.nextInt(maxPasseggeri);

                for(int j=0; j<randomPass; j++){
                    try {
                        semaphore.acquire();
                        System.out.println("Salito passeggero numero "+(maxPasseggeri-semaphore.availablePermits()));
                    } catch (InterruptedException ex) {
                    }
                }
            }
            if(i+1 == fermataControllore){
                Thread controllore = new Thread(new Controllore(semaphore, maxPasseggeri));
                controllore.start();
                try {
                    controllore.join();
                } catch (InterruptedException e) {}
            }
            try {
                TimeUnit.SECONDS.sleep(tempoFermata);
            } catch (InterruptedException ex) {}
        }
    }
}

