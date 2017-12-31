package main1;

/**
 *
 * @author federico.scaggiante
 */
public class Main1 {
    public static void main(String[] args){
        Thread t = new Thread(new Bus(10));
        t.start();
    }
}