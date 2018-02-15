/**
 *
 * @author giovanni.stevanato
 */
public class Controllore extends Thread{ 

private final int POSTI_LIBERI;
private final int POSTI_TOTALI;

public Controllore(int postiLiberi, int postiTotali){
	this.POSTI_LIBERI=postiLiberi;
        this.POSTI_TOTALI=postiTotali;
}

@Override
   public void run(){
   System.out.println("▶ CONTROLLORE A BORDO!");
       System.out.println("↳ Controllati biglietti di "+(this.POSTI_TOTALI-this.POSTI_LIBERI)+" passeggeri");
        }

}
