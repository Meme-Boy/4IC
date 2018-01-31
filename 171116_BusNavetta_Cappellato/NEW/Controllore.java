import java.util.concurrent.Semaphore;

class Controllore extends Thread{

    private Semaphore semaforo;

    Controllore(Semaphore semaforo){
        this.semaforo=semaforo;
    }

    @Override
    public void run(){
        System.out.println("Controllore: ");
        for(int i = 0; i<10-semaforo.availablePermits(); i++)
            System.out.println("Passeggero "+(i+1));
    }

}