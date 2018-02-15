package pizzeriapappiniello;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Clienti extends Thread {

    static Semaphore PostiSedere = new Semaphore(12);

    String name = "";

    Clienti(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        try {
            System.out.println(this.name + ": Mi stanno servendo");
            TimeUnit.SECONDS.sleep(5/*(int) ((Math.random() * 20) + 40)*/);
            try {
                System.out.println(this.name + ": Ho trovato un posto libero! Ora vado a sedermi");
                PostiSedere.acquire();
                System.out.println(this.name + ": Stomangiando la pizza!");
                TimeUnit.SECONDS.sleep(10/*(int) ((Math.random() * 120) + 500)*/);
            } finally {
                System.out.println(this.name + ": Vado a pagare e lascio il posto libero al cliente successivo");
                PostiSedere.release();
            }
        } catch (InterruptedException e) {
        }
    }
}
