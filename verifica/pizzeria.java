import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.*;

public class Pizzeria{
	public static final int NUMERO_POSTI = 12;
	private Lock sezioneCritica;
	private Semaphore postiLiberi;
	private Semaphore postiOccupati;
	private Cliente[] clienti;
	private String name;
	
	public Pizzeria(String name){
		postiLiberi = new Semaphore(NUMERO_POSTI);
		postiOccupati = new Semaphore(0);
		sezioneCritica = new ReentrantLock();
		clienti = new Cliente[NUMERO_POSTI];
		this.name = name;
	}
	public boolean entra(Cleinte cliente){
		int i;
	    boolean entrato=false;
		sezioneCritica.lock();
		if(postiLiberi.tryAcquire()){
		    entra=true;
            for(i=0; clienti[i] != null; i++);
            clienti[i] = cliente;
			postiOccupati.release();
        }
        sezioneCritica.unlock();
		return entra;
	}
	public void esce(Cliente cliente){
		int i;
		sezioneCritica.lock();
			postiOccupati.tryAcquire();
			for(i=0; clienti[i].getName()!=cliente.getName(); i++);
			clienti[i] = null;
			postiLiberi.release();
		sezioneCritica.unlock();
	}
}