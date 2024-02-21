package es.ujaen.ssccdd;

import java.util.concurrent.TimeUnit;

/**
 *  Main class. To interrupt the execution of thread
 */
public class Main3 {
    public static void main(String[] args) {
        // Launch the prime numbers generator
        Thread task=new PrimeGenerator();
        task.start();

        // Wait 5 seconds
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Interrupt the prime number generator
        task.interrupt();
    }
}
