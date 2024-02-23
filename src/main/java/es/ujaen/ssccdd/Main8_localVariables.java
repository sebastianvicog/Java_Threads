package es.ujaen.ssccdd;

import java.util.concurrent.TimeUnit;

public class Main8_localVariables {
    public static void main(String[] args) {
        // Creates the unsafe task
        SafeTask task=new SafeTask();

        // Throw three Thread objects
        for (int i=0; i<3; i++){
            Thread thread=new Thread(task);
            thread.start();
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
