import java.util.Random;

import static java.lang.Thread.sleep;

public class Main{
	public static final int MAX_CLIENTI_IN_ATTESA = 14;

	public static void main(String[]args) throws InterruptedException {
		Random generatore = new Random(System.currentTimeMillis());
		Cliente[] clienti = new Cliente[];
		System.out.println("Generazione passegeri");
		
		for(int i=0; i<MAX_CLIENTI_IN_ATTESA; i++){
			for(int j=i;j<sleep(randomNum(1,4));&&i<MAX_CLIENTI_IN_ATTESA){
				clienti[i] = new Cliente[generatore.nextInt(MAX_CLIENTI_IN_ATTESA)];
				clienti[i].start();
				j++;
				i++;
			}
			sleep(12000);
		}
		Pizzeria daPeppiniello = new Pizzeria("da Peppiniello");
		for(int i=0; i<NUMERO_FERMATE; i++){
			sleep(generatore.nextInt(1000)+1000);
			for(int j=0; j<passeggeri[i].length; j++){
				clienti[j].interrupt();
			}
			sleep(generatore.nextInt(1000)+1000);
		}
		
	}
	private static int randomNum(int min, int max) {
		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;
	}
}