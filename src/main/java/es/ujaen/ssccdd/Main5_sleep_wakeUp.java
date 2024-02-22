package es.ujaen.ssccdd;

import java.util.concurrent.TimeUnit;

/**
 *  Main class. To sleep and wake up the Threads
 */
public class Main5_sleep_wakeUp {
    public static void main(String[] args) {
        // Creates a FileClock runnable object and a Thread
        // to run it
        FileClock clock=new FileClock();
        Thread thread=new Thread(clock);

        // Starts the Thread
        thread.start();

        try {
            // Waits five seconds
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // Interrupts the Thread
        thread.interrupt();
    }
}
