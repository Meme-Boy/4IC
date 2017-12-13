/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg170927_threads;

import static java.lang.Thread.sleep;

/**
 *
 * @author sraem
 */
public class FileClock extends Thread{
    private int clock;

    public FileClock(int clock){
        this.clock = clock;
    }

    public int getClock(){
        return clock;
    }

    private int random(int min, int max) {
        int range = (max - min) + 1;
        return (int)(Math.random() * range) + min;
    }

    @Override
    public void run() {
        while(TestFileClock.threads.size() > 1) {
            try {
                sleep(random(500, 10000));
            } catch (InterruptedException e) {
                System.out.println(clock + "has ended");
                return;
            }
            FileClock endThread = TestFileClock.threads.get(random(0, TestFileClock.threads.size()-1));
            if(endThread.getClock() != clock && endThread.isAlive()){
                System.out.println(endThread.getClock());
                endThread.interrupt();
            }
        }
        System.out.println(clock);
    }
}