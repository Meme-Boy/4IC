import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.Random;


public class Bus extends Thread{

    private Random rnd = new Random();
    private Semaphore semaforo;
    private final int POSTI=10;
    private final int fermate = 5;
    private int fermataControllore;

    public Bus(){
        semaforo = new Semaphore(POSTI);
    }

    @Override
    public void run(){
        fermataControllore = rnd.nextInt(fermate-1)+1;
        for(int i=0; i<fermate; i++){

            System.out.println("FERMATA "+(i+1));

            //Passengers going down (2-6)
            int randomPass = rnd.nextInt((POSTI/2)+2);
            for(int j=0; j<randomPass; j++){
                if(semaforo.availablePermits() < POSTI) {
                    System.out.println("\tSceso passeggero " + (POSTI - semaforo.availablePermits()));
                    semaforo.release();
                }
            }

            //If it is not the last stop, passengers go up (2-6)
            if(i+1 < fermate){
                randomPass = rnd.nextInt((POSTI/2)+2);
                for(int j=0; j<randomPass; j++){
                    try {
                        semaforo.acquire();
                        System.out.println("\tSalito passeggero " + (POSTI-semaforo.availablePermits()));
                    } catch (InterruptedException ex) {}
                }
            }

            //Last stop
            if(i+1==fermate){
                while(semaforo.availablePermits() != 10){
                    System.out.println("\tSceso passeggero " + (POSTI - semaforo.availablePermits()));
                    semaforo.release();
                }
                currentThread().interrupt();
            }

            //Stop where the controller goes up
            if(i+1 == fermataControllore){
                Thread controllore = new Thread(new Controllore(semaforo));
                controllore.start();
                try {
                    controllore.join();
                } catch (InterruptedException e) {}
            }

            //Attesa fino alla fermata successiva
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException ex) {}
        }
    }
}
