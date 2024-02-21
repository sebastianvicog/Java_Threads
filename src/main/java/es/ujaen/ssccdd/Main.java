package es.ujaen.ssccdd;


import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;

/**
 *  Main class of the example
 */
public class Main {


//[1.] To create and to execute threads
/*
    public static void main(String[] args) {
        //Launch 10 threads that make the operation with a different number
        for (int i = 1; i <= 10; i++) {
            Calculator calculator = new Calculator(i);
            Thread thread = new Thread(calculator);
            thread.start();
        }
    }
*/



//[2.] To get thread information
/*
    public static void main(String[] args) {
        // Thread priority information
        System.out.printf("Minimum Priority: %s\n", Thread.MIN_PRIORITY);
        System.out.printf("Normal Priority: %s\n", Thread.NORM_PRIORITY);
        System.out.printf("Maximun Priority: %s\n", Thread.MAX_PRIORITY);

        Thread threads[];
        Thread.State status[];

        // Launch 10 threads to do the operation, 5 with the max
        // priority, 5 with the min
        threads = new Thread[10];
        status = new Thread.State[10];

        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(new Calculator(i));
            if ((i % 2) == 0) {
                threads[i].setPriority(Thread.MAX_PRIORITY);
            } else {
                threads[i].setPriority(Thread.MIN_PRIORITY);
            }
            threads[i].setName("Thread " + i);
        }

        try (FileWriter file = new FileWriter(".\\data\\log.txt"); PrintWriter pw = new PrintWriter(file);) {
            for (int i = 0; i < 10; i++) {
                pw.println("Main : Status of Thread " + i + " : " + threads[i].getState());
                status[i] = threads[i].getState();
            }

            for (int i = 0; i < 10; i++) {
                threads[i].start();
            }

            boolean finish = false;
            while (!finish) {
                for (int i = 0; i < 10; i++) {
                    if (threads[i].getState() != status[i]) {
                        writeThreadInfo(pw, threads[i], status[i]);
                        status[i] = threads[i].getState();
                    }
                }
                finish = true;
                for (int i = 0; i < 10; i++) {
                    finish = finish && (threads[i].getState() == Thread.State.TERMINATED);
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

     //
     // This method writes the state of a thread in a file
     //
     // @param pw     : PrintWriter to write the data
     // @param thread : Thread whose information will be written
     // @param state  : Old state of the thread
     //
    private static void writeThreadInfo(PrintWriter pw, Thread thread, Thread.State state) {
        pw.printf("Main : Id %d - %s\n", thread.getId(), thread.getName());
        pw.printf("Main : Priority: %d\n", thread.getPriority());
        pw.printf("Main : Old State: %s\n", state);
        pw.printf("Main : New State: %s\n", thread.getState());
        pw.printf("Main : ************************************\n");
    }
*/



//[3.] To interrupt the execution of thread
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