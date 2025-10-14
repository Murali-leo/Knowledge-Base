package main.java.multithreads;

public class MainThread {
    public static void main(String[] args) {
        System.out.println("Main thread started.");
        Thread childThread = new Thread1("ChildThread-1");
        childThread.start();
        Thread childThread2 = new Thread(new RunnableThread(), "ChildThread-2");
        childThread2.start();
        System.out.println("Main thread finished.");

        //Using lambda as Runnable is a functional interface
        Thread childThread3 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread() + " " + i);
            }
        }, "ChildThread-3");
        childThread3.start();

        Stack stack1 = new Stack(4);
        stack1.push(1);
        System.out.println(stack1);
        stack1.push(2);
        System.out.println(stack1);
        System.out.println(stack1.pop());
        stack1.push(3);
        System.out.println(stack1);
        stack1.push(7);
        System.out.println(stack1);
        stack1.push(9);
        System.out.println(stack1);
        stack1.push(10);

        BlockingQueue bq = new BlockingQueue(1);

        Thread producer = new Thread(() ->{
                bq.enqueue(42);
        });

        producer.start();

        for(int i = 0; i < 2; i++) {
            new Thread(() -> {
                bq.dequeue(); 
            }).start();
        }
    }
}
