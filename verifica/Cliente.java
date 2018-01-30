public class Cliente extends Thread{
	private int stopNumber;
	private String name;
	private Pizzeris pizzeria;
	public Cliente(String name){
		this.name = name;
	}
	public void run(){
		while(true) {
			try {
				sleep(randomNum(12000));
			} catch (InterruptedException e) {
				System.out.println("[" + getName() + "]Provo ad entrare");
				if(pizzeria.entra(this)) System.out.println("[" + getName() + "]Sono entrato");
				else System.out.println("[" + getName() + "]NON sono entrato");
				break;
			}
		}
		while(true) {
			try {
				sleep(randomNum(40,60)*1000);
			} catch (InterruptedException e) {
					System.out.println("[" + getName() + "]esco");
					pizzeria.esce(this);
					break;
			}
		}
	}
	private static int randomNum(int min, int max) {
		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;
	}
	
}