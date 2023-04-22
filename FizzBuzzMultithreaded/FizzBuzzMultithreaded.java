package FizzBuzzMultithreaded;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class FizzBuzzMultithreaded {

    private int n;
    private int currentNumber;
    private BlockingQueue<String> queue;

    public FizzBuzzMultithreaded(int n) {
        this.n = n;
        this.currentNumber = 1;
        this.queue = new LinkedBlockingQueue<>();
    }

    public void fizz() {
        while (currentNumber <= n) {
            if (currentNumber % 3 == 0 && currentNumber % 5 != 0) {
                queue.add("fizz");
            }
            currentNumber++;
        }
    }

    public void buzz() {
        while (currentNumber <= n) {
            if (currentNumber % 5 == 0 && currentNumber % 3 != 0) {
                queue.add("buzz");
            }
            currentNumber++;
        }
    }

    public void fizzbuzz() {
        while (currentNumber <= n) {
            if (currentNumber % 3 == 0 && currentNumber % 5 == 0) {
                queue.add("fizzbuzz");
            }
            currentNumber++;
        }
    }

    public void number() {
        while (currentNumber <= n) {
            try {
                String value = queue.take();
                System.out.print(value);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (currentNumber <= n) {
                System.out.print(", ");
            }
            currentNumber++;
        }
    }

    public static void main(String[] args) {
        FizzBuzzMultithreaded fizzBuzz = new FizzBuzzMultithreaded(15);

        Thread threadA = new Thread(fizzBuzz::fizz);
        Thread threadB = new Thread(fizzBuzz::buzz);
        Thread threadC = new Thread(fizzBuzz::fizzbuzz);
        Thread threadD = new Thread(fizzBuzz::number);

        threadA.start();
        threadB.start();
        threadC.start();
        threadD.start();
    }
}
