package simul_3;

import static simul_3.Risorsa.s;

public class Task extends Thread{

    String name = "";
    int firstTask;
    int secondTask;

    Task (String name, int firstTask, int secondTask) {
        this.name = name;
        this.firstTask = firstTask;
        this.secondTask = secondTask;
    }

    @Override
    public void run() {
        try {
            System.out.println(name + " : Acquisizione Risorsa");
            System.out.println(name + " : Risorse disponibili : " + s.availablePermits());
            s.acquire(firstTask);
            System.out.println(name + " : Permesso accettato");
            try {
                System.out.println(name + " : Acquisizione seconda risorsa");
                s.acquire(secondTask);
                System.out.println(name + " : Permesso seconda risorsa accettato");
                for (int i = 1; i <= 2; i++) {
                    System.out.println(name + " : Sta svolgendo l'operazione " + i + ", Risolrse disponibili : " + s.availablePermits());
                    Thread.sleep(1000);
                }
            } finally {
                System.out.println(name + " : Rilascio Risorse 1 e 2..");
                s.release(firstTask);
                s.release(secondTask);
                System.out.println(name + " : Risorse disponibili adesso: " + s.availablePermits());
            }
        } catch (InterruptedException e) {
        }
    }
}
