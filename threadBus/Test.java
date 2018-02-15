/**
 *
 * @author giovanni.stevanato
 */
public class Test{
 public static void main(String[] args){
        //10 posti e 5 fermate
        Thread t = new Bus(10, 5);
        t.start();
    }
}