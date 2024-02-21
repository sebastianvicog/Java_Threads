package es.ujaen.ssccdd;

public class Calculator implements Runnable {
    private int number;

    /**
     * @brief Constructor of class
     * @param number : The number
     */
    public Calculator (int number){
        this.number = number;
    }

    /**
     *  Method that do the calculations
     */
    @Override
    public void run() {
        for (int i=1; i<=10; i++){
            System.out.printf("%s: %d * %d = %d\n",Thread.currentThread().getName(),number,i,i*number);
        }
    }

}
