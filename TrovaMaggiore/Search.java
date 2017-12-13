import java.util.concurrent.CountDownLatch;

/**
 * Created by studente on 30/11/17.
 */
public class Search implements Runnable{
    int[] array= new int[100];
    int inizio;
    int fine;
    CountdownLatch countdownLatch;
    int[] max;
    int index;
    int chunkSize = array.length / ALL_THREADS;

	public Search(int[] array, int inizio, int fine, CountdownLatch countdownLatch, int[] max){
		this.array = array;
        this.inizio = inizio;
        this.fine = fine;
        this.countdownLatch = countdownLatch;
        this.max = max;
        this.indice = indice;
	}
	
	@Override
    public void run(int[] array) throws InterruptedException {
		massimo[indice] = array[inizio];
		for(int i=inizio; i<fine; i++)
            if(massimo[indice]<array[i]) massimo[indice] = array[i];
        System.out.println("Thread:" + indice +": " + massimo[indice]);
        countdownLatch.countDown();
    }
}
