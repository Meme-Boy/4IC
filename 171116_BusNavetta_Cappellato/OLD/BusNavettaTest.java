public class BusNavettaTest {
	
	public static void main (String args[]) {
			Bus noale = new Bus("Noale");
			Thread t1 = new Thread(new Task(noale));
			t1.start();
			try {
            TimeUnit.SECONDS.sleep(200);
			} catch (InterruptedException e) {
			}
			t1.interrupt();
			
	}
}

public class Bus{
	
	private String[50] posti; //aumento il numero dei posti 
	private String name;
	private int counter = 0;
	
	public Bus(String name){
	this.name= name;
	this.reset();
	}
	
	public void add(String passeggero){
		if(counter == posti.length()){
			System.out.println(posti[i]+"has join the bus");
			posti[counter]=passeggero;
			i++;
			}
		}
		else{
		system.err.println("there are no more seats");
		}
		public void remove(int posto){
		posti[counter]=null;
		counter--;
	}
	
	public void remove(int i){
		if(posti.length()!=0){
			System.out.println(posti[i]+"has left the bus");
			this.posti[i]==null;
			i--;
		}else{
		system.err.println("there are no more passenger");
		}
	}
	
	public String getName(){
		return this.name;
	}
	
	public int getCounter(){
		return this.counter;
	}
	
}


import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Task extends Thread {
	public Bus bus;
	
	public Task(Bus bus){
		this.bus=bus;
	}
	
	@Override
	public void run(){
		int tempo = 120 ; //faccio due ore di un bus
		for(;;){
			try{
				System.out.println(this.getName()+"has started");
				TimeUnit.SECONDS.sleep(1);
				while(tempo!=0){
					this.add("johhny"+tempo);
					this.remove(new Random().nextInt(2));
					tempo=tempo-10; //corrisponde a 10 minuti
				}	
			}catch{
			System.out.println(this.getName() + " has arrived to capolina con "+ this.getCounter()+"passeggeri.");
			break;
			}
		}
		
}  
