package es.ujaen.ssccdd;

/**
 *  This class generates prime numbers until is interrumped
 */
public class PrimeGenerator extends Thread {
    /**
     *  Central method of the class
     */
    @Override
    public void run() {
        long number = 1L;

        // This bucle never ends... until is interrupted
        while (true) {
            if (isPrime(number)) {
                System.out.printf("Number %d is Prime\n", number);
            }

        // When is interrupted, write a message and ends
            if (isInterrupted()) {
                System.out.printf("The Prime Generator has been Interrupted\n");
                return;
            }
            number++;
        }
    }
    private boolean isPrime (long number){
        if(number<=1) {
            return false;
        }
        for (int i=2; i<=number/2; i++) {
            if((number%i)==0)
                return  false;
        }
        return true;
    }

}