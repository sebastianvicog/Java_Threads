package es.ujaen.ssccdd;

import java.util.concurrent.TimeUnit;

/**
 *  Main class. To control the interrupt of execution of thread
 */
public class Main4_controlInterrupt {
    public static void main(String[] args) {
        // Creates the Runnable object and the Thread to run it
        FileSearch searcher=new FileSearch("..//..//..","build.xml");
        Thread thread=new Thread(searcher);

        // Starts the Thread
        thread.start();

        // Wait for ten seconds
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Interrupts the thread
        thread.interrupt();
    }

}