/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testdatadownload;

/**
 *
 * @author FortuF100
 */
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class TestDataDownload {
    public static void main(String[] args) {
        DataDownloader ddl = new DataDownloader();
        Thread td = new Thread(ddl,"DataDownloaderThread");
        Thread tn = new NetworkConnection(td,"NetworkConnectionThread");
        Thread observer=new Thread(new Osservatore(tn));
        tn.start();
        td.start();
        observer.start();
    }
}


class DataDownloader implements Runnable {
    
    @Override
    public void run() {
        System.out.printf("Connecting: %s\n",
                           new Date());
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("Download finished: %s\n", 
                           new Date());
    }
}

class NetworkConnection extends Thread {
    
    private Thread td; // the downloadr
    
    NetworkConnection(Thread td, String name){
        super(name);
        this.td = td;
    }
    
    @Override
    public void run() {
        System.out.printf("Network connected: %s\n",
                           new Date());
        try {
            td.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("Network not connected: %s\n", 
                           new Date());
    }
}
class Osservatore implements Runnable {
    private Thread.State stato;
    private Thread thread;
    public Osservatore(Thread currentThread) {
        thread=currentThread;
        stato=thread.getState();
    }
    @Override
    public void run() {
        for(;;) {
            if(!stato.equals(thread.getState()))  {
                System.out.println(thread.getName()+ ": State changed from "+stato+" in "+thread.getState());
                stato=thread.getState();
            }
            if(stato.equals(Thread.State.TERMINATED)) break;
            try{
                TimeUnit.MILLISECONDS.sleep(20);
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
