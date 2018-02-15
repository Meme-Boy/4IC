/**
 *
 * @author giovanni.stevanato
 */
import java.util.concurrent.Semaphore;
import java.util.Random;

public class Bus extends Thread {

    private final Random RANDOM = new Random();
    private final int POSTI;
    private final Semaphore SEMAFORO ;
    private final int FERMATE ;
    private int fermataControllore;
    private int discesa;
    private int salita;

    public Bus(int Posti, int fermate) {
        this.POSTI = Posti;
        this.FERMATE = fermate;
        this.SEMAFORO = new Semaphore(this.POSTI);
    }

    @Override
    public void run() {

        //Generazione random della fermata a cui salirà il controllore
        this.fermataControllore = this.RANDOM.nextInt(this.FERMATE - 1) + 1;
        System.out.println("PARTENZA!\n");
        
        //partenza
        for (int i = 1; i <= this.FERMATE; i++) {
            
            //fermata
            System.out.println("● FERMATA: " + i);
            
            //discesa passeggeri (2<n<6)
            this.discesa = this.RANDOM.nextInt((this.POSTI / 2) + 2);
            for (int s = 0; s < this.discesa; s++) {
                if (this.SEMAFORO.availablePermits() < this.POSTI) {
                    this.SEMAFORO.release();
                    System.out.println("↓ sceso passeggero (posti liberi: "+ this.SEMAFORO.availablePermits() + ");");
                }
            }

            //salita passeggeri (2<n<6) (eccetto ultima fermata)
            if (i < FERMATE) {
                this.salita = this.RANDOM.nextInt((this.POSTI / 2) + 2);
                for (int f = 0; f < this.salita; f++) {
                    try {
                        this.SEMAFORO.acquire();
                        System.out.println("↑ salito passeggero (posti liberi: "+ this.SEMAFORO.availablePermits() + ");");
                    } catch (InterruptedException ex) {
                    }
                }
            }

            //Capolinea e discesa di tutti i passeggeri rimanenti
            if (i == this.FERMATE) {
                while (this.SEMAFORO.availablePermits() != this.POSTI) {
                    System.out.println("↓ sceso passeggero (posti liberi: "+ this.SEMAFORO.availablePermits() + ");");
                    this.SEMAFORO.release();
                }
                System.out.println("\nCAPOLINEA!");
                currentThread().interrupt();
            }
            //Controllore
            if (i == this.fermataControllore) {
                Thread controllore = new Thread(new Controllore(this.SEMAFORO.availablePermits(), this.POSTI));
                controllore.start();
            }

            //Tempo di attesa per fermata
            try {
                sleep(10000);
            } catch (InterruptedException e) {
            }
        }
    }
}
