/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg170927_threads;

import static java.lang.Thread.sleep;
import java.util.ArrayList;

/**
 *
 * @author sraem
 */
public class TestFileClock {
    private static final int NTHREAD = 10;

    public static ArrayList<FileClock> threads;
    public static void main(String[] args) {
        threads =  new ArrayList<>();

        for(int i=0; i<NTHREAD; i++){
            threads.add(new FileClock(i));
        }

        for(int i=0; i<threads.size(); i++){
            threads.get(i).start();
        }

        while(threads.size() > 1){
            for(int i=0; i<threads.size(); i++){
                if(!threads.get(i).isAlive()){
                    System.out.println(threads.get(i).getClock());
                    threads.remove(i);
                }
            }
        }
        System.out.println(threads.get(0).getClock());
        try {
            sleep(500);
        }
        catch (InterruptedException e) {
        }
    }
}