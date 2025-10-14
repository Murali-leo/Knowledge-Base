package main.java.multithreads;

public class Deadlock {
    public static void main(String[] args) {
        String lock1 = "lock1";
        String lock2 = "lock2";

        Thread thread1 = new Thread(() -> 
        {
            synchronized(lock1) {
                System.out.println(Thread.currentThread().getName() + " acquired " + lock1);
                try{
                    // Simulate some work with lock1
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized(lock2) {
                    System.out.println(Thread.currentThread().getName() + " acquired " + lock2);
                }
            }
        }, "Thread-1");

        Thread thread2 = new Thread(() -> {
            synchronized(lock2){
                System.out.println(Thread.currentThread().getName() + " acquired " + lock1);
                try {
                    // Simulate some work with lock2
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized(lock1) {
                    System.out.println(Thread.currentThread().getName() + " acquired " + lock2);
                }
            }
        }, "Thread-2");

        thread1.start();
        thread2.start();
    }
}
