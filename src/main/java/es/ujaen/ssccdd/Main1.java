package es.ujaen.ssccdd;


import java.util.concurrent.TimeUnit;

/**
 *  Main class. To create and to execute threads
 */
public class Main1 {
    public static void main(String[] args) {
        //Launch 10 threads that make the operation with a different number
        for (int i = 1; i <= 10; i++) {
            Calculator calculator = new Calculator(i);
            Thread thread = new Thread(calculator);
            thread.start();
        }
    }
}